import java.util.Arrays;

/**
 * Created by nachtruine on 1/30/2017
 * Functionality: Finds all permutations of an array. Does not discriminate for uniqueness.
 */
public class FindAllPermutations {
    private static int counter = 0;

    private static char[] swap(char[] a, int left, int right){
        char temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        return a;
    }
    private static void backtrack(char[] a, int left, int right){
        if(isSolution(left, right))printSolution(a);
        else{
            for(int i=left; i<=right; i++){
                a = swap(a, left, i);
                backtrack(a, left+1, right);
                a = swap(a, left, i);
            }
        }
    }

    private static void printSolution(char[] abc) {
        System.out.println("Solution " + ++counter + ": " + Arrays.toString(abc));
    }

    private static boolean isSolution(int left, int right) {
        return left == right;
    }

    public static void main(String[] args0) {
        String test = "abcde";
        char[] a = test.toCharArray();
        backtrack(a, 0, a.length-1);
    }
}
