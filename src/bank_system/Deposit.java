package bank_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String cardpas;
    TextField textField;
    JButton b1, b2;


    Deposit(String cardpas){
        this.cardpas = cardpas;

        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        //Deposit main
        JLabel label1 = new JLabel("YATIRMAK İSTEDİĞİNİZ TUTARI GİRİNİZ:");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,400,35);
        l1.add(label1);

        //text area
        textField = new TextField();
        textField.setBackground(new Color(202, 200, 200));
        textField.setForeground(Color.BLACK);
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l1.add(textField);

        //button 1
        b1= new JButton("YATIR");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(202,200,200));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        //button 2
        b2= new JButton("GERİ");
        b2.setBounds(700,406,150,35);
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
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource()==b1){
                if (textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"LÜTFEN YATIRMAK İSTEDİĞİNİZ MİKTARI GİRİNİZ");
                }else {
                    Connect c = new Connect();
                    c.statement.executeUpdate("INSERT INTO bank values('"+cardpas+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Para yatırma başarılı.");
                    setVisible(false);
                }
            } else if (e.getSource()==b2) {
                setVisible(false);
            }
        }catch (Exception E){

        }

    }


    public static void main(String[] args) {
        new Deposit(" ");
    }
}
