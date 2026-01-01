package test;

public class Try_Catch_Finally_FlowControlTest {
    public static void main(String[] args) {
        String test = "yes";
        try {
            System.out.println("start try");
            doRisky(test);
            System.out.println("try block succeeds(no exception)");
        } catch (ScaryException e) {
            System.out.println("try block fails (an exception). immediately moves to the catch block");
        } finally {
            System.out.println("finally runs no matter what");
        }
        System.out.println("end of main");

    }

    static void doRisky(String test) throws ScaryException {
        System.out.println("start risky");
        if ("yes".equals(test)) {
            throw new ScaryException();
        }
        System.out.println("end risky");
    }
}

class ScaryException extends Exception {

}