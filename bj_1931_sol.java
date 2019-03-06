package algorithmEx;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

class meet{
	int start;
	int end;
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
}

class compareForMeeting implements Comparator<meet>{
	public int compare(meet m1, meet m2) {
		if(m1.end < m2.end) {
			return -1;
		} else if (m1.end == m2.end) {
			if(m1.start < m2.start) {
				return -1;
			} else {
				return 0;
			}
		}
		return 1;
	}
}

public class bj_1931_sol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		ArrayList<meet> list = new ArrayList<meet>();
		for(int i=0;i<m;i++) {
			meet meeting = new meet();
			meeting.setStart(sc.nextInt());
			meeting.setEnd(sc.nextInt());
			list.add(meeting);
		}
		Collections.sort(list, new compareForMeeting());
		System.out.println(solve(list));
	}
	
	public static int solve(ArrayList<meet> list) {
		int count = 0;
		int endTime = -1;
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getStart()>=endTime) {
				count++;
				endTime = list.get(i).getEnd();
			}
		}
		return count;
	}

}
