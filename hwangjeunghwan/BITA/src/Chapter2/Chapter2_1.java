package Chapter2;
import java.util.Arrays;
import java.util.Scanner;

public class Chapter2_1 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] su = new int[n];
		for(int i=0; i<n; i++)
			su[i] = sc.nextInt();
		Arrays.sort(su);
		int k = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k; i++) {
			
			
			if(binarySearch(su, sc.nextInt())>=0) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		System.out.print(sb);
		
	}
	
	
	static boolean check(int[] su, int m, int low, int high) {
		if(low>high)
			return false;
		
		int mid = (low+high)/2;
		if(su[mid] == m) {
			return true;
		}
		else if(su[mid]>m) {
			return check(su, m, low, mid-1);
		}
		else {
			return check(su, m, mid+1, high);
		}
	}
	
	public static int binarySearch(int[] arr, int key) {
		 
		int lo = 0;					// Ž�� ������ ���� �� �ε���
		int hi = arr.length - 1;	// Ž�� ������ ������ �� �ε���
 
		// lo�� hi���� Ŀ���� ������ �ݺ��Ѵ�.
		while(lo <= hi) {
 
			int mid = (lo + hi) / 2;	// �߰���ġ�� ���Ѵ�.
 
			// key���� �߰� ��ġ�� ������ ���� ���
			if(key < arr[mid]) {
				hi = mid - 1;
			}
			// key���� �߰� ��ġ�� ������ Ŭ ���
			else if(key > arr[mid]) {
				lo = mid + 1;
			}
			// key���� �߰� ��ġ�� ���� ���� ���
			else {
				return mid;
			}
		}
 
		// ã���� �ϴ� ���� �������� ���� ���
		return -1;
 
	}
	
}
