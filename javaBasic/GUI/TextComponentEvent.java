import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class TextComponentEvent extends Applet implements TextListener,ActionListener
{
   TextField tf;
   TextArea ta;
   public void init()
   {
	   
		   tf=new TextField(45);
		   ta=new TextArea(5,45);
		   add(tf);
		   add(ta);
		   tf.addActionListener(this);
		   tf.addTextListener(this);
		   
   }  
	   public void textValueChanged(TextEvent e)
	   {
		   if(e.getSource()==tf)
			   ta.setText(((TextField)e.getSource()).getText());
	   }
     public void actionPerformed(ActionEvent e)
     {
    	 if(e.getSource()==tf)
    		 ta.setText("");
    		 
     }
}
