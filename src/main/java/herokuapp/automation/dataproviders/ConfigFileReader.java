package herokuapp.automation.dataproviders;

import herokuapp.automation.exception.HerokuappException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigFileReader {

    private static final Logger LOGGER = Logger.getLogger(ConfigFileReader.class.getName());
    private static final Properties properties = new Properties();

    static {
        String propertiesFilePath = Paths.get(System.getProperty("user.dir"),
                "src", "test", "resources", "common.properties").toString();

        try (BufferedReader reader = new BufferedReader(new FileReader(propertiesFilePath))) {
            properties.load(reader);
            LOGGER.info("Loaded config from: " + propertiesFilePath);
        } catch (IOException e) {
            throw new HerokuappException("Error loading properties file: " + propertiesFilePath, e);
        }
    }

    private ConfigFileReader() {
    }

    public static String getBaseUrl() {
        String url = properties.getProperty("baseUrl");
        if (url != null) return url;
        else throw new HerokuappException("baseUrl not specified in common.properties.");
    }

    public static Duration getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) {
            return Duration.ofSeconds(Long.parseLong(implicitlyWait));
        } else {
            throw new HerokuappException("implicitlyWait not specified in the properties file.");
        }
    }

    public static Long getWaitSeconds() {
        String waitSeconds = properties.getProperty("waitSeconds");
        if (waitSeconds != null) {
            return Long.parseLong(waitSeconds) * 1000; // Convert to milliseconds
        } else {
            throw new HerokuappException("waitSeconds not specified in the properties file.");
        }
    }
}
