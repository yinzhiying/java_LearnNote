import java.applet. *;
import java.awt. *;
import java.awt.event. *;
public class AppletInOut extends Applet implements ActionListener
{
Label prompt;
TextField input,output;

public void init()
{
prompt=new Label("��������������");
input=new TextField(6);
output=new TextField(20);
add(prompt);
add(input);
add(output);
input.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
output.setText(input.getText()+",��ӭ�㣡");
}
}
