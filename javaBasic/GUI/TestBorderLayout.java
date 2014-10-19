import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class TestBorderLayout extends Applet 
{
   Button north,south,west,east,center;
   
   public void init()
   {
	   north=new Button("North");
	   south=new Button("South");
	   west=new Button("West");
	   east=new Button("East");
	   center=new Button("Center");
	   
	   setLayout(new BorderLayout());
	   add(east,BorderLayout.EAST);
	   add(center,BorderLayout.CENTER);
	   add(north,BorderLayout.NORTH);
	   add(south,BorderLayout.SOUTH);
	   add(west,BorderLayout.WEST);
   }
}
