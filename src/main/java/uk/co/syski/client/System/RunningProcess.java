package uk.co.syski.client.System;

public class RunningProcess
{
    private int threadCount, parent, id;
    private long uptime, size, kernaltime;
    private String name, path;

    //Getters
    public int getThreadCount()
    {
        return threadCount;
    }

    public int getParent()
    {
        return parent;
    }

    public int getID()
    {
        return id;
    }

    public long getUptime()
    {
        return uptime;
    }

    public long getSize()
    {
        return size;
    }

    public long getKernalTime()
    {
        return kernaltime;
    }

    public String getName()
    {
        return name;
    }

    public String getPath()
    {
        return path;
    }

    //Setters
    public void setThreadCount(int tc)
    {
        threadCount = tc;
    }

    public void setID(int i)
    {
        id = i;
    }

    public void setParent(int p)
    {
        parent = p;
    }

    public void setUptime(long ut)
    {
        uptime = ut;
    }

    public void setSize(long s)
    {
        size = s;
    }

    public void setKernaltime(long kt)
    {
        kernaltime = kt;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setPath(String p)
    {
        path = p;
    }
}
