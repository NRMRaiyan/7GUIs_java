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

    //Check Valid Dtate
    private boolean isValidDate(String text){

        try{
            dateFormat.parse(text);
            return true;
        }catch(ParseException e){
            return false;
        }
    }

    //Convert String to Date
    private Date getDate(String text){
        try{
            return dateFormat.parse(text);
        }
        catch(ParseException e){
            return null;
        }
    }

    //UpdateState
    private void updateState(){

        boolean returnFlight = flightType.getSelectedItem().equals("return flight");

        returnDateField.setEnabled(returnFlight);

        boolean startValid = isValidDate(startDateField.getText());

        boolean returnValid = isValidDate(returnDateField.getText());

        startDateField.setBackground(
            startValid ? Color.WHITE : Color.RED;
        );

        if(returnFlight){
            returnDateField.setBackground(returnValid ? Color.WHITE : Color.RED);
        }else{
            returnDateField.setBackground(Color.WHITE);
        }

        boolean valid = startValid;

        if(returnFlight){
            valid = valid && returnValid;
            
            if(startValid && returnValid){
                Date startDate = getDate(startDateField.getText());
                
                Date returnDate = getDate(returnDateField.getText());
                
                if(returnDate.before(startDate)){
                    
                    valid = false;
                }
            }
        }
        bookButton.setEnabled(valid);
    }

    //Booking Message

    public static void main(String [] args){
        new flightBooker();
    }
}
