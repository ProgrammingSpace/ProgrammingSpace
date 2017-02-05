package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by natha on 1/27/2017.
 */
public class Horizon
{

    private static ArrayList<String[]> grid = new ArrayList<String[]>();
    private static String word;
    private static int total = 0;

    private static class Point
    {

        int i;
        int j;

        public Point(int i, int j)
        {

            this.i = i;
            this.j = j;

        }

    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        try
        {

            for (int i = 0; i < 7; i++)
            {
                grid.add(sc.nextLine().split(" "));
            }

        }
        catch (Exception e) {}


        word = sc.nextLine();
        Point[] solution_set = new Point[word.length()];

        for (int i = 0; i < grid.size(); i++)
            for (int j = 0; j < grid.get(i).length; j++)
                if (grid.get(i)[j].equals("" + word.charAt(0)))
                    backtracking(solution_set, 0, word.length(), new Point(i, j));

        System.out.println("total: " + total);

    }

    private static void backtracking(Point[] solution_set, int k, int n, Point start)
    {

        ArrayList<Point> candidates = new ArrayList<Point>();
        int num_candidates;

        if (k == n - 1)
        {
            total++;
        }
        else
        {

            k++;
            num_candidates = possible_candidates(candidates, k, n, start);
            for (int i = 0; i < num_candidates; i++)
            {

                solution_set[k - 1] = candidates.get(i);
                backtracking(solution_set, k, n, candidates.get(i));

            }

        }

    }

    private static int possible_candidates(ArrayList<Point> candidates, int k, int n, Point start)
    {

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                try
                {

                    if (i - 1 == 0 && j - 1 == 0)
                        continue;

                    if (grid.get(start.i + i - 1)[start.j + j - 1].equals("" + word.charAt(k)))
                    {
                        candidates.add(new Point(start.i + i - 1, start.j + j - 1));
                        System.out.println(grid.get(start.i + i - 1)[start.j + j - 1]);
                    }

                }
                catch (Exception e) {}

        return candidates.size();

    }

}
