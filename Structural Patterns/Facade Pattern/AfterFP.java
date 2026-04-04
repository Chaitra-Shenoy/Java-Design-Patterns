class BookMovieTicketsServiceFP {
  public void bookTickets(String seatNumber, String movieName) {
    System.out.println("Tickets booked for - "+movieName+", seat number = "+seatNumber);
  }
}

class PaymentServiceFP {
  public void makePayment(double amount, String orderNumber) {
    System.out.println("Payment of "+amount+" made against order number "+orderNumber);
  }
}

class NotificationsServiceFP {
  public void notify(String emailId) {
    System.out.println("Email sent to "+emailId);
  }
}

class BookingFacade {
  BookMovieTicketsServiceFP bmt;
  PaymentServiceFP ps;
  NotificationsServiceFP ns;

  BookingFacade(BookMovieTicketsServiceFP bmt, PaymentServiceFP ps, NotificationsServiceFP ns) {
    this.bmt = bmt;
    this.ps = ps;
    this.ns = ns;
  }

  public void makeBooking(String seatNumber, String movie, double amount, String orderNo, String emailId) {
    bmt.bookTickets(seatNumber, movie);
    ps.makePayment(amount, orderNo);
    ns.notify(emailId);
  }
}
public class AfterFP {
    public static void main(String[] args) {
      BookingFacade bf = new BookingFacade(new BookMovieTicketsServiceFP(), new PaymentServiceFP(), new NotificationsServiceFP());
      bf.makeBooking("A1", "Movie A", 1000, "a1", "user@example.com");
    }
}