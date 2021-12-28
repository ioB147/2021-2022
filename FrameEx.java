import java.awt.*;
public class FrameEx {

	public static void main(String[] args) {

		Frame f = new Frame("My first GUI program");
		//by default, the frame is invisible and size =0,0
	
		f.setLayout(new FlowLayout());
		
		Button b = new Button("Button");
		f.add(b);
		
		Label lb= new Label("Label: ");
		f.add(lb);
		TextField tx = new TextField("TextField");
		f.add(tx);
		
		TextArea ta = new TextArea();
		f.add(ta);
		
		Checkbox cb1= new Checkbox();
		Checkbox cb2= new Checkbox();
		Checkbox cb3= new Checkbox();
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		
		//creat radio buttons
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox rb1= new Checkbox("Radio 1",cbg,true);
		Checkbox rb2= new Checkbox("Radio 2",cbg,false);
		Checkbox rb3= new Checkbox("Radio 3",cbg,false);
		f.add(rb1);
		f.add(rb2);
		f.add(rb3);
		
		//Create Choice
		
		Choice colors = new Choice();
		colors.addItem("red");
		colors.addItem("blue");
		colors.addItem("yellow");
		
		f.add(colors);
		
		List ls = new List();
//create a list
		for (int i=0;i<20;i++)
		ls.addItem(""+i);
		
		f.add(ls);
		
		
		f.show();
		f.pack();	
		
		
		
		
	}

}