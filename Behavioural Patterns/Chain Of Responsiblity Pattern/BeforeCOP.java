class Support {
  public void handleTicket(String type) {
    if (type.equals("general"))
      System.out.println("Handled by the customer support team");
    else if (type.equals("refund"))
      System.out.println("Handled by the Refund team");
    else if (type.equals("delivery"))
      System.out.println("Handled by the Delivery team!");
    else if (type.equals("technical"))
      System.out.println("Handled by Tech team");
    else
      System.out.println("No handler available");
  }
}

public class BeforeCOP {
    public static void main(String args[]) {
        Support support = new Support();

        support.handleTicket("general");
        support.handleTicket("refund");
        support.handleTicket("delivery");
        support.handleTicket("technical");
        support.handleTicket("unknown");
    }
}