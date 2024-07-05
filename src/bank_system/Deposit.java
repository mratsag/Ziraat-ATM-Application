package bank_system;

import javax.swing.*;
import java.awt.*;

public class Deposit extends JFrame {

    String cardpas;
    TextField textField;


    Deposit(String cardpas){
        this.cardpas = cardpas;

        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        //Deposit main
        JLabel label1 = new JLabel("YATIRMAK İSTEDİĞİNİZ TUTARI GİRİNİZ:");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,400,35);
        l1.add(label1);

        textField = new TextField();
        textField.setBackground(new Color(202, 200, 200));
        textField.setForeground(Color.BLACK);
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l1.add(textField);

        // Set screen
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }





    public static void main(String[] args) {
        new Deposit(" ");
    }
}
