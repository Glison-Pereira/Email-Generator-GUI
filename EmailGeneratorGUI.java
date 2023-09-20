// Create a GUI to generate random Email.

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;

class EmailGenerator extends JFrame
{
     Container c;
     JLabel YourName;
     JLabel PrintEmail;
     JTextField EnterName;
     JButton EmailGenerate;

     EmailGenerator()
     {
          c=getContentPane();
          c.setLayout(new FlowLayout(FlowLayout.CENTER,30,40));
          Color co=new Color(.5f, 0.3f, 0.1f, 0.5f);
          Color co1=new Color(0,153,0);
          YourName=new JLabel("Enter your name: ");
          YourName.setForeground(Color.RED);
          EnterName=new JTextField(40);
          EnterName.setForeground(co1);
          EmailGenerate=new JButton("Click to generate new Email");
          c.setBackground(co);
          Font f=new Font("Times new Roman",Font.BOLD,30);
          Font f1=new Font("Times new Roman",Font.ITALIC,30);
          YourName.setFont(f);
          EmailGenerate.setFont(f1);
          EmailGenerate.setForeground(Color.BLUE);
          EmailGenerate.setBackground(Color.WHITE);
          ActionListener a=(ap)->{
          try{
          String name=EnterName.getText();
          int len=name.length();
          if(!name.matches("[a-zA-Z ]+"))
             throw new Exception("You have enter invalid name");
          String[] num={"0","1","2","3","4","5","6","7","8","9"};
          String[] str={"gmail","yahoo","outlook","xyz","zoho","icloud","mail","yandex","tutanota","abc"};
          String[] letter={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
          String msg="";
          String namer="";
          int input=(int)(Math.random()*str.length);
          for(int i=0;i<(int)(Math.random()*str.length);i++)
          {
             int input1=(int)(Math.random()*num.length);
             msg=num[input1]+msg;
          }
          for(int i=0;i<(int)(Math.random()*str.length);i++)
          {
             int input2=(int)(Math.random()*letter.length);
             namer=letter[input2]+namer;
          }
          String msg1="Your Email is "+name+namer+msg+"1@"+str[input]+".com";
          JOptionPane.showMessageDialog(c,msg1);
          EnterName.setText("");
          EnterName.requestFocus();
          }
          catch(Exception e){
              JOptionPane.showMessageDialog(c,e.getMessage());
              EnterName.setText("");
              EnterName.requestFocus();  
          }
          };
          EmailGenerate.addActionListener(a);
          c.add(YourName);
          c.add(EnterName);
          c.add(EmailGenerate);
          setTitle("Email Generator GUI");
          setSize(500,500);
          setLocationRelativeTo(null);
          setResizable(false);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setVisible(true); 
     }
}

class EmailGeneratorGUI
{
public static void main(String args[])
{
  EmailGenerator eg=new EmailGenerator();
}
}