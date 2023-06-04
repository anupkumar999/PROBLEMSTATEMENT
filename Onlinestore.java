import java.util.Scanner;

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
        
    }
 }