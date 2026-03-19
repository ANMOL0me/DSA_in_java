import java.util.*;

class LoginSystem {

    private HashMap<String, Integer> users = new HashMap<>();

    private int hashpassword(String password) {
        return password.hashCode();
    }

    public void register(String username, String password) {

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Invalid input!");
            return;
        }

        if (users.containsKey(username)) {
            System.out.println(" User already exists!");
            return;
        }

        int hashed = hashpassword(password);
        users.put(username, hashed);

        System.out.println(" User registered successfully!");
    }

    public void login(String username, String password) {

        if (!users.containsKey(username)) {
            System.out.println(" User not found!");
            return;
        }

        int hashed = hashpassword(password);

        if (users.get(username).equals(hashed)) {
            System.out.println(" Login successful!");
        } else {
            System.out.println(" Wrong password!");
        }
    }

    public void displayusers() {
        System.out.println(users);
    }
}

public class Login_System {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoginSystem system = new LoginSystem();

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String user = sc.nextLine();

                System.out.print("Enter password: ");
                String pass = sc.nextLine();

                system.register(user, pass);

            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String user = sc.nextLine();

                System.out.print("Enter password: ");
                String pass = sc.nextLine();

                system.login(user, pass);

            } else {
                break;
            }
        }
        sc.close();
    }
}