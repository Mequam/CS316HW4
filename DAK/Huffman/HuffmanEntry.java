package DAK.Huffman;

/** 
 * represents a single entry in the Huffman tree
 * note that we feed this into a binary tree class to get the tree
 * structure that we need
*/
public class HuffmanEntry {
    public HuffmanEntry(char letter) {
        this.letter = letter;
        this.count = 1;
    }
    private int count;
    public void incriment_count() {
        count += 1;
    }
    public int get_count() {
        return this.count;
    }
    
    private char letter;
    public char get_letter() {
        return letter;
    }
    
    @Override
    public String toString() {
        return get_letter()+":" + Integer.toString(get_count());
    }
}
