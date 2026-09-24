
import java.util.Stack;

public class prob6_3 {

    // Returns operator precedence
    static int precedence(char op) {
        if (op == '^') {
            return 3;
        } else if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        }

        return 0;
    }

    // Check whether character is an operator
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' ||
               ch == '*' || ch == '/' || ch == '^';
    }

    // Convert infix to postfix
    static String infixToPostfix(String expression) {

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }

            // If operand, add directly to output
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch).append(' ');
            }

            // If opening bracket, push onto stack
            else if (ch == '(') {
                stack.push(ch);
            }

            // If closing bracket
            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }

                // Remove opening bracket
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }

            // If operator
            else if (isOperator(ch)) {

                while (!stack.isEmpty() &&
                       stack.peek() != '(' &&
                       precedence(stack.peek()) >= precedence(ch)) {

                    postfix.append(stack.pop()).append(' ');
                }

                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString().trim();
    }

    public static void main(String[] args) {

        String expression1 = "3 + 4 * 2";
        String expression2 = "(3 + 4) * 2";
        String expression3 = "A + B * C";

        System.out.println("Infix: " + expression1);
        System.out.println("Postfix: " + infixToPostfix(expression1));

        System.out.println();

        System.out.println("Infix: " + expression2);
        System.out.println("Postfix: " + infixToPostfix(expression2));

        System.out.println();

        System.out.println("Infix: " + expression3);
        System.out.println("Postfix: " + infixToPostfix(expression3));
    }
}