/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Abdullah
 */
public class FeedbackView extends JFrame {
   public static void submit_feedback(){
       submit_feedback obj = new submit_feedback();
       
       //obj.show();
   }
}

 class submit_feedback extends JFrame{
        
        public submit_feedback()
        {
        
          JTextArea editArea = new JTextArea(100,400);
          JButton submit = new JButton("ssss");
          Font font = new Font(
                        Font.MONOSPACED, 
                        Font.PLAIN, 
                        editArea.getFont().getSize());
                editArea.setFont(font);
                add(new JScrollPane(editArea,
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
          add(editArea);
          add(submit);
         // setLayout(new FlowLayout());
        setVisible(true);
       setSize(1000,1000);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
       
        }
    }