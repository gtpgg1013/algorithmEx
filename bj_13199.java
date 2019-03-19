package algorithmEx;

import java.util.*;

class eachcase {
	private int cp;
	private int mon;
	private int fc;
	private int co;
	public eachcase(int cp, int mon, int fc, int co) {
		super();
		this.cp = cp;
		this.mon = mon;
		this.fc = fc;
		this.co = co;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getMon() {
		return mon;
	}
	public void setMon(int mon) {
		this.mon = mon;
	}
	public int getFc() {
		return fc;
	}
	public void setFc(int fc) {
		this.fc = fc;
	}
	public int getCo() {
		return co;
	}
	public void setCo(int co) {
		this.co = co;
	}
}

public class bj_13199 {
	
	static int schick = 0;
	static int nchick = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<eachcase> list = new ArrayList<eachcase>();
		for(int i=0;i<n;i++) {
			eachcase temp = new eachcase(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			list.add(temp);
		}
		for(int i=0;i<n;i++) {
			calc_s(list.get(i).getCp(), list.get(i).getMon(), list.get(i).getFc(), list.get(i).getCo());
			calc_n(list.get(i).getCp(), list.get(i).getMon(), list.get(i).getFc(), list.get(i).getCo());
			System.out.println(schick-nchick);
			schick=0;
			nchick=0;
		}
	}
	
	public static void calc_s(int a, int b, int c, int d) {
		int chick = (b/a);
		if((chick*d/c)>0) {
			schick += chick*d/c;
			calc_s(1,chick*d/c,c,d);
		}
	}
	
	public static void calc_n(int a, int b, int c, int d) {
		int chick = (b/a);
		if((chick*d/c)>0) {
			nchick += chick*d/c;
		}
	}

}
