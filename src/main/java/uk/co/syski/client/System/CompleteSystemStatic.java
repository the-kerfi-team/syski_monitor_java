package uk.co.syski.client.System;

import uk.co.syski.client.System.Components.Static.CPUStatic;
import uk.co.syski.client.System.Components.Static.OSStatic;
import uk.co.syski.client.System.Components.Static.SystemStatic;

public class CompleteSystemStatic
{
    private CPUStatic cpu;
    private SystemStatic system;
    private OSStatic os;

    //Getters
    public CPUStatic getCPU()
    {
        return cpu;
    }

    public SystemStatic getSystem()
    {
        return system;
    }

    public OSStatic getOS()
    {
        return os;
    }

    //Setters
    public void setCPU(CPUStatic c)
    {
        cpu = c;
    }

    public void setSystem(SystemStatic s)
    {
        system = s;
    }

    public void setOS(OSStatic o)
    {
        os = o;
    }
}
