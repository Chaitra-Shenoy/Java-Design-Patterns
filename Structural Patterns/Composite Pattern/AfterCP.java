import java.util.List;
import java.util.ArrayList;

interface CartItem {
  public int getPrice();
  public void getInfo();
}

class ProductCP implements CartItem {
  private int price;
  private String productName;

  ProductCP(String productName, int price) {
    this.productName = productName;
    this.price = price;
  }

  @Override
  public int getPrice() {
    return price;
  }

  @Override
  public void getInfo() {
    System.out.println("Product Name - "+productName+", Product Price - "+price);
  }
}

class ProductBundleCP implements CartItem{
  private List<CartItem> productList;
  private String intent;

  public ProductBundleCP(String intent) {
    this.productList = new ArrayList<>();
    this.intent = intent;
  }

  public void addItem(CartItem productItem) {
    productList.add(productItem);
  }

  @Override
  public int getPrice() {
    int totalPrice = 0;
    for(CartItem product: productList) {
      totalPrice += product.getPrice();
    }
    return totalPrice;
  }

  @Override
  public void getInfo() {
    System.out.println(intent + " - Start Bundle\n");
    for(CartItem product: productList) {
      product.getInfo();
    }
    System.out.println("\n"+ intent + " - End Product Bundle\n");
  }
}

public class AfterCP {
    public static void main(String[] args) {
      ProductCP iphone = new ProductCP("Iphone 14 Plus", 1000);
      ProductCP airpods = new ProductCP("airpods pro", 500);
      ProductCP iphoneCharger = new ProductCP("20w charger", 100);

      ProductBundleCP iphoneBundle = new ProductBundleCP("IPhone");
      iphoneBundle.addItem(new ProductCP("Wired earphones", 150));
      iphoneBundle.addItem(iphoneCharger);
      iphoneBundle.addItem(iphone);
      iphoneBundle.addItem(airpods);

      List<CartItem> cart = new ArrayList<>();
      cart.add(iphoneBundle);
      cart.add(iphone);
      cart.add(airpods);
      
      int cartTotal = 0;
      for(CartItem cartItem: cart) {
        cartItem.getInfo();
        cartTotal += cartItem.getPrice();
      }
      System.out.println("Cart Total = "+cartTotal);
    }
}