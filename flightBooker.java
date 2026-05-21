import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;

public class flightBooker{

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public flightBooker(){

        //Frame
        JFrame frame = new JFrame("Book Flight");
        frame.setSize(450, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        //Date Format Stict
        dateFormat.setLenient(false);

        //Flight type combo box
        JComboBox<String> flightType;
        String [] options = {"one-way flight", "return flight"};
        flightType = new JComboBox<>(options);

        //Text Fields
        JTextField startDateField = new JTextField("01-01-2026");
        JTextField returnDateField = new JTextField("01-01-2026");

        //Button
        JButton bookButton = new JButton("Book");

        //Initially Disabled Return Date
        returnDateField.setEnabled(false);

        //Add Components
        frame.add(flightType);
        frame.add(startDateField);
        frame.add(returnDateField);
        frame.add(bookButton);

        //ComboBox Action
        flightType.addActionListener(e -> updateState());

        //Text Field Listeners
        KeyAdapter listener = new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                updateState();
            }
        };

        startDateField.addKeyListener(listener);
        returnDateField.addKeyListener(listener);

        //Button click
        bookButton.addActionListener(e -> bookFlight());

        //Initial Validation
        updateState();

        //Show Frame
        frame.setVisible(true);
    }

    public static void main(String [] args){
        new flightBooker();
    }
}
