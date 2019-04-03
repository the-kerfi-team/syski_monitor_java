package uk.co.syski.client.Collection.Linux.Variable.Component;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import uk.co.syski.client.System.Components.Variable.RAMVariable;

public class RAMVariableCollection
{
    public static RAMVariable getRAMVariableInfo()
    {
        RAMVariable ram = new RAMVariable();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        GlobalMemory mem = hal.getMemory();
        ram.setFree((int) mem.getAvailable());
        return ram;
    }
}
