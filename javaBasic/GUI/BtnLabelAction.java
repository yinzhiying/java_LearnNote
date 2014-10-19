import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class BtnLabelAction extends Applet implements ActionListener
{
   Label prompt;
   Button btn;
   public void init()
   {
	   prompt=new Label("你好");
	   btn=new Button("操作");
	   add(prompt);
	   add(btn);
	   btn.addActionListener(this);
	   
	}
  // private void add(Button btn2) {
	// TODO Auto-generated method stub
	
//}
public void actionPerformed(ActionEvent e)
   {
	   if(e.getSource()==btn)
		   if(prompt.getText()=="你好")
			   prompt.setText("再见");
		   else
			   prompt.setText("你好");
			
   }
   
   
}

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class BtnLabelAction extends Applet implements ActionListener
{
   Label prompt;
   Button btn;
   public void init()
   {
	   prompt=new Label("你好");
	   btn=new Button("操作");
	   add(prompt);
	   add(btn);
	   btn.addActionListener(this);
	   
	}
  // private void add(Button btn2) {
	// TODO Auto-generated method stub
	
//}
public void actionPerformed(ActionEvent e)
   {
	   if(e.getSource()==btn)
		   if(prompt.getText()=="你好")
			   prompt.setText("再见");
		   else
			   prompt.setText("你好");
			
   }
   
   
}

