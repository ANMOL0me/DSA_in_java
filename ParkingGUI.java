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
