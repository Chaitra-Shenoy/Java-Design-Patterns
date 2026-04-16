class OrderContext {
  OrderState orderState;
  public OrderContext() {
    this.orderState = new OrderPlacedState();
  }

  public void setState(OrderState state) {
    this.orderState = state;
  }

  public void nextState() {
    orderState.next(this);
  }

  public void cancel() {
    orderState.cancel(this);
  }

  public void getState() {
    System.out.println(orderState.getState());
  }
}

interface OrderState {
  public void next(OrderContext context);
  public void cancel(OrderContext context);
  public String getState();
}

class OrderPlacedState implements OrderState {
  public void next(OrderContext context) {
    context.setState(new OrderPreparedState());
    System.out.println("Order moving to next state - Order Being Prepared!");
  }

  public void cancel(OrderContext context) {
    context.setState(new OrderCancelledState());
    System.out.println("Order cancelled!");
  }

  public String getState() {
    return "Order Placed!";
  }
}

class OrderPreparedState implements OrderState {
  public void next(OrderContext context) {
    context.setState(new OutForDeliveryState());
    System.out.println("Order is out for delivery!");
  }

  public void cancel(OrderContext context) {
    context.setState(new OrderCancelledState()); 
    System.out.println("Order cancelled!");
  }

  public String getState() {
    return "Order Being Prepared!";
  }
}

class OutForDeliveryState implements OrderState {
  public void next(OrderContext context) {
    context.setState(new OrderDeliveredState());
    System.out.println("Order Delivered!");
  }

  public void cancel(OrderContext context) {
    System.out.println("Cannot cancel, already out for delivery!");
  }

  public String getState() {
    return "Out for Delivery!";
  }
}

class OrderCancelledState implements OrderState {
  public void next(OrderContext context) {
    System.out.println("Order Cancelled!");
  }

  public void cancel(OrderContext context) {
    System.out.println("Order already cancelled!");
  }

  public String getState() {
    return "Order Cancelled!";
  }
}

class OrderDeliveredState implements OrderState {
  public void next(OrderContext context) {
    System.out.println("Order already delivered!");
  }

  public void cancel(OrderContext context) {
    System.out.println("Cannot cancel delivered order!");
  }

  public String getState() {
    return "Order Delivered!";
  }
}

public class AfterSTP {
  public static void main(String args[]) {
    OrderContext oc = new OrderContext();
    oc.nextState();   // Placed → Prepared
    oc.getState();
    oc.nextState();   // Prepared → Out for Delivery
    oc.cancel();      // Should NOT cancel
    oc.nextState();   // Delivered
    oc.getState();
  }
}