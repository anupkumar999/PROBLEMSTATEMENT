import java.util.Scanner;
import java.util.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Order {
    private Customer customer;
    private List<Product> products;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public double applyDiscount() {
        double total = calculateTotal();
        if (total > 5000) {
            double discount = 0.3 * total;
            total -= discount;
        }
        return total;
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class Onlinestore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);
        Order order = new Order(customer);

        while (true) {
            int choice = displayMenu(scanner);
            switch (choice) {
                case 1:
                    addProductDetails(scanner, order);
                    break;
                case 2:
                    double totalPrice = order.calculateTotal();
                    double discountedPrice = order.applyDiscount();
                    displayOrderSummary(totalPrice, discountedPrice);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static int displayMenu(Scanner scanner) {
        System.out.println("1. Add product details");
        System.out.println("2. Calculate order summary and exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public static void addProductDetails(Scanner scanner, Order order) {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Product name: ");
        String productName = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(productName, category, price);
        order.addProduct(product);
    }

    public static void displayOrderSummary(double totalPrice, double discountedPrice) {
        System.out.println("Total price: " + totalPrice + "₹");
        System.out.println("Discounted price: " + discountedPrice + "₹");
    }
}