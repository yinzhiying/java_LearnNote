import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class TestGridLayout extends Applet
{
public void init()
{
	setLayout(new GridLayout(5,6));
	for(int i=1;i<31;i++)
	{
		if(Math.random()>0.0)
			add(new Button(Integer.toString(i)));
		else
			add(new Label());
	}
	}
}
