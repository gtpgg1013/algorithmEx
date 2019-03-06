package algorithmEx;

public class fibonacci {
	
	static public int fi(int n) {
		if(n==1) return 1;
		if(n==2) return 1;
		
		return fi(n-1) + fi(n-2);
	}

	public static void main(String[] args) {
		System.out.println(fi(3));
	}

}

// 어떤 자료구조를 선택할 것인가? 
// Dynamic Programming?
// n번째 fi를 구한다고 하면 --> n크기의 배열을 만들고 시작한다?