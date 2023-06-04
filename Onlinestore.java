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
    public static void main (String []args){
        //importing a scanner from a built in package  and taking a string input from the user 
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Name of the Customer: ");
        //creating a customer class and a new object to customer name  which will store name
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);
        Order order = new Order(customer);

        
    }
 }