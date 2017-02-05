package UVaJudge;

import java.util.*;

/**
 * Created by natha on 2/4/2017.
 */
public class CD // UVa Judge: 624
{

    private int max = 0;
    private ArrayList<Integer> max_list = new ArrayList<>(0);

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        try
        {

            while (true)
            {

                CD cd = new CD();
                HashMap<ArrayList<Integer>, Integer> solutions = new HashMap<>();

                int N = sc.nextInt();
                int t = sc.nextInt();

                String[] input = sc.nextLine().split(" ");
                int[] tracks = new int[input.length - 1];
                for (int i = 1; i < input.length; i++)
                    tracks[i - 1] = Integer.parseInt(input[i]);

                int[] solution_set = new int[tracks.length];

                cd.backtracking(solutions, tracks, solution_set, t, 0, N);

                for (Integer in : cd.max_list)
                {
                    System.out.print(in + " ");
                }
                System.out.println("sum:" + cd.max);


            }

        }
        catch (Exception e) { e.printStackTrace(); }

    }

    private void backtracking(HashMap<ArrayList<Integer>, Integer> solutions, int[] t, int[] s, int n, int k, int sum)
    {

        int[] candidates = {0, 1};

        if (n == k)
        {

            process_solution(solutions, t, s, k, sum);

        }
        else
        {
            k++;
            for (int i = 0; i < candidates.length; i++)
            {
                s[k - 1] = candidates[i];
                backtracking(solutions, t, s, n, k, sum);
            }

        }

    }

    private void process_solution(HashMap<ArrayList<Integer>, Integer> solutions, int[] t, int[] s,  int k, int sum)
    {

        ArrayList<Integer> combos = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < k; i++)
            if (s[i] == 1)
            {
                combos.add(t[i]);
                total += t[i];
            }

        if (total <= sum)
        {
            solutions.put(combos, total);

            if (total >= max)
                if (total == max && combos.size() > max_list.size())
                {
                    max = total;
                    max_list = combos;
                }
                else
                {
                    max = total;
                    max_list = combos;
                }
        }

    }

}
