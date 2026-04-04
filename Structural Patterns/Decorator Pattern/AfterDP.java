interface Pizza {
  double pizzaCost();
  String pizzaDescription();
}

class PlainPizza implements Pizza {
  @Override
  public double pizzaCost() {
    return 100;
  }

  @Override
  public String pizzaDescription() {
    return "Plain Pizza";
  }
}

class MargheritaPizza implements Pizza {
  @Override
  public double pizzaCost() {
    return 120;
  }

  @Override
  public String pizzaDescription() {
    return "Margherita Pizza";
  }
}

abstract class PizzaDecorator implements Pizza {
  protected Pizza pizza;
  public PizzaDecorator(Pizza pizza) {
    this.pizza = pizza;
  }
}

class ExtraCheese extends PizzaDecorator{
  public ExtraCheese(Pizza pizza) {
    super(pizza);
  }

  @Override
  public double pizzaCost() {
    return pizza.pizzaCost() + 20;
  }

  @Override
  public String pizzaDescription() {
    return pizza.pizzaDescription() + ", Extra Cheese";
  }
}

class Olives extends PizzaDecorator{
  public Olives(Pizza pizza) {
    super(pizza);
  }

  @Override
  public double pizzaCost() {
    return pizza.pizzaCost() + 40;
  }

  @Override
  public String pizzaDescription() {
    return pizza.pizzaDescription() + ", Olives";
  }
}

class StuffedCrust extends PizzaDecorator{
  public StuffedCrust(Pizza pizza) {
    super(pizza);
  }

  @Override
  public double pizzaCost() {
    return pizza.pizzaCost() + 80;
  }

  @Override
  public String pizzaDescription() {
    return pizza.pizzaDescription() + ", Stuffed Crust";
  }
}

public class AfterDP {
    public static void main(String args[]) {
      Pizza withCheese = new ExtraCheese(new PlainPizza());
      System.out.println(withCheese.pizzaDescription());
      System.out.println(withCheese.pizzaCost());

      Pizza withCheeseOlives = new ExtraCheese(new Olives(new MargheritaPizza()));
      System.out.println(withCheeseOlives.pizzaDescription());
      System.out.println(withCheeseOlives.pizzaCost());

    }
}