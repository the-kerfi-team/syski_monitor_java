package uk.co.syski.client.Configuration;

public class SystemConfiguration
{
    private static String systemid, systemsecret;

    //Getters
    public static String getSystemId()
    {
        return systemid;
    }

    public static String getSystemSecret()
    {
        return systemsecret;
    }

    //Setters
    public static void setSystemId(String id)
    {
        systemid = id;
    }

    public static void setSystemSecret(String secret)
    {
        systemsecret = secret;
    }
}
