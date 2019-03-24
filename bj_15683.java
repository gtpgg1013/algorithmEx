package algorithmEx;

import java.util.*;

public class bj_15683 {
	
	static int N, M;
	static int[][] list;
	static int answer = 10000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				list[i][j] = sc.nextInt();
			}
		}
		dfs(0,0);
		System.out.println(answer);
	}
	
	public static void dfs(int i, int j) {
		if(i+1==N && j==M) {
			sol();
			return;
		}
//		for(int i=y;i<N;i++) {
//			for(int j=j;j<M;j++) {
		else {
				if(list[i][j]==1) {
					for(int k=0;k<4;k++) {
						if(k==0) {
							makeupline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleteupline(i, j);
						}
						if(k==1) {
							makebelowline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deletebelowline(i, j);
						}
						if(k==2) {
							makeleftline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleteleftline(i, j);
						}
						if(k==3) {
							makerightline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleterightline(i, j);
						}
					}
				}
				else if(list[i][j]==2) {
					for(int k=0;k<2;k++) {
						if(k==0) {
							makeupline(i, j);
							makebelowline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleteupline(i, j);
							deletebelowline(i, j);
						}
						if(k==1) {
							makeleftline(i, j);
							makerightline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleteleftline(i, j);
							deleterightline(i, j);
						}
					}
				}
				else if(list[i][j]==3) {
					for(int k=0;k<4;k++) {
						if(k==0) {
							makeupline(i, j);
							makeleftline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleteupline(i, j);
							deleteleftline(i, j);
						}
						if(k==1) {
							makeleftline(i, j);
							makebelowline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleteleftline(i, j);
							deletebelowline(i, j);
						}
						if(k==2) {
							makebelowline(i, j);
							makerightline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deletebelowline(i, j);
							deleterightline(i, j);
						}
						if(k==3) {
							makerightline(i, j);
							makeupline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleterightline(i, j);
							deleteupline(i, j);
						}
					}
				}
				else if(list[i][j]==4) {
					for(int k=0;k<4;k++) {
						if(k==0) {
							makeupline(i, j);
							makeleftline(i, j);
							makerightline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleteupline(i, j);
							deleteleftline(i, j);
							deleterightline(i, j);
						}
						if(k==1) {
							makeleftline(i, j);
							makebelowline(i, j);
							makeupline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleteleftline(i, j);
							deletebelowline(i, j);
							deleteupline(i, j);
						}
						if(k==2) {
							makebelowline(i, j);
							makerightline(i, j);
							makeleftline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deletebelowline(i, j);
							deleterightline(i, j);
							deleteleftline(i, j);
						}
						if(k==3) {
							makerightline(i, j);
							makeupline(i, j);
							makebelowline(i, j);
							if(j+1==M && i+1!=N) {
								dfs(i+1,0);
							} else {
								dfs(i,j+1);
							}
							deleterightline(i, j);
							deleteupline(i, j);
							deletebelowline(i, j);
						}
					}
				}
				else if(list[i][j]==5) {
					makeupline(i, j);
					makeleftline(i, j);
					makerightline(i, j);
					makebelowline(i, j);
					if(j+1==M && i+1!=N) {
						dfs(i+1,0);
					} else {
						dfs(i,j+1);
					}
					deleteupline(i, j);
					deleteleftline(i, j);
					deleterightline(i, j);
					deletebelowline(i, j);
				}
				else {
					if(j+1==M && i+1!=N) {
						dfs(i+1,0);
					} else {
						dfs(i,j+1);
					}
				}
		}
//			}
//		}
	}
	
	public static void sol() {
		int temp = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(list[i][j]==0) {
					temp++;
				}
			}
		}
		if(answer>temp) {
			answer = temp;
		}
//		print();
//		System.out.println();
	}
	
	public static void makeupline(int i, int j) {
		int tmp = 1;
		while(true) {
			if(i+tmp>=N) break;
			if(list[i+tmp][j]==6) break;
			if(list[i+tmp][j]<=0) {
				list[i+tmp][j] = list[i+tmp][j] - 1;
			}
			tmp++;
		}
	}
	
	public static void deleteupline(int i, int j) {
		int tmp = 1;
		while(true) {
			if(i+tmp>=N) break;
			if(list[i+tmp][j]==6) break;
			if(list[i+tmp][j]<=0) {
				list[i+tmp][j] = list[i+tmp][j] + 1;
			}
			tmp++;
		}
	}
	
	public static void makebelowline(int i, int j) {
		int tmp = 1;
		while(true) {
			if(i-tmp<0) break;
			if(list[i-tmp][j]==6) break;
			if(list[i-tmp][j]<=0) {
				list[i-tmp][j] = list[i-tmp][j] - 1;
			}
			tmp++;
		}
	}
	
	public static void deletebelowline(int i, int j) {
		int tmp = 1;
		while(true) {
			if(i-tmp<0) break;
			if(list[i-tmp][j]==6) break;
			if(list[i-tmp][j]<=0) {
				list[i-tmp][j] = list[i-tmp][j] + 1;
			}
			tmp++;
		}
	}
	
	public static void makerightline(int i, int j) {
		int tmp = 1;
		while(true) {
			if(j+tmp>=M) break;
			if(list[i][j+tmp]==6) break;
			if(list[i][j+tmp]<=0) {
				list[i][j+tmp] = list[i][j+tmp] - 1;
			}
			tmp++;
		}
	}
	
	public static void deleterightline(int i, int j) {
		int tmp = 1;
		while(true) {
			if(j+tmp>=M) break;
			if(list[i][j+tmp]==6) break;
			if(list[i][j+tmp]<=0) {
				list[i][j+tmp] = list[i][j+tmp] + 1;
			}
			tmp++;
		}
	}
	public static void makeleftline(int i, int j) {
		int tmp = 1;
		while(true) {
			if(j-tmp<0) break;
			if(list[i][j-tmp]==6) break;
			if(list[i][j-tmp]<=0) {
				list[i][j-tmp] = list[i][j-tmp] - 1;
			}
			tmp++;
		}
	}
	
	public static void deleteleftline(int i, int j) {
		int tmp = 1;
		while(true) {
			if(j-tmp<0) break;
			if(list[i][j-tmp]==6) break;
			if(list[i][j-tmp]<=0) {
				list[i][j-tmp] = list[i][j-tmp] + 1;
			}
			tmp++;
		}
	}
	
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(list[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
