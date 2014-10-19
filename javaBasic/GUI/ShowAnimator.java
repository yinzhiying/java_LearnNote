import java.awt.*;
import java.applet.Applet;

public class ShowAnimator extends Applet 
{
  Image[] m_Images;
  int totalImages=18;
  int currentImage=1;
  public void init()
  {
	  m_Images=new Image[totalImages];
	  for(int i=0;i<totalImages;i++)
		  m_Images[i]=getImage(getDocumentBase(),"images\\Img00"+i+".gif");
	 
  }
  public void start()
  {
	  currentImage=0;
  }
  public void paint(Graphics g)
  {
	  g.drawImage(m_Images[currentImage], 50, 50, this);
	  currentImage=++currentImage % totalImages;
	try{
		Thread.sleep(50);
	}  
	catch(InterruptedException e)
	{
		showStatus(e.toString());
		
	}
	repaint();
	
	}
  public void update(Graphics g){
		paint(g);
  }
}
