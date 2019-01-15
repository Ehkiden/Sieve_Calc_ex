/*
Project:    Exercise 02
File:       Sieve_cal.java
Class:      CS 335
Author:     Jared Rigdon
Date:       9/28/2018
Purpose:    Displays the form that recieves integer input which then checks an array to see if the int is a prime number
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Sieve_cal extends JFrame {
    static boolean barray[]=new boolean[10000];
    private JButton submit;
    private JTextField txt_submit;
    private JLabel result;
    private JPanel sieve_view;

    public Sieve_cal(){
       // submit.addActionListener(new get_number());
        int len = barray.length;
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num_lookup = 0; //reset the int that holds the number each time the event is called
                int skip = 0;   //used to determine if an exception occurr
                // ed
                //try to convert to a string
                try{
                    num_lookup = Integer.parseInt(txt_submit.getText());
                }
                catch (NumberFormatException ex){
                    result.setText("Not an Integer!");
                    skip = 1;   //prep to skip the if statement
                }

                if (skip==0){
                    //check if the number is within the range
                    if (num_lookup < 1 || num_lookup > 10000){
                        result.setText("Please enter a number between 1 and 10000.");
                    }
                    //manual check for 10000 due to laziness
                    else if (num_lookup==10000){
                        result.setText(num_lookup + " is not a prime number.");
                    }
                    else if (num_lookup==1){
                        result.setText(num_lookup + " is technically considered not a prime number.");
                    }
                    else {
                        for (int i =1; i < len; i++){
                            if (i == num_lookup){
                                if (barray[i] == Boolean.TRUE){
                                    result.setText(num_lookup + " is a prime number.");
                                }
                                else {
                                    result.setText(num_lookup + " is not a prime number.");
                                }
                            }
                        }
                    }
                }

            }
        });
    }


    public static void initialize_barray(){
        Arrays.fill(barray, Boolean.TRUE);  //initialize boolean array to true
        int len=barray.length;
        for (int x=2; x<len;x++){
            if (barray[x]==Boolean.TRUE){
                //starting at the first multiple of x, change each multiple to false in the array
                for(int y=(2*x); y<len; y=(y+x)){
                    barray[y]=Boolean.FALSE;
                }
            }
        }
    }

    //construct the sieve array once and then the jframe
    public static void main(String[] args) {
        //initialize the array to make it accessible to the action listener
        initialize_barray();

        //construct the frame
        JFrame frame = new JFrame("Sieve Prime Number");
        frame.setPreferredSize(new Dimension(500,200));
        frame.setContentPane(new Sieve_cal().sieve_view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
