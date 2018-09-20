package academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ForthQuestion {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = bf.read();
		int K = bf.read();
		int L = bf.read();
		int n1 = 1;
		for (int i = 1; i <= N; i++) {
			n1 *= i;
		}
		
		System.out.println(n1 * (int) Math.pow((N - K), (L - N)));
		
		bf.close();
	}

}
