/**
 * <h1>Calculator Project</h1>
 * <p>This is a java Swing program to do Calculations<p/>
 *
 * @author Kavish Nanayakkara
 * @version 1.0
 * @since 2023.4.12
 *
 * **/


import gui.CalculatorFrame;


import javax.swing.*;



public class Main {
    public static void main(String[] args) {

        CalculatorFrame frame = new CalculatorFrame();
        frame.setVisible(true);
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}