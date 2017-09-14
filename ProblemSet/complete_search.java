/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complete_search;

import java.util.BitSet;

/**
 *
 * @author bm37
 */
public class Complete_search {

    private static int[] a = new int[10];
    static int[] set = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static int global_count = 0;
    static int[] num = new int[5];
    static int[] den = new int[5];

    //static int[] bit_set = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
       backtracking_subset(a, 0, 10);
       System.out.println(global_count);
        
        
    }
    
     private static void backtracking_subset(int[] a, int k, int n)
    {

        int[] constant = new int[2];
        int nc = 0;

        if(k == n)
        {
            process_solution_subset(a, k);
        }
        else
        {

            k++;
            nc = possible_candidates(a, k, n, constant);

            for (int i = 0; i < nc; i++)
            {

                a[k - 1] = constant[i];
                backtracking_subset(a, k, n);

            }

        }

    }

    private static void process_solution_subset(int[] a, int k)
    {

        int counter = 0, new_counter = 0, dew_counter = 0;
        
        for (int i = 0; i < k; i++)
            if (a[i] == 0)
                counter++;
        
        if (counter != 5)
            return;
        
        for (int i = 0; i < k; i++)
            if (a[i] == 0)
                num[new_counter++] = set[i];
            else
                den[dew_counter++] = set[i];
                

        //global_count++;
       // System.out.println();
       //for (int i = 0; i < 120; i++)
        backtracking(num, 0, num.length);
        backtracking(den, 0, den.length);

    }

    private static int possible_candidates(int[] a, int k, int n, int[] constant)
    {

        constant[0] = 0;
        constant[1] = 1;

        return 2;

    }
    
    
    private static void backtracking(int[] set, int k, int n )
    {
    
         if (k == n )
             process_solution(set);
         else
             for (int i = k; i < n; i++)
            {

               swap(set, k, i );
               backtracking(set, k + 1, n);
               swap(set, i, k);


            }

    }
    
    private static void swap(int[] set, int i, int j)
    {
        
        int tmp = set[i];
        set[i] = set[j];
        set[j] = tmp;
    
    
    }
    
    static void process_solution(int[] set)
    {
    
        for (int i = 0; i < set.length; i++)
        {
        
            System.out.print(set[i] + " ");
        
        }
        
        System.out.println();
        global_count++;
    
    }
    
   
}
