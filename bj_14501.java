package algorithmEx;

import java.util.*;

class detail {
	private int days;
	private int reward;
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	public detail(int days, int reward) {
		super();
		this.days = days;
		this.reward = reward;
	}
	
}

public class bj_14501 {

	static ArrayList<detail> info = new ArrayList<detail>();
	static int N;
	static int cost = 0;
	static int result = -10000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0;i<N;i++) {
			info.add(new detail(sc.nextInt(),sc.nextInt()));
		}
		dfs(0);
		System.out.println(result);
	}
	
	public static void dfs(int start) {
		if(start>=N) {
			if(cost>result) {
				result = cost;
			}
			return;
		}
//		if(start+info.get(start).getDays()>=N) {
//			if(cost>result) {
//				result = cost;
//			}
//		} else {
			for(int i=start;i<N;i++) {
				int getday = info.get(i).getDays();
				int reward = info.get(i).getReward();
				if(i+getday<=N) {
					cost = cost + reward;
					System.out.println(cost);
				}
				dfs(i+getday);
				if(i+getday<=N) {
					cost = cost - reward;
					System.out.println(cost);
				}
			}
//		}
	}
}
