package uk.co.syski.client.System.Components.Static;

public class StorageStatic
{
    private String model, manufacturer, type;
    private long bytes;

    //Getters
    public String getModel()
    {
        return model;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getType()
    {
        return type;
    }

    public long getBytes()
    {
        return bytes;
    }

    //Setters
    public void setModel(String m)
    {
        model = m;
    }

    public void setManufacturer(String m)
    {
        manufacturer = m;
    }

    public void setType(String t)
    {
        type = t;
    }

    public void setBytes(long b)
    {
        bytes = b;
    }
}
