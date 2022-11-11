package DAK.Matrix;

/** 
* simple class representing a matrix for orginization
* doesn't contain much atm other than the code for getting its dimension
*/
class Matrix {

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
   
    /** 
     * takes in an array containing the p values for the given matricies
     * and computes the correct order of the matrix
    */
    Integer [][] getCorrectOrder(Integer [] p) {
        return new Integer[1][1];
    }
}