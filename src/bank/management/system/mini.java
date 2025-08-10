package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.Vector;

public class mini extends JFrame implements ActionListener {

    String pin;
    JButton buttonExit, buttonPrint;
    JLabel label3, label4;
    JTable table;

    mini(String pin) {
        this.pin = pin;
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 800);
        setLocation(20, 20);
        setLayout(null);

        // Card holder name
        JLabel label2 = new JLabel("Suptika Singha");
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(150, 20, 200, 20);
        add(label2);

        // Card number label
        label3 = new JLabel();
        label3.setBounds(20, 80, 300, 20);
        add(label3);

        // Table column names
        String[] columnNames = {"Date", "Type", "Amount"};
        Vector<Vector<Object>> data = new Vector<>();

        // Fetch transactions and balance
        int balance = 0;
        try {
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getString("date"));
                row.add(resultSet.getString("type"));
                row.add(String.format("%,d", Integer.parseInt(resultSet.getString("amount"))));

                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Setup JTable
        table = new JTable(data, new Vector<>(java.util.Arrays.asList(columnNames)));
        table.setRowHeight(25);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 140, 340, 260);
        add(scrollPane);

        // Get card number separately
        try {
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '" + pin + "'");
            while (resultSet.next()) {
                label3.setText("Card Number: " +
                        resultSet.getString("card_number").substring(0, 4) +
                        "XXXXXXXX" +
                        resultSet.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Balance label
        label4 = new JLabel("Your Total Balance is Rs " + balance);
        label4.setBounds(20, 420, 300, 20);
        add(label4);

        // Print button
        buttonPrint = new JButton("Print");
        buttonPrint.setBounds(140, 500, 100, 25);
        buttonPrint.addActionListener(this);
        buttonPrint.setBackground(Color.BLACK);
        buttonPrint.setForeground(Color.WHITE);
        add(buttonPrint);

        // Exit button
        buttonExit = new JButton("Exit");
        buttonExit.setBounds(260, 500, 100, 25);
        buttonExit.addActionListener(this);
        buttonExit.setBackground(Color.BLACK);
        buttonExit.setForeground(Color.WHITE);
        add(buttonExit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonExit) {
            setVisible(false);
        } else if (e.getSource() == buttonPrint) {
            try {
                MessageFormat header = new MessageFormat("Mini Statement - Suptika Singha");
                MessageFormat footer = new MessageFormat("Page {0}");

                boolean complete = table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                if (complete) {
                    JOptionPane.showMessageDialog(this, "Mini statement printed successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Printing cancelled.");
                }
            } catch (Exception pe) {
                JOptionPane.showMessageDialog(this, "Error printing: " + pe.getMessage());
                pe.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new mini("");
    }
}
