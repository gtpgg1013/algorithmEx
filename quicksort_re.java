package algorithmEx;

public class quicksort_re {
	
	public static void sort(int[] list, int start, int end) {
		int left = start; // 맨 왼쪽
		int right = end; // 맨 오른쪽
		int pivot = list[(start+end)/2]; // 중간값을 피벗으로
		
		do { // 시작
			while(list[left] < pivot) left++; // 최 왼쪽부터 피벗값보다 짝으면 left++(pass)
			while(list[right] > pivot) right--; // 최 오른쪽부터 피벗값보다 크면 right--(pass)
			if(left<=right) { // 둘다 아니어서 나왔는데 left <= right이면 자리바꿔주기
				int temp = list[left];
				list[left] = list[right];
				list[right] = temp;
				left++; // 그후 왼쪽 ++
				right--; // 오른쪽 --
			}
		} while(left<=right); // 그리고 왼쪽이 오른쪽보다 작.같이면 반복 (같아도 반복-> 들어가서어쨋든 left++ 되거나 right--되서 반복문 탈출)
		
		if(start < right) sort(list, start, right); // 그 엇갈린 left, right에서 다쉬-시작
		if(end > left) sort(list, left, end); // 다쉬 - 시작
	}

	public static void main(String[] args) {
		int[] list = {66, 11, 22, 33, 55, 12};
		quicksort_re quick = new quicksort_re();
		quick.sort(list, 0, list.length-1);
		for(int i=0;i<list.length;i++) {
			System.out.println(list[i]);
		}
	}

}
