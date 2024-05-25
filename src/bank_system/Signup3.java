package bank_system;

import javax.swing.*;
import java.awt.*;

public class Signup3 extends JFrame {
    JRadioButton r1,r2,r3,r4;
    JTextField accountNumberField, ibanField;

    Signup3(){
        //account details
        JLabel l1 = new JLabel("Hesap Bilgileri");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(350,150,500,30);
        l1.setForeground(Color.WHITE);
        add(l1);

        //account type
        JLabel l2 = new JLabel("Hesap türü :");
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        l2.setBounds(130,200,200,30);
        l2.setForeground(Color.WHITE);
        add(l2);

        //add account type
        r1 = new JRadioButton("Cari Hesap");
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        r1.setBounds(130,230,150,30);
        r1.setOpaque(false);
        r1.setForeground(Color.WHITE);
        add(r1);
        r2 = new JRadioButton("Katılma Hesabı");
        r2.setFont(new Font("Raleway",Font.BOLD,15));
        r2.setBounds(130,260,150,30);
        r2.setOpaque(false);
        r2.setForeground(Color.WHITE);
        add(r2);
        r3 = new JRadioButton("Altın Hesapları");
        r3.setFont(new Font("Raleway",Font.BOLD,15));
        r3.setBounds(290,230,150,30);
        r3.setOpaque(false);
        r3.setForeground(Color.WHITE);
        add(r3);
        r4 = new JRadioButton("Gümüş Hesapları");
        r4.setFont(new Font("Raleway",Font.BOLD,15));
        r4.setBounds(290,260,150,30);
        r4.setOpaque(false);
        r4.setForeground(Color.WHITE);
        add(r4);

        //buttonGroup
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        //add account number
        JLabel accountNumberLabel = new JLabel("Hesap Numarası:");
        accountNumberLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        accountNumberLabel.setBounds(130, 310, 200, 30);
        accountNumberLabel.setForeground(Color.WHITE);
        add(accountNumberLabel);
        accountNumberField = new JTextField();
        accountNumberField.setBounds(130, 340, 300, 30);
        accountNumberField.setFont(new Font("Raleway",Font.BOLD,18));
        add(accountNumberField);

        //add iban
        JLabel ibanLabel = new JLabel("IBAN:");
        ibanLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        ibanLabel.setBounds(130, 380, 200, 30);
        ibanLabel.setForeground(Color.WHITE);
        add(ibanLabel);
        ibanField = new JTextField();
        ibanField.setBounds(130, 410, 300, 30);
        ibanField.setFont(new Font("Raleway",Font.BOLD,20));
        add(ibanField);

        //add bank logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 100, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(275, 10, 300, 100);
        this.add(image);

        //background
        ImageIcon b1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.jpg"));
        Image b2 = b1.getImage().getScaledInstance(850, 700, 1);
        ImageIcon b3 = new ImageIcon(b2);
        JLabel bImage = new JLabel(b3);
        bImage.setBounds(0, 0, 850, 700);
        this.add(bImage);

        //set screen
        this.setLayout((LayoutManager)null);
        this.setSize(850, 700);
        this.setLocation(500, 200);
        this.setUndecorated(true);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new Signup3();
    }
}
