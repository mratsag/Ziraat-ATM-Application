package bank_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Password1 extends JFrame implements ActionListener {
    JButton b1;
    JLabel l1;
    String cardpas;

    Password1(String cardpas) {
        this.cardpas = cardpas;
        // Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1550, 830);
        l1.setLayout(null);
        add(l1);

        // Text
        String text = "<html><div>" +
                "<h2>Kişisel ve Finansal Güvenlik</h2>" +
                "<p>Şifrenizi belirlerken kolaylıkla tahmin edilebilecek kişisel bilgilerinizi (doğum yılınız,<br>" +
                "tuttuğunuz takım kuruluş yılı vb.) kullanmayınız.</p>" +
                "<p>Kişisel bilgilerinizi gizli tutunuz. Doğum tarihi, kimlik numarası, anne kızlık soyadı gibi<br>" +
                "bilgilerinizin; telefonla ya da e-posta yoluyla talep edilmesi durumunda son derece<br>" +
                "dikkatli ve şüpheci davranınız.</p>" +
                "<p>Sizi telefon ile arayarak kart bilgileriniz ile her türlü şifrenizi okumanızı ve tuşlamanızı<br>" +
                "isteyen kişilere itibar etmeyiniz.</p>" +
                "<p>Kart bilgileriniz, müşteri numaranız, internet ve mobil bankacılık şifreniz ile cep<br>" +
                "telefonunuza gönderilen tek kullanımlık onay şifreniz sadece size özeldir. Bu bilgileri<br>" +
                "banka personelleri dahil, kimseyle paylaşmayınız.</p><br>" +
                "<p>Bankamız tarafından e-posta yoluyla hiçbir şifre işlemi gerçekleştirilmemekte, hem<br>" +
                "kişisel hem de kart bilgileriniz istenmemektedir. Bu tarz e-postalara yanıt vermeyiniz.<br>" +
                "Böyle bir durum ile karşılaşırsanız 0850 220 00 00 Çağrı Merkezimiz ile iletişime geçiniz.</p>" +
                "</div></html>";

        JLabel label1 = new JLabel(text);
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, (int) 10.5));
        label1.setBounds(415, 20, 580, 500);
        l1.add(label1);

        // Button 1
        b1 = new JButton("DEVAM");
        b1.setBounds(705, 410, 150, 35);
        b1.setBackground(new Color(202, 200, 200));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        // Set screen
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new Password2(cardpas);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Password1("");
    }
}
