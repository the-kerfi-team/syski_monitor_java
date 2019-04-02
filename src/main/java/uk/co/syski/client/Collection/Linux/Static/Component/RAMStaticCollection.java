package uk.co.syski.client.Collection.Linux.Static.Component;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import uk.co.syski.client.System.Components.Static.RAMStatic;

public class RAMStaticCollection
{
    public static RAMStatic[] getRAMStaticInfo() throws Exception
    {
        RAMStatic[] ram = new RAMStatic[1];
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        GlobalMemory mem = hal.getMemory();
        ram[0].setSize(mem.getTotal());
        return ram;
    }
}
