import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class App {
    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        String expr = in.nextLine();
        String expr = "( 1 + 2 ) * 4 + 3";

        // TODO: А что, если будут введены символы без пробела??? Пока не учитываем
        String[] tokens = expr.split(" ");
        List<String> operators = Arrays.asList("+", "-", "*", "/", "(", ")");
        LinkedList<String> list = new LinkedList<String>();
        Stack<String> stack = new Stack<String>();

        for (String token : tokens) {
            System.out.println("token: " + token);

            // TODO: нужна проверка на недопустимые символы
            if (operators.contains(token)) {
                if (token.equals(")")) {
                    System.out.println("!!!");

                    while (!stack.peek().equals("(")) {
                        list.add(stack.pop());
                    }
                    stack.pop(); // удаляем "("
                } else {
                    if (!stack.empty()
                            && (token.equals("+") || token.equals("-"))
                            && (stack.peek().equals("+")
                                || stack.peek().equals("-")
                                || stack.peek().equals("*")
                                || stack.peek().equals("/"))) {
                        list.add(stack.pop());
                        System.out.println("second");
                    } else if (!stack.empty()
                            && (token.equals("*") || token.equals("/"))
                            && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        list.add(stack.pop());
                        System.out.println("first");
                    }

                    stack.push(token);
                }
            } else {
                list.add(token);
            }

            // -> ( 1 + 2 ) * 4 + 3
            // <- 1 2 + 4 × 3 +
            System.out.println("List: " + list);
            System.out.println("Stack: " + stack + "\n");
        }

        while (!stack.empty()) {
            list.add(stack.pop());
        }

        System.out.println("Out list: " + list);
        System.out.println("Exp list: [1, 2, +, 4, *, 3, +]");

        Stack<Double> stack2 = new Stack<Double>();

        for (String token : list) {
            if (operators.contains(token)) {
                double x2 = stack2.pop();
                double x1 = stack2.pop();

                switch (token) {
                    case "+": stack2.push(x1 + x2); break;
                    case "-": stack2.push(x1 - x2); break;
                    case "*": stack2.push(x1 * x2); break;
                    case "/": stack2.push(x1 / x2); break;
                    default:
                        System.out.println("error");
                }
            } else {
                stack2.push(Double.valueOf(token));
            }
        }

        System.out.println("\nStack2: " + stack2);
    }

    public static void simple() {
        Scanner in = new Scanner(System.in);
        Integer x1 = Integer.valueOf(in.nextLine());
        Integer x2 = Integer.valueOf(in.nextLine());
        String cmd = in.nextLine();

        switch (cmd) {
            case "+": System.out.println(x1 + x2); break;
            case "-": System.out.println(x1 - x2); break;
            case "*": System.out.println(x1 * x2); break;
            default:
                System.out.println("error");
        }
    }
}