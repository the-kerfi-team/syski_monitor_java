package uk.co.syski.client.Configuration;


public class APIConfiguration
{
    private static String url;
    private static int port;

    //Getters
    public static String getURL()
    {
        return url;
    }

    public static int getPort()
    {
        return port;
    }

    //Setters
    public static void setURL(String u)
    {
        url = u;
    }

    public static void setPort(int p)
    {
        if (p <= 65535)
            port = p;
        else
            throw new IllegalArgumentException();
    }
}
