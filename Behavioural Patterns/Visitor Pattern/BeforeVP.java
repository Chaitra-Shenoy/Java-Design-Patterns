import java.util.*;

class PhysicalItem {
  public void sendItem() {
    System.out.println("Shipping physical item via courier");
  }

  public void warehouseCost() {
    System.out.println("Warehouse cost: Rs. 50");
  }
}

class GiftCard {
  public void sendItem() {
    System.out.println("Sending gift card via email");
  }

  public void warehouseCost() {
    System.out.println("No warehouse cost for gift card");
  }
}

class DigitalProduct {
  public void sendItem() {
    System.out.println("Sending digital product via download link");
  }

  public void warehouseCost() {
    System.out.println("No warehouse cost for digital product");
  }
}

public class BeforeVP {
  public static void main(String args[]) {

    List<Object> items = Arrays.asList(
        new PhysicalItem(),
        new GiftCard(),
        new DigitalProduct()
    );

    for (Object item : items) {
      if (item instanceof PhysicalItem) {
        PhysicalItem p = (PhysicalItem) item;
        p.sendItem();
        p.warehouseCost();
      } 
      else if (item instanceof GiftCard) {
        GiftCard g = (GiftCard) item;
        g.sendItem();
        g.warehouseCost();
      } 
      else if (item instanceof DigitalProduct) {
        DigitalProduct d = (DigitalProduct) item;
        d.sendItem();
        d.warehouseCost();
      }

      System.out.println();
    }
  }
}