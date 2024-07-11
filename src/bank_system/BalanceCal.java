package bank_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceCal extends JFrame implements ActionListener {

    JButton b2;
    JLabel label1,label2;
    String cardpas;


    BalanceCal(String cardpas){
        this.cardpas=cardpas;
        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);


        //label 1
        label1 = new JLabel("MEVCUT BAKİYENİZ :");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430,180,400,35);
        l1.add(label1);

        //label 2
        label2 = new JLabel();
        label2.setForeground(Color.white);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460,220,400,35);
        l1.add(label2);

        //button 2
        b2= new JButton("GERİ");
        b2.setBounds(405,410,150,35);
        b2.setBackground(new Color(202,200,200));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l1.add(b2);

        //set
        int balance = 0;
        try {
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE cardpas = '"+cardpas+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception E){
            E.printStackTrace();
        }


        label2.setText(""+balance);

        //set screen
        setLayout(null);
        setSize(1500,1080);
        setLocation(0,0);
        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_class(cardpas);

    }


    public static void main(String[] args) {
        new BalanceCal("");
    }
}
