package util;

import io.cucumber.java.Scenario;

public class LoggerUtil {
    public static void log(Scenario scenario, String message) {
        scenario.log(message);
        System.out.println("[LOG] " + message);
    }
}

