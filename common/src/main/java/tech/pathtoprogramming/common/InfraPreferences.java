package tech.pathtoprogramming.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class InfraPreferences {

    private static final Logger log = LoggerFactory.getLogger(InfraPreferences.class);
    private static Preferences preferences;

    public static void loadPreferences(String preferencesFile) {
        log.info("loading preferences from xml file from {}", preferencesFile);
        preferences.init();
    }

    public static String getEventPublisherUrl() {
        log.info("get eventPublisherUrl url from file");
        return "https://pathtoprogramming.tech/events/publish";
    }

    public static String getJavaKeystoreUsername() {
        return Preferences.getJavaKeystoreUsername();
    }

    public static String getJavaKeystorePassword() {
        return Preferences.getJavaKeystorePassword();
    }
}

class Preferences {
    static Map<String, String> prefs;

    static {
        // TODO replace with map with actual file reader
        prefs = new HashMap<>() {{
                put("keystoreUsername", "admin");
                put("keystorePassword", "root123");
        }};
    }

    public static void init() {
        System.out.println("initializing default preferences.");
    }

    public static String getJavaKeystoreUsername() {
        String keystoreUsername = prefs.get("keystoreUsername");
        System.out.println("Getting username from preferences storage " + keystoreUsername);
        return keystoreUsername;
    }
    public static String getJavaKeystorePassword() {
        String keystorePassword = prefs.get("keystorePassword");
        System.out.println("Getting username from preferences storage " + keystorePassword);
        return keystorePassword;
    }
}

