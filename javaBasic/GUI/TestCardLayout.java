import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class TestCardLayout extends Applet
{
   CardLayout MyCard=new CardLayout();//创建CardLayout布局管理器对象
   Button btn1=new Button("第一个按钮");
   Button btn2=new Button("第二个按钮");
   Button btn3=new Button("第三个按钮");
   Button btn4=new Button("第四个按钮");
   Button btn5=new Button("第五个按钮");
   
   public void init()
   {
	   setLayout(MyCard);//设置容器的布局策略为CardLayout
	   add("第一页",btn1);//加入组件并指定名字
	   add("第二页",btn2);
	   add("第三页",btn3);
	   add("第四页",btn4);
	   add("第五页",btn5);
	   btn1.addMouseListener(new MouseMoveCard(MyCard,this));
	   btn2.addMouseListener(new MouseMoveCard(MyCard,this));
	   btn3.addMouseListener(new MouseMoveCard(MyCard,this));
	   btn4.addMouseListener(new MouseMoveCard(MyCard,this));
	   btn5.addMouseListener(new MouseMoveCard(MyCard,this));
   }
}
class MouseMoveCard extends MouseAdapter
{
   CardLayout c1;
   Applet m_Parent;
   MouseMoveCard(CardLayout c,Applet a)
   {
	   c1=c;
	   m_Parent=a;
   }
   public void mouseClicked(MouseEvent e)
   {
	   if(e.getModifiers()==InputEvent.BUTTON1_MASK)
		   c1.next(m_Parent);//鼠标左键
	   else
		   c1.previous(m_Parent);//鼠标右键
   }
}
