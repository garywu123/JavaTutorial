package queue;

import java.util.Stack;

/**
 * @author ：Gary Wu
 * @date ：Created in 16:47 2020/2/5
 * @description：
 * @modified By：
 * @version: $
 */

public class EvaluateExpression {

    public static void main(String[] args) {
        // 首先检查传入的数据
        if (args.length != 1) {
            System.out.println(
                    "Usage: java EvaluateExpression \"expression\"");
            System.exit(1);
        }

        try {
            System.out.println(evaluateExpression(args[0]));
        } catch (Exception ex) {
            System.out.println("错误的表达式：" + args[0]);
        }
    }

    /**
     * 评估表达式
     */
    public static int evaluateExpression(String expression) {
        // 创建 operandStack 来储存数字
        Stack<Integer> operandStack = new Stack<>();
        // 创建operatorStack来储存操作符
        Stack<Character> operatorStack = new Stack<>();

        // 在表达式中的操作符前后插入空格作为分隔符
        expression = insertBlanks(expression);

        // 提取数字和操作符
        String[] tokens = expression.split(" ");

        // 阶段1：扫描表达式
        for (String token : tokens) {
            if (token.length() == 0) {
                continue; // 如果是空格就返回循环继续提取下一个
            }
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // 处理所有出于栈顶的操作符
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                         operatorStack.peek() == '-' ||
                         operatorStack.peek() == '*' ||
                         operatorStack.peek() == '/' )){
                    processAnOperator(operandStack, operatorStack);
                }
                // 将 + 或者 - 压入 operator 栈中
                operatorStack.push(token.charAt(0));
            }
            else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                // 处理之前在栈中的 * 或者 /
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' ||
                         operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                // 将操作符压入
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            }
            else if (token.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop();
            }
            else { // 如果扫描到的是数字，则存入
                operandStack.push(new Integer(token));
            }
        }

        // 阶段2：处理栈中的运算符
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        return operandStack.pop();
    }

    private static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+') {
            operandStack.push(op2 + op1);
        }
        else if (op == '-') {
            operandStack.push(op2 - op1);
        }
        else if (op == '*') {
            operandStack.push(op2 * op1);
        }
        else if (op == '/') {
            operandStack.push(op2 / op1);
        }
    }

    private static String insertBlanks(String expression) {
        String result = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == ')'||
                    expression.charAt(i) == '+' || expression.charAt(i) == '-'||
                    expression.charAt(i) == '*' || expression.charAt(i) == '/'
            ) {
                result += " " + expression.charAt(i) + " ";
            }else
                result += expression.charAt(i);
        }
        return result;
    }
}
