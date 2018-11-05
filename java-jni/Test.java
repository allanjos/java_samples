public class Test {
    public native void displayMessage();

    static {
      System.loadLibrary("test");
    }

    public static void main(String args[]) {
        Test test = new Test();

        test.displayMessage();
    }
}
