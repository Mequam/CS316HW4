package DAK.Huffman;

import java.util.Hashtable;

public class Huffman {
   public static void main(String [] args) {
      if (args.length < 1) System.out.println("[ERROR] at least one argument is required");

      //this NEEDS to be a treap, but im tired so have a built in Hash table :p
      Hashtable<Character,HuffmanTree<Character>> letterCounts = new Hashtable<>();
      
      int size = args[0].length();
      for (int i = 0; i < size; i++) {
         if (!letterCounts.containsKey(args[0].charAt(i))) {
            letterCounts.put(args[0].charAt(i), new HuffmanTree<Character>(args[0].charAt(i)));
         } else {
            letterCounts.get(args[0].charAt(i)).incriment_count();
         }
      }
      System.out.println(letterCounts);
   }
}
