package algorithmEx;

public class quicksort_re {
	
	public static void sort(int[] list, int start, int end) {
		int left = start; // �� ����
		int right = end; // �� ������
		int pivot = list[(start+end)/2]; // �߰����� �ǹ�����
		
		do { // ����
			while(list[left] < pivot) left++; // �� ���ʺ��� �ǹ������� ¦���� left++(pass)
			while(list[right] > pivot) right--; // �� �����ʺ��� �ǹ������� ũ�� right--(pass)
			if(left<=right) { // �Ѵ� �ƴϾ ���Դµ� left <= right�̸� �ڸ��ٲ��ֱ�
				int temp = list[left];
				list[left] = list[right];
				list[right] = temp;
				left++; // ���� ���� ++
				right--; // ������ --
			}
		} while(left<=right); // �׸��� ������ �����ʺ��� ��.���̸� �ݺ� (���Ƶ� �ݺ�-> ������¶�� left++ �ǰų� right--�Ǽ� �ݺ��� Ż��)
		
		if(start < right) sort(list, start, right); // �� ������ left, right���� �ٽ�-����
		if(end > left) sort(list, left, end); // �ٽ� - ����
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
