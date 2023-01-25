import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {

    @Test
    public void testPurchaseAmountCalculation() {
        CashRegister cashRegister = new CashRegister();
        HashMap<String, Double> items = new HashMap<>();
        items.put("item1", 10.5);
        items.put("item2", 20.0);
        Double item3 = items.put("item3", 15.25);
        double purchaseAmount = items.values().stream().mapToDouble(Double::doubleValue).sum();
        assertEquals(46.725, purchaseAmount, 0.001);
    }


    @Test
    public void testChangeCalculation() {
        CashRegister cashRegister = new CashRegister();
        HashMap<String, Double> items = new HashMap<>();
        items.put("item1", 10.5);
        items.put("item2", 20.0);
        items.put("item3", 15.25);
        double purchaseAmount = items.values().stream().mapToDouble(Double::doubleValue).sum();
        double cashTendered = 50;
        double change = cashTendered - purchaseAmount;
        assertEquals(3.275, change, 0.001);
    }

    @Test
    public void testCurrencyFormatting() {
        CashRegister cashRegister = new CashRegister();
        HashMap<String, Double> items = new HashMap<>();
        items.put("item1", 10.5);
        items.put("item2", 20.0);
        items.put("item3", 15.25);
        double purchaseAmount = items.values().stream().mapToDouble(Double::doubleValue).sum();
        double cashTendered = 50;
        String currencyCode = "EUR";
        double change = cashTendered - purchaseAmount;
        assertEquals("€3.28", change);
    }
}