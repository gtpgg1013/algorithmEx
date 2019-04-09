package algorithmEx;

// 필수 기억 -> 나무 심고 오름차순 정리!

import java.util.*;

class land{
	int y;
	int x;
	int nutrition;
	ArrayList<Integer> treelist = new ArrayList<Integer>();
	public land() {}
	public land(int y, int x, int nutrition, ArrayList<Integer> treelist) {
		super();
		this.y = y;
		this.x = x;
		this.nutrition = nutrition;
		this.treelist = treelist;
	}
}

public class bj_16235 {
	
	static land[][] map;
	static int[][] nutval;
	static int N,M,K;
	static int dx[] = {1,1,0,-1,-1,-1,0,1};
	static int dy[] = {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new land[N][N];
		nutval = new int[N][N];
		
		for(int i=0;i<N;i++) { // 겨울때 뿌릴 양분 값 저장 map
			for(int j=0;j<N;j++) {
				nutval[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<N;i++) { // 지도 초기화
			for(int j=0;j<N;j++) {
				map[i][j] = new land(i,j,5,new ArrayList<Integer>());
			}
		}
		
		for(int i=0;i<M;i++) { // 나무 심기
			int tempy = sc.nextInt()-1;
			int tempx = sc.nextInt()-1;
			int temptree = sc.nextInt();
			map[tempy][tempx].treelist.add(temptree);
		}
		
//		for(int i=0;i<N;i++) { // 나무 리스트 소팅
//			for(int j=0;j<N;j++) {
//				if(map[i][j].treelist.size()!=0) {
//					Collections.sort(map[i][j].treelist);
//				}
//			}
//		}
		
		for(int i=0;i<K;i++) {
			spring_summer();
			fall();
			winter();
//			print();
//			printnut();
		}
		
		System.out.println(getTreeNum());
		
	}
	
	public static void spring_summer() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				land l = map[i][j]; 
				ArrayList<Integer> tlist = l.treelist;
				int nut = l.nutrition;
				for(int k=0;k<tlist.size();k++) {
					if(tlist.get(k)<=nut) {
						nut = nut - tlist.get(k);
						tlist.set(k, tlist.get(k)+1);
					} else {
						tlist.set(k, -tlist.get(k));
					}
				}
				for(int k=tlist.size()-1;k>=0;k--) {
					if(tlist.get(k)<0) {
						nut = nut - tlist.get(k)/2; // 이걸 더해줘서 답이 안나온거였음!
						tlist.remove(k);
					}
				}
//				Collections.sort(tlist);
				map[i][j].treelist = tlist;
				map[i][j].nutrition = nut;
			}
		}
	}
	
//	public static void summer() {
//		
//	}
	
	public static void fall() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				land templand = map[i][j];
				ArrayList<Integer> list = templand.treelist;
				for(int k=0;k<list.size();k++) {
					if(list.get(k)%5==0) {
						for(int a=0;a<8;a++) {
							int nexty = i + dx[a];
							int nextx = j + dy[a];
							if(nextx>=0 && nextx<N && nexty>=0 && nexty<N) {
								map[nexty][nextx].treelist.add(0,1);
							}
						}
					}
				}
			}
		}
	}
	
	public static void winter() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j].nutrition += nutval[i][j];
			}
		}
	}
	
	public static int getTreeNum() {
		int ans = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ans += map[i][j].treelist.size();
			}
		}
		return ans;
	}
	
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j].treelist.size()+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printnut() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j].nutrition+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
