package bank_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Password2 extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String cardpas;

    Password2(String cardpas){
        this.cardpas = cardpas;
        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        //change your pin
        JLabel label1 = new JLabel("ŞİFRE DEĞİŞTİRME");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,400,35);
        l1.add(label1);

        //enter
        JLabel label2 = new JLabel("Yeni Şifre :");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(430,220,150,35);
        l1.add(label2);

        //pin1
        p1 = new JPasswordField();
        p1.setForeground(Color.BLACK);
        p1.setBounds(600,220,180,25);
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.add(p1);

        //re-enter
        JLabel label3 = new JLabel("Tekrar giriniz :");
        label3.setForeground(Color.white);
        label3.setFont(new Font("System",Font.BOLD,16));
        label3.setBounds(430,255,150,35);
        l1.add(label3);

        //pin2
        p2 = new JPasswordField();
        p2.setForeground(Color.BLACK);
        p2.setBounds(600,255,180,25);
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        l1.add(p2);


        // button 2
        b2 = new JButton("GERİ");
        b2.setBounds(405, 410, 150, 35);
        b2.setBackground(new Color(202, 200, 200));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l1.add(b2);

        //button 1
        b1= new JButton("EVET");
        b1.setBounds(705,410,150,35);
        b1.setBackground(new Color(202,200,200));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        // Set screen
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pass1 =p1.getText();
            String pass2 =p2.getText();

            if (!pass1.equals(pass2)){
                JOptionPane.showMessageDialog(null,"Girdiğiniz şifreler aynı değil lütfen tekrar deneyiniz!!");
                return;
            }
            if (e.getSource()==b1){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Yeni şifreyi giriniz.");
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Şifreyi tekrar giriniz.");
                }

                Connect c = new Connect();
                String q1 = "update bank set cardpas ='"+pass1+"' where cardpas = '"+cardpas+"'";
                String q2 = "update login set card_password ='"+pass1+"' where card_password = '"+cardpas+"'";
                String q3 = "update signup set card_password ='"+pass1+"' where card_password = '"+cardpas+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"Şifre başarıyla değiştirildi.");
                setVisible(false);
                new another();
            } else if (e.getSource()==b2) {
                new main_class(cardpas);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Password2("");
    }
}
