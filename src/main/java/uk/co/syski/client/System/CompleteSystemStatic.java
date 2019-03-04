package uk.co.syski.client.System;

import uk.co.syski.client.System.Components.Static.*;

public class CompleteSystemStatic
{
    private CPUStatic cpu;
    private SystemStatic system;
    private OSStatic os;
    private GPUStatic gpu;
    private MotherboardStatic mb;
    private RAMStatic[] ram;
    private StorageStatic[] storage;

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

    public GPUStatic getGPU()
    {
        return gpu;
    }

    public MotherboardStatic getMotherboard()
    {
        return mb;
    }

    public RAMStatic[] getRAM()
    {
        return ram;
    }

    public StorageStatic[] getStorage()
    {
        return storage;
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

    public void setGPU(GPUStatic g)
    {
        gpu = g;
    }

    public void setMotherboard(MotherboardStatic m)
    {
        mb = m;
    }

    public void setRAM(RAMStatic[] r)
    {
        ram = r;
    }

    public void setStorage(StorageStatic[] s)
    {
        storage = s;
    }
}
