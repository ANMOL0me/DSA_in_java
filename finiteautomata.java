//how finite automata works.
    import java.util.Scanner;

public class finiteautomata {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the input string: ");
        String input = sc.nextLine();

        System.out.print("Enter allowed letters (alphabet): ");
        String alphabet = sc.nextLine();

        // Convert string to character array
        char[] arr = input.toCharArray();

        boolean valid = true;

        System.out.println("\nFinite Automata Processing:");
        System.out.print("Start State -> ");

        for(int i = 0; i < arr.length; i++) {

            boolean found = false;

            // Check if character exists in alphabet
            for(int j = 0; j < alphabet.length(); j++) {
                if(arr[i] == alphabet.charAt(j)) {
                    found = true;
                    break;
                }
            }

            if(found) {
                System.out.print("q" + i + " --" + arr[i] + "--> q" + (i+1) + "   ");
            } else {
                valid = false;
                System.out.println("\nInvalid symbol: " + arr[i]);
                break;
            }
        }

        if(valid) {
            System.out.println("\nString Accepted by Finite Automata");
        } else {
            System.out.println("String Rejected by Finite Automata");
        }

        sc.close();
    }
}

