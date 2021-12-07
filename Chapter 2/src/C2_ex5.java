import java.util.*;
public class C2_ex5 {
//data/attributes/
String name;
int age;
String address;
float AverMark,math,phy,che;

//methods/operations

public void input()
{
Scanner key = new Scanner(System.in);
System.out.print("Input student name = ");
name= key.nextLine();
System.out.print("Input Age: ");
age = key.nextInt();

key.nextLine();//clear buffer
System.out.print("Address = ");
address= key.nextLine();

System.out.print("Math mark = ");
math=key.nextFloat();
System.out.print("Physic mark = ");
phy=key.nextFloat();
System.out.print("Chemistry mark = ");
che=key.nextFloat();
AverMark = (math+phy+che)/3;
}
//
public void output()
{
System.out.println("\nName:"+ name +"\nAddress:" +address + "\nAge: "+ age +"\nMath mark: " + math + "\nPhysic mark: " + phy + "\nChemistry mark: " + che +"\nAverage mark: "+AverMark);
}
public static void main(String[] args) {

C2_ex5 A = new C2_ex5();
A.input();
A.output();

}

}