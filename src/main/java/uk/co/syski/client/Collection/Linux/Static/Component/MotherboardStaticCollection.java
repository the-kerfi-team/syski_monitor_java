package uk.co.syski.client.Collection.Linux.Static.Component;

import java.io.IOException;
import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import uk.co.syski.client.System.Components.Static.MotherboardStatic;
import uk.co.syski.client.System.Components.Static.SystemStatic;

public class MotherboardStaticCollection
{
    public static MotherboardStatic getMotherboardStaticInfo() throws IOException
    {
        MotherboardStatic mb = new MotherboardStatic();
        SystemStatic system = new SystemStatic();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        ComputerSystem com = hal.getComputerSystem();
        mb.setModel(com.getBaseboard().getModel());
        mb.setManufacturer(com.getBaseboard().getManufacturer());
        mb.setVersion(com.getBaseboard().getVersion());
        return mb;
    }
}
