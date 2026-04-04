interface Email {
    void send(String to);
}
class EmailTemplate implements Email{
    private String content;
    private String subject;

    EmailTemplate(String content, String subject) {
        this.content = content;
        this.subject = subject;
    }

    public void send(String to) {
        System.out.println("Sending email to "+to+ " with content "+content+" and subject "+subject);
    }
}
public class BeforePP {
    public static void main(String args[]) {
      EmailTemplate e1 = new EmailTemplate("Test", "Test Email 1");
      e1.send("test@gmail.com");

      EmailTemplate e2 = new EmailTemplate("Test", "Test Email 1");
      e2.send("test@gmail.com");
    }
}