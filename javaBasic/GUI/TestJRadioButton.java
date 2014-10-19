import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class TestJRadioButton extends JApplet implements ItemListener,ListSelectionListener
{
	JButton  jbtn;
	//ButtonGroup bg;
	JCheckBox jc;
	//JLabel jl;
	JComboBox jcb;
	JList jl;
	String[] elementList={"18","24","30"};
	Font oldF;
	Color oldC;
	public void init()
	{
		Container c = getContentPane();
		jbtn=new JButton("  Ð§¹û   "); 
		jc=new JCheckBox("blue"); 
		jl=new JList(elementList); 
		jcb=new JComboBox(); 
	     
		jcb.addItem("plain");
		jcb.addItem("italic");
		jcb.addItem("bold");
		
		c.setLayout(new FlowLayout());
		c.add(jbtn); 
		c.add(jc);
		c.add(jcb);
		c.add(jl);
		//bg.add(r2); 
		//bg.add(r3);
		
		//c.add(r1,BorderLayout.NORTH);
		//c.add(r2,BorderLayout.CENTER);
		//c.add(r3,BorderLayout.SOUTH);
			
		jcb.addItemListener(this);
		jc.addItemListener(this);
		jl.addListSelectionListener(this);
	}
	public void itemStateChanged(ItemEvent e)
	{
		//JRadioButton temp;
		oldF=jbtn.getFont();
		
		if(e.getItemSelectable() instanceof JCheckBox)
		{
			if(((JCheckBox)e.getItemSelectable()).isSelected())
			jbtn.setBackground(Color.blue);
		}
		if(e.getItemSelectable() instanceof JComboBox)//temp = (JRadioButton)(e.getItemSelectable());
	{
			if(((JComboBox)e.getItemSelectable()).getSelectedItem() == "plain");
			    jbtn.setFont(new Font(oldF.getName(), Font.PLAIN, oldF.getSize()));	
			if(((JComboBox)e.getItemSelectable()).getSelectedItem() == "italic")
				jbtn.setFont(new Font(oldF.getName(), Font.ITALIC, oldF.getSize()));	
			if(((JComboBox)e.getItemSelectable()).getSelectedItem() == "bold")
				jbtn.setFont(new Font(oldF.getName(), Font.BOLD, oldF.getSize()));	
		}
	}
	public void valueChanged(ListSelectionEvent e)
	{
		oldF=jbtn.getFont();
		jbtn.setFont(new Font(oldF.getName(),oldF.getStyle(),Integer.parseInt((String)((JList)e.getSource()).getSelectedValue())));
		
	}
}
