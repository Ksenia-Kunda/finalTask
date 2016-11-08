package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Ksenia on 31.10.2016.
 */
public class DbConfig {

    private static Properties props;

    static {
        props = new Properties();
        try {
            FileInputStream stream = new FileInputStream("src/main/resources/db.properties");
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return props.getProperty(key);
    }
}
