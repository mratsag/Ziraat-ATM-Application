package bank_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bill extends JFrame implements ActionListener {

    String cardpas;
    JButton b1,b2,b3,b4,b5;

    Bill(String cardpas ) {
        this.cardpas = cardpas;
        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);


        // phone bill
        b2 = new JButton("Telefon Faturası");
        b2.setBounds(405, 270, 150, 35);
        b2.setBackground(new Color(202, 200, 200));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l1.add(b2);

        // water bill
        b3 = new JButton("Su Faturası");
        b3.setBounds(705, 270, 150, 35);
        b3.setBackground(new Color(202, 200, 200));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        l1.add(b3);

        // electric bill
        b4 = new JButton("Elektirk Faturası");
        b4.setBounds(405, 316, 150, 35);
        b4.setBackground(new Color(202, 200, 200));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        l1.add(b4);

        // utility bill
        b5 = new JButton("Doğalgaz Faturası");
        b5.setBounds(705, 316, 150, 35);
        b5.setBackground(new Color(202, 200, 200));
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        l1.add(b5);

        //back button
        b1= new JButton("GERİ");
        b1.setBounds(405,410,150,35);
        b1.setBackground(new Color(202,200,200));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);


        //set screen
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1){
            new Payment(cardpas);
            setVisible(false);
        } else if (e.getSource()==b2) {
            new Error(cardpas);
            setVisible(false);
        }else if (e.getSource()==b3) {
            new Error(cardpas);
            setVisible(false);
        }else if (e.getSource()==b4) {
            new Error(cardpas);
            setVisible(false);
        }else if (e.getSource()==b5) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Bill(" ");
    }
}
