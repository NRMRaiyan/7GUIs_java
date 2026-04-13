import javax.swing.*;
import java.awt.event.*;

public class counter{
    public static void main(String [] args){
        //Create Frame
        JFrame frame = new JFrame("Counter");
        frame.setSize(290, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        //Create Text Field
        JTextField textField = new JTextField("0");
        textField.setBounds(100, 30, 80, 30);
        textField.setEditable(false);

        //Create Button
        JButton button = new JButton("Click Me!");
        button.setBounds(90, 80, 100, 30);

        //Counter Variable
        final int []  count = {0};

        //Button Click Event
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count[0]++;
                textField.setText(String.valueOf(count[0]));
            }
        });

        //Add Components to Frame
        frame.add(textField);
        frame.add(button);

        //Show Frame
        frame.setVisible(true);
    }
}