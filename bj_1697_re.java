package algorithmEx;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class xcount{
	int x;
	int count;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public xcount(int x, int count) {
		super();
		this.x = x;
		this.count = count;
	}
	
}
public class bj_1697_re {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int count = 0;
		Queue<xcount> q = new LinkedList<xcount>();
		int[] list = new int[100001];
		
		xcount start = new xcount(m, count);
		
		for(int i=0;i<list.length;i++) {
			list[i] = -1;
		}
		q.offer(start);
		while(!q.isEmpty()) {
			// 여기서 만약 nowx랑 nowcount를 설정 안하고 가면 ex -> q.offer(new xcount(tp.getX(),tp.getCount())) 이따위로 쓰면 메모리오바남
			xcount tp = q.poll();
			int nowx = tp.getX();
			int nowcount = tp.getCount();
			list[nowx] = nowcount;
			if(nowx-1>=0 && nowx-1<100001 && list[nowx-1]==-1) {
					q.offer(new xcount(nowx-1, nowcount+1));
					list[nowx-1] = nowcount+1;
			}
			if(nowx+1>=0 && nowx+1<100001 && list[nowx+1]==-1) {
					q.offer(new xcount(nowx+1, nowcount+1));
					list[nowx+1] = nowcount+1;
			}
			if(nowx*2>=0 && nowx*2<100001 && list[nowx*2]==-1) {
					q.offer(new xcount(nowx*2, nowcount+1));
					list[nowx*2] = nowcount+1;
			}
			if(list[n]!=-1) break;
		}
		System.out.println(list[n]);
	}

}
