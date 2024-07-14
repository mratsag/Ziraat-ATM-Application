package bank_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Error extends JFrame implements ActionListener {
    String cardpas;
    JButton b1;

    Error(String cardpas){
        this.cardpas = cardpas;

        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        //Deposit main
        JLabel label1 = new JLabel("<html>ŞU AN İÇİN HİZMET DIŞI <br>LÜTFEN DAHA SONRA TEKRAR DENEYİNİZ!!</html>");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,400,35);
        l1.add(label1);


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
            new another();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Error(" ");
    }
}
