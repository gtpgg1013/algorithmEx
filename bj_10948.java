package algorithmEx;

import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;

public class bj_10948 {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		HashSet<Integer> userset = getuserSet(100);
		HashSet<Integer> lottoset = getlottoSet();
		
		int count = 0;
		
		Iterator<Integer> iterator = userset.iterator();
		Iterator<Integer> iterator2 = lottoset.iterator();
		
		while(iterator.hasNext()) {
			Integer element = iterator.next();
			list1.add(element);
		}
		
		for(int i : list1) {
			System.out.println(i);
		}
		
		while(iterator2.hasNext()) {
			Integer element = iterator2.next();
			list2.add(element);
		}
		
		System.out.println();

		for(int i : list2) {
			System.out.println(i);
		}
		
		System.out.println();
		
		for(int i=0; i<list1.size(); i++) {
			for(int j=0; j<list2.size(); j++) {
				if(list1.get(i)==list2.get(j)) {
					count++;
				}
			}
		}
		
		int score = count*20;
		if(score == 0) {
			System.out.println("Æ²·È½À´Ï´Ù!");
		} else {
			System.out.println(score);
		}
		
		
	}
	
	public static HashSet<Integer> getuserSet(int seed) {
		Random rand = new Random(seed);
		HashSet<Integer> set = new HashSet<Integer>();
		while(true) {
			int r = rand.nextInt(45);
			set.add(r);
			if(set.size()==6) break;
		}
		return set;
	}
	
	public static HashSet<Integer> getlottoSet() {
		Random rand = new Random();
		HashSet<Integer> set = new HashSet<Integer>();
		while(true) {
			int r = rand.nextInt(45);
			set.add(r);
			if(set.size()==6) break;
		}
		return set;
	}

}
