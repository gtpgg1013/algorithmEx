package algorithmEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class quicksort {
	
	static List<Integer> list = new ArrayList<Integer>(10);

	public static void main(String[] args) {
		Random rd = new Random();
		for(int i=0; i<10; i++) {
			list.add(rd.nextInt(30));
			System.out.print(list.get(i)+" ");
		}
		
		sort(0,9,list);
		System.out.println();
		
		for(int i=0; i<10; i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	public static int partition (int start, int end, List<Integer> list) {
		int low = start + 1;
		int high = end;
		int pivot = list.get(start);
		
		while (low <= high) {
			while (low <= end && pivot >= list.get(low)) low++;
			while (high >= start+1 && pivot <= list.get(high)) high--;
		
			if(low <= high) {
				int temp = list.get(low);
				list.set(low, list.get(high));
				list.set(high, temp);
			}
		}
		int temp = list.get(start);
		list.set(start, list.get(high));
		list.set(high, temp);
		return high;
	}
	
	public static void sort(int start, int end, List<Integer> list) {
		if(start < end) {
			int pivotNewIndex = partition(start, end, list);
			sort(start,pivotNewIndex-1,list);
			sort(pivotNewIndex+1,end,list);
		}
//	
//			int pivot = list.get(start);
//			int p = start+1;
//			int q = end;
//			
//			while(p<q) {
//				while((list.get(p)<=pivot) && (p<=end)) {
//					p++;
//				}
//				while((list.get(q)>pivot) && (p<=start+1)) {
//					q--;
//				}
//				
//				if(p<=q) {
//					int temp = list.get(p);
//					list.set(p, list.get(q));
//					list.set(q, temp);
//					p = p+1;
//					q = q-1;
//				}
//			}
//			
//			int temp = list.get(start);
//			list.set(q, temp);
//			list.set(0, list.get(q));
//			
			
	
	}

}

// Divide and Conquer
// p와 q가 만나는 순간!