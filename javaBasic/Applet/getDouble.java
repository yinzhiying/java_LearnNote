import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class getDouble extends Applet implements ActionListener
{
Label prompt;
TextField input;
double d=0.0;

public void init()
{
	prompt=new Label("请输入一个浮点数：");
	input=new TextField(10);
	add(prompt);
	add(input);
	input.addActionListener(this);
}
public void paint(Graphics g)
{
	g.drawString("你输入了数据："+d,10,50);
}
public void actionPerformed(ActionEvent e)
{
	d=Double.valueOf(input.getText()).doubleValue();
	repaint();
}
}