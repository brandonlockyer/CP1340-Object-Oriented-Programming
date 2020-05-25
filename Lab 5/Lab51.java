import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
class CConverter extends JFrame {
    CConverter() {
        super("CConverter");
        buildGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    private void buildGUI() {
        JTextField input = new JTextField(7);
        JTextField input2 = new JTextField(7);
        JButton Compute = new JButton("Compute");
        JButton quit = new JButton("Quit");
        JLabel Cobalt = new JLabel("Amount of Cobalt");
        JLabel Years = new JLabel("Number of Years");
        JLabel Amount = new JLabel("Amount Left: ");
        
        
        Container ct = getContentPane();
        ct.setLayout(new GridBagLayout());
        
        GridBagConstraints c =
        new GridBagConstraints();
        
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(20, 20, 10, 10);
        
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        ct.add(input, c);
        
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        ct.add(input2, c);
        
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        ct.add(Compute, c);
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        ct.add(Cobalt, c);
        
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        ct.add(Years, c);
        
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        ct.add(Amount, c);
        
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        ct.add(quit, c);
        
        QuitListener quitl = new QuitListener();
        quit.addActionListener(quitl);
        
        AddListener addl =
        new AddListener(input, input2, Amount);
        Compute.addActionListener(addl);
        input.addActionListener(addl);
    }
    
    class AddListener implements ActionListener {
        private JTextField in , in2;
        private JLabel out;
        
        AddListener(JTextField in , JTextField in2, JLabel out) {
            this.in = in ;
            this.in2 = in2;
            this.out = out;
        }
        
        public void actionPerformed(ActionEvent e) {
            double cobalt = (double)
            Double.parseDouble( in .getText());
            double years = (double)
            Double.parseDouble(in2.getText());
            double Amount;
            
            
            for (int i = 1; i <= years; i++) {
                cobalt = cobalt - 0.12 * cobalt;
            }
            Amount = cobalt;
            DecimalFormat df =
            new DecimalFormat("#0.0000000");
            out.setText("Amount Left:" +
                        df.format(Amount));
        }
    }
    
    class QuitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
public class Lab51{
    public static void main(String[] args) {
        CConverter cc = new CConverter();
    }
}
