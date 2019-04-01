package algorithmEx;

import java.util.*;

public class set_Ex {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		boolean flag = set.contains(3);
		System.out.println(flag);
		for(int num : set) {
			System.out.println(num);
		}
		boolean f2 = set.contains(2);
		System.out.println(!f2);
		set.remove(2);
		System.out.println(f2);
		
		
	}

}
