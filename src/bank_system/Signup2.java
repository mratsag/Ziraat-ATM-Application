package bank_system;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Signup2 extends JFrame {
    String formno;
    JComboBox<String> comboBoxCities, comboBoxDistrict;
    Map<String, String[]> districtsMap;


    JTextField  textStreet;
    JTextArea textAddress;

    Signup2(String first){
        super(" Kayıt ");

        //add bank logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 100, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(275, 10, 300, 100);
        this.add(image);

        this.formno = formno;

        //add header
        JLabel l1 = new JLabel("Kişisel Bilgiler");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(350,230,500,30);
        l1.setForeground(Color.WHITE);
        add(l1);

        //add address
        JLabel l2 = new JLabel("Adres :");
        l2.setFont(new Font("Raleway",Font.BOLD,20));
        l2.setBounds(230,450,500,30);
        l2.setForeground(Color.WHITE);
        add(l2);

        //add address
        textAddress = new JTextArea(3,20);
        textAddress.setLineWrap(true);
        textAddress.setWrapStyleWord(true);
        textAddress.setFont(new Font("Arial", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(textAddress);
        scrollPane.setBounds(370, 450, 300, 60);
        add(scrollPane);


        //add street
        JLabel l4 = new JLabel("Sokak :");
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        l4.setBounds(230,410,500,30);
        l4.setForeground(Color.WHITE);
        add(l4);

        //add text street
        textStreet = new JTextField(20);
        textStreet.setBounds(370, 410, 150, 30);
        textStreet.setFont(new Font("Arial", Font.BOLD, 14));
        add(textStreet);

        //add city
        JLabel l3 = new JLabel("Şehir :");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        l3.setBounds(230,330,500,30);
        l3.setForeground(Color.WHITE);
        add(l3);

        //add city combox
        comboBoxCities = new JComboBox<>();
        comboBoxCities.setBounds(370, 330, 170, 30);
        comboBoxCities.setFont(new Font("Arial", Font.BOLD, 14));
        add(comboBoxCities);


        //add district
        JLabel l5 = new JLabel("İlçe :");
        l5.setFont(new Font("Raleway",Font.BOLD,20));
        l5.setBounds(230,370,500,30);
        l5.setForeground(Color.WHITE);
        add(l5);

        //add district combox
        comboBoxDistrict = new JComboBox<>();
        comboBoxDistrict.setBounds(370, 370, 170, 30);
        comboBoxDistrict.setFont(new Font("Arial", Font.BOLD, 14));
        add(comboBoxDistrict);

        //load data
        loadCityDistrictData();

        //Update districts for the first city
        updateDistricts((String) comboBoxCities.getSelectedItem());

        //ActionListener that updates districts when city is selected
        comboBoxCities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCity  = (String) comboBoxCities.getSelectedItem();
                updateDistricts(selectedCity);
            }
        });





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

    private void loadCityDistrictData() {
        districtsMap = new HashMap<>();
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("E:\\Programs\\Software studies\\Ziraat-ATM-Application\\src\\data\\cities.json")){
            districtsMap = gson.fromJson(reader, new TypeToken<Map<String, String[]>>(){}.getType());
            for (String city: districtsMap.keySet()){
                comboBoxCities.addItem(city);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void updateDistricts(String city) {
        comboBoxDistrict.removeAllItems();
        String[] districts = districtsMap.get(city);
        if (districts != null){
            for (String district: districts){
                comboBoxDistrict.addItem(district);
            }
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
