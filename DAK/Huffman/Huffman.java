package DAK.Huffman;

import java.util.Hashtable;
import java.util.PriorityQueue;

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
     

      PriorityQueue<HuffmanTree<Character>> Q = 
         new PriorityQueue<HuffmanTree<Character>>();
      
      //again, this hash table is SCREAMING make me a treap so we can
      //avoid this nasty mapping buisness, but this works ftm

      for (Character c : letterCounts.keySet()) {
         Q.add(letterCounts.get(c));
      }
      System.out.println(""); 
      System.out.println("letter counts");
      System.out.println("----------");
      System.out.println(letterCounts);
      
      HuffmanTree<Character> lowest = Q.poll();
      HuffmanTree<Character> nextlowest = Q.poll();

      while (lowest != null && nextlowest != null) {
         

         //return them to the Q
         
         Q.add(lowest.merge(nextlowest));
         
         lowest = Q.poll(); 
         nextlowest = Q.poll();
      }

      System.out.println("");
      System.out.println("encoding table");
      System.out.println("----------");

      Hashtable<Character,String> encoding = lowest.get_hash_table();
      TreeRunner treeRun = new TreeRunner(encoding,letterCounts);
      lowest.vlr_carry((data,enc)->{
         TreeRunner tr = (TreeRunner)enc;
         if (data.getData() != null) {
            tr.incriment_count((HuffmanTree<Character>)data);
         }
      },treeRun);
     
      System.out.println(""); 
      System.out.println("compression percentage");
      System.out.println("----------");

      
      System.out.println(1-(float)treeRun.bit_count/(float)(args[0].length()*8)); 
      
      
   }
   
   private static class TreeRunner {
      public TreeRunner(Hashtable<Character,String> ht,
         Hashtable<Character,HuffmanTree<Character>> len_count) {
       
         this.character_count = len_count;
         this.encoding = ht;
         this.bit_count = 0;
      }
      public void incriment_count(HuffmanTree<Character> c) {
         bit_count += character_count.get(c.getData()).get_count()*encoding.get(c.getData()).length();
      }
      Hashtable<Character,HuffmanTree<Character>> character_count;
      Hashtable<Character,String> encoding;
      public int bit_count = 0;
   }

}
