package DAK.Matrix;

/** 
* simple class representing a matrix for orginization
* doesn't contain much atm other than the code for getting its dimension
*/
class Matrix {
    public static void main(String [] args) {
        
        Integer [] p = {5,7,2,3,7,4};
        PyramidArrayBack<Integer> order = chain_order(p);
        order.forEach((x,y,data)->{
            System.out.println(Integer.toString(x)+
            ","+ Integer.toString(y)+
            Integer.toString((Integer)data.get(x,y)));
        });
        
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
        PyramidArrayBack<Integer> m,Integer [] p)  {
            
        return m.get(k+1,j)+m.get(i,k)+p[i-1]*p[k]*p[j];
    }

    /** 
     * returns a pytamid array representation of the best
     * order for matrix multiplication.
    */
    public static PyramidArrayBack<Integer> chain_order(Integer [] p) {
        PyramidArrayBack<Integer> ret_val = new PyramidArrayBack<Integer>(p.length);
        PyramidArrayBack<Integer> reqs = new PyramidArrayBack<Integer>(p.length);

        System.out.println(reqs.size());
        System.out.println("printing data ---");
        reqs.forEach((i,k,data)->{
             System.out.println((Object)(Integer.toString(i) + "," + Integer.toString(k)));
        });
        System.out.println("finished printing data ---");

        for (int i = 0; i < p.length;i++) {
            System.out.println(Integer.toString(i)+","+ Integer.toString(i));
            reqs.set(i, i, 0);
        }
        reqs.forEachLong((j,i,data)->{
            int min = Integer.MAX_VALUE;  //give up a single integer value as infinity
            int best_k = 1;
            for (int k = i; k < j ; k++) {
                int test = compute_matrix_entry(i,j,k,reqs,p);
                
                System.out.println(test);
            
                System.out.println(Integer.toString(i)+
                    ","+ Integer.toString(j)+
                    Integer.toString(test)
                );

                if (test < min) {
                   min = test;
                   best_k = k;
                }
            }
            ret_val.set(i, j, best_k);
            reqs.set(i, j, min); 
            System.out.println(Integer.toString(i)+
                ","+ Integer.toString(j)+
                Integer.toString(min)
            );

        }); 
        return ret_val;
    }
}