/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    
    public UI() {
        super("ROT");
        this.input = new JTextField(20);
        this.output = new JLabel(" ");
        this.selector = new JSpinner(new SpinnerNumberModel(13, 1, 26, 1));
        JButton action = new JButton("ROT");
        action.addActionListener(this);
        
        JPanel pane = new JPanel();
        pane.add(this.selector);
        pane.add(action);
        
        this.getContentPane().add(new TextFieldScrollPane(this.input), BorderLayout.PAGE_START);
        this.getContentPane().add(new LabelScrollPane(this.output), BorderLayout.CENTER);
        this.getContentPane().add(new ButtonScrollPane(pane), BorderLayout.PAGE_END);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        output.setText(Rotation.rotate(input.getText(), (Integer) selector.getValue()));
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
    
    public class LabelScrollPane extends JScrollPane {
        public LabelScrollPane(JLabel jLabel) {
            super(jLabel);
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                    "Output",
                    TitledBorder.CENTER,
                    TitledBorder.TOP));
        }
    
    }
    
    public class ButtonScrollPane extends JScrollPane {
        public ButtonScrollPane(JPanel content) {
            super(content);
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                    "Rotate",
                    TitledBorder.CENTER,
                    TitledBorder.TOP));
        }
    
    }
}
