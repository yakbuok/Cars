import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealer {
    private String name;
    private double money;
    private List<Car> cars;

    public Dealer(String name, double initialMoney) {
        this.name = name;
        this.money = initialMoney;
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Car added: " + car);
    }

    public void showCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            System.out.println("Available cars:");
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    public void sellCar(int index) {
        if (index >= 0 && index < cars.size()) {
            Car car = cars.remove(index);
            money += car.sell();
            System.out.println("Sold car: " + car);
            System.out.println("Current money: $" + money);
        } else {
            System.out.println("Invalid car index.");
        }
    }

    public void dealerMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nDealer Menu:");
            System.out.println("1. Show all cars");
            System.out.println("2. Add a car");
            System.out.println("3. Sell a car");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showCars();
                    break;
                case 2:
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter mileage: ");
                    double mileage = scanner.nextDouble();
                    System.out.print("Enter power: ");
                    double power = scanner.nextDouble();
                    Car newCar = new Vehicle(year, mileage, power).new Sedan();
                    addCar(newCar);
                    break;
                case 3:
                    System.out.print("Enter car index to sell: ");
                    int index = scanner.nextInt();
                    sellCar(index);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Dealer dealer = new Dealer("Best Cars", 50000);
        dealer.dealerMenu();
    }
}
