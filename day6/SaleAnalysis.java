
import java.util.*;
import java.util.stream.Collectors;

class Sale {
    private String productId;
    private int quantity;
    private double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}

class ProductSales {
    private String productId;
    private double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String getProductId() { return productId; }
    public double getTotalRevenue() { return totalRevenue; }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Revenue: $" + totalRevenue;
    }
}

class SaleAnalysis {

    public static List<ProductSales> getTop5Products(List<Sale> sales) {
        return sales.stream()
                .filter(sale -> sale.getQuantity() > 10)
                .collect(Collectors.groupingBy(
                        Sale::getProductId,
                        Collectors.summingDouble(s -> s.getQuantity() * s.getPrice())
                ))
                .entrySet().stream()
                .map(entry -> new ProductSales(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())            
                .limit(5)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("P001", 15, 100.0),
            new Sale("P002", 5, 300.0),
            new Sale("P003", 20, 50.0),
            new Sale("P001", 10, 100.0),
            new Sale("P004", 25, 80.0),
            new Sale("P005", 12, 200.0),
            new Sale("P006", 30, 90.0),
            new Sale("P007", 18, 120.0)
        );

        List<ProductSales> topProducts = getTop5Products(sales);
        topProducts.forEach(System.out::println);
    }
}
