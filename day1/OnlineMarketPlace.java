import java.util.*;

interface bookCategory{}
interface ClothingCategory{ }
interface GadgetCategory{}

class Product <T> {
    private String name;
    private double price;
    private T  category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getname(){
        return name;
    }

    public double getprice(){
        return price;
    }

    public T getcategory(){
        return category;
    }

    public void setprice(double newprice){
        this.price = price;
    }
    
    public void displayProduct(){
        System.out.println("Product : "+name+", Price : "+price+", Category : "+category);
    }
}

class friction implements bookCategory{}
class nonfriction implements bookCategory{}

class menclothing implements ClothingCategory{}
class womenclothing implements ClothingCategory{}

class Mobile implements GadgetCategory{}
class Laptop implements GadgetCategory{}

class Discountutil{
    public static <T extends Product> void applyDiscount(T product, double percentage){
        double discount = product.getprice()*percentage/100;
        product.setprice(product.getprice()-discount);
        System.out.println("Discount of " + percentage + "% applied on: " + product.getname());

    }
}

class Catalog{
    private List<Product<?>> productlist = new ArrayList<>();

    public void addlist(Product<?> product){
        productlist.add(product);
    }

    public void displayCatalog(){
        for (Product<?> product : productlist){
            product.displayProduct();
        }
    }
}

public class OnlineMarketPlace {
    public static void main(String[] args) {
        Product<bookCategory> book1 = new Product<>("Harry Potter", 29.99, new friction());
        Product<ClothingCategory> shirt = new Product<>("Men's Shirt", 49.99, new menclothing());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 599.99, new Mobile());

        Catalog catalog = new Catalog();

        catalog.addlist(book1);
        catalog.addlist(shirt);
        catalog.addlist(phone);

        System.out.println("Catalog Before Discount:");
        catalog.displayCatalog();

    
        Discountutil.applyDiscount(book1, 10);
        Discountutil.applyDiscount(phone, 15);

        System.out.println("\nCatalog After Discount:");
        catalog.displayCatalog();
    }
    

}
