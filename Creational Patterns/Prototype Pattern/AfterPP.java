import java.util.*;

// Prototype interface
interface EmailTemplatePP extends Cloneable {
    EmailTemplatePP clone();      // clone method
    void setContent(String content);
    void send(String to);
}

// Concrete Prototype
class WelcomeEmail implements EmailTemplatePP {
    private String subject;
    private String content;

    public WelcomeEmail() {
        this.subject = "Welcome to TUF+";
        this.content = "Hi there! Thanks for joining us.";
    }

    @Override
    public WelcomeEmail clone() {
        try {
            return (WelcomeEmail) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed", e);
        }
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + ": [" + subject + "] " + content);
    }
}

// Registry to store and provide clones
class EmailTemplateRegistry {
    private static final Map<String, EmailTemplatePP> templates = new HashMap<>();

    static {
        templates.put("welcome", new WelcomeEmail());
    }

    public static EmailTemplatePP getTemplate(String type) {
        EmailTemplatePP template = templates.get(type);
        if (template != null) {
            return template.clone();
        }
        throw new IllegalArgumentException("Template type not found: " + type);
    }
}

// Client
public class AfterPP {
    public static void main(String[] args) {
        // Clone welcome email for Alice
        EmailTemplatePP email1 = EmailTemplateRegistry.getTemplate("welcome");
        email1.setContent("Hi Alice! Welcome to TUF+.");
        email1.send("alice@example.com");

        // Clone welcome email for Bob
        EmailTemplatePP email2 = EmailTemplateRegistry.getTemplate("welcome");
        email2.setContent("Hi Bob! Welcome to TUF+.");
        email2.send("bob@example.com");

        // Clone welcome email for Charlie
        EmailTemplatePP email3 = EmailTemplateRegistry.getTemplate("welcome");
        email3.setContent("Hi Charlie! Welcome to TUF+.");
        email3.send("charlie@example.com");
    }
}