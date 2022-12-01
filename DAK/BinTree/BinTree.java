package DAK.BinTree;

/** 
 * this class represents a single node in a binary tree
 * and contains functions that are used in order to
 * navigate the tree
*/
public class BinTree<T extends Comparable<T>> {
   
    /**
     * the testing function that the binary tree uses to compare keys 
     * */ 
    public Integer compare(T us,T them) {
        if (us == null)
            return -1;
        if (them == null)
            return 1;
        return us.compareTo(them);
    }

    /** 
     * merges two binary trees together by creating a node above 
     * them and placing them in the tree in appropriate order
    */
    public BinTree<T> merge(BinTree<T> toMerge) {
        BinTree<T> ret_val = new BinTree<>();
        if (compare(toMerge.getData(),this.data) < 0) {
            ret_val.leftPointer = toMerge;
            ret_val.rightPointer = this;
        } else {
            ret_val.leftPointer = this;
            ret_val.rightPointer = toMerge;
        }
        return ret_val;
    }
    public BinTree() {

    }
    public BinTree(T data) {
        this.data = data;
    }
    public interface Visit<T extends Comparable<T>> {
        public void visit(BinTree<T> b);
    }
    public class PrintVisit<J extends Comparable<J>> implements Visit<J> {
        public void visit(BinTree<J> b) {
            J data = b.data;
            if (data != null){
                System.out.print(data.toString() + " ");
            } else {
                System.out.print("# ");   
            }
        }
    }

    /** 
     * the pointers to the left and right of the tree,
     * private variables so as to remain protected
    */
    protected BinTree<T> leftPointer = null; //null pointer indicates no tree
    protected BinTree<T> rightPointer = null;
    /** 
     * the data stored at this node
    */
    protected T data = null;//data defaults to null

    /** 
     * getters for the left and right pointers of the tree
    */
    public BinTree<T> getLeftPointer() {
        return leftPointer;
    }
    public BinTree<T> getRightPointer() {
        return rightPointer;
    }
    public T getData() {
        return data;
    }
    /** convinence function to safely insert data
     * in nodes to our right
    */
    public void insertRight(T data) {
        if (getRightPointer() == null) {
            rightPointer = new BinTree<T>(data);
        } else {
            getRightPointer().insert(data);
        }
    }
    /** 
     * private convinence function to insert data to the LEFT of the current
     * node safely
    */
    public void insertLeft(T data) {
        if (getLeftPointer() == null) {
            leftPointer = new BinTree<T>(data);
        } else {
            getLeftPointer().insert(data);
        }
    }
    /** inserts the given data into the tree */
    public void insert(T data) {
        if (this.data == null) {
            this.data = data;
        }

        if (compare(this.data,data) < 0) {
            insertLeft(data);
        }
        else if (compare(this.data,data) > 0) {
            insertRight(data);
        }
    }

    //visit functions


    /** convinence function to set default arguments of vlr*/
    public void vlr() {
        vlr(new PrintVisit<T>());
    }
    /** visit left right function */
    public void vlr(Visit<T> v) {
        v.visit(this);
        if (getLeftPointer() != null) {
            getLeftPointer().vlr(v);
        }
        if (getRightPointer() != null) {
            getRightPointer().vlr(v);
        }
    }

    /**convineince function to left visit right */
    public void lvr() {
        lvr(new PrintVisit<T>());
    }
    /**left visit right function */
    public void lvr(Visit<T> v) {
        if (getLeftPointer() != null) {
            getLeftPointer().lvr(v);
        }
        v.visit(this);
        if (getRightPointer() != null) {
            getRightPointer().lvr(v);
        }
    }

    /**convineince function to left visit right */
    public void lrv() {
        lrv(new PrintVisit<T>());
    }
    /**left right visit function */
    public void lrv(Visit<T> v) {
        if (getLeftPointer() != null) {
            getLeftPointer().lrv(v);
        }
        if (getRightPointer() != null) {
            getRightPointer().lrv(v);
        }
        v.visit(this);
    }
    
    public void vrl() {
        vrl(new PrintVisit<T>());
    }
    /**left right visit function */
    public void vrl(Visit<T> v) {
        v.visit(this);
        if (getRightPointer() != null) {
            getRightPointer().vrl(v);
        }
        if (getLeftPointer() != null) {
            getLeftPointer().vrl(v);
        }
    }
    
    public void rvl() {
        rvl(new PrintVisit<T>());
    }
    /**right visit left*/
    public void rvl(Visit<T> v) {
        if (getRightPointer() != null) {
            getRightPointer().rvl(v);
        }
        v.visit(this);
        if (getLeftPointer() != null) {
            getLeftPointer().rvl(v);
        }
    }
    public void rlv() {
        rlv(new PrintVisit<T>());
    }
    /**right visit left*/
    public void rlv(Visit<T> v) {
        if (getRightPointer() != null) {
            getRightPointer().rlv(v);
        }
        if (getLeftPointer() != null) {
            getLeftPointer().rlv(v);
        }
        v.visit(this);
    }
}
