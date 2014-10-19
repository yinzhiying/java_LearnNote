import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;
public class TestChangedIcon extends JApplet implements ActionListener
{
  JLabel jlbl;
  JButton jbtn;
  JTextField jt;
  //Icon lalIcon,btnIcon;
  Font oldF;
  public void init()
  {
	  Container c=getContentPane();
	  Icon normalIcon=new ImageIcon("img001.gif");
	  Icon pressedIcon=new ImageIcon("img0018.gif");
	  Icon rolloverIcon=new ImageIcon("img0018.gif");
	  jlbl=new JLabel("这是Swing标签，normalIcon,JLabel.Center");
	  jbtn=new JButton("JButton按钮",normalIcon);
	  jt=new JTextField("text");
	  jbtn.setToolTipText("我是Swing按钮");
	  jbtn.setPressedIcon(pressedIcon);
	  jbtn.setRolloverIcon(rolloverIcon);
	  jbtn.setRolloverEnabled(true);
	
	  oldF=jbtn.getFont();
	  c.add(jlbl);
	  c.add(jbtn,BorderLayout.NORTH);
	  c.add(jt,BorderLayout.SOUTH);
	  jbtn.addActionListener(this);
	  
	  
  }
  public void actionPerformed(ActionEvent e)
  {
	  jlbl.setText(jt.getText());
	  showStatus("响应单击j按钮");
  }
}
