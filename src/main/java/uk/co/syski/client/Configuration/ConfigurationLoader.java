package uk.co.syski.client.Configuration;

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class ConfigurationLoader
{
    public static final String CONFIGURATION_FILE = "config.ini"; //Should change this to an appdata folder.

    private static Wini configINI;

    public static void loadINI() throws IOException
    {
        configINI = new Wini(new File(CONFIGURATION_FILE));
    }

    public static void loadAllConfigurations()
    {
        loadAccountConfiguration();
        loadAPIConfiguration();
    }

    public static void loadAPIConfiguration()
    {
        if (configINI != null)
        {
            APIConfiguration.setURL(configINI.get("api", "url"));
            APIConfiguration.setPort(Integer.parseInt(configINI.get("api", "port"))); //This throws exceptions that need to be caught.
        }
        else
            throw new NullPointerException("Please load the INI file before loading configurations.");
    }

    public static void loadAccountConfiguration()
    {
        if (configINI != null)
        {
            AccountConfiguration.setAccessToken(configINI.get("account", "accesstoken"));
            AccountConfiguration.setRefreshToken(configINI.get("account", "refreshtoken"));
        }
        else
            throw new NullPointerException("Please load the INI file before loading configurations.");
    }
}
