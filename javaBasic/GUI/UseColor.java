import java.awt.*;
import java.applet.Applet;

public class UseColor extends Applet
{
	int cr,cg,cb;
	Color oldColor;
	Image myImage;
	/*public void init()
	{
		cr=Integer.parseInt(getParameter("red"));
		cg=Integer.parseInt(getParameter("green"));
		cb=Integer.parseInt(getParameter("blue"));
		myImage=getImage(getDocumentBase(),"学生选课系统.jpg");
	}*/
	
  public void paint(Graphics g)
  {
          g.setColor(Color.yellow);
          g.fillOval(100,100,50,50);
          g.setColor(Color.black);
          g.drawOval(115,110,5,5);
          g.setColor(Color.black);
          g.drawOval(135,110,5,5);
          g.setColor(Color.black);
          g.drawArc(113,120,24,18,0,-180);
          oldColor=g.getColor();
	      g.setFont(new Font("Arial",Font.BOLD,15));
	      g.setColor(new Color(cr,cg,cb));
	      g.drawString("show current color",10,20);
	      g.drawImage(getImage(getDocumentBase(),"学生选课系统.jpg"),300,300,600,900,this);
          //g.setColor(oldColor);
          /*g.drawString("old default color"+g.getColor().toString

(),10,40);*/
  }
}
