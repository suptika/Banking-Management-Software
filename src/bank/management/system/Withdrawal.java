package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    String pin;

    TextField textField;

    JButton b1, b2;

    Withdrawal(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS Rs.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460, 180, 700, 35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460, 220, 400, 35);
        l3.add(label2);

        textField = new TextField();
        textField.setBackground(new Color(203, 241, 243));
        textField.setForeground(Color.BLACK);
        textField.setBounds(460, 260, 320, 25);
        textField.setFont(new Font("Ralway", Font.BOLD, 22));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(700, 362, 150, 35);
        b1.setBackground(new Color(203, 241, 243));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700, 406, 150, 35);
        b2.setBackground(new Color(203, 241, 243));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();

                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else {
                    int withdrawalAmount = Integer.parseInt(amount);
                    if (withdrawalAmount > 10000) {
                        JOptionPane.showMessageDialog(null,
                                "Maximum withdrawal limit is Rs. 10,000. Please enter an amount less than or equal to Rs. 10,000",
                                "Withdrawal Limit Exceeded",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (withdrawalAmount <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid amount greater than 0",
                                "Invalid Amount",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    connection c = new connection();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;

                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < withdrawalAmount) {
                        JOptionPane.showMessageDialog(null,
                                "Insufficient Balance. Available balance: Rs. " + balance,
                                "Insufficient Funds",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdrawal','" + amount + "')");
                    JOptionPane.showMessageDialog(null,
                            "Rs. " + amount + " Debited Successfully",
                            "Transaction Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    new main_Class(pin);
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid numeric amount",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null,
                        "An error occurred during the transaction. Please try again.",
                        "Transaction Error",
                        JOptionPane.ERROR_MESSAGE);
                E.printStackTrace();
            }

        } else if (e.getSource() == b2) {
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main (String[]args){
            new Withdrawal("");
        }
    }

