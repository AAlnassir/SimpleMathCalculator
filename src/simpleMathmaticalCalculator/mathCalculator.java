package simpleMathmaticalCalculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class mathCalculator {

    public static void main(String[] args) {
        // Declare JFrame
        JFrame frame = new JFrame();

        // Define the layout that will be given to the frame
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        // Add the boxLayout to the frame
        frame.setLayout(boxLayout);

        // Declare the needed panels
        JPanel panelTextArea = new JPanel(new BorderLayout());
        JPanel buttonsArea = new JPanel(new GridLayout(6, 3));

        // Make buttons objects
        ArrayList<JButton> numbers = new ArrayList<JButton>();
        numbers.add(new JButton("1"));
        numbers.add(new JButton("2"));
        numbers.add(new JButton("3"));
        numbers.add(new JButton("4"));
        numbers.add(new JButton("5"));
        numbers.add(new JButton("6"));
        numbers.add(new JButton("7"));
        numbers.add(new JButton("8"));
        numbers.add(new JButton("9"));
        numbers.add(new JButton("0"));
        numbers.add(new JButton("+"));
        numbers.add(new JButton("-"));
        numbers.add(new JButton("/"));
        numbers.add(new JButton("*"));
        numbers.add(new JButton("="));
        numbers.add(new JButton("^"));
        numbers.add(new JButton("C"));

        Font font = new Font("SansSerif", Font.BOLD, 60);

        // Define a textfield
        JTextField display = new JTextField(20);

        // Add all the buttons to the Panel desired
        for (int i = 0; i < numbers.size(); i++) {
            buttonsArea.add(numbers.get(i));
        }

        // ACTION LISTENERS FOR BUTTONS
        // On button click add 1
        numbers.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "1");
            }
        });

        // On button click add 2
        numbers.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "2");
            }
        });

        // On button click add 3
        numbers.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "3");
            }
        });

        // On button click add 4
        numbers.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "4");
            }
        });

        // On button click add 5
        numbers.get(4).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "5");
            }
        });

        // On button click add 6
        numbers.get(5).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "6");
            }
        });

        // On button click add 7
        numbers.get(6).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "7");
            }
        });

        // On button click add 8
        numbers.get(7).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "8");
            }
        });

        // On button click add 9
        numbers.get(8).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "9");
            }
        });

        // On button click add 0
        numbers.get(9).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "0");
            }
        });

        // On button click add +
        numbers.get(10).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "+");
            }
        });

        // On button click add -
        numbers.get(11).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "-");
            }
        });

        // On button click add /
        numbers.get(12).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "/");
            }
        });

        // On button click add *
        numbers.get(13).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText(display.getText() + "*");
            }
        });

        // On button click add ^ || FUNCTION IS CURRENTLY OFF DUE TO RUN-TIME ERROR
        numbers.get(15).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        // On button click add C
        numbers.get(16).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                display.setText("");
                System.out.println("Result cleared.");
            }
        });

        // Get the result
        numbers.get(14).addActionListener(new ActionListener() {
            int result = 0;

            @Override
            public void actionPerformed(ActionEvent ae) {
                // ScriptEngineManager is used to call a function from other saved or used language in Java.
                ScriptEngineManager mgr = new ScriptEngineManager();
                // JavaScript is the language in use to do the mathmatical operation.
                ScriptEngine scriptEngine = mgr.getEngineByName("JavaScript");
                String expression = display.getText();
                try {
                    System.out.println("Expression: " + display.getText());
                    // Rounding result.
                    float roundedResult = (float) (Math.round(Double.parseDouble(scriptEngine.eval(expression).toString())));
                    System.out.println("Exact result: " + scriptEngine.eval(expression));
                    System.out.println("Rounded result: " + roundedResult);
                    display.setText(roundedResult + "");
                    System.out.println("== END OF OPERATION ==");
                } catch (ScriptException ex) {
                    System.out.println("System down! \nHere is the log: \n");
                    Logger.getLogger(mathCalculator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Disable writing within the textbox
        display.setEnabled(false);
        // Add the jTextField to the panel
        panelTextArea.add(display, BorderLayout.CENTER);

        // Center text in jTextField
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setLocation(5, 5);
        display.setSize(150, 20);
        display.setFont(font);
        // Add panels to the frame
        frame.add(panelTextArea);
        frame.add(buttonsArea);

        // Specify frame properties
        frame.setSize(new Dimension(300, 500));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

}
