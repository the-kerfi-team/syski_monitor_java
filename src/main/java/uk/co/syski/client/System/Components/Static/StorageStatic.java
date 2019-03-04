package uk.co.syski.client.System.Components.Static;

public class StorageStatic
{
    private String model, manufacturer, type;
    private long size;

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

    public long getSize()
    {
        return size;
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

    public void setSize(long s)
    {
        size = s;
    }
}
