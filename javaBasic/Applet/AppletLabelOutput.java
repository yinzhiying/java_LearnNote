import java.applet. *;
import java.awt. *;
import java.awt.event. *;
public class AppletLabelOutput extends Applet
{
Label myLabel;


public void init()
{
myLabel=new Label("Java是面向对象的语言");

add(myLabel);


}
}
