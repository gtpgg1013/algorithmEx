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
		// pivot 값 설정
		int i = a.size()-1;
		while (i>0 && a.get(i-1)>=a.get(i)) {
			i--;
		}
		// i가 0보다 작아지면 stop
		if(i<=0) {
			return false;
		}
		// successor 값 설정
		int j = a.size()-1;
		while (j>0 && a.get(i-1)>=a.get(j)) {
			j--;
		}
		// pivot과 successor 위치변경
		swap(i-1,j);
		
		// pivot 다음자리(i) ~ successor(j) 사이 오름차순 정렬
		// list[i] ~ list[j]까지 꺼내서 그만한 리스트에 쳐넣고 sort한 다음에 다시 a에 넣어주자
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

