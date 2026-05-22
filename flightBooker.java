import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;

public class flightBooker {

    JFrame frame;
    JComboBox<String> flightType;
    JTextField startDateField;
    JTextField returnDateField;
    JButton bookButton;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public flightBooker() {

        frame = new JFrame("Flight Booker");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        dateFormat.setLenient(false);

        String[] options = {
                "one-way flight",
                "return flight"
        };

        flightType = new JComboBox<>(options);

        startDateField = new JTextField("04.04.2026");
        returnDateField = new JTextField("04.04.2026");

        bookButton = new JButton("Book");

        returnDateField.setEnabled(false);

        frame.add(flightType);
        frame.add(startDateField);
        frame.add(returnDateField);
        frame.add(bookButton);

        // ComboBox listener
        flightType.addActionListener(e -> updateState());

        // Keyboard listener
        KeyAdapter listener = new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                updateState();
            }
        };

        startDateField.addKeyListener(listener);
        returnDateField.addKeyListener(listener);

        // Button action
        bookButton.addActionListener(e -> bookFlight());

        updateState();

        frame.setVisible(true);
    }

    // Check valid date
    private boolean isValidDate(String text) {

        try {
            dateFormat.parse(text);
            return true;
        }
        catch (ParseException e) {
            return false;
        }
    }

    // Convert String to Date
    private Date getDate(String text) {

        try {
            return dateFormat.parse(text);
        }
        catch (ParseException e) {
            return null;
        }
    }

    // Update GUI state
    private void updateState() {

        boolean returnFlight = flightType.getSelectedItem().equals("return flight");

        returnDateField.setEnabled(returnFlight);

        boolean startValid = isValidDate(startDateField.getText());

        boolean returnValid = isValidDate(returnDateField.getText());

        startDateField.setBackground(
                startValid ? Color.WHITE : Color.PINK
        );

        if (returnFlight){
            returnDateField.setBackground(returnValid ? Color.WHITE : Color.PINK);
        }else{
            returnDateField.setBackground(Color.WHITE);
        }

        boolean valid = startValid;

        if (returnFlight) {

            valid = valid && returnValid;

            if (startValid && returnValid) {

                Date startDate = getDate(startDateField.getText());

                Date returnDate = getDate(returnDateField.getText());

                if (returnDate.before(startDate)) {
                    valid = false;
                }
            }
        }

        bookButton.setEnabled(valid);
    }

    // Booking message
    private void bookFlight() {

        String type = (String) flightType.getSelectedItem();

        if (type.equals("one-way flight")) {

            JOptionPane.showMessageDialog(
                    frame,
                    "You booked a one-way flight on "
                            + startDateField.getText()
            );
        }
        else {

            JOptionPane.showMessageDialog(
                    frame,
                    "You booked a return flight from "
                            + startDateField.getText()
                            + " to "
                            + returnDateField.getText()
            );
        }
    }

    public static void main(String[] args) {

        new flightBooker();
    }
}