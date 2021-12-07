import java.lang.StringBuffer;
public class C2_ex2 {

	public static void main(String[] args) {
		//1 int length()
		StringBuffer str = new StringBuffer("Hello VKU!");
		System.out.println(str.length());
		//2	 int capacity()
		System.out.println(str.capacity());
		//3 StringBuffer append(Object)
		System.out.println(str.append(" Welcome"));
		//4 StringBuffer insert()
		System.out.println(str.insert(6, "K21 "));
		//5 StringBuffer delete(int start, int end)
		System.out.println(str.delete(0, 6));
		//6 int indexOf
		System.out.println(str.indexOf("K21"));
		System.out.println(str.indexOf("VKU!"));
		//7 String subtring(int start, int end)
		System.out.println(str.substring(0, 8));
		//8 int lastIndexOf(String str)
		System.out.println(str.lastIndexOf("l"));
		//9 StringBuffer reverse
		System.out.println(str.reverse());
		//10 StringBuffer deleteCharAt(int index)
		System.out.println(str.deleteCharAt(0));
	}

}
