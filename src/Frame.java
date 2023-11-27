import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{


    public Frame(){
        this.setVisible(true);
        this.setTitle("Calculator");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(18, 18, 18));
        this.getContentPane().setLayout(new BorderLayout());


    }
}
