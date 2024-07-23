package bank_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment2 extends JFrame implements ActionListener {
    String cardpas;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;

    Payment2(String cardpas){
        this.cardpas = cardpas;

        //background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);


        // Driver and Identity License Payments
        b3 = new JButton("<html>Sürücü ve Kimlik<br> Belgesi Ödemeleri</html>");
        b3.setBounds(405, 270, 150, 35);
        b3.setBackground(new Color(202, 200, 200));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        l1.add(b3);

        // Donation Payments
        b4 = new JButton("Bağış Ödemeleri");
        b4.setBounds(705, 270, 150, 35);
        b4.setBackground(new Color(202, 200, 200));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        l1.add(b4);

        // Central Payments
        b5 = new JButton("Merkezi Ödemeler");
        b5.setBounds(405, 316, 150, 35);
        b5.setBackground(new Color(202, 200, 200));
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        l1.add(b5);

        // education and institution
        b6 = new JButton("<html>Eğitim ve Sınav<br>Ödemeleri</html>");
        b6.setBounds(705, 316, 150, 35);
        b6.setBackground(new Color(202, 200, 200));
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        l1.add(b6);

        // games of chance
        b7 = new JButton("<html>Şans Oyunları <br> Ödemleri</html>");
        b7.setBounds(405, 363, 150, 35);
        b7.setBackground(new Color(202, 200, 200));
        b7.setForeground(Color.BLACK);
        b7.addActionListener(this);
        l1.add(b7);

        //Contracted institution payments
        b8 = new JButton("<html>Anlaşmalı Kurum<br>Ödemeleri</html>");
        b8.setBounds(705, 363, 150, 35);
        b8.setBackground(new Color(202, 200, 200));
        b8.setForeground(Color.BLACK);
        b8.addActionListener(this);
        l1.add(b8);


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
        if (e.getSource()==b2) {
            new Payment(cardpas);
            setVisible(false);
        }else if (e.getSource()==b3) {
            new Bill(cardpas);
            setVisible(false);
        }else if (e.getSource()==b4) {
            new Error(cardpas);
            setVisible(false);
        }else if (e.getSource()==b5) {
            new Error(cardpas);
            setVisible(false);
        }else if (e.getSource()==b6) {
            new Error(cardpas);
            setVisible(false);
        }else if (e.getSource()==b7) {
            new Error(cardpas);
            setVisible(false);
        }else if (e.getSource()==b8) {
            new Error(cardpas);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Payment2("");
    }
}
