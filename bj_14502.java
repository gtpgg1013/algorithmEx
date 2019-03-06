//package algorithmEx;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class bj_14502 {
//	
//	
//	
//	static int N,M;
//	static int[][] map;
//	static int[][] memory_map;
//	static Queue<xy> q = new LinkedList<xy>();
//	final static int WALL = 1;
//	final static int EMPTY = 0;
//	final static int VIRUS = 2;
//	static int[] drow = {-1,0,1,0};
//	static int[] dcol = {0,-1,0,1};
//	static int ans=-100;
//
//	static Scanner sc = new Scanner(System.in);
//	
//	public static void main(String[] args) {
//		N = sc.nextInt();
//		M = sc.nextInt();
//		map = new int[N][M];
//		memory_map = new int[N][M];
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				map[i][j]= sc.nextInt();
//			}
//		}
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++)
//				memory_map[i][j]=map[i][j];
//		}
//		makeWall();
//		System.out.print(ans);
//		
//
//	}
//	
//	public static void bfs() {
//		
//		boolean[][] check = new boolean[N][M];
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++)
//				check[i][j]=false;
//		}
//		
//	
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				if(map[i][j]==VIRUS) {
//					xy temp = new xy();
//					temp.setRow(i);
//					temp.setCol(j);
//					check[i][j]=true;
//					q.offer(temp);
//				}
//			}
//		}
//		
//		//바이러스 퍼뜨리기 시작
//		while(!q.isEmpty()) {
//			xy front = new xy();		//q front 받는애
//			front.setRow(q.peek().getRow());
//			front.setCol(q.peek().getCol());
//			
//			// 포문은 front랑 인접해있는 empty를 virus로 바꿔주고 그 xy를 q에 push하는거
//			for(int i=0;i<4;i++) {
//				if(front.getRow()+drow[i]>-1&&front.getRow()+drow[i]<N&&
//						front.getCol()+dcol[i]>-1&&front.getCol()+dcol[i]<M) {
//					if(map[front.getRow()+drow[i]][front.getCol()+dcol[i]]==EMPTY
//							&&check[front.getRow()+drow[i]][front.getCol()+dcol[i]]==false) {
//						xy temp = new xy();
//						int temp_row = front.getRow()+drow[i];
//						int temp_col = front.getCol()+dcol[i];
//						
//						map[temp_row][temp_col]=VIRUS;
//						check[temp_row][temp_col]=true;
//						temp.setRow(temp_row);
//						temp.setCol(temp_col);
//						q.offer(temp);
//					}
//				}
//			}
//			q.poll();
//			
//		}
//	}
//	
//	public static int countEmpty() {
//		int count=0;
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				if(map[i][j]==EMPTY) {
//					count++;
//				}
//			}
//		}
//		return count;
//	}
//	
//	public static void printMap() {
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//	}
//	
//	public static void clearMap() {
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++)
//				map[i][j]=memory_map[i][j];
//		}
//	}
//	
//	public static void makeWall() {
//		
//		int temp_map[][]= new int[N][M];
//		
//		for(int a=0;a<N;a++) {
//			for(int b=0;b<M;b++) {
//				if(map[a][b]==EMPTY) {
//					for(int c=0;c<N;c++) {
//						for(int d=0;d<M;d++) {
//							if(map[c][d]==EMPTY) {
//								for(int e=0;e<N;e++) {
//									for(int f=0;f<M;f++) {
//										if(map[e][f]==EMPTY) {
//											map[a][b]=WALL;
//											map[c][d]=WALL;
//											map[e][f]=WALL;
//											bfs(); // 뿌려
//											if(countEmpty()>ans)
//												ans=countEmpty(); // 최대엠티개수 갱신
//											clearMap();
//										}
//									}
//								}
//							}
//							
//						}
//					}
//				}
//				
//			}
//		}
//	}
//
//}
//
////class xy{
////	int row;
////	int col;
////	public int getRow() {
////		return row;
////	}
////	public void setRow(int row) {
////		this.row = row;
////	}
////	public int getCol() {
////		return col;
////	}
////	public void setCol(int col) {
////		this.col = col;
////	}
//	
//}
