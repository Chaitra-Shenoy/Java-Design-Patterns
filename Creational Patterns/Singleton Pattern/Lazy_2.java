class LazySingleton2 {
  private static LazySingleton2 INSTANCE;

  private LazySingleton2() {}

  public static synchronized LazySingleton2 getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new LazySingleton2();
    }
    return INSTANCE;
  }
}

public class Lazy_2 {
  public static void main(String[] args) {
    LazySingleton2 ls = LazySingleton2.getInstance();
    LazySingleton2 ls1 = LazySingleton2.getInstance();

    System.out.println(ls);
    System.out.println(ls1);
  }
}