
import java.util.Scanner;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stock[] stocks = {
            new Stock("TCS", 3500),
            new Stock("INFOSYS", 1800),
            new Stock("RELIANCE", 2900)
        };

        int[] quantity = new int[stocks.length];
        double balance = 10000;
        int choice;

        do {
            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Available Stocks");
            System.out.println("2. Buy Stocks");
            System.out.println("3. Sell Stocks");
            System.out.println("4. View My Portfolio");
            System.out.println("5. View Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("\nAvailable Stocks:");
                for (int i = 0; i < stocks.length; i++) {
                    System.out.println((i + 1) + ". "
                        + stocks[i].name + " - Rs. "
                        + stocks[i].price);
                }
            } else if (choice == 2) {
                System.out.println("\nSelect a stock:");
                for (int i = 0; i < stocks.length; i++) {
                    System.out.println((i + 1) + ". "
                        + stocks[i].name + " - Rs. "
                        + stocks[i].price);
                }

                System.out.print("Enter stock number: ");
                int stockNo = sc.nextInt();

                if (stockNo < 1 || stockNo > stocks.length) {
                    System.out.println("Invalid stock number.");
                } else {
                    System.out.print("Enter quantity to buy: ");
                    int qty = sc.nextInt();
                    int index = stockNo - 1;
                    double cost = stocks[index].price * qty;

                    if (qty <= 0) {
                        System.out.println("Quantity must be positive.");
                    } else if (cost > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        quantity[index] += qty;
                        balance -= cost;
                        System.out.println("Stocks purchased successfully!");
                    }
                }
            } else if (choice == 3) {
                System.out.println("\nYour Portfolio:");
                for (int i = 0; i < stocks.length; i++) {
                    System.out.println((i + 1) + ". "
                        + stocks[i].name + " - Quantity: "
                        + quantity[i]);
                }

                System.out.print("Enter stock number to sell: ");
                int stockNo = sc.nextInt();

                if (stockNo < 1 || stockNo > stocks.length) {
                    System.out.println("Invalid stock number.");
                } else {
                    int index = stockNo - 1;
                    System.out.print("Enter quantity to sell: ");
                    int qty = sc.nextInt();

                    if (qty <= 0) {
                        System.out.println("Quantity must be positive.");
                    } else if (qty > quantity[index]) {
                        System.out.println("You do not own enough shares.");
                    } else {
                        quantity[index] -= qty;
                        balance += stocks[index].price * qty;
                        System.out.println("Stocks sold successfully!");
                    }
                }
            } else if (choice == 4) {
                System.out.println("\n===== MY PORTFOLIO =====");
                double totalValue = 0;

                for (int i = 0; i < stocks.length; i++) {
                    double value = stocks[i].price * quantity[i];
                    totalValue += value;
                    System.out.println(stocks[i].name
                        + " | Quantity: " + quantity[i]
                        + " | Value: Rs. " + value);
                }

                System.out.println("Total Portfolio Value: Rs. "
                    + totalValue);
            } else if (choice == 5) {
                System.out.println("Available Balance: Rs. " + balance);
            } else if (choice == 6) {
                System.out.println("Thank you for using the platform!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}

