class Order {
  private String CURRENT_STATUS;
  public Order() {
    this.CURRENT_STATUS = "ORDER_PLACED";
  }

  public String getStatus() {
    return CURRENT_STATUS;
  }

  public String next() {
    switch(CURRENT_STATUS){
      case "ORDER_PLACED" : CURRENT_STATUS = "PREPARING_ORDER"; break;
      case "PREPARING_ORDER" : CURRENT_STATUS = "OUT_FOR_DELIVERY"; break;
      case "OUT_FOR_DELIVERY" : CURRENT_STATUS = "DELIVERED"; break;
      case "CANCELLED" : CURRENT_STATUS = "CANCELLED"; break;
      default: CURRENT_STATUS = "ORDER_PLACED";
    }
    return CURRENT_STATUS;
  }

  public String cancel() {
    switch(CURRENT_STATUS){
      case "ORDER_PLACED" : CURRENT_STATUS = "CANCELLED"; break;
      case "PREPARING_ORDER" : CURRENT_STATUS = "CANCELLED"; break;
      case "OUT_FOR_DELIVERY" : System.out.println("Order cannot be cancelled!"); break;
      case "CANCELLED" : CURRENT_STATUS = "CANCELLED"; break;
      default: CURRENT_STATUS = "ORDER_PLACED";
    }
    return CURRENT_STATUS;
  }

  public String getState() {
    System.out.println("Current Status - "+CURRENT_STATUS);
    return CURRENT_STATUS;
  }
}
public class BeforeSTP {
  public static void main(String args[]) {
    Order o = new Order();
    o.getState();
    o.next();
    o.next();
    o.cancel();
    o.getState();
  }
}