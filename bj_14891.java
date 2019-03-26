// Scanner를 쓸 때, 받을꺼면 한번에 받고, 나눠서 지랄하지 말자!

package algorithmEx;

import java.util.ArrayList;
import java.util.Scanner;

public class bj_14891 {
	
	static ArrayList<String> top1 = new ArrayList<String>();
	static ArrayList<String> top2 = new ArrayList<String>();
	static ArrayList<String> top3 = new ArrayList<String>();
	static ArrayList<String> top4 = new ArrayList<String>();
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		getInput(sc);
//		for(int i=0;i<8;i++) {
//			System.out.println(top4.get(i));
//		}
//		N =Integer.parseInt(sc.next());
		N = sc.nextInt();
		for(int i=0;i<N;i++) {
			String fu = sc.nextLine();
			int num = sc.nextInt();
			int dir = sc.nextInt();
			sol(num,dir);
		}
		System.out.println(getAns());
		// 2번, 6번이 포인트
	}
	
	public static int getAns() {
		int ans = 0;
		if(!(top1.get(0).equals("N"))) ans = ans + 1;
		if(!(top2.get(0).equals("N"))) ans = ans + 2;
		if(!(top3.get(0).equals("N"))) ans = ans + 4;
		if(!(top4.get(0).equals("N"))) ans = ans + 8;
		return ans;
	}
	
	public static void revolve(ArrayList<String> top, int dir) {
		if(dir==1) {
			for(int i=0;i<7;i++) {
				top.add(top.get(0));
				top.remove(0);
			}
		} else {
			top.add(top.get(0));
			top.remove(0);
		}
	}
	
	public static void sol(int num, int dir) {
		boolean isSame1 = (top1.get(2)).equals(top2.get(6));
		boolean isSame2 = (top2.get(2)).equals(top3.get(6));
		boolean isSame3 = (top3.get(2)).equals(top4.get(6));
		if(num==1) {
			revolve(top1,dir);
			if(!isSame1) {
				revolve(top2,-dir);
				if(!isSame2) {
					revolve(top3,dir);
					if(!isSame3) {
						revolve(top4,-dir);
					}
				}
			}
		} else if(num==2) {
			revolve(top2,dir);
			if(!isSame1) {
				revolve(top1,-dir);
			}
			if(!isSame2) {
				revolve(top3,-dir);
				if(!isSame3) {
					revolve(top4,dir);
				}
			}
		} else if(num==3) {
			revolve(top3,dir);
			if(!isSame2) {
				revolve(top2,-dir);
				if(!isSame1) {
					revolve(top1,dir);
				}
			}
			if(!isSame3) {
				revolve(top4,-dir);
			}
		} else {
			revolve(top4,dir);
			if(!isSame3) {
				revolve(top3,-dir);
				if(!isSame2) {
					revolve(top2, dir);
					if(!isSame1) {
						revolve(top1,-dir);
					}
				}
			}
		}
	}
	
	public static void getInput(Scanner sc) {
		String[] list1 = (sc.next()).split("");
		String[] list2 = (sc.next()).split("");
		String[] list3 = (sc.next()).split("");
		String[] list4 = (sc.next()).split("");
		for(int i=0;i<8;i++) {
			String tmp = list1[i];
			if(tmp.equals("1"))
				top1.add("S");
			else
				top1.add("N");
		}
		for(int i=0;i<8;i++) {
			String tmp = list2[i];
			if(tmp.equals("1"))
				top2.add("S");
			else
				top2.add("N");
		}
		for(int i=0;i<8;i++) {
			String tmp = list3[i];
			if(tmp.equals("1"))
				top3.add("S");
			else
				top3.add("N");
		}
		for(int i=0;i<8;i++) {
			String tmp = list4[i];
			if(tmp.equals("1"))
				top4.add("S");
			else
				top4.add("N");
		}
	}

}
