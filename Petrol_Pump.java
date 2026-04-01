import java.awt.*;
import java.awt.event.*;

public class Petrol_Pump extends Frame implements ActionListener {

    TextField quantity;
    TextArea receipt;
    Button petrol, diesel;

    double petrolPrice = 106.5;
    double dieselPrice = 94.2;

    Petrol_Pump() {

        setTitle("Petrol Pump System");
        setSize(400,300);
        setLayout(new FlowLayout());

        Label l1 = new Label("Enter Litres:");

        quantity = new TextField(10);
