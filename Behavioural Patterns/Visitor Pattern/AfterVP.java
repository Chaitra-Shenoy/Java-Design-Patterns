import java.util.ArrayList;
import java.util.List;
interface Item {
  public void accept(ItemVisitor visitor);
}

class PhysicalItemVP implements Item {
  private int weight;
  private String name;

  PhysicalItemVP(int weight, String name) {
    this.weight = weight;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public void accept(ItemVisitor visitor) {
    visitor.visit(this);
  }
}

class GiftCardVP implements Item {
  private int value;

  GiftCardVP(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
  @Override
  public void accept(ItemVisitor visitor) {
    visitor.visit(this);
  }
}

class DigitalProductVP implements Item {
  private String name;

  DigitalProductVP(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public void accept(ItemVisitor visitor) {
    visitor.visit(this);
  }
}

interface ItemVisitor {
  public void visit(PhysicalItemVP physicalItem);
  public void visit(GiftCardVP giftCard);
  public void visit(DigitalProductVP digitalProduct);
}

class InvoiceGenerator implements ItemVisitor {
  public void visit(PhysicalItemVP physicalItem) {
    System.out.println("Generate invoice for physical item - "+physicalItem.getName());
  }
  public void visit(GiftCardVP giftCard) {
    System.out.println("Generate invoice for gift card with value - "+giftCard.getValue());
  }
  public void visit(DigitalProductVP digitalProduct) {
    System.out.println("Generate invoice for digital product with value - "+digitalProduct.getName());
  }
}

class WarehouseCost implements ItemVisitor {
  public void visit(PhysicalItemVP physicalItem) {
    System.out.println("Warehouse Cost = 50");
  }
  public void visit(GiftCardVP giftCard) {
    System.out.println("No warehouse cost");
  }
  public void visit(DigitalProductVP digitalProduct) {
    System.out.println("No warehouse cost");
  }
}

class DeliveryProcess implements ItemVisitor {
  public void visit(PhysicalItemVP physicalItem) {
    System.out.println("Delivery Cost = 100");
  }
  public void visit(GiftCardVP giftCard) {
    System.out.println("No delivery cost");
  }
  public void visit(DigitalProductVP digitalProduct) {
    System.out.println("No delivery cost");
  }
}

public class AfterVP {
  public static void main(String args[]) {
    List<Item> cart = new ArrayList<>();
    cart.add(new PhysicalItemVP(1, "Shoes"));
    cart.add(new DigitalProductVP("Book"));
    cart.add(new GiftCardVP(1000));

    InvoiceGenerator ig = new InvoiceGenerator();
    WarehouseCost wc = new WarehouseCost();
    DeliveryProcess dp = new DeliveryProcess();

    for(Item item : cart) {
      item.accept(ig);
      item.accept(wc);
      item.accept(dp);
    }
  }
}
