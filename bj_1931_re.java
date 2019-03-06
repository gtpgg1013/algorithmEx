package algorithmEx;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

class met{
	private int start;
	private int end;
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
	public met(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
}

class compareForMet implements Comparator<met>{
	@Override
	public int compare(met o1, met o2) {
		if(o1.getEnd()<o2.getEnd()) {
			return -1;
		}else if(o1.getEnd()==o2.getEnd()) {
			if(o1.getStart()<o2.getStart()) {
				return -1;
			} else { return 0; }
		}
		return 1;
	}
}

public class bj_1931_re {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		ArrayList<met> list = new ArrayList<met>();
		for(int i=0;i<m;i++) {
			list.add(new met(sc.nextInt(),sc.nextInt()));
		}
		Collections.sort(list, new compareForMet());
		
	}
	public static int solve(ArrayList<met> list) {
		int count = 0;
		int endTime = -1;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getStart()>=endTime) {
				count++;
				endTime=list.get(i).getEnd();
			}
		}
		return count;
	}
}
