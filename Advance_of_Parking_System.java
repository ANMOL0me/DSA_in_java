import java.util.*;
// hybridised.
public class Advance_of_Parking_System {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingSystem parking = new ParkingSystem();

        while (true) {

            System.out.println("\n1 Front");
            System.out.println("2 Rear");
            System.out.println("3 Middle");
            System.out.println("4 Exit Car");
            System.out.println("5 Display Car");
            System.out.println("6 Exit Program");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Car Number: ");
                    parking.enterFront(sc.next());
                    break;

                case 2:
                    System.out.print("Car Number: ");
                    parking.enterRear(sc.next());
                    break;

                case 3:
                    System.out.print("Car Number: ");
                    String car = sc.next();
                    System.out.print("Permission (true/false): ");
                    boolean p = sc.nextBoolean();
                    parking.enterMiddle(car, p);
                    break;

                case 4:
                    System.out.print("Car Number to exit: ");
                    parking.removeCar(sc.next());
                    break;

                case 5:
                    parking.display();
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
class Node {
    String carNumber;
    Node prev;
    Node next;

    Node(String carNumber) {
        this.carNumber = carNumber;
        prev = null;
        next = null;
    }
}

class ParkingSystem {

    Node front = null;
    Node rear = null;
    Node mid1 = null;
    Node mid2 = null;

    int size = 0;

    // pointer to each car.
    HashMap<String, Node> carMap = new HashMap<>();

    void enterFront(String car) {

        Node newNode = new Node(car);

        if (front == null) {
            front = rear = mid1 = mid2 = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        carMap.put(car, newNode);
        size++;
        updateMiddle();

        System.out.println(car + " entered from FRONT");
    }

    void enterRear(String car) {

        Node newNode = new Node(car);

        if (rear == null) {
            front = rear = mid1 = mid2 = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }

        carMap.put(car, newNode);
        size++;
        updateMiddle();

        System.out.println(car + " entered from REAR");
    }

    void enterMiddle(String car, boolean permission) {

        if (!permission) {
            System.out.println("Middle entry needs permission");
            return;
        }

        Node newNode = new Node(car);

        if (mid1 == null) {
            front = rear = mid1 = mid2 = newNode;
        } else {

            Node next = mid1.next;

            mid1.next = newNode;
            newNode.prev = mid1;

            newNode.next = next;

            if (next != null)
                next.prev = newNode;
            else
                rear = newNode;
        }

        carMap.put(car, newNode);
        size++;
        updateMiddle();

        System.out.println(car + " entered from MIDDLE");
    }

    // remove specific car directly
    void removeCar(String car) {

        Node target = carMap.get(car);

        if (target == null) {
            System.out.println("Car not found");
            return;
        }

        Node prev = target.prev;
        Node next = target.next;

        if (prev != null)
            prev.next = next;
        else
            front = next;

        if (next != null)
            next.prev = prev;
        else
            rear = prev;

        carMap.remove(car);

        size--;
        updateMiddle();

        System.out.println(car + " exited directly");
    }

    void updateMiddle() {

        Node temp = front;
        int count = 0;

        int m1 = size / 2;
        int m2 = (size / 2) - 1;

        while (temp != null) {

            if (count == m1)
                mid1 = temp;

            if (count == m2)
                mid2 = temp;

            temp = temp.next;
            count++;
        }
    }

    void display() {

        Node temp = front;

        while (temp != null) {
            System.out.print(temp.carNumber + ",");
            temp = temp.next;
        }

        System.out.println("NULL");
    }
}

