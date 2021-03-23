package boj.day0323; 

public class BJ_4673_Main {

	private static boolean []arr = new boolean[10001];
	// 자신이 생성한 수열을 리턴하는 메서드
	private static void su(Integer num) {
		
		int len = num.toString().length();
		//System.out.println(num+"에 대한 결과 알아보기 ");
		Integer result = num;
		for(int i = 0; i < len; i++) {
			String sub = result.toString().substring(i, i+1);
			num += Integer.parseInt(sub);
			//System.out.println(sub+","+num);
		}
		if(num < 10001) {
			arr[num] = true;
		}
	}
	
	public static void main(String[] args) {
		
		for(int i = 1; i < 10001; i++) {
			su(i);
		}
		
		for(int i = 1; i < 10001; i++) {
			if(!arr[i]) {
				System.out.println(i);
			}
		}
	}
}
