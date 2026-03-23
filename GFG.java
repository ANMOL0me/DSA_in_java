import java.awt.*;
import java.awt.event.*;

public class GFG {
    public static void main(String[] args) {
        Frame frame = new Frame("Event Handling Example");
        Button button = new Button("Click Me");

        // Add the button to the frame
        frame.add(button);

        // Register an ActionListener for the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to execute when the button is clicked
                System.out.println("Button Clicked!");
            }
        });

        // Set layout manager and window properties
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 100);
        frame.setVisible(true);

        // Handle window close event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}