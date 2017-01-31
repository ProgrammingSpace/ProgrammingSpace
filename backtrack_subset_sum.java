import java.util.Arrays;
import java.util.Scanner;


public class backtrack_subset_sum {
	static int main_sum;
	static int[] main_set;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		try{
//			while(true){
				int n = scan.nextInt();
				main_sum = scan.nextInt();
				main_set = new int[n];
				main_set[0] = 0;
				for(int i = 0; i<n; i++){
					main_set[i] = scan.nextInt();
				}
//				Arrays.sort(main_set);
				System.out.println(Arrays.toString(main_set));
				int[] a = new int[n+1];
				backtrack(a,0,n);
//			}
//		}catch(Exception e){}		
		scan.close();
	}	
	static void backtrack(int[] a, int k, int n){
		System.out.println(Arrays.toString(a));
		int[] c = new int[n];
		int nc = 0;
		if(is_a_solution(a,k,n)){
			process_solution(a,k,n);
		}else if(k!=n){
			k++;
			nc = construct_candidates(a,k,n,c);
			for(int i = 0; i<nc; i++){
				a[k] = c[i];
				backtrack(a,k,n);
			}
		}
	}
	
	static void process_solution(int[] a,int k,int n){
		System.out.println("Ans: " + Arrays.toString(a));
	}
	static boolean is_a_solution(int[] a, int k, int n){
		int sum = 0;
		for(int i = 1; i<k; i++){
			if(a[i]==1)
			sum += main_set[i-1];
		}
		System.out.println("Sum = "+sum);
		return sum == main_sum;
//		return k==n;
	}
	static int construct_candidates(int[] a, int k, int n, int[] c){
//		int sum = 0;
//		int nc = 0;
//		for(int i = 1; i<k; i++){
//			sum += main_set[a[i]];
//		}
//		if(sum<main_sum){
//			c[0] = 1;
//			nc = 1;
//		}
		c[0] = 0; 
		c[1] = 1;
		return 2;
	}

}
