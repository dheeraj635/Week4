import java.util.*;
interface MealPlan{
    void showmealdetails();
}

class VegetrainMeal implements MealPlan{
    public void showmealdetails(){
    System.out.println("Vegetarian Meal: Grilled vegetables, lentil soup, fruit salad.");
    }
}

class VeganMeal implements MealPlan{
    public void showmealdetails(){
        System.out.println("Vegan Meal: Tofu stir-fry, quinoa, avocado smoothie.");
    }
}

class KetoMeal implements MealPlan {
    public void showmealdetails(){
        System.out.println("Keto Meal: Bacon omelet, cheese sticks, avocado salad.");
    }
}

class HighProteinMeal implements MealPlan {
    public void showmealdetails(){
        System.out.println("High-Protein Meal: Grilled chicken, eggs, protein shake.");

    }
}

class Meal<T extends MealPlan> {
    private T mealType;
    public Meal(T mealType){
        this.mealType = mealType;
    }
    public T getMealType(){
        return mealType;
    }

    public void displayMeal(){
        mealType.showmealdetails();
    }
}

class MealPlanner {
    public static <T extends MealPlan> Meal <T> generatePlan(T mealType){
        System.out.println("Generating personalized Meal Plan");
        return new Meal<> (mealType);
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetrainMeal> vegetarian = MealPlanner.generatePlan(new VegetrainMeal());
        Meal<VeganMeal> vegan = MealPlanner.generatePlan(new VeganMeal());
        Meal<KetoMeal> keto = MealPlanner.generatePlan(new KetoMeal());
        Meal<HighProteinMeal> highProtein = MealPlanner.generatePlan(new HighProteinMeal());

        System.out.println("\nYour Personalized Meal Plans:");
        vegetarian.displayMeal();
        vegan.displayMeal();
        keto.displayMeal();
        highProtein.displayMeal();
    }
}
