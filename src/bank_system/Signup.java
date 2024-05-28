package bank_system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JTextField textName, textSurname, textCardNo, textId, textCardPass;
    JPasswordField CardPass;
    JDateChooser dateChooser;
    JButton next;

    Random ran = new Random();
    long first1 = (ran.nextLong() % 9000L) + 1000L;
    String formno = " " + Math.abs(first1);

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
        JLabel label1 = new JLabel("Üye Başvuru No:" + formno);
        label1.setBounds(230,150,500,45);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);


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
        textCardPass = new JPasswordField(4);
        textCardPass.setBounds(370, 530, 170, 30);
        textCardPass.setFont(new Font("Arial", Font.BOLD, 14));
        add(textCardPass);

        // DocumentFilter to allow only 4 digits
        ((AbstractDocument) textCardPass.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (isNumeric(string) && fb.getDocument().getLength() + string.length() <= 4) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isNumeric(text) && fb.getDocument().getLength() - length + text.length() <= 4) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            // Helper method to check if a string is numeric
            private boolean isNumeric(String str) {
                return str.matches("\\d+");
            }
        });

        //next
        next = new JButton("Diğer Sayfa");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(400,600,120,30);
        next.addActionListener(this);
        add(next);

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



    @Override
    public void actionPerformed(ActionEvent e) {
        String tcno = textId.getText();
        String name = textName.getText();
        String surname = textSurname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String cardno = textCardNo.getText();
        String cardpas = textCardPass.getText();

        try {
            if (textName.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Lütfen tüm alanları doldurun!");
            }else{
                Connect con = new Connect();
                String q = "INSERT INTO signup VALUES ('"+formno+"','"+tcno+"','"+name+"','"+surname+"','"+dob+"','"+cardno+"','"+cardpas+"')";
                String q2 = "INSERT INTO login VALUES ('"+formno+"','"+cardno+"','"+cardpas+"')";
                con.statement.executeUpdate(q);
                con.statement.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Kart no : "+cardno+"\n Şifre : "+cardpas);
                new Signup2(formno);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new Signup();
    }
}
