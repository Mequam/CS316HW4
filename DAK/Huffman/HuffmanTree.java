package DAK.Huffman;

import DAK.BinTree.*;

/** 
 * Huffman tree containing the data that we need for mergeing and the like
*/
public class HuffmanTree<T extends Comparable<T>> extends BinTree<T> implements Comparable<HuffmanTree<T>>{
   
    @Override
    public String toString() {
        return this.data.toString() + ":" + Integer.toString(this.count);
    }
    public HuffmanTree(T data) {
        this.data = data;
        this.count = 1;
    }
    /** 
     * the number of the element that we are containing that we are storing
    */
    private int count = 1;
    public void incriment_count() {
        count += 1;
    }
    public int get_count() {
        return this.count;
    }
    
    /** 
     * combine two of our huffman nodes into a new tree and incriment the value of
     * that tree
     * 
     * note that there is some ordering imposed on how we place the nodes
     * left and right based on there order simply on account of us using
     * a binary tree for these operations
    */
    @Override
    public BinTree<T> merge(BinTree<T> toMerge) {
        BinTree<T> ret_val = super.merge(toMerge);
        return ret_val;
    }
    
    /** 
     * comparison on how nodes are ordered
     * used in the built in tree from java to 
     * keep our nodes nice and sorted!
    */
    @Override
    public int compareTo(HuffmanTree<T> arg0) {
        return count - arg0.count;
    }
}
