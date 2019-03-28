package algorithmEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

class graph {
	int me;
	ArrayList<Integer> connected = new ArrayList<Integer>();
	public graph(int me, ArrayList<Integer> connected) {
		super();
		this.me = me;
		this.connected = connected;
	}
	
}

public class bj_1260 {
	
	static int N, M, V;
	static graph[] list;
	static boolean[] visited = new boolean[1001];
	static Queue<graph> q = new LinkedList<graph>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		list = new graph[N+1];
		for(int i=0;i<visited.length;i++) {
			visited[i] = false;
		}
		
		for(int i=0;i<N+1;i++) {
			list[i] = new graph(i, new ArrayList<Integer>());
		}
		for(int i=0;i<M;i++) {
			int temp = sc.nextInt();
			int conn = sc.nextInt();
			(list[temp].connected).add(conn);
			(list[conn].connected).add(temp);
		}
		for(int i=0;i<N;i++) {
			Collections.sort(list[i].connected);
		}
		dfs(V);
		System.out.println();
		clearvisited();
		q.offer(list[V]);
		bfs();
	}
	
	public static void dfs(int start) {
		if(visited[start]==false) {
			visited[start] = true;
			System.out.print(start+" ");
		}
		graph temp = list[start];
		ArrayList<Integer> connlist = temp.connected;
		for(int i=0;i<connlist.size();i++) {
			if(visited[connlist.get(i)]==false) {
				dfs(connlist.get(i));
			}
		}
	}
	
	// priority Queue
	public static void bfs() {
		while(!q.isEmpty()) {
			graph temp = q.poll();
			int me = temp.me;
			ArrayList<Integer> connlist = temp.connected;
			if(visited[me]==false) {
				visited[me] = true;
				System.out.print(me+" ");
			} 
			for(int i=0;i<connlist.size();i++) {
				if(visited[connlist.get(i)]==false) {
					q.offer(list[connlist.get(i)]);
				}
			}
		}
	}
	
	public static void clearvisited() {
		for(int i=0;i<visited.length;i++) {
			visited[i] = false;
		}
	}
	
}
