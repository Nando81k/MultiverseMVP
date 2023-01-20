import java.util.HashMap;
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class CashRegister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create scanner object
        HashMap<String, Double> items = new HashMap<>(); // create hashmap object
        double purchaseAmount = 0; // initialize purchaseAmount to 0
        double cashTendered = 0; // initialize cashTendered to 0
        double salesTax = 0.08; // 8% sales tax
        String currencyCode = "USD"; // initialize currencyCode to USD

        while(true){
            System.out.print("Enter item name (or 'done' to finish): "); // prompt user for item name
            String itemName = scanner.nextLine(); // store item name in itemName
            if(itemName.equalsIgnoreCase("done")) break; // if user enters "done", break out of loop
            System.out.print("Enter item price: ");
            if (scanner.hasNextDouble()) {
                double itemPrice = scanner.nextDouble();
                purchaseAmount += itemPrice;
                items.put(itemName, itemPrice);
            } else {
                System.out.println("Invalid input! Please enter a valid item price.");
                return; // exit program
            }
            scanner.nextLine(); // Consume newline left-over
        }

        purchaseAmount += purchaseAmount*salesTax;
        System.out.println("Total Amount (including tax): " + purchaseAmount);
        System.out.print("Enter cash tendered: ");
        if (scanner.hasNextDouble()) {
            cashTendered = scanner.nextDouble(); // store cashTendered in cashTendered
        } else {
            System.out.println("Invalid input! Please enter a valid cash tendered amount.");
            return; // exit program
        }

        System.out.print("Enter currency code (e.g. USD, EUR, INR): ");
        if (scanner.hasNext()) {
            currencyCode = scanner.next();
        }

        if (cashTendered < purchaseAmount) {
            System.out.println("Error: cash tendered is less than purchase amount. Please try again.");
            return; // exit program
        }

        double change = cashTendered - purchaseAmount; // calculate change

        Locale locale = new Locale("en", currencyCode); // create locale object
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale); // create currency formatter object
        System.out.println("Change: " + currencyFormatter.format(change));
        System.out.println("Items: ");
        for(String key : items.keySet()){
            System.out.println(key + " : " + currencyFormatter.format(items.get(key)));
        }
    }
}
