package Util;

public class Logging {
    private final static boolean doLog = true;

    public static void log(String text){
        if(doLog) {
            System.out.println(text);
        }
    }
}
