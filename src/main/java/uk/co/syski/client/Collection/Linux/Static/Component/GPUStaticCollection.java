package uk.co.syski.client.Collection.Linux.Static.Component;

import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.Display;
import oshi.hardware.HardwareAbstractionLayer;
import uk.co.syski.client.System.Components.Static.GPUStatic;
import uk.co.syski.client.System.Components.Static.SystemStatic;

import java.io.IOException;

public class GPUStaticCollection
{
    public static GPUStatic getGPUStaticInfo() throws UnsupportedOperationException
    {
        return new GPUStatic();
        //throw new UnsupportedOperationException();
    }
}
