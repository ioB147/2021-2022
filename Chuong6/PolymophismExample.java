package Chuong6;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Pet {
    private String name;
    private int age;
    private double price;
    public double weight;

    public void makeSounds() 
    {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getWeight() 
    {
        return weight;
    }

    public void setWeight(double weight) 
    {
        this.weight = weight;
    }
    

    public Pet() {
    }

    public Pet(String name, int age, double price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public String toString1()
    {
        return ("Name: " + this.name + "; Age: " + this.age + "; Price: " + this.price); // 
    }
    public String toString2()
    {
        return ("Name: " + this.name + "; Age: " + this.age + "; Price: " + this.weight); // 
    }
}

class Cats extends Pet {
    private int numberOfLegs;

    public void makeSounds() {
        System.out.println("Meo Meo");
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    
    public Cats() {
    }


    public Cats(String name, int age, double price, int numberOfLegs) {
        super(name, age, price);
        this.numberOfLegs = numberOfLegs;
    }

    public Cats InputCat() 
    {
        Scanner scanner2 = new Scanner(System.in);
        
        System.out.print("Name cat's name: ");
        String name = scanner2.next();
        System.out.print("Age: ");
        int age = scanner2.nextInt();
        System.out.print("Price: ");
        double price = scanner2.nextDouble();
        System.out.print("Number Of Legs: ");
        int legs = scanner2.nextInt();
        return new Cats(name, age, price, legs); // 
    }
}

class Dogs extends Pet {


    public void makeSounds() 
    {
        System.out.println("Gout Gout");
    }

    
    public Dogs() 
    {
    }


    public Dogs(String name, int age, double price, double weight) 
    {
        super(name, age, price);
        this.weight = weight;
    }
    
    public Dogs InputDog() 
    {
        Scanner scanner1 = new Scanner(System.in);
        
        System.out.print("Dog's name: ");
        String name = scanner1.next();
        System.out.print("Age: ");
        int age = scanner1.nextInt();
        System.out.print("Price: ");
        double price = scanner1.nextDouble();
        System.out.print("Weight: ");
        int weight = scanner1.nextInt();
        return new Dogs(name, age, price, weight); 
        
    }

}

public class PolymophismExample {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int num1,num2;
        
        System.out.print("Enter the number of cats: ");
        num1 = sc.nextInt();
        Pet[] A = new Pet[num1];
        for (int i = 0; i < num1; i++) 
        {
            A[i] = new Cats().InputCat();
        }
        
        System.out.print("Enter the number of dogs: ");
        num2 = sc.nextInt();
        Pet[] B = new Pet[num2];
        for (int i = 0; i < num2; i++) 
        {
            B[i] = new Dogs().InputDog();
        }
        
        System.out.println("====================================================");
        System.out.println("\tSorting Alphabetic");
        Arrays.stream(A).sorted(Comparator.comparing(person -> person.getName())).collect(Collectors.toList()).forEach(s -> System.out.println(s.toString1()));
        System.out.println("====================================================");
        Arrays.stream(B).sorted(Comparator.comparing(person -> person.getName())).collect(Collectors.toList()).forEach(s -> System.out.println(s.toString2()));
        System.out.println("====================================================");
        
        

    }
}

