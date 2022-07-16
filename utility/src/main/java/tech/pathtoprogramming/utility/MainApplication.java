package tech.pathtoprogramming.utility;

import tech.pathtoprogramming.common.EventPub;
import tech.pathtoprogramming.common.InfraPreferences;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainApplication {

    private EventPub eventPub;


    public MainApplication() {
        String javaKeyStoreUsername = InfraPreferences.getJavaKeystoreUsername();
        String javaKeyStorePassword = InfraPreferences.getJavaKeystorePassword();
        String eventPublisherUrl = InfraPreferences.getEventPublisherUrl();
        String jwtToken;

        String javaKeystore = javaKeyStoreUsername + ":" + javaKeyStorePassword;

        jwtToken = JwtV3Util.getJwt();
        // load pref attributes
        eventPub = new EventPub(javaKeystore, jwtToken, eventPublisherUrl);
    }

    public static void main(String[] args) throws IOException {
        // file={pathToFile} preferencesFile={path to prefs.xml} publishFlag={YES | NO}
        String eventFile;
        String preferencesFile;
        String publishFlag;
        long startingEventLineNumber;
        long endingEventLineNumber;


        eventFile = args[0].split("=")[1];
        preferencesFile = args[1].split("=")[1];
        publishFlag = args[2].split("=")[1];

        // load prefs
        InfraPreferences.loadPreferences(preferencesFile);

        MainApplication mainApplication = new MainApplication();
        BufferedReader reader = new BufferedReader(new FileReader(eventFile));

        try {
            // set up file reader

            // read each line and publish to event publisher
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (publishFlag.equals("YES")) {
                    // TODO: add starting and ending event line numbers
                    mainApplication.eventPub.publishEventUtil(line);
                    System.out.println("Event sent from Utility. Line: " + line);
                }
            }
        } catch (Exception e) {
            String m = e.getMessage();
            System.out.println("Failed to read file " + m);
        } finally {
            reader.close();
        }
    }
}
