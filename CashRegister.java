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
    }
}
