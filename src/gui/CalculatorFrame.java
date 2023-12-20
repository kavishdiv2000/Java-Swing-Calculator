package gui;

import controller.ButtonClickListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame(){
        super("Calculator");

        //////////////////////////////////
        ////TextField/////////////////////
        /////////////////////////////////

        JTextField txtField = new JTextField();
        txtField.setBackground(Color.decode("#8FBB99"));
        txtField.setEditable(false);
        txtField.setBorder(new EmptyBorder(10, 10, 10, 10));

        txtField.setForeground(Color.decode("#363635"));
        txtField.setFont(new Font("Arial", Font.BOLD, 40));


        //////////////////////////////////
        ////Buttons/////////////////////
        /////////////////////////////////

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5, 4, 15, 10));
        p.setBackground(Color.decode("#595A4A"));

        String[] BUTTONLABELS = {
                "AC", "Del", "(", ")",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };
        for (String btnText: BUTTONLABELS){
            JButton btn = new JButton(btnText);
            btn.setBackground(Color.decode("#B0FE76"));
            // if you use MAC
            btn.setOpaque(true);
            btn.setBorderPainted(false);

            //set the color and chenge the font
            btn.setForeground(Color.decode("#363635"));
            btn.addActionListener(new ButtonClickListener(txtField));
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            p.add(btn);

        }

        this.add(txtField, BorderLayout.NORTH);
        this.add(p, BorderLayout.CENTER);





    }




}
