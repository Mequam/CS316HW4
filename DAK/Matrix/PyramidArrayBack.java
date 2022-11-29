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
 
        System.out.println("---");
        
        pa.forEachLong((i,k,data)->{ 
            System.out.println(Integer.toString(i) +","+ Integer.toString(k));
            data.set(i,
                    k,(Integer.toString(i) + "," + Integer.toString(k))); 

           });
        System.out.println("---");    
        
        System.out.println(pa);
        
        for (int i = 0; i < 10;i++) {
            for (int j = 0;j<10;j++) {
                System.out.println(Integer.toString(i)+","+Integer.toString(j) + ":"
                + Boolean.toString(pa.validAddr(i, j)));
            }
        }


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
     * returns wether or not the given address is a valid index of the class
     */
   @Override
   public boolean validAddr(int i,int j)  {
    return super.validAddr(i,map(j)) && map(j) >= 0;
   }
    /** 
     * runs the given function over each of the elements
     * inside of the container
     * 
     * uses an ordering that travels along the long row
     * of the matrix
    */
    public void forEachLong(mapRunner<T> f)  {
        for (int i = 0;i < this.width();i++) {
            for (int j = 0; j < this.width()-i;j++){
                f.run(j,i+j, this); }
        }
    }
    /** 
     * converts the array into a string
    */
    @Override
    public String toString() {
        String ret_val = "";
        for (int i = 0;i < this.width();i++) {
            for (int j = 0; j < this.width()-i;j++){
                ret_val += data[i][j] + " ";
            }
            ret_val += "\n";
        }
        return ret_val;
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
