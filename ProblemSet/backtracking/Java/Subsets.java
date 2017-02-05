package backtracking;

/**
 * Created by natha on 1/19/2017.
 */
public class Subsets
{

    private static int[] a = new int[5];
    private static int[] set = {1, 2, 3, 7, 18};

    public static void main(String[] args)
    {


        backtracking(a, 0, 5);

    }

    private static void backtracking(int[] a, int k, int n)
    {

        int[] constant = new int[2];
        int nc = 0;

        if(k == n)
        {
            process_solution(a, k);
        }
        else
        {

            k++;
            nc = possible_candidates(a, k, n, constant);

            for (int i = 0; i < nc; i++)
            {

                a[k - 1] = constant[i];
                backtracking(a, k, n);

            }

        }

    }

    private static void process_solution(int[] a, int k)
    {

        for (int i = 0; i < k; i++)
            if (a[i] == 0)
                System.out.print(set[i] + " ");


        System.out.println();

    }

    private static int possible_candidates(int[] a, int k, int n, int[] constant)
    {

        constant[0] = 0;
        constant[1] = 1;

        return 2;

    }

}
