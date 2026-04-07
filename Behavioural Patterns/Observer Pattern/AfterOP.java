import java.util.*;

interface Subscriber {
  void update(String title);
}

class EmailSubscriber implements Subscriber {
  private String userEmail;

  public EmailSubscriber(String userEmail) {
    this.userEmail = userEmail;
  }

  public void update(String title) {
    System.out.println("Email to " + userEmail + ": " + title);
  }
}

class AppSubscriber implements Subscriber {
  private String appUser;

  public AppSubscriber(String appUser) {
    this.appUser = appUser;
  }

  public void update(String title) {
    System.out.println("App notification to " + appUser + ": " + title);
  }
}

interface Channel {
  void subscribe(Subscriber user);
  void unsubscribe(Subscriber user);
  void uploadVideo(String title);
}

class YoutubeChannel implements Channel {
  private List<Subscriber> userlist = new ArrayList<>();

  public void subscribe(Subscriber user) {
    userlist.add(user);
  }

  public void unsubscribe(Subscriber user) {
    userlist.remove(user);
  }

  public void uploadVideo(String title) {
    System.out.println("Uploaded video: " + title);

    for (Subscriber user : userlist) {
      user.update(title);
    }
  }
}

public class AfterOP {
  public static void main(String[] args) {
    YoutubeChannel channel = new YoutubeChannel();

    channel.subscribe(new EmailSubscriber("user@example.com"));
    channel.subscribe(new AppSubscriber("raj"));

    channel.uploadVideo("Observer Pattern");
  }
}