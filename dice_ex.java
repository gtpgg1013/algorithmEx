package algorithmEx;

import java.util.*;

public class dice_ex {

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		while(true) {
			int temp = rd.nextInt(7);
			System.out.println(temp);
			int d = sc.nextInt();
		}
	}

}
