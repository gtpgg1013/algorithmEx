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

// � �ڷᱸ���� ������ ���ΰ�? 
// Dynamic Programming?
// n��° fi�� ���Ѵٰ� �ϸ� --> nũ���� �迭�� ����� �����Ѵ�?