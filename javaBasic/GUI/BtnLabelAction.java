import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class BtnLabelAction extends Applet implements ActionListener
{
   Label prompt;
   Button btn;
   public void init()
   {
	   prompt=new Label("���");
	   btn=new Button("����");
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
		   if(prompt.getText()=="���")
			   prompt.setText("�ټ�");
		   else
			   prompt.setText("���");
			
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
	   prompt=new Label("���");
	   btn=new Button("����");
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
		   if(prompt.getText()=="���")
			   prompt.setText("�ټ�");
		   else
			   prompt.setText("���");
			
   }
   
   
}

