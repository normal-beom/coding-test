import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ��������ؿ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		
	
		  StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < n; i++) {
	            int num = sc.nextInt();
	            
	            if(minQ.size() == maxQ.size()) maxQ.add(num); //����� ������ �ִ��� �ֱ�
	            else minQ.add(num); //�ٸ��� �ּ��� �ֱ�
	            
	            if(!minQ.isEmpty() && !maxQ.isEmpty() && minQ.peek() < maxQ.peek()) { //�ּ��� ���簪���� �ִ��� ���簪 ũ�� ����
	                int temp = minQ.poll();
	                minQ.add(maxQ.poll());
	                maxQ.add(temp);
	            }
	            sb.append(maxQ.peek() + "\n");        
	        }
	        System.out.println(sb);
		
	}

}
