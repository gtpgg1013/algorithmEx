package algorithmEx;

// Ʋ�� ���� : long�� �Ƚ��༭

import java.util.*;

public class bj_13458 {
	
	static long N;
	static ArrayList<Long> list = new ArrayList<Long>();
	static long B,C;
	static long answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0;i<N;i++) {
			long temp = sc.nextInt();
			list.add(temp);
		}
		B = sc.nextInt();
		C = sc.nextInt();
		
		for(int i=0;i<list.size();i++) {
			long val = list.get(i);
			answer++;
			if(B>=val) {
				continue;
			} else {
				long tempval = val - B; // ������
				if(tempval<=C) { // �ȳ����൵ �� (�ΰ��� ���̽���)
					answer++;
				} else {
					answer += tempval/C;
					if(tempval%C!=0) {
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
