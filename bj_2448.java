package algorithmEx;

import java.util.*;

public class bj_2448 {
	
	static int num;
	static ArrayList<String> map = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		map.add("  *  ");
		map.add(" * * ");
		map.add("*****");
		makebigstar();
		printstar();
	}
	
	public static void makeblank(int n) {
		for(int i=0;i<n;i++) {
			System.out.print(" ");
		}
	}
	
	public static void makebigstar() {
		int n = num;
		int cnt = 0;
		while(true) {
			if(n%2!=0) {
				break;
			} else {
				n = n/2;
				cnt++;
			}
		}
		int temp = 3;
		for(int i=0;i<cnt;i++) {
			String space = "";
			for(int j=0;j<temp;j++) {
				space += " ";
			}
			for(int j=0;j<temp;j++) {
				map.add(map.get(j)+" "+map.get(j));
				map.set(j, space + map.get(j) + space);
			}
			temp = temp * 2;
		}
	}
	
	public static void printstar() {
		for(int i=0;i<num;i++) {
//			makeblank(((num-i)/3)*3);
			System.out.println(map.get(i));
		}
	}
}
