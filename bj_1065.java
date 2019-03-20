package algorithmEx;

import java.util.*;

public class bj_1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n<100) {
			System.out.println(n);
		} else {
			System.out.println(calc(n)+99);
		}
	}
	
	public static int calc(int n) {
		int count = 0;
		for(int i=100;i<=n;i++) {
			String temp = String.valueOf(i);
			ArrayList<String> templist = new ArrayList<String>(Arrays.asList(temp.split("")));
			int tempval = Integer.parseInt(templist.get(0))-Integer.parseInt(templist.get(1));
			int tempcnt = 0;
			for(int j=0;j<templist.size()-1;j++) {
				if(tempval != Integer.parseInt(templist.get(j))-Integer.parseInt(templist.get(j+1))) {
					break;
				}
				tempcnt++;
			}
			if(tempcnt==templist.size()-1) {
				count++;
			}
		}
		return count;
	}

}
