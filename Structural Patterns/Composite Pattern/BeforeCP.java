import java.util.List;
import java.util.ArrayList;

class Product {
  private String productName;
  private int productPrice;

  public Product(String productName, int productPrice) {
    this.productName = productName;
    this.productPrice = productPrice;
  }

  public int getPrice() {
    return productPrice;
  }

  public String getProductName() {
    return productName;
  }

  public void getInfo() {
    System.out.println("Product Name - "+productName+", Product Price - "+productPrice);
  }
}

class ProductBundle {
  private List<Product> productList;
  private int productPrice;

  public ProductBundle(List<Product> productList) {
    this.productList = productList;
    this.productPrice = 0;
  }

  public int getPrice() {
    for(Product product: productList) {
      productPrice += product.getPrice();
    }
    return productPrice;
  }

  public void getInfo() {
    for(Product product: productList) {
      System.out.println("Product Name - "+product.getProductName()+", Product Price - "+product.getPrice());
    }
  }
}

public class BeforeCP {
    public static void main(String[] args) {
      Product iphone = new Product("Iphone 14 Plus", 1000);
      Product airpods = new Product("airpods pro", 500);
      Product iphoneCharger = new Product("20w charger", 100);

      List<Product> iphoneBundleList = new ArrayList<>(List.of(iphone, airpods, iphoneCharger));

      ProductBundle iphoneBundle = new ProductBundle(iphoneBundleList);

      List<Object> cart = new ArrayList<>();
      cart.add(iphoneBundle);
      cart.add(iphone);
      cart.add(airpods);
      
      int cartTotal = 0;
      for(Object cartItem: cart) {
        if(cartItem instanceof Product) {
          Product productItem = (Product) cartItem;
          productItem.getInfo();
          cartTotal += productItem.getPrice();
        } else {
          ProductBundle productBundleItem = (ProductBundle) cartItem;
          productBundleItem.getInfo();
          cartTotal += productBundleItem.getPrice();
        }
      }
      System.out.println("Cart Total = "+cartTotal);
    }
}