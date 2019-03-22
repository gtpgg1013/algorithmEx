package algorithmEx;

import java.util.*;

class paper{
	int imp;
	boolean target;
	public paper(int imp, boolean target) {
		super();
		this.imp = imp;
		this.target = target;
	}
}

public class bj_1966 {
	
	static int N;
	static ArrayList<Integer> ans = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0;i<N;i++) {
			int length = sc.nextInt();
			int targetnum = sc.nextInt();
			Queue<paper> q = new LinkedList<paper>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			ArrayList<Boolean> result = new ArrayList<Boolean>();
			for(int j=0;j<length;j++) {
				int temp = sc.nextInt();
				list.add(temp);
				if(j==targetnum) {
					q.add(new paper(temp,true));
				} else {
					q.add(new paper(temp,false));
				}
			}
			
			
			// ArrayList까지 양쪽에 들고 하면 할 수 있을듯?
			while(!q.isEmpty()) {
				paper p = q.poll();
				int imp = p.imp;
				boolean tar = p.target;
				boolean check = false;
				int max = Collections.max(list);
				if(imp==max)
					check = true;
				if(check==true) {
					list.remove(0);
					result.add(tar);
				} else {
					q.add(p);
					list.remove(0);
					list.add(imp);
				}
			}
			for(int j=0;j<result.size();j++) {
				if(result.get(j)==true)
//					System.out.println(j);
					ans.add(j+1);
			}
		}
		printlist();
	}
	
	public static void printlist() {
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
