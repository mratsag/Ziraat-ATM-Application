package bank_system;

import javax.swing.*;
import java.awt.*;

public class Deposit extends JFrame {

    String cardpas;
    Deposit(String cardpas){
        this.cardpas = cardpas;





        // Background
        ImageIcon b1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.jpg"));
        Image b2 = b1.getImage().getScaledInstance(850, 700, 1);
        ImageIcon b3 = new ImageIcon(b2);
        JLabel bImage = new JLabel(b3);
        bImage.setBounds(0, 0, 850, 700);
        this.add(bImage);

        // Set screen
        this.setLayout(null);
        this.setSize(850, 700);
        this.setLocation(400, 100);
        this.setUndecorated(true);
        this.setVisible(true);
    }





    public static void main(String[] args) {
        new Deposit(" ");
    }
}
