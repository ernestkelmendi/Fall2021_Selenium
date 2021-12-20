package Helper;

public class Misc {
    /*
        either by object or by className
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
