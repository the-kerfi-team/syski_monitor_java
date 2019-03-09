package uk.co.syski.client.System.Components.Variable;

public class CPUVariable
{
    private float load;
    private int processes;

    //Getters
    public float getLoad()
    {
        return load;
    }

    public int getProcesses()
    {
        return processes;
    }

    //Setters
    public void setLoad(float l)
    {
        load = l;
    }

    public void setProcesses(int p)
    {
        processes = p;
    }
}
