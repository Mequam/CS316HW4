package DAK.Huffman;

import java.util.Hashtable;

public class Huffman {
   public static void main(String [] args) {
      if (args.length < 1) System.out.println("[ERROR] at least one argument is required");

      Hashtable<Character,HuffmanEntry> letterCounts = new Hashtable<>();
      //get the letter count foreach letter in the word
      //this could prolly be way more efficeint, but im tired :)
      int size = args[0].length();
      for (int i = 0; i < size; i++) {
         if (!letterCounts.containsKey(args[0].charAt(i))) {
            letterCounts.put(args[0].charAt(i), new HuffmanEntry(args[0].charAt(i)));
         } else {
            letterCounts.get(args[0].charAt(i)).incriment_count();
         }
      }
      System.out.println(letterCounts);
   }
}
