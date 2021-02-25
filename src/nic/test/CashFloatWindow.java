package nic.test;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class CashFloatWindow extends JPanel {

    private static JTextField c5Field;
    private static JTextField c10Field;
    private static JTextField c20Field;
    private static JTextField c50Field;
    private static JTextField r1Field;
    private static JTextField r2Field;
    private static JTextField r5Field;
    private static JTextField r10Field;
    private static JTextField r20Field;
    private static JTextField r50Field;
    private static JTextField r100Field;
    private static JTextField r200Field;


    private static JLabel res;

    public CashFloatWindow() {

        // I tested out using the constructor to create and fill the JFrame

        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();



        JPanel panel1 = new JPanel();
        JLabel label = new JLabel("5c  ");
        panel1.add(label);

        container.add(panel1);

        c5Field = new JTextField(10);
        panel1.add(c5Field);
        add(panel1, gbc);



        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("10c  ");
        panel2.add(label2);

        container.add(panel2);

        c10Field = new JTextField(10);
        panel2.add(c10Field);
        add(panel2);



        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("20c ");
        panel3.add(label3);

        container.add(panel3);

        c20Field = new JTextField(10);
        panel3.add(c20Field);
        add(panel3);


        JPanel panel4 = new JPanel();
        JLabel label4 = new JLabel("50c ");
        panel4.add(label4);

        container.add(panel4);

        c50Field = new JTextField(10);
        panel4.add(c50Field);
        add(panel4);



        JPanel panel5 = new JPanel();
        JLabel label5 = new JLabel("R1  ");
        panel5.add(label5);

        container.add(panel5);

        r1Field = new JTextField(10);
        panel5.add(r1Field);
        add(panel5);



        JPanel panel6 = new JPanel();
        JLabel label6 = new JLabel("R2   ");
        panel6.add(label6);

        container.add(panel6);

        r2Field = new JTextField(10);
        panel6.add(r2Field);
        add(panel6);



        JPanel panel7 = new JPanel();
        JLabel label7 = new JLabel("R5  ");
        panel7.add(label7);

        container.add(panel7);

        r5Field = new JTextField(10);
        panel7.add(r5Field);
        add(panel7);


        JPanel panel8 = new JPanel();
        JLabel label8 = new JLabel("R10 ");
        panel8.add(label8);

        container.add(panel8);

        r10Field = new JTextField(10);
        panel8.add(r10Field);
        add(panel8);


        JPanel panel9 = new JPanel();
        JLabel label9 = new JLabel("R20 ");
        panel9.add(label9);

        container.add(panel9);

        r20Field = new JTextField(10);
        panel9.add(r20Field);
        add(panel9);



        JPanel panel10 = new JPanel();
        JLabel label10 = new JLabel("R50 ");
        panel10.add(label10);

        container.add(panel10);

        r50Field = new JTextField(10);
        panel10.add(r50Field);
        add(panel10);



        JPanel panel11 = new JPanel();
        JLabel label11 = new JLabel("R100");
        panel11.add(label11);

        container.add(panel11);

        r100Field = new JTextField(10);
        panel11.add(r100Field);
        add(panel11);



        JPanel panel12 = new JPanel();
        JLabel label12 = new JLabel("R200");
        panel12.add(label12);

        container.add(panel12);

        r200Field = new JTextField(10);
        panel12.add(r200Field);
        add(panel12);


        JPanel centerPanel = new JPanel();
        JButton btn = new JButton("Calculate");
        btn.addActionListener(new BtnListener());
        centerPanel.add(btn);

        res = new JLabel();
        res.setVisible(false);
        centerPanel.add(res);

        add(centerPanel, gbc);
    }

    public void getFrameCaller(){
        frameCaller();
    }

    private void frameCaller() {
        // A method to call the frame and make it visible
        JFrame frame = new JFrame("Cash float calc");

        frame.add(new CashFloatWindow());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(350, 295);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private static class BtnListener implements ActionListener {
        // class to perform the calculations once the inputs have been received,
        // includes basic error catching, the ability to auto fill blank fields to 0
        // and is set up to output a text log with the date as the file name that contains
        // the time, float and whether it's under or over
        @Override
        public void actionPerformed(ActionEvent e) {
            double c5Content;
            double c10Content;
            double c20Content;
            double c50Content;
            double r1Content;
            double r2Content;
            double r5Content;
            double r10Content;
            double r20Content;
            double r50Content;
            double r100Content;
            double r200Content;

            try {
                if (!(c5Field.getText().equals(""))) {
                    c5Content = Double.parseDouble(c5Field.getText());
                    if (c5Content < 0) {
                        c5Content = 0;
                    }
                } else {
                    c5Content = 0;
                }

                if (!(c10Field.getText().equals(""))) {
                    c10Content = Double.parseDouble(c10Field.getText());
                    if (c10Content < 0) {
                        c10Content = 0;
                    }
                } else {
                    c10Content = 0;
                }

                if (!(c20Field.getText().equals(""))) {
                    c20Content = Double.parseDouble(c20Field.getText());
                    if (c20Content < 0) {
                        c20Content = 0;
                    }
                } else {
                    c20Content = 0;
                }

                if (!(c50Field.getText().equals(""))) {
                    c50Content = Double.parseDouble(c50Field.getText());
                    if (c50Content < 0) {
                        c50Content = 0;
                    }
                } else {
                    c50Content = 0;
                }

                if (!(r1Field.getText().equals(""))) {
                    r1Content = Double.parseDouble(r1Field.getText());
                    if (r1Content < 0) {
                        r1Content = 0;
                    }
                } else {
                    r1Content = 0;
                }

                if (!(r2Field.getText().equals(""))) {
                    r2Content = Double.parseDouble(r2Field.getText());
                    if (r2Content < 0) {
                        r2Content = 0;
                    }
                } else {
                    r2Content = 0;
                }

                if (!(r5Field.getText().equals(""))) {
                    r5Content = Double.parseDouble(r5Field.getText());
                    if (r5Content < 0) {
                        r5Content = 0;
                    }
                } else {
                    r5Content = 0;
                }

                if (!(r10Field.getText().equals(""))) {
                    r10Content = Double.parseDouble(r10Field.getText());
                    if (r10Content < 0) {
                        r10Content = 0;
                    }
                } else {
                    r10Content = 0;
                }

                if (!(r20Field.getText().equals(""))) {
                    r20Content = Double.parseDouble(r20Field.getText());
                    if (r20Content < 0) {
                        r20Content = 0;
                    }
                } else {
                    r20Content = 0;
                }

                if (!(r50Field.getText().equals(""))) {
                    r50Content = Double.parseDouble(r50Field.getText());
                    if (r50Content < 0) {
                        r50Content = 0;
                    }
                } else {
                    r50Content = 0;
                }

                if (!(r100Field.getText().equals(""))) {
                    r100Content = Double.parseDouble(r100Field.getText());
                    if (r100Content < 0) {
                        r100Content = 0;
                    }
                } else {
                    r100Content = 0;
                }

                if (!(r200Field.getText().equals(""))) {
                    r200Content = Double.parseDouble(r200Field.getText());
                    if (r200Content < 0) {
                        r200Content = 0;
                    }
                } else {
                    r200Content = 0;
                }

                // the calculations for how much each field is valued

                double cashMoney =(c5Content * 0.05) + (c10Content * 0.1) +
                        (c20Content * 0.2) + (c50Content * 0.5) + r1Content + (r2Content * 2) + (r5Content * 5)
                        + (r10Content * 10) + (r20Content * 20) + (r50Content * 50)
                        + (r100Content * 100) + (r200Content * 200);

                DecimalFormat df = new DecimalFormat("#.##");

                // in app output when the calculate button is hit

                if(cashMoney > 1500){
                    res.setText("Float: R" + df.format(cashMoney) + " Over: R"
                            + df.format(cashMoney - 1500));
                    res.setVisible(true);
                } else if (cashMoney < 1500){
                    res.setText("Float: R" + df.format(cashMoney) + " Under: R"
                            + df.format(1500 - cashMoney));
                    res.setVisible(true);
                }
                else {
                    res.setText("Float: R" + df.format(cashMoney));
                    res.setVisible(true);
                }
                try{

                    // outputs the text log

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                    if(cashMoney < 1500) {
                        FileWriter myWriter = new FileWriter(LocalDate.now() + ".txt", true);
                        myWriter.write(LocalTime.now().format(dtf) + " The float is: R" + cashMoney + " Under: R" + (1500 - cashMoney) + "\n");
                        myWriter.close();
                    } else if (cashMoney > 1500) {
                        FileWriter myWriter = new FileWriter(LocalDate.now() + ".txt", true);
                        myWriter.write(LocalTime.now().format(dtf) + " The float is: R" + cashMoney + " Over: R" + (cashMoney - 1500) + "\n");
                        myWriter.close();
                    } else {
                        FileWriter myWriter = new FileWriter(LocalDate.now() + ".txt", true);
                        myWriter.write(LocalTime.now().format(dtf) + " The float is: R" + cashMoney + "\n");
                        myWriter.close();
                    }
                } catch (IOException k){
                    k.printStackTrace();
                }

            } catch (Exception ex) {
                res.setText("Error, please only use numbers.");
                res.setVisible(true);
            }
        }
    }
}
