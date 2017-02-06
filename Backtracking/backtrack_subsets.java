
/*Backtracking program to create all the subsets of first n natural numbers
 * Can be easily modified for any general backtracking algorithm
 * --->Remember this is a simplistic backtracking, in other words, the set
 * --->of possible candidates remains static all the time
 * In a more general algorithms, each recursive call gets a new set of 
 * variables to generate the possible candidates
 * */
import java.util.Scanner;

public class backtrack_subsets {

	static int MAXCANDIDATES = 2;
	static int[] c = new int[MAXCANDIDATES];
	static int ncandidates = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n;
		n = scan.nextInt();
		int[] a = new int[n+1];
		backtrack(a,0,n);
	}
	
	static void backtrack(int[] a, int k, int n){
		if(is_a_solution(a,k,n)){
			process_solution(a,k,n);
		}else{
			k++;
			construct_candidates(a,k,n);
			for(int i = 0; i<ncandidates; i++){
				a[k] = c[i];
				//make_move(a,k,n);
				backtrack(a,k,n);
				//unmake_move(a,k,n);
				//if(finished)return;
			}
		}
	}	
	static boolean is_a_solution(int[] a, int k, int n){
		return k==n;
	}	
	static void construct_candidates(int[] a, int k, int n){
		c[0] = 0;
		c[1] = 1;
		ncandidates = 2;
	}
	static void process_solution(int[] a, int k, int n){
		System.out.print("{");
		for(int i = 0; i<k; i++){
			if(a[i+1]==1)System.out.print(i+1 + "");
		}
		System.out.println("}");
	}
}
