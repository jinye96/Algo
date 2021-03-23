package sweajw.day0323;

import java.util.Scanner;

public class SWE_2005_Solution {
	public static int[] Paskal(int[] arr) {
		int[] newArr = new int [arr.length + 1];
		
		newArr[0] = 1;
		newArr[newArr.length -1] = 1;
		
		for(int i = 1; i < arr.length; i++) {
			newArr[i] = arr[i-1] + arr[i];
		}
		
		return newArr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int[] input = new int[1];
			input[0] = 1;
			int loop = sc.nextInt();
			System.out.println("#" + (i+1));
			System.out.println(1);
			for(int i1 = 1; i1 < loop; i1++) {
				input = Paskal(input);
				for(int j = 0; j < input.length; j++) {
					System.out.print(input[j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
