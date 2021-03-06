/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package nl.derf.hello_gnu_longopt;

import gnu.getopt.Getopt;
import gnu.getopt.LongOpt;

public class App {

  public static void main(String[] argv) {
    for (String arg : argv) {
      System.out.println("Raw option: " + arg);
    }

    LongOpt[] longOpts = {new LongOpt("destination", LongOpt.REQUIRED_ARGUMENT, null, 'd'),
        new LongOpt("delay-milliseconds", LongOpt.REQUIRED_ARGUMENT,null, 'w'),
        new LongOpt("dry-run", LongOpt.NO_ARGUMENT, null, 'n')};
    Getopt opt = new Getopt("RedisMigration", argv, "d:w:n", longOpts);

    int c = -1;
    while ((c = opt.getopt()) != -1) {
      switch (c) {
        case 'n':
          System.out.println("Dry run");
          break;
        case 'd':
          String destination = opt.getOptarg();
          System.out.println("Destination: " + destination);
          break;
        case 'w':
          try {
            int delay = Integer.parseInt(opt.getOptarg());
            System.out.println("delay arg is: " + delay);
          } catch (NumberFormatException e) {
            System.out.println("Please specify valid number");
            System.exit(1);
          }
      }
    }
  }
}
