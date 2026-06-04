import java.io.*;
import java.awt.*;
import java.awt.event.*;

class StudentFile extends Frame implements ActionListener {

    // Defining window components
    TextField number, name, marks;
    Button enter, done;
    Label numLabel, nameLabel, markLabel;
    DataOutputStream dos;

    // Constructor
    public StudentFile() {
        super("Create Student File");
    }

    // Setup the window
    public void setup() {
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));

        // Create components
        number = new TextField(25);
        numLabel = new Label("Roll Number");

        name = new TextField(25);
        nameLabel = new Label("Student Name");

        marks = new TextField(25);
        markLabel = new Label("Marks");

        enter = new Button("ENTER");
        done = new Button("DONE");

        // Add components
        add(numLabel);
        add(number);

        add(nameLabel);
        add(name);

        add(markLabel);
        add(marks);

        add(enter);
        add(done);

        // Add event listeners
        enter.addActionListener(this);
        done.addActionListener(this);

        setVisible(true);

        // Open file
        try {
            dos = new DataOutputStream(new FileOutputStream("student.dat"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Write to file
    public void addRecord() {
        try {
            int num = Integer.parseInt(number.getText());
            double m = Double.parseDouble(marks.getText());

            dos.writeInt(num);
            dos.writeUTF(name.getText());
            dos.writeDouble(m);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        // Clear fields
        number.setText("");
        name.setText("");
        marks.setText("");
    }

    // Cleanup
    public void cleanup() {
        if (!number.getText().equals("")) {
            addRecord();
        }
        try {
            dos.flush();
            dos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter) {
            addRecord();
        } else if (e.getSource() == done) {
            cleanup();
            System.exit(0);
        }
    }

    // Main method
    public static void main(String args[]) {
        StudentFile student = new StudentFile();
        student.setup();
    }
}