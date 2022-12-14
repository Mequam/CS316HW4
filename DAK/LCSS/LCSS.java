package DAK.LCSS;

import java.util.Scanner;

import javax.imageio.stream.IIOByteBuffer;

public class LCSS {
    private static void displayTableEntry(int i,int j,LCSSEntry[][] table,String [] args) {
                System.out.print(table[i][j]);
                System.out.print(args[0].charAt(i-1));
                System.out.print(args[1].charAt(j-1));
                System.out.print("->");
                if (table[i][j].pointerX != 0 && table[i][j].pointerY != 0) {
                    System.out.print(args[0].charAt(table[i][j].pointerX-1));
                    System.out.print(args[1].charAt(table[i][j].pointerY-1));
                }

    }
    private static int [] getLargestNeighbor(int x,int y,LCSSEntry[][] table){
        if (table[x - 1][y].value > table[x][y-1].value) {
            return new int [] {x-1,y};
        }
        return new int [] {x,y-1};
    }
    
    
    private static void check_entry(String wx,String wy,LCSSEntry [][] table,int x,int y) {
        int [] target = getLargestNeighbor(x, y, table);
        if (wx.charAt(x-1) == wy.charAt(y-1)) {
            //they match! so we need to incriment and aim up
            table[x][y].pointerX = x-1;
            table[x][y].pointerY = y-1;
            table[x][y].value = table[target[0]][target[1]].value+1;
        } else {
            table[x][y].pointerX = target[0];
            table[x][y].pointerY = target[1];
            table[x][y].value = table[target[0]][target[1]].value;
        }
    }
    
    public static void main(String [] args)  {
        String word1;
        String word2;
        
        if (args.length < 2) {
            Scanner jin = new Scanner(System.in);
            word1 = jin.nextLine();
            word2 = jin.nextLine();
            jin.close();             
        } else {
            word1 = args[0];
            word2 = args[1];
        }
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        LCSSEntry table[][] = new LCSSEntry[word1.length()+1][word2.length()+1];
        
        //initilize the values at the table
        for (int i = 0; i < word1.length()+1;i++) {
            for (int j = 0; j < word2.length()+1;j++) {

                table[i][j] = new LCSSEntry();
            }
        }

        //run the chain paths through the table
        for (int i = 1; i < word1.length()+1;i++) {
            for (int j = 1; j < word2.length()+1;j++) {
                check_entry(word1,
                    word2,
                    table,
                    i,
                    j);
            }
        }

        int target_x = word1.length();
        int target_y = word2.length();

        //prints out the table for debugging
        //System.out.println(table[target_x][target_y].value);
        //for (int i = 1; i < word1.length()+1;i++) {
            //for (int j = 1; j < word2.length()+1;j++) {
                //displayTableEntry(i, j, table, args);
                //System.out.print(" ");
            //}
            //System.out.println();
        //}
        
       
        String ret_val = "";
        while (table[target_x][target_y].value != 0) {
                if (table[target_x][target_y].pointerY == target_y - 1 &&
                    table[target_x][target_y].pointerX == target_x - 1) {
                    ret_val = word1.charAt(target_x-1) + ret_val;
                }
                int cach_x = target_x;//you will not belive how long this took to find
                target_x = table[target_x][target_y].pointerX;
                target_y = table[cach_x][target_y].pointerY; 
        }
        
        System.out.println("\nLCSS");
        System.out.println("----------");
        
        System.out.println(ret_val);
        System.out.println("\n[*] program finished :)");
   }
}
