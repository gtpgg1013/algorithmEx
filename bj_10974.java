package algorithmEx;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj_10974 {
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		list = new ArrayList<Integer>(number);
		for(int i=0; i<6; i++) {
			list.add(i+1);
		}
		while(permutation(list)) {
			printlist(list);
			System.out.println();
		}
	}
	public static boolean permutation(ArrayList<Integer> a) {
		// pivot �� ����
		int i = a.size()-1;
		while (i>0 && a.get(i-1)>=a.get(i)) {
			i--;
		}
		// i�� 0���� �۾����� stop
		if(i<=0) {
			return false;
		}
		// successor �� ����
		int j = a.size()-1;
		while (j>0 && a.get(i-1)>=a.get(j)) {
			j--;
		}
		// pivot�� successor ��ġ����
		swap(i-1,j);
		
		// pivot �����ڸ�(i) ~ successor(j) ���� �������� ����
		// list[i] ~ list[j]���� ������ �׸��� ����Ʈ�� �ĳְ� sort�� ������ �ٽ� a�� �־�����
		partsort(i,j);
		
		return true;
		
	}
	
	public static void printlist(ArrayList<Integer> a) {
		for(int i=0; i<a.size(); i++) {
			System.out.print(a.get(i)+" ");
		}
	}
	
	public static void swap(int i, int j) {
		int temp = list.get(i);
		list.set(i,list.get(j));
		list.set(j,temp);
	}
	
	public static void partsort(int start, int end) {
		List<Integer> sublist = list.subList(start, end);
		Collections.sort(sublist);
		for(int i=start;i<end;i++) {
			list.set(i, list.get(i-start));
		}
	}
	
}

