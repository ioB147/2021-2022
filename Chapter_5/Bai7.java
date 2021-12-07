package Chapter_5;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Car extends CarList{
    public Car(int id, String name, double price, double extraOut, int quantity, double priceOfCar) 
    {
        super(id, name, price, extraOut, quantity, priceOfCar);
        // methods
    }

    
    public Car() {} // 
    
    public Car Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter extra out: ");
        double extraOut = scanner.nextDouble();
        System.out.println("Enter the quantity: ");
        int quantity = scanner.nextInt();

        // PriceForSale();
        return new Car(id, name, price, extraOut, quantity, this.getPriceOfCar());
    }
    
    
    // public double PriceForSale() {
    //     if(this.getQuantity() < 50)
    //     {
    //         (this.getPrice() + this.getExtraOut());
    //     }
    //     else if(this.getQuantity() >= 50)
    //     {
    //         (this.getPrice() + this.getExtraOut() + 0.1 * this.getExtraOut());
    //     }
    //     return this.getPriceOfCar();
    // }

}

class CarList {
    private Car[] car;
    private int id, quantity;
    private double price, extraOut, priceOfCar;
    private String name;
    
    public double getPriceOfCar() {
        return priceOfCar;
    }

    public void setPriceOfCar(double priceOfCar) {
        this.priceOfCar = priceOfCar;
    }

    public Car[] getCar() {
        return car;
    }

    public void setCar(Car[] car) {
        this.car = car;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getExtraOut() {
        return extraOut;
    }
    
    public void setExtraOut(double extraOut) {
        this.extraOut = extraOut;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    public CarList() {}
    
    public CarList(int id, String name, double price, double extraOut, int quantity, double priceOfCar) {
        //
        this.id = id;
        this.name = name;
        this.price = price;
        this.extraOut = extraOut;
        this.quantity = quantity;
        this.priceOfCar = priceOfCar;
    }
    
    int num;
    int sumOfCar = 0;
    public void Processing() {
        Scanner scanner = new Scanner(System.in);
        
        int selection;
        System.out.print("Enter the number of objects: ");
        num = scanner.nextInt();
        CarList[] c = new CarList[num];
        
        for(int i = 0; i < num; i++)
        {
            c[i] = new Car().Input();
        }
        
        System.out.println("====================================================");
        System.out.println("Enter your selection");
        System.out.println("1.Print the list of Car.");
        System.out.println("2.Print the list of Car that have price sale more then 20.");
        System.out.println("3.Print the sum of Car");
        System.out.println("====================================================");
        selection = scanner.nextInt();
    
        switch (selection) {
            case 1:
                System.out.println("1.Print the list of Car.");
                Arrays.stream(c).collect(Collectors.toList()).forEach(car -> System.out.println(car.toString()));
                break;
            case 2:
                System.out.println("2.Print the list of Car that have price sale more then 20.");
                // Arrays.stream(c).filter(priceCar -> priceCar.getPriceOfCar() >= 20).collect(Collectors.toList()).forEach(p -> System.out.println(p.toString()));
                break;
            case 3:
                System.out.println("====================================================");
                System.out.println("3.Print the sum of Car");
                for(int j = 0; j<num; j++)
                {
                    sumOfCar = sumOfCar + c[j].quantity;
                }
                System.out.println(sumOfCar);
                System.out.println("====================================================");
                break;
        }
        scanner.close();
    }
    
    public String toString() {
        return "ID: " + id  + " Name: " + name + " Price: " + price + " ExtreaOut: " + extraOut + " Quantity: " + quantity + " Price Of Car: " + priceOfCar;
    }
}

public class Bai7 {
    public static void main(String[] args) {
        // new Car(1, "Vin Fast", 500, 500, 12); // 
        new CarList().Processing();
    }
}
