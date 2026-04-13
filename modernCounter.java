import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class modernCounter {
    private int count = 0;

    public modernCounter(){
        //Create Frame
        JFrame frame = new JFrame("Modern Counter");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //Create Label
        JLabel label = new JLabel("0", SwingConstants.CENTER);
        label.setFont(new Font("Ubuntu", Font.BOLD, 40));
        label.setForeground(Color.RED);

        //Panel for Button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //Create Button
        JButton increaseBtn = new JButton("+");
        JButton decreaseBtn = new JButton("-");
        JButton resetBtn = new JButton("Reset");

        //Styling Button
        Font btnFont = new Font("Ubuntu", Font.BOLD, 16);
        increaseBtn.setFont(btnFont);
        decreaseBtn.setFont(btnFont);
        resetBtn.setFont(btnFont);

        //Button Action
        increaseBtn.addActionListener(e -> {
                count++;
                label.setText(String.valueOf(count));
        });

        decreaseBtn.addActionListener(e -> {
                count--;
                label.setText(String.valueOf(count));
        });

        resetBtn.addActionListener(e -> {
                count = 0;
                label.setText(String.valueOf(count));
        });

        //Add Component
        //frame.add(label);
        panel.add(increaseBtn);
        panel.add(decreaseBtn);
        panel.add(resetBtn);

        frame.add(label, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        //Make Visible
        frame.setVisible(true);
    }

    public static void main(String [] args){
        new modernCounter();
    }
}
