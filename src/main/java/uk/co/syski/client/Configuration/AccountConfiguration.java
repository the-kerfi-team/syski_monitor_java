package uk.co.syski.client.Configuration;

public class AccountConfiguration
{
    private static String accesstoken, refreshtoken;

    //Getters
    public static String getAccessToken()
    {
        return accesstoken;
    }

    public static String getRefreshToken()
    {
        return refreshtoken;
    }

    //Setters
    public static void setAccessToken(String at)
    {
        accesstoken = at;
    }

    public static void setRefreshToken(String rt)
    {
        refreshtoken = rt;
    }
}
