class LazySingleton1 {
  private static LazySingleton1 INSTANCE;
  
  private LazySingleton1() {}

  public static LazySingleton1 getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new LazySingleton1();
    }
    return INSTANCE;
  }
}

public class Lazy_1 {
    public static void main(String[] args) {
      LazySingleton1 ls1 = LazySingleton1.getInstance();
      LazySingleton1 ls2 = LazySingleton1.getInstance();

      System.out.println(ls1);
      System.out.println(ls2);
    }
}