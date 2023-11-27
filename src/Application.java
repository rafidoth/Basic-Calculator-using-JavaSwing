import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Operations {
    String name;
    JButton btn;

    public Operations(String name, JButton btn, ActionListener AL) {
        this.name = name;
        this.btn = btn;
        btn.setText(name);
        btn.addActionListener(AL);
        btn.setBackground(new Color(18,18,18));
        btn.setForeground(Color.white);
    }
}

class actionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String input1Text = Application.input1.getText();
            String input2Text = Application.input2.getText();


            double val1 = Double.parseDouble(input1Text);
            double val2 = Double.parseDouble(input2Text);
            double result=0;

            JButton sourceButton = (JButton) e.getSource();
            String operation = sourceButton.getText();

            System.out.println(val1);
            System.out.println(val2);
            System.out.println(operation);
            if(operation.equals("Clear")){
                Application.input1.setText("");
                Application.input2.setText("");
            }else if(operation.equals("Plus")){
                result = val1 + val2;
            }else if(operation.equals("Minus")){
                result= val1 -val2;
            }else if(operation.equals("Multiplication")){
                result= val1 *val2;
            }else if(operation.equals("Division")){
                result= val1/val2;
            }else if(operation.equals("Mod")){
                result= val1%val2;
            }
            Application.resultLabel.setText(Double.toString(result));
        }catch(NumberFormatException ex){
            Application.resultLabel.setText("Enter Numbers Only!");
        }

    }
}

public class Application {
    Frame frame = new Frame();
    JPanel mainPanel = new JPanel(new GridBagLayout());
    JPanel operationPanel = new JPanel();
    JPanel topPanel = new JPanel(new GridLayout(1, 2));
    JPanel resultPanel = new JPanel(new GridLayout());
    static JLabel resultLabel = new JLabel("0.0");

    static JTextField input1 = new JTextField();
    static JTextField input2 = new JTextField();
    String[] opNames = new String[]{"Plus", "Minus", "Multiplication", "Division", "Mod", "Clear"};
    Operations[] op = new Operations[opNames.length];

    public Application() {
        operationPanel.setLayout(new GridLayout(3, 2, 30, 30));
        for (int i = 0; i < op.length; i++) {
            op[i] = new Operations(opNames[i], new JButton(), new actionListener());
            operationPanel.add(op[i].btn);
        }
        operationPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        operationPanel.setPreferredSize(new Dimension(400, 200));
        operationPanel.setBackground(new Color(18,18,18));
        operationPanel.setForeground(Color.white);

        topPanel.add(input1);
        topPanel.add(input2);
        topPanel.setPreferredSize(new Dimension(400, 30));
        topPanel.setBackground(new Color(18,18,18));
        input1.setBackground(new Color(18,18,18));
        input2.setBackground(new Color(18,18,18));
        input1.setForeground(Color.white);
        input2.setForeground(Color.white);


        resultPanel.setPreferredSize(new Dimension(400,50));
        resultLabel.setForeground(Color.white);
        resultPanel.add(resultLabel);
        resultPanel.setBackground(new Color(18,18,18));
        resultPanel.setForeground(Color.white);

        GridBagConstraints gc = new GridBagConstraints();
        frame.add(mainPanel);
        mainPanel.setBackground(new Color(18, 18, 18));
        mainPanel.setSize(500, 500);

        gc.gridx = 0;
        gc.gridy = 0;
        mainPanel.add(topPanel, gc);
        gc.gridy = 1;
        mainPanel.add(resultPanel,gc);
        gc.gridy=2;
        mainPanel.add(operationPanel, gc);
    }
}
