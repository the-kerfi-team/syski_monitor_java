package uk.co.syski.client.System.Components.Static;

public class CPUStatic
{
    private int id, clock, coreCount, threadCount;
    private String model, manufacturer, arch;

    //Getters
    public int getID()
    {
        return id;
    }

    public String getModel()
    {
        return model;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getArchitecture()
    {
        return arch;
    }

    public int getClock()
    {
        return clock;
    }

    public int getCoreCount()
    {
        return coreCount;
    }

    public int getThreadCount()
    {
        return threadCount;
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

    public void setManufacturer(String m)
    {
        manufacturer = m;
    }

    public void setArchitecture(String a)
    {
        arch = a;
    }

    public void setClock(int c)
    {
        clock = c;
    }


    public void setCoreCount(int cc)
    {
        coreCount = cc;
    }

    public void setThreadCount(int tc)
    {
        threadCount = tc;
    }
}
