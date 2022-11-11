package DAK.Matrix;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * this is a container class that impliments
 * the jagged array structure necessary for the m
 * and s tables in the matrix algorithm
 */
public class PyramidArray<T extends Object> {

    private Object[][] data;
   
    @FunctionalInterface
    public interface mapRunner<T> {
        void run(int i,int j, Object[][] o);
    }
    
    
    public PyramidArray(int size) {
        data = new Object[size][];
        for (int i = 0; i < size; i++)
            data[i] = new Object[size - i];
    }
  
    
    /** 
     * runs the given function over each of the elements
     * inside of the container
    */
    public void forEach(mapRunner<T> f)  {
        for (int i = 0;i < data.length;i++) {
            for (int j = 0; j < data.length - i;j++){
                f.run(i, j, data);
            }
        }

    }
    
    public void forEach(Consumer<T> f)  {
        forEach((i,j,data)->{
            f.accept((T)(data[i][j]));
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
            data[i][k] = (Object)(Integer.toString(i) + "," + Integer.toString(k));
        });
        pa.forEach((c)->System.out.println(c));

    }
}
