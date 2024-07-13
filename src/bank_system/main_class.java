package bank_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    String cardpas;

    main_class(String cardpas){
        this.cardpas = cardpas;
        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        //main
        JLabel label1 = new JLabel(" YAPMAK İSTEDİĞİNİZ İŞLEMİ SEÇİNİZ");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 18));
        label1.setBounds(460,180,600,35);
        l1.add(label1);

        //deposit
        b1= new JButton("PARA ÇEKME");
        b1.setBounds(405,270,150,35);
        b1.setBackground(new Color(202,200,200));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        //cash withdrawn
        b2= new JButton("PARA YATIRMA");
        b2.setBounds(705,270,150,35);
        b2.setBackground(new Color(202,200,200));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l1.add(b2);

        //fast cash
        b3= new JButton("PARA TRANSFERLERİ");
        b3.setBounds(405,316,150,35);
        b3.setBackground(new Color(202,200,200));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        l1.add(b3);

        //information
        b4= new JButton("ÖDEME İŞLEMLERİ");
        b4.setBounds(705,316,150,35);
        b4.setBackground(new Color(202,200,200));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        l1.add(b4);

        //Pin change
        b5= new JButton("ŞİFRE DEĞİŞTİRME");
        b5.setBounds(405,363,150,35);
        b5.setBackground(new Color(202,200,200));
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        l1.add(b5);

        //balance information
        b6= new JButton("BAKİYE-BİLGİ");
        b6.setBounds(705,363,150,35);
        b6.setBackground(new Color(202,200,200));
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        l1.add(b6);

        //exit
        b7= new JButton("ÇIKIŞ");
        b7.setBounds(705,410,150,35);
        b7.setBackground(new Color(202,200,200));
        b7.setForeground(Color.BLACK);
        b7.addActionListener(this);
        l1.add(b7);

        // Set screen
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new withdrawl(cardpas);
            setVisible(false);
        } else if (e.getSource()==b2) {
            new Deposit(cardpas);
            setVisible(false);
        }else if (e.getSource()==b3) {
            setVisible(false);
        }else if (e.getSource()==b4) {
            new Payment(cardpas);
            setVisible(false);
        }else if (e.getSource()==b5) {
            setVisible(false);
        }else if (e.getSource()==b6) {
            new BalanceCal(cardpas);
            setVisible(false);
        }else if (e.getSource()==b7) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new main_class("");
    }
}
