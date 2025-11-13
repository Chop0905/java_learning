package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static void warn(String message) {
        System.err.println(now() + "[WARNING] " + message);
    }

    public static void info(String message) {
        System.out.println(now() + "[INFO] " + message);
    }

    public static void debug(String message) {
        System.out.println(now() + "[DEBUG] " + message);
    }

    public static void error(String message) {
        System.err.println(now() + "[ERROR] " + message);
    }

    public static void fatal(String message) {
        System.out.println(now() + "[FATAL] " + message);
    }

}
