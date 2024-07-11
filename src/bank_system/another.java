package bank_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class another extends JFrame implements ActionListener {

    JButton b1,b2;
    String cardpas;
    another(){
        this.cardpas = cardpas;
        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        //Deposit main
        JLabel label1 = new JLabel("BAŞKA İŞLEM YAPMAK İSTİYOR MUSUNUZ?");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,400,35);
        l1.add(label1);

        //button 1
        b1= new JButton("EVET");
        b1.setBounds(705,410,150,35);
        b1.setBackground(new Color(202,200,200));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        //button 2
        b2= new JButton("HAYIR");
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
            new main_class(cardpas);
            setVisible(false);
        } else if (e.getSource() == b2) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new another();
    }
}
