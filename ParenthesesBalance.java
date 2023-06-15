import java.util.Stack;
import java.util.Scanner;

public class ParenthesesBalance {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean repeat = true;
        while (repeat) {
            System.out.print("Enter the number of test cases: ");
            int n = scn.nextInt();
            scn.nextLine(); // This is the number of test cases
            String[] results = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the set of parentheses: "); // This will ask the user to enter the number of test cases
                String parentheses = scn.nextLine();
                if (isBalanced(parentheses)) {
                    results[i] = "BALANCED";    
                } else {
                    results[i] = "NOT BALANCED";  
                }
            }
            for (String result : results) {
                System.out.println(result);   // This will display the output
            }
            
        }
    }

    public static boolean isBalanced(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if (c == '(' || c == '{') {
                stack.push(c); // Push opening parentheses onto the stack
            } else if (c == ')' || c == '}') {
                if (stack.isEmpty()) {
                    return false; // Closing parentheses without a corresponding opening parentheses
                }
                char top = stack.pop(); // Pop the top element from the stack
                if ((c == ')' && top != '(') || (c == '}' && top != '{')) {
                    return false; // conditional statement if found mismatched closing parentheses
                }
            }
        }
        return stack.isEmpty(); // This will check if there are any remaining opening parentheses
    }
}