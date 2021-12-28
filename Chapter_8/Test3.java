package Chapter_8;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Test3 extends JFrame {
	private JComboBox jComboBox;
	
	public void create_frame()
	{
		jComboBox = new JComboBox();
		jComboBox.addItem("Red");
		jComboBox.addItem("Green");
		jComboBox.addItem("Blue");
		jComboBox.addItem("Black");
		jComboBox.addItem("White");
		
		Container container = this.getContentPane();

		container.add(jComboBox);
		
		pack();
		setVisible(true);
		
		jComboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int index = jComboBox.getSelectedIndex();
				switch (index) {
				case 0:
					container.setBackground(Color.RED);
					break;
				case 1:
					container.setBackground(Color.GREEN);
					break;
				case 2:
					container.setBackground(Color.BLUE);
					break;
				case 3:
					container.setBackground(Color.BLACK);
					break;
				case 4:
					container.setBackground(Color.WHITE);
				break;
				}
			}
		});
	}
	public static void main(String[] args) {
		Test3 t3 = new Test3();
		t3.create_frame();
		t3.setSize(700, 700);
	}

}
