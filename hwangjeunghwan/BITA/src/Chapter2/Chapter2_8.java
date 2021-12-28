package Chapter2;
import java.util.Scanner;
public class Chapter2_8 {
	
final static long P = 1000000007;	

static long C(long n, long r) {
	long a = 1L, b = 1L;

    // a = n! / (n-r)!
    // b = r!
    for (int i = 0; i < r; ++i) {
        a = a * (n - i) % P;
        b = b * (i + 1) % P;
    }

    // nCr = a / b = a * b^-1
    return a * pow(b, P - 2) % P;
}

public static long pow(long base, long expo) {
	
	// ������ 1�� ��� base^1 �̹Ƿ� base % P�� ����
	if(expo == 1) {
		return base % P;
	}
	// ������ ���ݿ� �ش��ϴ� base^(expo / 2) �� ���Ѵ�.
	long temp = pow(base, expo / 2);
	
	/*
	 * ���� ������ Ȧ �� ���ٸ�
	 * base^(expo / 2) * base^(expo / 2) * base �̹Ƿ�
	 * base�� �� �� �� �����־�� �Ѵ�.
	 * 
	 * ex) A^9 = A^4 * A^4 * A
	 */
	if(expo % 2 == 1) {
		return (temp * temp % P) * base % P;
	}
	return temp * temp % P;
			
}
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		 // ������ġ -> ���丮
	    long a = C(x1 + y1, x1);
	    // ���丮 -> ������ġ
	    long b = C(N - x1 + M - y1, N - x1);

	    // ������ġ -> ���丮�� ������ �ִ� ���
	    if (x2 <= x1 && y2 <= y1)
	        a -= C(x2 + y2, x2) * C(x1 - x2 + y1 - y2, x1 - x2) % P;

	    // ���丮 -> ������ġ�� ������ �ִ� ���
	    if (x1 <= x2 && y1 <= y2)
	        b -= C(x2 - x1 + y2 - y1, x2 - x1) * C(N - x2 + M - y2, N - x2) % P;

	    // ������ �ƴٸ� ����� ����� �ش�
	    if (a < 0) a += P;
	    if (b < 0) b += P;

	    

	    System.out.println(a*b%P);
		
		
	}
}
