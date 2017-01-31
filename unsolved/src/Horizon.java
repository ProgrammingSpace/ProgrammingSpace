import java.util.ArrayList;
import java.util.List;

/**
 * Created by nachtruine on 1/30/2017
 * Functionality: Find occurrences of a word in a matrix, moving up, down, left, right, and diagonally.
 * TODO: Figure this out.
 */

class Point{
    int x, y;
    char c;
    ArrayList<Point> validConnections = new ArrayList<Point>();

    Point(int x, int y, char c){
        this.x = x;
        this.y = y;
        this.c = c;
    }

    void addValidConnection(Point p){
        validConnections.add(p);
    }

    public String toString(){
        int formattingCounter = 0;
        String result = "[" + x + "," + y + "]: " + c;
        formattingCounter++;
        for(Point p : validConnections){
            for(int i=0; i<formattingCounter; i++)result += "-";
            result += (p);
        }
        return result;
    }
}
public class Horizon {
    private static int[] directions = {-1, 0, 1};
    private static char[][] matrix = {
            {'t', 'z', 'x', 'c', 'd'},
            {'a', 'h', 'n', 'z', 'x'},
            {'h', 'w', 'o', 'i', 'o'},
            {'o', 'r', 'n', 'r', 'n'},
            {'a', 'b', 'r', 'i', 'n'}
    };
    private static int index = 0;
    private static String desiredWord = "horizon";
    private static List<Point> exclude = new ArrayList<Point>();

    public static void main(String[] args0) {
        findWord();
    }

    private static void findWord() {
        ArrayList<Point> starting = findStartingPlaces(desiredWord.charAt(index++));
        if(desiredWord.length() == 1){
            printSolutions(starting);
        }
        for(Point p : starting){
            exclude.add(p);
            findValidConnections(p, index++);
            exclude.remove(p);
        }
        printSolutions(starting);
    }

    private static void printSolutions(ArrayList<Point> solutions) {
        for(Point p : solutions){
            System.out.println(p);
            //printSolutions(p.validConnections);
        }
    }

    private static void findValidConnections(Point p, int thisindex) {
        if(thisindex > desiredWord.length()-1)return;
        for(int x : directions){
            for(int y : directions){
                Point check;
                try {
                    check = new Point(p.x+x, p.y+y, matrix[p.x+x][p.y+y]);
                    if(x == 0 && y == 0)continue;
                    boolean isExcluded = false;
                    for(Point excluded : exclude){
                        if(excluded.x == check.x && excluded.y == check.y)isExcluded = true;
                    }
                    if(isExcluded)continue;
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
                if(check.c == desiredWord.charAt(thisindex))p.addValidConnection(check);
            }
        }
        ++thisindex;
        for(Point newP : p.validConnections){
            exclude.add(newP);
            findValidConnections(newP, thisindex);
            exclude.remove(newP);
        }
    }

    private static ArrayList<Point> findStartingPlaces(char c) {
        ArrayList<Point> list = new ArrayList<Point>();
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                char check = matrix[i][j];
                if(check == c)list.add(new Point(i,j,c));
            }
        }
        return list;
    }
}
