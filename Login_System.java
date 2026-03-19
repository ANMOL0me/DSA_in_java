import java.util.*;

class loginsystem {

    private HashMap<String, Integer> users = new HashMap<>();

    // Hash function for password
    private int hashpassword(String password) {
        return password.hashCode(); // simple hashing
    }

    // Register user
    
    }
    }
    // Login user
    public void login(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("User not found!");
            return;
        }

        int hashed = hashpassword(password);

        if (users.get(username) == hashed) {
            System.out.println("Login successful ");
        } else {
            System.out.println("Wrong password ");
        }
    }

    // Display all users (for testing)
    public void displayusers() {
        System.out.println(users);
    }
}

public class Login_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loginsystem system = new loginsystem();

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

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