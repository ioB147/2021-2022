package Chapter_8;
import javax.swing.*;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Test1 extends JFrame {
	private JButton jButton;
	private JTextField jTextField;
	
	public void create_frame()
	{
		jButton = new JButton("Increase");
		jTextField = new JTextField("0");
		
		Container container = this.getContentPane();
		
		container.setLayout(new FlowLayout());
		
		container.add(jButton);
		container.add(jTextField);

		
		setVisible(true);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int temp = Integer.parseInt(jTextField.getText());
				temp += 1;
				jTextField.setText(String.valueOf(temp));
			}
		});;
	}

	
	public static void main(String[] args) {
		
		Test1 t1 = new Test1();
		t1.create_frame();;
		t1.pack();
	}


}
