/* Backtracking Algorithm for enumerating all the permutation of the first n natural numbers
 * It can easily be modified to enumerate permutation of any set of elements
 * -Always remember that every recursive call has its on part in the stack
 * -and thus gets a new variable set for its local funciton. 
 * - So always declare any local variables inside the recursive function
 * -Or go through disaster
 * This is much more dynamic than the subset backtracking algorithm, since it
 * has a more dynamic set of possible candidates at each marker in the solution
 * vector.
 */
import java.util.Arrays;
import java.util.Scanner;

public class backtrack_permutations {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n;
		n = scan.nextInt();
		int[] a = new int[n+1];
		backtrack(a,0,n);
	}
	
	static void backtrack(int[] a, int k, int n){
		int[] c = new int[n];
		int ncandidates = 0;
		if(is_a_solution(a,k,n)){
			process_solution(a,k,n);
		}else{
			k++;
			ncandidates = construct_candidates(a,k,n,c);
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
	static int construct_candidates(int[] a, int k, int n, int[] c){
		int x = 0;
		boolean[] in_perm = new boolean[n+1];
		Arrays.fill(in_perm, false);
		for(int i = 0; i<k; i++){
			in_perm[ a[i] ] = true;
		}
		for(int i = 1; i<=n; i++){
			if(in_perm[i]==false){
				c[x++] = i; 
			}
		}
		return x;
	}
	static void process_solution(int[] a, int k, int n){
		System.out.print("{");
		for(int i = 1; i<=k; i++){
			System.out.print(a[i] + "");
		}
		System.out.println("}");
	}
}