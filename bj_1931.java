package algorithmEx;

import java.util.ArrayList;
import java.util.Scanner;

// 이거 틀림

class meeting {
	int start;
	int end;
	int length;
	public meeting(int start, int end, int length) {
		this.start = start;
		this.end = end;
		this.length = length;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}

public class bj_1931 {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<meeting> list = new ArrayList<meeting>();
	static int M;
	static int tlength = 0;
	static int count = 0;
	static int ans = 0;
	static boolean[] timelist;
	
	public static void main(String[] args) {
		M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			meeting nm = new meeting(m,n,n-m);
			list.add(nm);
		}
		for(int i=0;i<M;i++) {
			if(tlength<=list.get(i).getEnd()) {
				tlength = list.get(i).getEnd();
			}
		}
		System.out.println(tlength);
		
		timelist = new boolean[tlength];
		
		for(int i=0;i<tlength;i++) {
			timelist[i]=false;
		}
		
		int max = getMaxVal();
		
		while(true) {
			// 길이 제일 짧은거부터 해서 넣어주기 --> 넣으면 ans ++ // 길이 제일 짧은거는 반례가 있다.
			// 그리고 ++ 하면서 넣어주기
			// 마지막  끝
			for(int i=0;i<list.size();i++) {
				// if(list.get(i).getLength()==0) {ans++;} 
				if(list.get(i).getLength()==count) {
					int s = list.get(i).getStart();
					int l = list.get(i).getLength();
					boolean check = false;
					for(int a=s;a<s+l;a++) {
						if(timelist[a]==true) {
							check=true;
						}
					}
					if(check==false) {
						for(int a=s;a<s+l;a++) {
							timelist[a]=true;
						}
						ans++;
					}
				}
			}
			count++;
			if(max<count) {break;}
		}
		
		System.out.println(ans);
		
	}
	
	public static int getMaxVal() {
		int ans = 0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getEnd()>ans)
				ans = list.get(i).getEnd();
		}
		return ans;
	}
	
	public static void printlist(int [] a) {
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]+ " ");
		}
	}
	
	public static void printlist(ArrayList<Integer> a) {
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i)+ " ");
		}
	}

}
