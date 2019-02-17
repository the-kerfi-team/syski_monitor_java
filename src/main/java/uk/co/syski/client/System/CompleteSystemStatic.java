package uk.co.syski.client.System;

import uk.co.syski.client.System.Components.Static.CPUStatic;
import uk.co.syski.client.System.Components.Static.SystemStatic;

public class CompleteSystemStatic
{
    private CPUStatic cpu;
    private SystemStatic system;

    //Getters
    public CPUStatic getCPU()
    {
        return cpu;
    }

    public SystemStatic getSystem()
    {
        return system;
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
}
