
import java.util.*;

abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getname(){
        return name;
    }
    public abstract void display();

}

class Electronics extends WarehouseItem {
    public Electronics(String name){
        super(name);
    }

    public void display(){
        System.out.println("Electronic name : "+getname());
    }
}

class Groceries extends WarehouseItem {
    public Groceries (String name){
        super(name);
    }

    public void display(){
        System.out.println("Groceries name : "+getname());
    }
}

class warehouseUtil {
    public static void displayallitems(List<? extends WarehouseItem> items){
        for(WarehouseItem item:items){
            item.display();
        }
    }
}

class Furniture extends WarehouseItem{
    public Furniture(String name){
        super(name);
    }

    public void display(){
        System.out.println("Furniture name : "+getname());
    }
}
class Stroage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void additems(T item){
        items.add(item);
    }

    public T getitems(int index){
        return items.get(index);
    }

    public List<T> getallitems(){
        return items;
    }
}

class warehouse_managment{
    public static void main(String[] args) {
        Stroage<Electronics> estorage = new Stroage<>();
        estorage.additems(new Electronics("Laptop"));
        estorage.additems(new Electronics("Mobile"));

        Stroage<Groceries> gstorage = new Stroage<>();
        gstorage.additems(new Groceries("Corn Floor"));
        gstorage.additems(new Groceries("Rice"));

        Stroage<Furniture> fStroage = new Stroage<>();
        fStroage.additems(new Furniture("Bed"));
        fStroage.additems(new Furniture("Door"));

        System.out.println("Displaying Electronics : ");
        warehouseUtil.displayallitems(estorage.getallitems());

        System.out.println("Displaying Groceries : ");
        warehouseUtil.displayallitems(gstorage.getallitems());

        System.out.println("Displaying Furniture : ");
        warehouseUtil.displayallitems(fStroage.getallitems());
    }
}