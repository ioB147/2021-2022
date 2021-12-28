import java.awt.*;
public class BorderLayoutEx {

	public static void main(String[] args) {

		Frame f = new Frame("With GridLayout");
		f.setLayout(new GridLayout(5,4));
		Button[] b = new Button[20];
		for (int i=0;i<20;i++)
		{
			b[i]= new Button(""+i);
			f.add(b[i]);
		}
		
		f.show();
		f.pack();
  
  
  
  
		
	}

}