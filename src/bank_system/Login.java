package bank_system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JLabel label1,label2,label3;
    JTextField textField;
    JPasswordField passwordField;
    JButton button1,button2,button3;

    public Login(){
        super("Ziraat Bankası");
        //add bank image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 100, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(270, 10, 300, 100);
        this.add(image);

        //add card image
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image c2 = c1.getImage().getScaledInstance(100, 100, 1);
        ImageIcon c3 = new ImageIcon(c2);
        JLabel cImage = new JLabel(c3);
        cImage.setBounds(630, 350, 100, 100);
        this.add(cImage);

        //add label1
        this.label1 = new JLabel("HOŞGELDİNİZ");
        this.label1.setForeground(Color.WHITE);
        this.label1.setFont(new Font("AvantGarde", 1, 34));
        this.label1.setBounds(300, 150, 450, 40);
        this.add(this.label1);

        //add label2
        this.label2 = new JLabel("Kart Numarası: ");
        this.label2.setFont(new Font("Ralway", 1, 28));
        this.label2.setForeground(Color.WHITE);
        this.label2.setBounds(110, 230, 375, 30);
        this.add(this.label2);

        //add textField
        this.textField = new JTextField(16);
        this.textField.setBounds(330, 230, 230, 30);
        this.textField.setFont(new Font("Arial", 1, 14));
        this.add(this.textField);

        //add label3
        this.label3 = new JLabel("Kart Şifresi: ");
        this.label3.setFont(new Font("Ralway", 1, 28));
        this.label3.setForeground(Color.WHITE);
        this.label3.setBounds(110, 280, 375, 30);
        this.add(this.label3);

        //add passwordField
        this.passwordField = new JPasswordField(4);
        this.passwordField.setBounds(330, 280, 230, 30);
        this.passwordField.setFont(new Font("Arial", 1, 14));
        this.add(this.passwordField);

        //button login
        this.button1 = new JButton("Giriş Yap");
        this.button1.setFont(new Font("Arial", 1, 14));
        this.button1.setForeground(Color.BLACK);
        this.button1.setBackground(Color.WHITE);
        this.button1.setBounds(330, 335, 100, 30);
        this.button1.addActionListener(this);
        this.add(this.button1);

        //button sing up
        button3 = new JButton("Kayıt Ol");
        button3.setFont(new Font("Arial",1,14));
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.WHITE);
        button3.setBounds(460, 335, 100, 30);
        button3.addActionListener(this);
        add(this.button3);

        // add close button
        button2 = new JButton(" ");
        button2.setFont(new Font("Arial", 1, 9));
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.WHITE);
        button2.setBounds(825, 0, 25, 25);
        button2.addActionListener(this);
        add(this.button2);

        //background
        ImageIcon b1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.jpg"));
        Image b2 = b1.getImage().getScaledInstance(850, 550, 1);
        ImageIcon b3 = new ImageIcon(b2);
        JLabel bImage = new JLabel(b3);
        bImage.setBounds(0, 0, 850, 550);
        this.add(bImage);

        //set screen
        this.setLayout((LayoutManager)null);
        this.setSize(850, 550);
        this.setLocation(400, 140);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1){
                String cardno = textField.getText();
                String cardpas = passwordField.getText();
                Connect c = new Connect();
                String query = "SELECT * FROM login WHERE card_no = ? AND card_password = ?";
                PreparedStatement stmt = c.connection.prepareStatement(query);
                stmt.setString(1, cardno);
                stmt.setString(2, cardpas);
                ResultSet resultSet = stmt.executeQuery();
                if (resultSet.next()){
                    setVisible(false);
                    new main_class(cardpas);
                }else {
                    JOptionPane.showMessageDialog(null,"CARD NUMARASI VEYA ŞİFRENİZ YANLIŞ!");
                }
            }else if (e.getSource() == button2){
                System.exit(0);
                
            } else if (e.getSource()== button3) {
                new Signup();
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Login();
    }
}
