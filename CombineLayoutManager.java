import java.awt.*;
public class CombineLayoutManager {

	public static void main(String[] args) {
		Frame f = new Frame();//BorderLayout by default
		
        Panel P1 = new Panel();//FlowLayout by default
        Panel P2 = new Panel();
		
        P2.setLayout(new GridLayout(3,4));
        
        Button[] b=new Button[12];
        for (int i=0;i<10;i++)
        {
        	b[i] = new Button(""+i);
        	P2.add(b[i]);
        }
        b[10]= new Button("AC");
        b[11]= new Button("=");
        P2.add(b[10]);
        P2.add(b[11]);
        
        
        Button add= new Button("+");
        Button sub= new Button("-");
        Button mul= new Button("*");
        Button div= new Button("/");
        
        P1.add(add);
        P1.add(sub);
        P1.add(mul);
        P1.add(div);
        
       TextField tx = new TextField();
       
       f.add(tx,"North");
       f.add(P1,"South");
       f.add(P2);//remainder space of frame is center
       
       f.show();
       f.pack();
       
       
        
		
        
        
	}

}
