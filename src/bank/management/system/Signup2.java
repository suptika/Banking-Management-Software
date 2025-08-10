package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textpan,textAadhar;
    JRadioButton r1, r2, e1, e2;
    JButton next;
    private String formno;

    Signup2(String formno){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        JLabel l1 = new JLabel("Page 2");
        l1.setFont(new Font("Ralway", Font.BOLD,22));
        l1.setBounds(420,20,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Ralway",Font.BOLD,22));
        l2.setBounds(360,60,600,40);
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Ralway", Font.BOLD,18));
        l3.setBounds(230,120,100,30);
        add(l3);

        String religion[] = {"Hindu", "Muslim", "Sikh","Christian", "Other"};
        comboBox = new JComboBox(religion);
        getContentPane().setBackground(new Color(222,255,228));
        comboBox.setFont(new Font("Ralway",Font.BOLD,14));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);

        JLabel l4 = new JLabel("Category : ");
        l4.setFont(new Font("Ralway", Font.BOLD,18));
        l4.setBounds(225,170,100,30);
        add(l4);

        String Category[] = {"General", "SC", "ST","OBC", "Other"};
        comboBox2 = new JComboBox(Category);
        getContentPane().setBackground(new Color(222,255,228));
        comboBox2.setFont(new Font("Ralway",Font.BOLD,14));
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income : ");
        l5.setFont(new Font("Ralway", Font.BOLD,18));
        l5.setBounds(240,220,100,30);
        add(l5);

        String income [] = {"Null", "<1,50,000", "2,50,000","5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        getContentPane().setBackground(new Color(222,255,228));
        comboBox3.setFont(new Font("Ralway",Font.BOLD,14));
        comboBox3.setBounds(350,220,320,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Educational : ");
        l6.setFont(new Font("Ralway", Font.BOLD,18));
        l6.setBounds(195,270,150,30);
        add(l6);

        String educational [] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate"};
        comboBox4 = new JComboBox(educational);
        getContentPane().setBackground(new Color(222,255,228));
        comboBox4.setFont(new Font("Ralway",Font.BOLD,14));
        comboBox4.setBounds(350,270,320,30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation : ");
        l7.setFont(new Font("Ralway", Font.BOLD,18));
        l7.setBounds(200,320,150,30);
        add(l7);

        String occupation [] = {"Salaried", "Sel-Employed", "Business", "Retired", "Student", "Other"};
        comboBox5 = new JComboBox(occupation);
        getContentPane().setBackground(new Color(222,255,228));
        comboBox5.setFont(new Font("Ralway",Font.BOLD,14));
        comboBox5.setBounds(350,320,320,30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number : ");
        l8.setFont(new Font("Ralway", Font.BOLD,18));
        l8.setBounds(190,370,150,30);
        add(l8);

        textpan = new JTextField();
        textpan.setBackground(new Color(255, 255, 255));
        textpan.setFont(new Font("Ralway", Font.BOLD,18));
        textpan.setBounds(350,370,320,30);
        add(textpan);

        JLabel l9 = new JLabel("Aadhar Number : ");
        l9.setFont(new Font("Ralway", Font.BOLD,18));
        l9.setBounds(165,420,170,30);
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setBackground(new Color(255, 255, 255));
        textAadhar.setFont(new Font("Ralway", Font.BOLD,18));
        textAadhar.setBounds(350,420,320,30);
        add(textAadhar);

        JLabel l10 = new JLabel("Senior Citizen : ");
        l10.setFont(new Font("Ralway", Font.BOLD,18));
        l10.setBounds(175,470,170,30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Ralway", Font.BOLD,18));
        r1.setBackground(new Color(111, 206, 220));
        r1.setBounds(350,470,100,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Ralway", Font.BOLD,18));
        r2.setBackground(new Color(111, 206, 220));
        r2.setBounds(460,470,100,30);
        add(r2);

        JLabel l11 = new JLabel("Existing Account : ");
        l11.setFont(new Font("Ralway", Font.BOLD,18));
        l11.setBounds(150,520,170,30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Ralway", Font.BOLD,18));
        e1.setBackground(new Color(111, 206, 220));
        e1.setBounds(350,520,100,30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Ralway", Font.BOLD,18));
        e2.setBackground(new Color(111, 206, 220));
        e2.setBounds(460,520,100,30);
        add(e2);

        JLabel l12 = new JLabel("Form No : ");
        l12.setFont(new Font("Ralway", Font.BOLD,16));
        l12.setBounds(680,10,200,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Ralway", Font.BOLD,16));
        l13.setBounds(760,10,100,30);
        add(l13);

        next = new JButton("Next");
        next.setFont(new Font("Ralway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(570,580,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(111, 206, 220));
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String pan = textpan.getText();
        String aadhar = textAadhar.getText();

        String scitizen = " ";
        if ((r1.isSelected())){
            scitizen = "Yes";
        } else if (r2.isSelected()) {
            scitizen = "No";
        }
        String eAccount = " ";
        if ((r1.isSelected())){
            eAccount = "Yes";
        } else if (r2.isSelected()) {
            eAccount = "No";
        }

        try{
            if (textpan.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }else{
                connection c1 = new connection();
                String q = "insert into Signup2 values('"+formno+"','"+rel+"', '"+cate+"', '"+inc+"', '"+edu+"', '"+occ+"', '"+pan+"', '"+aadhar+"', '"+scitizen+"', '"+eAccount+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Signup2("");
    }

}
