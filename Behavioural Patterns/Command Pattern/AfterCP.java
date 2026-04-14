import java.util.Stack;

class LightCP {
  public void on() {
    System.out.println("Light switched ON!");
  }
  public void off() {
    System.out.println("Light switched OFF!");
  }
}

class ACCP {
  public void on() {
    System.out.println("AC switched ON!");
  }
  public void off() {
    System.out.println("AC switched OFF!");
  }
}

interface Command {
  public void execute();
  public void undo();
}

class LightON implements Command {
  LightCP l;
  public LightON(LightCP l) {
    this.l = l;
  }
  
  @Override
  public void execute() {
    l.on();
  }

  @Override
  public void undo() {
    l.off();
  }
}

class LightOFF implements Command {
  LightCP l;
  public LightOFF(LightCP l) {
    this.l = l;
  }
  
  @Override
  public void execute() {
    l.off();
  }

  @Override
  public void undo() {
    l.on();
  }
}

class ACON implements Command {
  ACCP ac;
  public ACON(ACCP ac) {
    this.ac = ac;
  }

  @Override
  public void execute() {
    ac.on();
  }

  @Override
  public void undo() {
    ac.off();
  }
}

class ACOFF implements Command {
  ACCP ac;
  public ACOFF(ACCP ac) {
    this.ac = ac;
  }

  @Override
  public void execute() {
    ac.off();
  }

  @Override
  public void undo() {
    ac.on();
  }
}

class RemoteCP {
  Command[] commands = new Command[4];
  Stack<Command> st = new Stack<>();

  public void setCommand(int index, Command c) {
    commands[index] = c;
  }

  public void execute(int index) {
    if (commands[index] != null) {
      commands[index].execute();
      st.push(commands[index]);
    }
  }

  public void undo() {
    if (!st.isEmpty()) {
      st.pop().undo();
    } else {
      System.out.println("Nothing to undo");
    }
  }
}

public class AfterCP {
    public static void main(String args[]) {
      LightCP light = new LightCP();
      ACCP ac = new ACCP();

      RemoteCP r = new RemoteCP();
      r.setCommand(0, new LightON(light));
      r.setCommand(1, new LightOFF(light));
      r.setCommand(2, new ACON(ac));
      r.setCommand(3, new ACOFF(ac));

      r.execute(0);
      r.execute(2);
      r.undo();
      r.undo();
      r.execute(0);
      r.execute(2);
    }
}