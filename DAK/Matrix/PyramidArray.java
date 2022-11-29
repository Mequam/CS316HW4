package DAK.Matrix;

import java.util.function.Consumer;

/**
 * this is a container class that impliments
 * the jagged array structure necessary for the m
 * and s tables in the matrix algorithm
 */
public class PyramidArray<T extends Object> {

    protected Object[][] data;
   
    @FunctionalInterface
    public interface mapRunner<T> {
        void run(int i,int j, PyramidArray<T> o);
    }
    
    /** 
     * do nothing function
     * that can only be called privatly
    */
    protected PyramidArray() {
        
    }
    public PyramidArray(int size) {
        data = new Object[size][];
        for (int i = 0; i < size; i++)
            data[i] = new Object[size - i];
    }
  
    @Override
    public String toString() {
        String ret_val = "";
        for (int i = 0;i < data.length;i++) {
            for (int j = 0; j < data.length - i;j++){
                ret_val += data[j][i].toString() + " ";
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
            for (int j = 0; j < data.length - i;j++){
                f.run(i, j, this);
            }
        }

    }
    
    public void forEach(Consumer<T> f)  {
        forEach((i,j,data)->{
            f.accept((T)(this.get(i,j)));
        });
    }
    /**
     * gets the size of the largest array
     */
    public int width() {
        return data.length;
    }
    /** 
     * gets the total cell count of the structure
    */
    public int size() {
        return (data.length*data.length + data.length)/2;
    }
    public void set(int i, int j,T data){
        this.data[i][j] = data;
    }
    public T get(int i,int j) {
        return (T)(this.data[i][j]);
    }
  
    /**
     * tester program for the class
     * 
     */
    public static void main(String [] args) {
        PyramidArray<String> pa = new PyramidArray<String>(5);
        
        pa.forEach((i,k,data)->{
            data.set(i,
                k,
                (Integer.toString(i) + "," + Integer.toString(k)));
            });
        
        pa.forEach((c)->System.out.println(c));
        
        System.out.println(pa.toString());

    }
}