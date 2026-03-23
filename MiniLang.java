import java.util.*;

public class MiniLang {

    // Interpreter
    public static void interpret(String input) {

        String[] tokens = input.split(" ");

        if (tokens[0].equals("PRINT")) {
            int num1 = Integer.parseInt(tokens[1]);
            String operator = tokens[2];
            int num2 = Integer.parseInt(tokens[3]);

            int result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }

            System.out.println("Output: " + result);
        } else {
            System.out.println("Invalid Command");}
       
        System.out.println("choice 1 , 2");
        int choice = sc.nextLine();
        switch (choice) {
            case 1:
                interpret(code);
                break;
            default:
                exit;
        }
   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your code:");
        String code = sc.nextLine();
        

        interpret(code);
      }
}