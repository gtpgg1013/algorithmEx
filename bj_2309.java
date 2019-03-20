package algorithmEx;

import java.util.*;

public class bj_2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<9;i++) {
			list.add(sc.nextInt());
		}
		int sum = 0;
		for(int i=0;i<9;i++) {
			sum = sum + list.get(i);
		}
		for(int i=0;i<9;i++) {
			int loopout = 0;
			for(int j=0;j<9;j++) {
				if(i!=j) {
					int tempsum = sum-list.get(i)-list.get(j);
					if(tempsum==100) {
						Integer tempval1 = list.get(i);
						Integer tempval2 = list.get(j);
						list.remove(tempval1);
						list.remove(tempval2);
						loopout=1;
						break;
					}
				}
			}
			if(loopout==1)
				break;
		}
		Collections.sort(list);
		for(Integer num : list) {
			System.out.println(num);
		}
	}

}
