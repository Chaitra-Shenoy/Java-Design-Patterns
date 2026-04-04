class BurgerMeal {
    private String bunType;
    private String pattyType;
    private boolean cheese;
    private boolean addDrink;

    BurgerMeal(String bunType, String pattyType) {
        this.bunType = bunType;
        this.pattyType = pattyType;
    }

    BurgerMeal(String bunType, String pattyType, boolean cheese) {
        this.bunType = bunType;
        this.pattyType = pattyType;
        this.cheese = cheese;
    }

    BurgerMeal(String bunType, String pattyType, boolean cheese, boolean addDrink) {
        this.bunType = bunType;
        this.pattyType = pattyType;
        this.cheese = cheese;
        this.addDrink = addDrink;
    }


}
public class BeforeBP {
    public static void main(String[] args) {
        BurgerMeal burgerMeal = new BurgerMeal("wheat", "veg");
        BurgerMeal burgerMealwithCheese = new BurgerMeal("wheat", "non-veg", true);
        BurgerMeal burgerMealWithCheeseAndDrink = new BurgerMeal("wheat", "veg", true, true);
    }
}