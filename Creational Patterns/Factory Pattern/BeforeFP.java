interface Logistics {
  void send();
}

class Road implements Logistics {
  @Override
  public void send() {
    System.out.println("Send parcel by road");
  }
}

class Train implements Logistics {
  @Override
  public void send() {
    System.out.println("Send parcel by train");
  }
}

class Plane implements Logistics {
  @Override
  public void send() {
    System.out.println("Send parcel by aeroplane");
  }
}

class LogisticsService {
  private String modeOfTransport;
  LogisticsService(String modeOfTransport) {
    this.modeOfTransport = modeOfTransport;
  }

  public void sendParcel() {
    Logistics obj;
    if(modeOfTransport.equalsIgnoreCase("road"))
      obj = new Road();
    else if(modeOfTransport.equalsIgnoreCase("train"))
      obj = new Train();
    else if(modeOfTransport.equalsIgnoreCase("plane"))
      obj = new Plane();
    else
      throw new IllegalArgumentException("Invalid mode of transport");

      obj.send();
  }
}
public class BeforeFP {
  public static void main(String args[]) {
    LogisticsService ls = new LogisticsService("car");
    ls.sendParcel();
  }
}