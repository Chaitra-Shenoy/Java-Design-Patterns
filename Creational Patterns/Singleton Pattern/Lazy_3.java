class LazySingleton3 {
  private static volatile LazySingleton3 INSTANCE;

  private LazySingleton3() {}

  public static LazySingleton3 getInstance() {
    if(INSTANCE == null) {
      synchronized (LazySingleton3.class) {
        if(INSTANCE == null) {
          INSTANCE = new LazySingleton3();
        }
      }
    }
    return INSTANCE;
  }
}
public class Lazy_3 {
    public static void main(String[] args) {
      LazySingleton3 l = LazySingleton3.getInstance();
      LazySingleton3 l1 = LazySingleton3.getInstance();

      System.out.println(l);
      System.out.println(l1);
    }
}