package DAK.Matrix;

/** 
* simple class representing a matrix for orginization
* doesn't contain much atm other than the code for getting its dimension
*/
class Matrix {
    public static void main(String [] args) {
        
        Integer [] p = {5,7,2,3,7,4};
        PyramidArrayBack<Integer> order = chain_order(p);
        
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
        PyramidArrayBack<Integer> ret_val = new PyramidArrayBack<Integer>(p.length-1);
        PyramidArrayBack<Integer> reqs = new PyramidArrayBack<Integer>(p.length-1);

        System.out.println(reqs.size());

        reqs.forEachLong((i,k,data)->{
            reqs.set(i, k, 0);
        });
        
        reqs.forEachLong((i,j,data)->{
            int max = Integer.MAX_VALUE;
            int best_k = 0;

            for (int k = i; k < j-1;k++) {
                int challenger = compute_matrix_entry(i, j, k, reqs, p);
                if (max > challenger) {
                    max = challenger;
                    best_k = k;
                }
            }
        });
        
        reqs.forEachLong((i,k,data)->{
            
        });
        System.out.println("finished printing data ---");

        System.out.println("RUNNING MATRIX FOREACH");
        reqs.forEachLong((j,i,data)->{
            System.out.println(
                Integer.toString(i) + ","  +Integer.toString(j)
                );
        }); 
        return ret_val;
    }
}