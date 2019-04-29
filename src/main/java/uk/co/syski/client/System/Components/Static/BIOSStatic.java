package uk.co.syski.client.System.Components.Static;

import java.util.Date;

public class BIOSStatic
{
    private String manufacturer, caption, version, date;

    //Getters
    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getCaption()
    {
        return caption;
    }

    public String getVersion()
    {
        return version;
    }

    public String getDate()
    {
        return date;
    }

    //Setters
    public void setManufacturer(String m)
    {
        manufacturer = m;
    }

    public void setCaption(String c)
    {
        caption = c;
    }

    public void setVersion(String v)
    {
        version = v;
    }

    public void setDate(String d)
    {
        date = d;
    }
}
