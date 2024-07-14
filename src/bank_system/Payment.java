package bank_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {
    String cardpas;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    Payment(String cardpas){
        this.cardpas = cardpas;
        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);


        // Bill Payments
        b3 = new JButton("Fatura Ödemeleri");
        b3.setBounds(405, 270, 150, 35);
        b3.setBackground(new Color(202, 200, 200));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        l1.add(b3);

        // SSI Payments
        b4 = new JButton("SGK Ödemeleri");
        b4.setBounds(705, 270, 150, 35);
        b4.setBackground(new Color(202, 200, 200));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        l1.add(b4);

        // Tax Payments
        b5 = new JButton("Vergi Ödemeleri");
        b5.setBounds(405, 316, 150, 35);
        b5.setBackground(new Color(202, 200, 200));
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        l1.add(b5);

        // Loan Payments
        b6 = new JButton("Kredi Ödemeleri");
        b6.setBounds(705, 316, 150, 35);
        b6.setBackground(new Color(202, 200, 200));
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        l1.add(b6);

        // Title Deed Payments
        b7 = new JButton("Tapu Ödemeleri");
        b7.setBounds(405, 363, 150, 35);
        b7.setBackground(new Color(202, 200, 200));
        b7.setForeground(Color.BLACK);
        b7.addActionListener(this);
        l1.add(b7);

        //Trafik Cezası Ödemeleri
        b8 = new JButton("<html>Trafik Ceza<br>Ödemeleri</html>");
        b8.setBounds(705, 363, 150, 35);
        b8.setBackground(new Color(202, 200, 200));
        b8.setForeground(Color.BLACK);
        b8.addActionListener(this);
        l1.add(b8);



        //next page
        b1= new JButton("DİĞER");
        b1.setBounds(705,410,150,35);
        b1.setBackground(new Color(202,200,200));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        //back button
        b2= new JButton("GERİ");
        b2.setBounds(405,410,150,35);
        b2.setBackground(new Color(202,200,200));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l1.add(b2);

        // Set screen
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new Payment2(cardpas);
            setVisible(false);
        }else if (e.getSource()==b2){
            new main_class(cardpas);
            setVisible(false);
        } else if (e.getSource()==b3) {
            new Bill(cardpas);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Payment("");
    }
}
