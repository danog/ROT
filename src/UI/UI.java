/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import library.Rotation;

/**
 *
 * @author root
 */
public class UI extends JFrame implements ActionListener {
    private JTextField input;
    private JLabel output;
    private JSpinner selector;
    private JCheckBox numeric;
    
    public UI() {
        super("ROT");
        this.input = new JTextField(20);
        this.output = new JLabel(" ");
        this.output.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                    "Output",
                    TitledBorder.CENTER,
                    TitledBorder.TOP));
        this.selector = new JSpinner(new SpinnerNumberModel(13, 0, 26, 1));
        this.numeric = new JCheckBox("From numbers");
        
        JPanel pane = new JPanel();
        pane.add(this.selector);
        pane.add(this.numeric);
        pane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                    "Settings",
                    TitledBorder.CENTER,
                    TitledBorder.TOP));
        
        JButton action = new JButton("ROT");
        action.addActionListener(this);
        
        JPanel actionPane = new JPanel();
        actionPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                    "Rotate",
                    TitledBorder.CENTER,
                    TitledBorder.TOP));
        actionPane.add(action);
        
        this.getContentPane().add(new TextFieldScrollPane(this.input), BorderLayout.PAGE_START);
        this.getContentPane().add(this.output, BorderLayout.PAGE_END);
        this.getContentPane().add(pane, BorderLayout.LINE_START);
        this.getContentPane().add(actionPane, BorderLayout.LINE_END);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        output.setText(" ");
        if (this.numeric.isSelected())  {
            String input = "";
            try {
                for (String number: this.input.getText().split(" ")) {
                    input += (char)(Integer.parseInt(number) + 96);
                }                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Non sono stati forniti dei numeri", "Errore", ERROR_MESSAGE);
                return;
            }
            output.setText(Rotation.rotate(input, (Integer) selector.getValue())+ " ");
        } else {
            output.setText(Rotation.rotate(this.input.getText(), (Integer) selector.getValue()) + " ");
        }
        this.input.requestFocus();
    }
    
    public class TextFieldScrollPane extends JScrollPane {
        public TextFieldScrollPane(JTextField textField) {
            super(textField);
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                    "Input",
                    TitledBorder.CENTER,
                    TitledBorder.TOP));
        }

    }
    
}
