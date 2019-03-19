package algorithmEx;

import java.util.Scanner;

public class bj_14890 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int tri = sc.nextInt();
		int[][] list = new int[m][m];
		int count = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				list[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				if(j+1<m && Math.abs(list[i][j]-list[i][j+1])>=2) { // 2칸 이상 뛰면 못가는길
					break;
				} else if(j+1+tri<m && list[i][j]-list[i][j+1]==1) { // 앞의 블럭이 더 높은 경우
					int temp = 0;
					for(int k=0;k<tri;k++) {
						if(list[i][j+1+k]!=list[i][j+2+k]) {
							break;
						} else {
							temp++;
						}
					}
					if(temp!=tri-1) {
						break;
					} else {
						count++;
						break;
					}
				} else if(j-tri>0 && j+1<m && list[i][j]-list[i][j+1]==-1) { // 뒤의 블럭이 더 높은경우
					int temp = 0;
					for(int k=0;k<tri;k++) {
						if(list[i][j-k]!=list[i][j-1-k]) {
							break;
						} else {
							temp++;
						}
					}
					if(temp!=tri-1) {
						break;
					} else {
						count++;
						break;
					}
				} else {
					count++;
				}
			}
		}
		
		for(int j=0;j<m;j++) {
			for(int i=0;i<m;i++) {
				if(i+1<m && Math.abs(list[i][j]-list[i+1][j])>=2) { // 2칸 이상 뛰면 못가는길
					break;
				} else if(i+1+tri<m && list[i][j]-list[i+1][j]==1) { // 앞의 블럭이 더 높은 경우
					int temp = 0;
					for(int k=0;k<tri;k++) {
						if(list[i+1+k][j]!=list[i+2+k][j]) {
							break;
						} else {
							temp++;
						}
					}
					if(temp!=tri-1) {
						break;
					} else {
						count++;
						break;
					}
				} else if(i-tri>0 && i+1<m && list[i][j]-list[i+1][j]==-1) { // 뒤의 블럭이 더 높은경우
					int temp = 0;
					for(int k=0;k<tri;k++) {
						if(list[i-k][j]!=list[i-1-k][j]) {
							break;
						} else {
							temp++;
						}
					}
					if(temp!=tri-1) {
						break;
					} else {
						count++;
						break;
					}
				} else {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	// 이렇게 세면 겹쳐지게 됨
}
