//Source => youtube video

import com.sun.org.apache.xpath.internal.objects.XString;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
    JButton num[] = new JButton[10];
    JButton func[] = new JButton[8];
    JButton add,min,div,mul,equal,clr,del,dec;
    JTextField text;
    JPanel panel;
    double num1=0,num2=0,fin=0;
    String sit;
    Font font = new Font("Serif",Font.PLAIN,30);
    Main(){

        JFrame frame = new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(3);
        frame.setSize(600,800);
        frame.setLayout(null);

        text = new JTextField();
        text.setBounds(50,50,480,60);
        text.setFont(font);
        text.setEditable(false);

        add = new JButton("+");
        min = new JButton("-");
        div = new JButton("/");
        mul = new JButton("*");
        equal = new JButton("=");
        dec = new JButton(".");
        del = new JButton("Delete");
        clr = new JButton("Clear");
        func[0]=add;
        func[1]=min;
        func[2]=div;
        func[3]=mul;
        func[4]=equal;
        func[5]=dec;
        func[6]=del;
        func[7]=clr;

        for(int i=0 ; i<8 ; i++){
            func[i].addActionListener(this);
            func[i].setFont(font);
            func[i].setFocusable(false);
        }
        for (int i =0 ; i<=9 ; i++){
            num[i] = new JButton(String.valueOf(i));
            num[i].addActionListener(this);
            num[i].setFont(font);
            num[i].setFocusable(false);
        }

        del.setBounds(50,680,225,40);
        clr.setBounds(305,680,225,  40 );

        panel = new JPanel();
        panel.setBounds(50,120,480,550);
        panel.setLayout(new GridLayout(4,4,20,20));
        panel.setBackground(Color.DARK_GRAY);

        panel.add(num[7]);
        panel.add(num[8]);
        panel.add(num[9]);
        panel.add(div);
        panel.add(num[4]);
        panel.add(num[5]);
        panel.add(num[6]);
        panel.add(mul);
        panel.add(num[1]);
        panel.add(num[2]);
        panel.add(num[3]);
        panel.add(add);
        panel.add(num[0]);
        panel.add(dec);
        panel.add(equal);
        panel.add(min);





        frame.add(panel);
        frame.add(del);
        frame.add(clr);
        frame.add(text);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
     Main calculator = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0 ; i<10 ; i++){
            if(e.getSource()==num[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==dec){
            text.setText(text.getText().concat("."));

        }
        else if(e.getSource()==add){
            num1 = Double.parseDouble(text.getText());
            sit = "+";
            text.setText("");
        }
        else if(e.getSource()==min){
            num1 = Double.parseDouble(text.getText());
            sit = "-";
            text.setText("");
        }
        else if(e.getSource()==mul){
            num1 = Double.parseDouble(text.getText());
            sit = "*";
            text.setText("");
        }
        else if(e.getSource()==div){
            num1 = Double.parseDouble(text.getText());
            sit = "/";
            text.setText("");
        }
        else if (e.getSource()==equal) {
            num2 = Double.parseDouble(text.getText());
            switch (sit){
                case "+":
                    fin = num1+num2;
                    break;
                case "-":
                    fin = num1-num2;
                    break;
                case "*":
                    fin = num1*num2;
                    break;
                case "/":
                    fin = num1/num2;
                    break;
            }
            text.setText(String.valueOf(fin));
            num1=fin;
        }
        else if (e.getSource()==clr) {
            text.setText("");
        }
        else if (e.getSource()==del) {
            String input = text.getText();
            text.setText("");
            String output;
            int len =input.length();
            for(int i =0 ; i<len-1; i++){
                text.setText(text.getText()+ input.charAt(i));
            }
        }
         /*else if (Integer.valueOf(text.getText())==0){
            text.setText("");
        }*/

    }
}