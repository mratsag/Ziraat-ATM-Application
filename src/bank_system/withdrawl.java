package bank_system;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener {
    TextField textField;
    JButton b1, b2, b3,b4,b5,b6,b7,b8;
    String cardpas;
    withdrawl(String cardpas){
        this.cardpas = cardpas;
        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png")) ;
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        //Deposit main
        JLabel label1 = new JLabel("ÇEKMEK İSTEDİĞİNİZ TUTARI GİRİNİZ:");
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
        b1= new JButton("ÇEK");
        b1.setBounds(705,410,150,35);
        b1.setBackground(new Color(202,200,200));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        //button 2
        b2= new JButton("GERİ");
        b2.setBounds(405,410,150,35);
        b2.setBackground(new Color(202,200,200));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l1.add(b2);

        // 20
        b3 = new JButton("20");
        b3.setBounds(405, 270, 150, 35);
        b3.setBackground(new Color(202, 200, 200));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        l1.add(b3);

        // 200
        b4 = new JButton("200");
        b4.setBounds(705, 270, 150, 35);
        b4.setBackground(new Color(202, 200, 200));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        l1.add(b4);

        // 50
        b5 = new JButton("50");
        b5.setBounds(405, 316, 150, 35);
        b5.setBackground(new Color(202, 200, 200));
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        l1.add(b5);

        // 500
        b6 = new JButton("500");
        b6.setBounds(705, 316, 150, 35);
        b6.setBackground(new Color(202, 200, 200));
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        l1.add(b6);

        // 100
        b7 = new JButton("100");
        b7.setBounds(405, 363, 150, 35);
        b7.setBackground(new Color(202, 200, 200));
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
        if (e.getSource() == b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "ÇEKMEK İSTEDİĞİNİZ MİKTARI GİRİNİZ.");
                } else {
                    Connect c = new Connect();
                    ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE cardpas = '" + cardpas + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "YETERSİZ BAKİYE");
                        return;
                    }
                    c.statement.executeUpdate("INSERT INTO bank VALUES('" + cardpas + "','" + date + "','withdrawl','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " PARA ÇEKME BAŞARILI");
                    setVisible(false);
                    new another();
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            new main_class(cardpas);
            setVisible(false);
        } else if (e.getSource() == b3) {
            textField.setText("20");
        } else if (e.getSource() == b4) {
            textField.setText("200");
        } else if (e.getSource() == b5) {
            textField.setText("50");
        } else if (e.getSource() == b6) {
            textField.setText("500");
        } else if (e.getSource() == b7) {
            textField.setText("100");
        }
    }


    public static void main(String[] args) {
        new withdrawl(" ");
    }
}
