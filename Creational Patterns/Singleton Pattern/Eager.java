class SingletonEager {
  private static final SingletonEager INSTANCE = new SingletonEager();

  private SingletonEager() {

  }

  public static SingletonEager getInstance() {
    return INSTANCE;
  }
}

public class Eager {
  public static void main(String[] args) {
    SingletonEager singletonEagerObj = SingletonEager.getInstance();
    System.out.println(singletonEagerObj);

    SingletonEager singletonEager2 = SingletonEager.getInstance();
    System.out.println(singletonEager2);
  }
}