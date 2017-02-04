package backtracking;

/**
 * Created by natha on 1/27/2017.
 */
public class Permutations
{

    // The list of elements which will be permutated and displayed
    private static int[] set = {1, 2, 3, 7, 18};

    public static void main(String[] args)
    {


        backtracking(set, 0, set.length);

    }

    /**
     * The backtracking algorithm which generates the permutations of a given set
     * @param set the list of elements which will be permutated
     * @param k the counter to keep track of the permutations
     * @param n the size of the set
     */
    private static void backtracking(int[] set, int k, int n)
    {

        if(k == n)
        {
            process_solution(set);
        }
        else
        {

            for (int i = k; i < n; i++)
            {

                swap(set, k, i);
                backtracking(set, k + 1, n);
                swap(set, i, k);

            }

        }

    }

    /**
     * Swaps the elements at the provided indices with eachother
     * @param set the list of elements
     * @param i the first indice of the element in the set to be swapped
     * @param j the second indice of the element in the set to be swapped
     */
    private static void swap(int[] set, int i, int j)
    {

        int tmp = set[i];
        set[i] = set[j];
        set[j] = tmp;

    }

    /**
     * Prints out a solution to the console
     * @param set the list of elements to be printed out
     */
    private static void process_solution(int[] set)
    {

        for (int i = 0; i < set.length; i ++)
            System.out.print(set[i] + " ");

        System.out.println();
    }

}
