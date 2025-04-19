
import java.util.*;

class ShoppingCart {
    private HashMap<String, Double> priceMap = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, List<String>> priceSortedMap = new TreeMap<>();

    public void addProduct(String product, double price) {
        priceMap.put(product, price);
    }

    public void addToCart(String product) {
        if (!priceMap.containsKey(product)) {
            System.out.println("Product not found.");
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + 1);
        double price = priceMap.get(product);
        priceSortedMap.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
    }

    public void displayCartInsertionOrder() {
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue() + " @ " + priceMap.get(entry.getKey()));
        }
    }

    public void displayCartSortedByPrice() {
        for (Map.Entry<Double, List<String>> entry : priceSortedMap.entrySet()) {
            for (String product : entry.getValue()) {
                if (cart.containsKey(product)) {
                    System.out.println(product + " x" + cart.get(product) + " @ " + entry.getKey());
                }
            }
        }
    }

    public void displayAvailableProducts() {
        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Add to Cart");
            System.out.println("3. Display Cart (Insertion Order)");
            System.out.println("4. Display Cart (Sorted by Price)");
            System.out.println("5. Display Available Products");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product Name: ");
                    String product = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    cart.addProduct(product, price);
                    System.out.println("Product Added.");
                    break;
                case 2:
                    System.out.print("Enter Product Name to Add to Cart: ");
                    String cartProduct = scanner.nextLine();
                    cart.addToCart(cartProduct);
                    break;
                case 3:
                    cart.displayCartInsertionOrder();
                    break;
                case 4:
                    cart.displayCartSortedByPrice();
                    break;
                case 5:
                    cart.displayAvailableProducts();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}



