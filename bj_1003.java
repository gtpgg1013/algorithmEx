package algorithmEx;

import java.util.Scanner;
import java.util.ArrayList;

class fi_cnt{
	int val;
	int zero;
	int one;
	public int getZero() {
		return zero;
	}
	public void setZero(int zero) {
		this.zero = zero;
	}
	public int getOne() {
		return one;
	}
	public void setOne(int one) {
		this.one = one;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public fi_cnt(int zero, int one, int val) {
		super();
		this.zero = zero;
		this.one = one;
		this.val = val;
	}
}

public class bj_1003 {
	
	static fi_cnt[] fi_list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<m;i++) {
			list.add(sc.nextInt());
		}
		fi_list = new fi_cnt[getMax(list)+1];

		for(int i=0;i<list.size();i++) {
			fi_cnt ans = fi(list.get(i));
			System.out.println(ans.getZero()+ " " + ans.getOne());
		}
		
	}
	
	static public fi_cnt fi(int n) {
		if(fi_list[n]==null) {
			if(n==0) {
				fi_list[n] = new fi_cnt(1,0,0);
			}else if(n==1) {
				fi_list[n] = new fi_cnt(0,1,1);
			}
			else {
				fi_list[n] = new fi_cnt(fi(n-1).getZero()+fi(n-2).getZero(),
											fi(n-1).getOne()+fi(n-2).getOne(),
											fi(n-1).getVal()+fi(n-2).getVal());
			}
			return fi_list[n];
		}
		else {
			return fi_list[n];
		}
	}
	
	static public int getMax(ArrayList<Integer> list) {
		int max = -100;
		for(int i=0;i<list.size();i++) {
			if(max<list.get(i)) {
				max = list.get(i);
			}
		}
		return max;
	}

}
