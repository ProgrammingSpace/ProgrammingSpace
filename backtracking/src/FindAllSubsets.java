/**
 * Created by nachtruine on 1/30/2017
 * Functionality: Find all subsets of a set.
 */
public class FindAllSubsets {
    private static boolean[] choices = {false, true};
    private static int[] data_set = {1,2,3,5,18,26};
    private static int counter = 0;

    public static void main(String[] args){
        boolean[] a  = new boolean[data_set.length];//chooses whether to include in solution or not
        for(int i=0; i<data_set.length; i++){
            a[i] = false;
        }
        backtrack(a, -1);
    }

    private static void backtrack(boolean[] a, int index){
        if(isSolution(a.length, index))printSolution(a);
        else{
            index++;
            int number_candidates = possibleCandidates();
            for(int i=0; i<number_candidates; i++){
                a[index] = choices[i];
                //make();
                backtrack(a, index);
                //unmake();
            }
        }
    }

    private static int possibleCandidates() {
        return choices.length;
    }

    private static void printSolution(boolean a[]) {
        System.out.print("Solution "+ ++counter + ": [");
        for(int i=0; i<a.length; i++){
            if(a[i]){
                System.out.print(" " + data_set[i] + " ");
            }
        }
        System.out.println("]");
    }

    private static boolean isSolution(int length, int index) {
        return length-1 == index;
    }
}
