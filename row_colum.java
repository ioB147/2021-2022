
public class row_colum {

	public void row_colum (int n)
	{
		for (int i=1;i<=n;i++)
		{
			for (int j=1;j<=n;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		row_colum o = new row_colum();
		o.row_colum(5);
	}

}
