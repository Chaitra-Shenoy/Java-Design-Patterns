class BurgerMealBP {
    private String burgerBun;
    private String pattyType;
    private boolean cheese;
    private boolean addDrink;

    private BurgerMealBP(BurgerBuilderBP builder) {
        this.burgerBun = builder.burgerBun;
        this.pattyType = builder.pattyType;
        this.cheese = builder.cheese;
        this.addDrink = builder.addDrink;
    }

    public static class BurgerBuilderBP {
        private String burgerBun;
        private String pattyType;
        private boolean cheese;
        private boolean addDrink;

        public BurgerBuilderBP(String burgerBun, String pattyType) {
            this.burgerBun = burgerBun;
            this.pattyType = pattyType;
        }

        public BurgerBuilderBP addCheese() {
            this.cheese = true;
            return this;
        }

        public BurgerBuilderBP addDrink() {
            this.addDrink = true;
            return this;
        }

        public BurgerMealBP build() {
            return new BurgerMealBP(this);
        }
    }
}

public class AfterBP {
    public static void main(String[] args) {
      BurgerMealBP burgerMealWithCheese =  new BurgerMealBP.BurgerBuilderBP("wheat", "veg").addCheese().build();
      BurgerMealBP burgerMealWithCheeseDrink = new BurgerMealBP.BurgerBuilderBP("wheat", "veg").addCheese().addDrink().build();
    }
}