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
