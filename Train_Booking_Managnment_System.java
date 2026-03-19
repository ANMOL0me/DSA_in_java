import java.util.*;

// Passenger Node
class Passenger {
    String name;
    int seat;
    Passenger next;

    Passenger(String name, int seat) {
        this.name = name;
        this.seat = seat;
        this.next = null;
    }
}

// Coach Node (Tree)
class Coach {
    int coachNo;
    Passenger head;
    Coach left, right;

    Coach(int coachNo) {
        this.coachNo = coachNo;
        head = null;
        left = right = null;
    }

    void addPassenger(String name, int seat) {
        Passenger p = new Passenger(name, seat);

        if (head == null) head = p;
        else {
            Passenger temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = p;
        }

        System.out.println("Passenger Added Successfully!");
    }

    void removePassenger(int seat) {
        Passenger temp = head, prev = null;

        while (temp != null) {
            if (temp.seat == seat) {
                if (prev == null) head = temp.next;
                else prev.next = temp.next;

                System.out.println(" Passenger Removed!");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println(" Seat Not Found!");
    }

    void displayPassengers() {
        System.out.print("Coach " + coachNo + " → ");
        Passenger temp = head;

        if (temp == null) {
            System.out.println("No Passengers");
            return;
        }

        while (temp != null) {
            System.out.print("[" + temp.name + "-" + temp.seat + "] → ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}

public class Train_Booking_Managnment_System {

    static Coach root = null;
    static Scanner sc = new Scanner(System.in);

    // Insert Coach (BST)
    static Coach insertCoach(Coach root, int coachNo) {
        if (root == null) return new Coach(coachNo);

        if (coachNo < root.coachNo)
            root.left = insertCoach(root.left, coachNo);
        else
            root.right = insertCoach(root.right, coachNo);

        return root;
    }

    // Search Coach
    static Coach searchCoach(Coach root, int coachNo) {
        if (root == null || root.coachNo == coachNo) return root;

        if (coachNo < root.coachNo)
            return searchCoach(root.left, coachNo);
        else
            return searchCoach(root.right, coachNo);
    }

    // Display All
    static void displayTrain(Coach root) {
        if (root != null) {
            displayTrain(root.left);
            root.displayPassengers();
            displayTrain(root.right);
        }
    }

    // UI Menu
    static void showMenu() {
        System.out.println("\n=================================");
        System.out.println("     TRAIN MANAGEMENT SYSTEM   ");
        System.out.println("=================================");
        System.out.println("1. Add Passenger");
        System.out.println("2. Remove Passenger");
        System.out.println("3. Display Train");
        System.out.println("4. Exit");
        System.out.println("=================================");
        System.out.print("Enter Choice: ");
    }

    public static void main(String[] args) {

        // Predefined Coaches
        root = insertCoach(root, 1);
        root = insertCoach(root, 2);
        root = insertCoach(root, 3);

        while (true) {
            showMenu();
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Add Passenger ---");
                    System.out.print("Enter Coach No: ");
                    int c1 = sc.nextInt();

                    Coach coach = searchCoach(root, c1);
                    if (coach == null) {
                        System.out.println(" Coach Not Found!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Seat No: ");
                    int seat = sc.nextInt();

                    coach.addPassenger(name, seat);
                    break;

                case 2:
                    System.out.println("\n--- Remove Passenger ---");
                    System.out.print("Enter Coach No: ");
                    int c2 = sc.nextInt();

                    Coach coach2 = searchCoach(root, c2);
                    if (coach2 == null) {
                        System.out.println(" Coach Not Found!");
                        break;
                    }

                    System.out.print("Enter Seat No: ");
                    int seat2 = sc.nextInt();

                    coach2.removePassenger(seat2);
                    break;

                case 3:
                    System.out.println("\n--- Train Status ---");
                    displayTrain(root);
                    break;

                case 4:
                    System.out.println(" Exiting System...");
                    System.exit(0);

                default:
                    System.out.println(" Invalid Choice!");
            }
        }
    }
}