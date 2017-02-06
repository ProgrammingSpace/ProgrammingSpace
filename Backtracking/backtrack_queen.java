/*Backtracking algorithm to solve the Classic Queens problem
 * Stick to the permutations functions for construct candidates
 * as far as possible. It has been very well designed.
 */

import java.util.Scanner;
import java.util.Arrays;

public class backtrack_queen {	
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
//		int n = 4;
		int[] a = new int[n+1];
		backtrack(a,0,n);
		System.out.println(count);
	}
	
	static void backtrack(int[] a, int k, int n){
//		System.out.println(Arrays.toString(a) + " k = " + k);
		int[] c = new int[n];
		int nc;
		if(is_a_solution(a,k,n)){
			count++;
			process_solution(a,k,n);
		}else{
			k++;
			nc = construct_candidates(a,k,n,c);
//			System.out.println(nc);
			for(int i = 0; i<nc; i++){
				a[k] = c[i];
				backtrack(a,k,n);
			}
		}
	}
	
	static int construct_candidates(int[] a,int k,int n,int[] c){
		int x = 0;
		boolean[] in_perm = new boolean[n+1];
		Arrays.fill(in_perm, false);
		for(int i = 0; i<k; i++){
			in_perm[ a[i] ] = true;
		}
		for(int i = 1; i<=n; i++){
			if(in_perm[i]==false){
				if(is_good(a,k,i))
				c[x++] = i; 
			}
		}

		return x;
	}
	
	static boolean is_good(int[] a, int k, int y){
		int conf = 0;
		for(int i = 1; i<k; i++){
			if(conflict(i,a[i],k,y))
				conf++;
		}
		return conf==0;
	}
	
	static boolean conflict(int x1, int y1, int x2, int y2){
		boolean result = false;
		result = (x1 == x2)
			||	 (y1 == y2)
			||	 ((x1+y1)==(x2+y2))
			|| 	 ((x1-y1)==(x2-y2));	
		return result;
	}
	
	static boolean is_a_solution(int[] a,int k,int n){
		return k==n;
	}
	
	static void process_solution(int[] a,int k,int n){
		System.out.println(Arrays.toString(a));
	}

}
