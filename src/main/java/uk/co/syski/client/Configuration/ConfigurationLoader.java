package uk.co.syski.client.Configuration;

import org.ini4j.Wini;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;

public class ConfigurationLoader
{
    private static final String CONFIGURATION_FILE = "config.ini"; //Should change this to an appdata folder.

    private static Wini configINI;

    public static void loadINI() throws IOException
    {
        File configFile = new File(CONFIGURATION_FILE);
        if (configFile.exists())
            configINI = new Wini(configFile);
        else
            if (!configFile.createNewFile())
                throw new FileNotFoundException();
            else
            {
                configINI = new Wini(configFile);
                saveDefaults();
            }

    }

    private static void saveDefaults() throws IOException
    {
        configINI.put("system", "id", "");
        configINI.put("system", "secret", "");
        configINI.put("api", "url", APIConfiguration.getURL());
        configINI.put("api", "port", APIConfiguration.getPort());
        configINI.store();
    }

    public static void save() throws IOException
    {
        configINI.put("system", "id", SystemConfiguration.getSystemId());
        configINI.put("system", "secret", SystemConfiguration.getSystemSecret());
        configINI.store();
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
            try
            {
                APIConfiguration.setPort(Integer.parseInt(configINI.get("api", "port"))); //This throws exceptions that need to be caught.
            }
            catch (NumberFormatException nfe)
            {
                // Set the defalt port here when blank so it does connect to an invalid port of 0
                // Handle an actual invalid port that the user has inputted to the file.
            }
        }
        else
            throw new NullPointerException("Please load the INI file before loading configurations.");
    }

    public static void loadAccountConfiguration()
    {
        if (configINI != null)
        {
            SystemConfiguration.setSystemId(configINI.get("system", "id"));
            SystemConfiguration.setSystemSecret(configINI.get("system", "secret"));
        }
        else
            throw new NullPointerException("Please load the INI file before loading configurations.");
    }
}
