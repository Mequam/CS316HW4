package DAK.Matrix;


public class PyramidArrayBack<T> extends PyramidArray<T> {
    
    public PyramidArrayBack(int size) {
        data = new Object[size][];
        for (int i = 0; i < size; i++)
            data[i] = new Object[size - i];
    }
   
    public static void main(String [] args) {

        PyramidArrayBack<String> pa = new PyramidArrayBack<String>(5);
        
        pa.forEach((i,k,data)->{

            System.out.println(Integer.toString(i) +","+ Integer.toString(k));

            data.set(i,
                    k,(Integer.toString(i) + "," + Integer.toString(k)));
        });
       
        System.out.println("---");

        pa.forEach((c)->System.out.println(c));

    }
    
    /** 
     * private contstructor that does nothing
    */
    protected PyramidArrayBack(){

    } 
    /** 
     * setter function
    */
    public void set(int i, int j,T data){
        this.data[i][map(j)] = data;
    }

    /** 
     * runs the given function over each of the elements
     * inside of the container
    */
    public void forEach(mapRunner<T> f)  {
        for (int i = 0;i < data.length;i++) {
            for (int j = data.length - 1; j >= i;j--){
                f.run(i, j, this); }
        }
    }

    private int map(int j){
        return this.width()-j-1;
    }
    
    public T get(int i,int j) {
        return (T)(this.data[i][map(j)]);
    }
}
