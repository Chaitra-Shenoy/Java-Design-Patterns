import java.util.HashMap;
import java.util.function.Supplier;
interface TransportFP {
  void send();
}

class TrainFP implements TransportFP {
  @Override
  public void send() {
    System.out.println("Send parcel by train!");
  }
}

class PlaneFP implements TransportFP {
  @Override
  public void send() {
    System.out.println("Send parcel by plane!");
  }
}


class RoadFP implements TransportFP {
  @Override
  public void send() {
    System.out.println("Send parcel by road!");
  }
}

class LogisticsFactory {
  private static final HashMap<String, Supplier<TransportFP>> hmap = new HashMap<>();
  static {
    hmap.put("road", RoadFP::new);
    hmap.put("plane", PlaneFP::new);
    hmap.put("train", TrainFP::new);
  }

  public static TransportFP logistics(String mode) {
    Supplier<TransportFP> supplier = hmap.get(mode.toLowerCase());
    if(supplier == null)
      throw new IllegalArgumentException("Invalid Mode Of Transport!");

    return supplier.get();
  }
}

class LogisticsServiceFP {
  private String mode;
  LogisticsServiceFP(String mode) {
    this.mode = mode;
  }

  public void sendParcel() {
    TransportFP tfp = LogisticsFactory.logistics(mode);
    tfp.send();
  }
}

public class AfterFP {
  public static void main(String args[]) {
    LogisticsServiceFP ls = new LogisticsServiceFP("road");
    ls.sendParcel();
  }
}