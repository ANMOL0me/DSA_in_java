 import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Main GUI Class
public class ParkingGUI extends Frame implements ActionListener {

    TextField carField;
    Checkbox permissionBox;
    TextArea displayArea;

    Button frontBtn, rearBtn, middleBtn, exitBtn, displayBtn;

    ParkingSystem parking = new ParkingSystem();

    public ParkingGUI() {

        setTitle("Parking System");

        setLayout(new FlowLayout());

        // Input field
        add(new Label("Car Number:"));
        carField = new TextField(15);
        add(carField);

        // Permission checkbox
        permissionBox = new Checkbox("Middle Permission");
        add(permissionBox);

        // Buttons
        frontBtn = new Button("Enter Front");
        rearBtn = new Button("Enter Rear");
        middleBtn = new Button("Enter Middle");
        exitBtn = new Button("Remove Car");
        displayBtn = new Button("Display");

        add(frontBtn);
        add(rearBtn);
        add(middleBtn);
        add(exitBtn);
        add(displayBtn);

        // Output area
        displayArea = new TextArea(10, 40);
        add(displayArea);

        // Register events
        frontBtn.addActionListener(this);
        rearBtn.addActionListener(this);
        middleBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        displayBtn.addActionListener(this);

        // Window close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String car = carField.getText();

        if (e.getSource() == frontBtn) {
            parking.enterFront(car);
            displayArea.append(car + " entered from FRONT\n");
        }

        else if (e.getSource() == rearBtn) {
            parking.enterRear(car);
            displayArea.append(car + " entered from REAR\n");
        }

        else if (e.getSource() == middleBtn) {
            boolean permission = permissionBox.getState();
            parking.enterMiddle(car, permission);
            displayArea.append(car + " tried MIDDLE entry\n");
        }

        else if (e.getSource() == exitBtn) {
            parking.removeCar(car);
            displayArea.append(car + " removed\n");
        }

        else if (e.getSource() == displayBtn) {
            displayArea.append("Parking: " + parking.getDisplay() + "\n");
        }

        carField.setText("");
    }

    public static void main(String[] args) {
        new ParkingGUI();
   }
}

// Node Class
class Node {
    String carNumber;
    Node prev, next;

    Node(String carNumber) {
        this.carNumber = carNumber;
    }
}

// Parking System Logic (Same as yours with small addition)
class ParkingSystem {

    Node front = null, rear = null, mid1 = null, mid2 = null;
    int size = 0;

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
    }

    void enterMiddle(String car, boolean permission) {
        if (!permission) return;

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
    }

    void removeCar(String car) {
        Node target = carMap.get(car);

        if (target == null) return;

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
    }

    void updateMiddle() {
        Node temp = front;
        int count = 0;

        int m1 = size / 2;
        int m2 = (size / 2) - 1;

        while (temp != null) {
            if (count == m1) mid1 = temp;
            if (count == m2) mid2 = temp;
            temp = temp.next;
            count++;
        }
    }

    // NEW method for GUI
    String getDisplay() {
        StringBuilder sb = new StringBuilder();
        Node temp = front;

        while (temp != null) {
            sb.append(temp.carNumber).append(" -> ");
            temp = temp.next;
        }

        sb.append("NULL");
        return sb.toString();
    }
}