enum SingletonEmum {
  INSTANCE;
}

public class Enum {
  public static void main(String args[]) {
    System.out.println(SingletonEmum.INSTANCE);
    System.out.println(SingletonEmum.INSTANCE);
  }
}