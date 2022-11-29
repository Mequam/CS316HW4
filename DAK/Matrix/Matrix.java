package DAK.Matrix;

/** 
* simple class representing a matrix for orginization
* doesn't contain much atm other than the code for getting its dimension
*/
class Matrix {  
    /** 
     * simple convinence function to bootstrap the recursive one
     * 
     * this would be a good candidate for inline in c++
    */
    public static String parenth_location(String outputStr,PyramidArray<Integer> order) {
        return parenth_location(0,outputStr.length()-1,outputStr,order);
    }
    /** 
     * recursive function to display the parenthasis order for a string sequence
    */
    public static String parenth_location(int start,int stop,
        String s,
        PyramidArray<Integer> order
    ){
        
        if (stop - start > 2) {
            int insert_location = order.get(start, stop-2);
            return "("+parenth_location(start, insert_location, s, order)+
             ")("+
             parenth_location(insert_location, stop, s, order)+")";
        }
        return s.substring(start,stop);
    }
    public static void main(String [] args) { 
        Integer [] p = {30,35,15,5,10,20,25};
        PyramidArrayBack<Integer> order = chain_order(p);
        System.out.println("S");
        System.out.println("--------------------");
        System.out.println(order);
        String orderable = "0123456";
        System.out.println("order");
        System.out.println("--------------------");
        System.out.println(parenth_location(orderable,order)); 
    }
    
    LatticePoint2D lp; 
    /** 
     * creates a matrix with the given dimensions
    */
    public Matrix(LatticePoint2D lp) {
        this.lp = lp;
    }
    /**
     * simple class to place code that needs to interact with latice point math
     */
    class LatticePoint2D {
        int x;
        int y;
    } 
    public LatticePoint2D getDimension() {
        return lp;
    } 
   
   
    public static Integer compute_matrix_entry(int i,
        int j,
        int k,
        PyramidArrayBack<Integer> m,
        Integer [] p)  {
            return m.get(k+1,j) + m.get(i,k) + p[i]*p[k+1]*p[j+1];
    }

    /** 
     * returns a pytamid array representation of the best
     * order for matrix multiplication.
    */
    public static PyramidArrayBack<Integer> chain_order(Integer [] p) {
        PyramidArrayBack<Integer> ret_val = new PyramidArrayBack<Integer>(p.length-2);
        PyramidArrayBack<Integer> reqs = new PyramidArrayBack<Integer>(p.length-1);


        reqs.forEachLong((i,k,data)->{
            reqs.set(i, k, 0);
        });
        
        reqs.forEachLong((i,j,data)->{
            int min = Integer.MAX_VALUE;

            for (int k = i; k < j;k++) {
                int challenger = compute_matrix_entry(i, j, k, reqs, p);
                if (min > challenger) {
                    min = challenger;
                    reqs.set(i, j, min);
                    
                    if (i != j) {
                        ret_val.set(i,j-1,k+1);
                    } 
                }
            }
        });
        //print out the requirement matrix that we used to get here
        //TODO: make this return along with the other value
        System.out.println("M");
        System.out.println("--------------------");
        System.out.println(reqs);
        return ret_val;
    }
}