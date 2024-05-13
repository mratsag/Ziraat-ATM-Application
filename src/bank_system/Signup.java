package bank_system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Signup extends JFrame {
    JTextField textName, textSurname, textCardNo;
    JPasswordField CardPass;

    Random ran = new Random();
    long first1 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first1);

    Signup(){
        super(" Kayıt ");

        //add bank image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 100, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(275, 10, 300, 100);
        this.add(image);

        //add application form no
        JLabel label1 = new JLabel("Üye Başvuru No:" + first);
        label1.setBounds(230,150,500,45);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        //add page 1
        /*JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        label2.setBounds(230,250,500,30);
        label2.setForeground(Color.WHITE);
        add(label2);*/

        //add
        JLabel label3 = new JLabel("Kişisel Bilgiler");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(350,230,500,30);
        label3.setForeground(Color.WHITE);
        add(label3);

        //personal details (Name)
        JLabel labelName = new JLabel("İsim :");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(230,330,500,30);
        labelName.setForeground(Color.WHITE);
        add(labelName);

        //add textName
        textName = new JTextField(20);
        textName.setBounds(370, 330, 170, 30);
        textName.setFont(new Font("Arial", Font.BOLD, 14));
        add(textName);

        //personal details (Surname)
        JLabel labelSurname = new JLabel("Soyisim :");
        labelSurname.setFont(new Font("Raleway",Font.BOLD,20));
        labelSurname.setBounds(230,370,500,30);
        labelSurname.setForeground(Color.WHITE);
        add(labelSurname);

        //add textSurname
        textSurname = new JTextField(20);
        textSurname.setBounds(370, 370, 170, 30);
        textSurname.setFont(new Font("Arial", Font.BOLD, 14));
        add(textSurname);

        //personal details (CardNo)
        JLabel labelCardNo = new JLabel("Kart No :");
        labelCardNo.setFont(new Font("Raleway",Font.BOLD,20));
        labelCardNo.setBounds(230,410,500,30);
        labelCardNo.setForeground(Color.WHITE);
        add(labelCardNo);

        //add textCardNo
        textCardNo = new JTextField(20);
        textCardNo.setBounds(370, 410, 170, 30);
        textCardNo.setFont(new Font("Arial", Font.BOLD, 14));
        add(textCardNo);

        //personal details (CardPassword)
        JLabel labelCardPas = new JLabel("Kart Şifre :");
        labelCardPas.setFont(new Font("Raleway",Font.BOLD,20));
        labelCardPas.setBounds(230,450,500,30);
        labelCardPas.setForeground(Color.WHITE);
        add(labelCardPas);

        //add card password
        CardPass = new JPasswordField(4);
        CardPass.setBounds(370, 450, 170, 30);
        CardPass.setFont(new Font("Arial", Font.BOLD, 14));
        add(CardPass);


        //background
        ImageIcon b1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.jpg"));
        Image b2 = b1.getImage().getScaledInstance(850, 700, 1);
        ImageIcon b3 = new ImageIcon(b2);
        JLabel bImage = new JLabel(b3);
        bImage.setBounds(0, 0, 850, 700);
        this.add(bImage);

        //set screen
        this.setLayout((LayoutManager)null);
        this.setSize(850, 700);
        this.setLocation(500, 200);
        this.setUndecorated(true);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new Signup();
    }
}
