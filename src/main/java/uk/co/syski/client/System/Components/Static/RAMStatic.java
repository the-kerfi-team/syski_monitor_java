package uk.co.syski.client.System.Components.Static;

public class RAMStatic
{
    private String model, manufacturer, type;
    private int speed;
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

    public int getSpeed()
    {
        return speed;
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

    public void setSpeed(int s)
    {
        speed = s;
    }

    public void setSize(long b)
    {
        size = b;
    }
}
