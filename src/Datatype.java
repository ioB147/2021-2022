public class Datatype {

	public static void main(String[] args) {
		
		//store marks of 10 students
		
		float marks[] = new float[10];//10 variables marks
		
		marks[0]=8.5f;
		marks[1]=9.5f;
		marks[2]=6.5f;
		marks[3]=7.5f;
		marks[4]=8.0f;
		marks[5]=8.2f;
		marks[6]=8.5f;
		marks[7]=8.5f;
		marks[8]=6.7f;
		marks[9]=8.5f;
		
		for (int i =0;i<10;i++)
			System.out.println("marks["+i+"]= "+marks[i]);
	}

}
