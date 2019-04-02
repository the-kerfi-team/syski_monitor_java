package uk.co.syski.client.Collection.Linux.Static.Component;

import java.io.IOException;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import uk.co.syski.client.System.Components.Static.OSStatic;

public class OSStaticCollection
{
    public static OSStatic getOSStaticInfo() throws IOException
    {
        OSStatic os = new OSStatic();
        SystemInfo si = new SystemInfo();
        OperatingSystem oss = si.getOperatingSystem();
        os.setArchitecture(String.valueOf(oss.getBitness()));
        os.setName(oss.getFamily());
        os.setVersion(oss.getVersion().toString());
        return os;
    }
}
