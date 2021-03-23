package sweajw.day0323;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_SWEA_Flatten {

	private static void dump(ArrayList<Integer> arr, int cnt) {

		if (cnt == 0) {
			return;
		}
		int maxHeight = 0, minHeight = 100;
		int maxIndex = 0, minIndex = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > maxHeight) {
				maxHeight = arr.get(i);
				maxIndex= i;
			}
			if (arr.get(i) < minHeight) {
				minHeight = arr.get(i);
				minIndex= i;
			}
		}
		arr.set(maxIndex,(arr.get(maxIndex)-1));
		arr.set(minIndex,(arr.get(minIndex)+1));
		dump(arr, --cnt);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int T = 0; T < 10; T++) {
			int cnt = sc.nextInt();
			sc.nextLine();
			String boxLine = sc.nextLine();
			String [] boxSplit = boxLine.split(" ");
			ArrayList<Integer> box = new ArrayList<>();
			
			for(int i = 0; i < boxSplit.length; i++) {
				box.add(Integer.parseInt(boxSplit[i]));
			}
			dump(box, cnt);
			
			int maxHeight = 0, minHeight = 100;
			for (int i = 0; i < box.size(); i++) {
				if(box.get(i) > maxHeight)
					maxHeight = box.get(i);
				if(box.get(i) < minHeight)
					minHeight = box.get(i);
			}
			System.out.println("#" + (T+1) + " " + (maxHeight-minHeight));
		}
		sc.close();
	}
}
