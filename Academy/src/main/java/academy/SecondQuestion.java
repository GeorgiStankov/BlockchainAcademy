package academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SecondQuestion {

	public static void main(String[] args) {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(bf.readLine());

			for (int i = 0; i < n; i++) {
				String s = bf.readLine();
				System.out.println(isBalenced(s) ? "YES" : "NO");

			}

			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isBalenced(String ch) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : ch.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				char top = stack.pop();
				if (!((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{'))) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
