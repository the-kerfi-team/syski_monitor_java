package uk.co.syski.client.Collection.Linux.Static.Component;

import java.io.IOException;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import uk.co.syski.client.Collection.CMDInterface;
import uk.co.syski.client.System.Components.Static.SystemStatic;


public class SystemStaticCollection
{
    public static SystemStatic getSystemStaticInfo() throws IOException
    {
        SystemStatic system = new SystemStatic();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        ComputerSystem com = hal.getComputerSystem();
        system.setManufacturer(com.getManufacturer());
        system.setModel(com.getModel());
        system.setHostName((CMDInterface.executeWithResponse("hostname")[0]));
        system.setType("linux");
        return system;
    }
}
