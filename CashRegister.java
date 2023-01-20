import java.util.HashMap; // will use later to store items and their prices
import java.util.Locale; // will use later to format currency
import java.util.Scanner; // will use later to get user input
import java.text.NumberFormat; // will use later to also format currency



public class CashRegister {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // create scanner object
        Hashmap<String, Double> items = new HashMap<String, Double>(); // create hashmap object
        double purchaseAmount = 0; // initialize purchaseAmount to 0
        double cashTendered = 0; // initialize cashTendered to 0
        double salesTax = 0.08; // 8% sales tax
        String currencyCode = "USD"; // initialize currencyCode to USD
        
        while(true){
            System.out.print("Enter item name (or 'done' to finish): "); // prompt user for item name
            String itemName = scanner.nextLine(); // store item name in itemName
            if(itemName.equalsIgnoreCase("done")) break; // if user enters "done", break out of loop
            System.out.print("Enter item price: "); // prompt user for item price
            if (scanner.hasNextDouble()) { // if user enters a double
                double itemPrice = scanner.nextDouble(); // store item price in itemPrice
                purchaseAmount += itemPrice; // add itemPrice to purchaseAmount
                items.put(itemName, itemPrice); // add item name and price to hashmap
            } else {
                System.out.println("Invalid input! Please enter a valid item price."); // if user does not enter a double, print error message
                return; // exit program
            }
            scanner.nextLine(); // Consume newline left-over
        }

        purchaseAmount += purchaseAmount*salesTax;
        System.out.println("Total Amount (including tax): " + purchaseAmount); //
        System.out.print("Enter cash tendered: ");
        if (scanner.hasNextDouble()) {
            cashTendered = scanner.nextDouble(); // store cashTendered in cashTendered
        } else {
            System.out.println("Invalid input! Please enter a valid cash tendered amount.");
            return;
        }
    }
}
