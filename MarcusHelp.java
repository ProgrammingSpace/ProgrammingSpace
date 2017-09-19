/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtoqueen;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nac33
 */
public class MarcusHelp
{

    static String word = "IEHOVA#";
    static char map[][];
    static String[] directions = new String[7];
    static int n,m;
    
    static void backtrack(int x, int y, int k){
        if(map[x][y]=='#' || k==7){
            return;
        }else{
//            System.out.println(x + " " + y);
            for(int i = -1; i<1; i++){
                for(int j = -1; j<2; j++){
//                    System.out.println("HERE: " + m + " " + n);
                    if(x+i>=0 && x+i<m && y+j>=0 && y+j<n){
                        
                        if(word.charAt(k)==map[x+i][y+j]){                            
                            if(i==-1 && j==0)directions[k] = "forth";
                            else if(i==0 && j==-1)directions[k] = "left";
                            else if(i==0 && j==1)directions[k] = "right";
                            backtrack(x+i,y+j,k+1);
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] arg)
    {
    
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        //scan.nextLine();

        for (int i = 0; i < t; i++)
        {
        
            m = scan.nextInt();
            n = scan.nextInt();
            int row=0, col=0;
            
            map = new char[m][n];
            scan.nextLine();
            for (int j = 0; j < m; j++)
            {
                
                String tmp = scan.nextLine();
                for (int k = 0; k < n; k++)
                {
                    map[j][k] = tmp.charAt(k);
                    if (map[j][k] == '@')
                    {
                    
                        row = j;
                        col = k;
                    
                    }
                }
                
            }
            
//            System.out.println(Arrays.deepToString(map));
            
            backtrack(row, col, 0);
//            System.out.println(Arrays.toString(directions));

            for(int b = 0; b<7; b++)if(b!=6)System.out.print(directions[b] + " ");
            else System.out.println(directions[b]);
        }
        
    }

}
