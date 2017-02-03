import java.util.ArrayList;

/**
 * Created by nachtruine on 1/30/2017
 * Functionality: Find occurrences of a word in a matrix, moving up, down, left, right, and diagonally.
 */

public class Horizon {
    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "[" + x + "," + y + "]";
        }
    }

    private static int[] directions = {-1, 0, 1};
    private static char[][] matrix = {
            {'t', 'z', 'x', 'c', 'd'},
            {'a', 'h', 'n', 'z', 'x'},
            {'h', 'w', 'o', 'i', 'o'},
            {'o', 'r', 'n', 'r', 'n'},
            {'a', 'b', 'r', 'i', 'n'}
    };
    private static int totalSolutions = 0;
    private static String desiredWord = "horizon";

    public static void main(String[] args0) {
        ArrayList<Point> solutions = new ArrayList<Point>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                int index = 0;
                if(matrix[i][j] == desiredWord.charAt(index)){
                    System.out.println(matrix[i][j]);
                    findAdjacent(solutions, index, new Point(i,j));
                }
            }
        }
        System.out.println(totalSolutions);
    }

    private static void format(int formatting) {
        for(int i=0; i<formatting; i++){
            System.out.print('-');
        }
    }

    private static void findAdjacent(ArrayList<Point> solutions, int index, Point start) {
        ArrayList<Point> candidates = new ArrayList<Point>();
        if(index == desiredWord.length()-1)totalSolutions++;
        else{
            index++;
            findCandidates(candidates, index, start);
            for (Point candidate : candidates) {
                solutions.add(index - 1, candidate);
                findAdjacent(solutions, index, candidate);
            }
        }
    }

    private static void findCandidates(ArrayList<Point> candidates, int index, Point start){
        for(int i : directions){
            for(int j : directions){
                try{
                    if(i==0 && j==0)continue;
                    if(matrix[start.x+i][start.y+j] == desiredWord.charAt(index)){
                        candidates.add(new Point(start.x+i, start.y+j));
                        format(index);
                        System.out.println(matrix[start.x+i][start.y+j]);
                    }
                }
                catch(Exception ignored){}
            }
        }
    }
}
