package utils;

public class EnvUtils {

    public static String getBaseUrl(){
        String env= configReader.get("env");
        return configReader.get(env + ".url");
    }
}
