package uk.co.syski.client.System;

public class System
{
    private int id;
    private String model;
    private String type;
    private String hostName;

    //Getters
    public int getID()
    {
        return id;
    }

    public String getModel()
    {
        return model;
    }

    public String getType()
    {
        return type;
    }

    public String getHostName()
    {
        return hostName;
    }

    //Setters
    public void setID(int ID)
    {
        id = ID;
    }

    public void setModel(String m)
    {
        model = m;
    }

    public void setType(String t)
    {
        type = t;
    }

    public void setHostName(String hn)
    {
        hostName = hn;
    }
}
