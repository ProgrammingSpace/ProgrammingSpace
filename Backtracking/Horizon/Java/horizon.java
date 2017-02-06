/*The Horizon: Uses Backtracking algorithm to count the number of occurences of a word
 * in the given grid of characters.
 */
import java.util.Scanner;

public class horizon {
	static String word;
	static char[][] grid;
	static int m,n;
	static int count;

	public static void main(String[] args){
		//Setup for inputs using Scanner
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		count = 0;
		grid = new char[m][n];
		
		//Garbage String to move on from the last integer to the first character
		String temp = scan.nextLine();
		
		//Form the grid by splitting the input strings
		for(int i = 0; i<m; i++){
			grid[i] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
		}
		
		//Input string to search for in the grid
		word = scan.nextLine();
		
		//Search for the first character of the word in the grid and start the backtrack from it
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(grid[i][j]==word.charAt(0)){
					backtrack(i,j,1);
				}
			}
		}
		
		//Print out the number of occurences of the word in the grid
		System.out.println(count);
	}
	
	//The main recursive backtracking function that searches the grid for the succeeding 
	//characters of the word at each level of recursion.
	static void backtrack(int x, int y, int k){
		if((k)==word.length()){
			count++;
		}else{
			for(int i = -1; i<2; i++){
				for(int j = -1; j<2; j++){
					if(x+i>=0 && x+i<m && y+j>=0 && y+j<n){
						if(word.charAt(k)==grid[x+i][y+j]){
							backtrack(x+i,y+j,k+1);
						}
					}
				}
			}
		}
	}
}
