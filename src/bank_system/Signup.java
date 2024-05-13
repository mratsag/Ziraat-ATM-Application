package bank_system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.util.Random;

public class Signup extends JFrame {
    JTextField textName, textSurname, textCardNo, textId;
    JPasswordField CardPass;
    JDateChooser dateChooser;

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

        //add id no
        JLabel labelId = new JLabel("TC No:");
        labelId.setFont(new Font("Raleway",Font.BOLD,20));
        labelId.setBounds(230,330,500,30);
        labelId.setForeground(Color.WHITE);
        add(labelId);

        //add id no
        textId = new JTextField(20);
        textId.setBounds(370, 330, 170, 30);
        textId.setFont(new Font("Arial", Font.BOLD, 14));
        add(textId);

        // DocumentFilter to allow only 11 digits
        ((AbstractDocument) textId.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (isNumeric(string) && fb.getDocument().getLength() + string.length() <= 11) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isNumeric(text) && fb.getDocument().getLength() - length + text.length() <= 11) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            // Helper method to check if a string is numeric
            private boolean isNumeric(String str) {
                return str.matches("\\d+");
            }
        });

        //personal details (Name)
        JLabel labelName = new JLabel("İsim :");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(230,370,500,30);
        labelName.setForeground(Color.WHITE);
        add(labelName);

        //add textName
        textName = new JTextField(20);
        textName.setBounds(370, 370, 170, 30);
        textName.setFont(new Font("Arial", Font.BOLD, 14));
        add(textName);

        //personal details (Surname)
        JLabel labelSurname = new JLabel("Soyisim :");
        labelSurname.setFont(new Font("Raleway",Font.BOLD,20));
        labelSurname.setBounds(230,410,500,30);
        labelSurname.setForeground(Color.WHITE);
        add(labelSurname);

        //add textSurname
        textSurname = new JTextField(20);
        textSurname.setBounds(370, 410, 170, 30);
        textSurname.setFont(new Font("Arial", Font.BOLD, 14));
        add(textSurname);

        //add birthday
        JLabel DOB = new JLabel("Doğum Tarihi:");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(230,450,500,30);
        DOB.setForeground(Color.WHITE);
        add(DOB);

        //dataChooser
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(370,450,170,30);
        add(dateChooser);


        //personal details (CardNo)
        JLabel labelCardNo = new JLabel("Kart No :");
        labelCardNo.setFont(new Font("Raleway",Font.BOLD,20));
        labelCardNo.setBounds(230,490,500,30);
        labelCardNo.setForeground(Color.WHITE);
        add(labelCardNo);

        //add textCardNo
        textCardNo = new JTextField(20);
        textCardNo.setBounds(370, 490, 170, 30);
        textCardNo.setFont(new Font("Arial", Font.BOLD, 14));
        add(textCardNo);

        //personal details (CardPassword)
        JLabel labelCardPas = new JLabel("Kart Şifre :");
        labelCardPas.setFont(new Font("Raleway",Font.BOLD,20));
        labelCardPas.setBounds(230,530,500,30);
        labelCardPas.setForeground(Color.WHITE);
        add(labelCardPas);

        //add card password
        CardPass = new JPasswordField(4);
        CardPass.setBounds(370, 530, 170, 30);
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
