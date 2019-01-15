/*
Project:    Exercise 02
File:       Calculator.java
Class:      CS 335
Author:     Jared Rigdon
Date:       9/28/2018
Purpose:    Constructs the calculator gui
 */

import javax.swing.*;
import java.awt.*;

public class Caculator {
    private JTextField results;
    private JButton but3;
    private JButton but_sub;
    private JButton but2;
    private JButton but1;
    private JButton but0;
    private JButton but_dec;
    private JButton but_equal;
    private JButton but6;
    private JButton but9;
    private JButton but_add;
    private JButton but7;
    private JButton but4;
    private JButton but5;
    private JButton but8;
    private JButton but_div;
    private JButton but_multi;
    private JPanel calc_view;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Caculator");
        frame.setPreferredSize(new Dimension(400,400));
        frame.setContentPane(new Caculator().calc_view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
