// Client Driven

class BookMovieTicketsService {
  public void bookTickets(String seatNumber, String movieName) {
    System.out.println("Tickets booked for - "+movieName+", seat number = "+seatNumber);
  }
}

class PaymentService {
  public void makePayment(double amount, String orderNumber) {
    System.out.println("Payment of "+amount+" made against order number "+orderNumber);
  }
}

class NotificationsService {
  public void notify(String emailId) {
    System.out.println("Email sent to "+emailId);
  }
}

public class BeforeFP {
    public static void main(String[] args) {
      BookMovieTicketsService bmt = new BookMovieTicketsService();
      bmt.bookTickets("B1", "ABC");

      PaymentService ps = new PaymentService();
      ps.makePayment(1000, "123");
      
      NotificationsService ns = new NotificationsService();
      ns.notify("user@gmail.com");
    }
}