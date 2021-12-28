package Chapter_8;

import java.awt.Checkbox;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test2 extends JFrame{
	private JLabel jLabel;
	private Checkbox checkbox1, checkbox2, checkbox3, checkbox4;
	
	public void create_frame()
	{
		jLabel = new JLabel("Question?");
		checkbox1 = new Checkbox("Answer A",false);
		checkbox2 = new Checkbox("Answer B",false);
		checkbox3 = new Checkbox("Answer C",false);
		checkbox4 = new Checkbox("Answer D",false);
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(5,1));
		container.add(jLabel);
		container.add(checkbox1);
		container.add(checkbox2);
		container.add(checkbox3);
		container.add(checkbox4);
		
		pack();
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 t2 = new Test2();
		t2.create_frame();
	}

}
