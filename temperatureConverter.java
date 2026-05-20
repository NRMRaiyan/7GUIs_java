import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class temperatureConverter {

    private boolean updating = false;

    public temperatureConverter(){
    //Create Frame
    JFrame frame = new JFrame("Temperature Converter");
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(2, 2, 10, 10));

    //Labels
    JLabel celciusLabel = new JLabel("Celcius:");
    JLabel fahrenheitLabel = new JLabel("Fahrenheit:");

    //Text Fields
    JTextField celciusField = new JTextField();
    JTextField fahrenheitField = new JTextField();

    //Add Components
    frame.add(celciusLabel);
    frame.add(celciusField);

    frame.add(fahrenheitLabel);
    frame.add(fahrenheitField);

    //Celcius -> Fahrenheit
    celciusField.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e){
            if(updating) return;

            try{
                updating = true;

                String text = celciusField.getText();

                if(text.isEmpty()){
                    fahrenheitField.setText("");
                }else{
                    double c = Double.parseDouble(text);

                    double f = (c * 9 / 5) + 32;

                    fahrenheitField.setText(String.format("%.2f", f));
                }
            } catch (NumberFormatException ex){
                // Invalid Input -- Do nothing
            }

            updating = false;
        }
    });

    //Fahrenheit -> Celcius
    fahrenheitField.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e){

            if(updating) return;

            try{
                updating = true;

                String text = fahrenheitField.getText();

                if(text.isEmpty()){
                    celciusField.setText("");
                }else{
                    double f = Double.parseDouble(text);

                    double c = (f - 32) * 5 / 9;

                    celciusField.setText(String.format("%.2f", c));
                }
            } catch(NumberFormatException ex){
                //Invalid Input -- Do nothing
            }

            updating = false;
        }
    });

    //Show Frame
    frame.setVisible(true);
    }
    
    public static void main(String [] args){
        new temperatureConverter();
    }
}
