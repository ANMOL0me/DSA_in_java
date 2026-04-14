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

        petrol = new Button("Petrol");
        diesel = new Button("Diesel");

        receipt = new TextArea(8,30);

        
        add(petrol);
        add(diesel);
        add(l1);
        add(quantity);
        add(receipt);

        petrol.addActionListener(this);
        diesel.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        double litres = Double.parseDouble(quantity.getText());
        double amount;

        if(e.getSource() == petrol) {

            amount = litres * petrolPrice;

            receipt.setText("Fuel : Petrol\n");
            receipt.append("Price/Litre : " + petrolPrice + "\n");
            receipt.append("Litres : " + litres + "\n");
            receipt.append("Total Amount : ₹" + amount);
        }

        if(e.getSource() == diesel) {

            amount = litres * dieselPrice;


            receipt.setText("Fuel : Diesel\n");
            receipt.append("Price/Litre : " + dieselPrice + "\n");

            receipt.append("Litres : " + litres + "\n");
            receipt.append("T    public static void main(String[] args) {\r\n" + //
                                "Total Amount : ₹" + amount);
        }
}


        new Petrol_Pump();
    }
