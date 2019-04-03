package algorithmEx;

import java.util.*;

public class bj_1158 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			q.add(i+1);
		}
		
		while(!q.isEmpty()) {
			int cnt = 0;
			while(cnt<K-1) {
				int front = q.poll();
				q.add(front);
				cnt++;
			}
			int temp = q.poll();
			answer.add(temp);
		}
		System.out.print("<");
		for(int i=0;i<answer.size()-1;i++) {
			System.out.print(answer.get(i)+", ");
		}
		System.out.print(answer.get(answer.size()-1)+">");
		
//		for(int i=0;i<6;i++) {
//			list.add(i*i);
//		}
//		list.remove((Integer)4);
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i)); 
//		} // 요 친구들을 통해 값을 지우려면 (Integer)(숫자)로 해줘야 함을 알았다.
	}

}
