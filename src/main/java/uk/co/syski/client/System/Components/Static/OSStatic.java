package uk.co.syski.client.System.Components.Static;

public class OSStatic
{
    private String name, arch, version;

    //Getters
    public String getName()
    {
        return name;
    }

    public String getArchitecture()
    {
        return arch;
    }

    public String getVersion()
    {
        return version;
    }

    //Setters
    public void setName(String n)
    {
        name = n;
    }

    public void setArchitecture(String a)
    {
        arch = a;
    }

    public void setVersion(String v)
    {
        version = v;
    }
}
