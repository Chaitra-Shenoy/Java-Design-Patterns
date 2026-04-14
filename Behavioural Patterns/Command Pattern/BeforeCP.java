class Light {
  private String light;
  public void on() {
    this.light = "on";
    System.out.println("Light is on");
  }
  public void off() {
    this.light = "off";
    System.out.println("Light is off");
  }
}

class AC {
  private String ac;
  public void on() {
    this.ac = "on";
    System.out.println("AC is on");
  }
  public void off() {
    this.ac = "off";
    System.out.println("AC is off");
  }
}

class Remote {
  Light light;
  AC ac;
  String LAST_ACTION = "";

  public Remote(Light light, AC ac) {
    this.light = light;
    this.ac = ac;
  }

  public void switchLightOn() {
    light.on();
    LAST_ACTION = "LIGHTS_ON";
  }

  public void switchLightOff() {
    light.off();
    LAST_ACTION = "LIGHTS_OFF";
  }

  public void switchACOn() {
    ac.on();
    LAST_ACTION = "AC_ON";
  }

  public void switchACOff() {
    ac.off();
    LAST_ACTION = "AC_OFF";
  }

  public void undo() {
    switch(LAST_ACTION) {
      case "LIGHTS_ON" : light.off(); LAST_ACTION = "LIGHTS_OFF"; break;
      case "LIGHTS_OFF" : light.on(); LAST_ACTION = "LIGHTS_ON"; break;
      case "AC_ON" : ac.off(); LAST_ACTION = "AC_OFF"; break;
      case "AC_OFF" : ac.on(); LAST_ACTION = "AC_ON"; break;
      default : System.out.println("Nothing to undo!");
    }
  }
}
public class BeforeCP {
  public static void main(String args[]) {
    Light light = new Light();
    AC ac = new AC();
    Remote remote = new Remote(light, ac);
    remote.switchLightOn();
    remote.switchACOn();
    remote.undo();
    remote.switchACOn();
    remote.undo();
    remote.undo();
  }
}