package uk.co.syski.client.Collection.Windows.Static.Component;

import uk.co.syski.client.Collection.Windows.WMICInterface;
import uk.co.syski.client.System.Components.Static.GPUStatic;

import java.io.IOException;

public class GPUStaticCollection
{
    public static GPUStatic getGPUStaticInfo() throws IOException
    {
        GPUStatic gpu = new GPUStatic();
        String[] result = WMICInterface.getInfo("PATH Win32_VideoController", new String[] {"name", "adaptercompatibility"});
        gpu.setModel(result[0]);
        gpu.setManufacturer(result[1]);
        return gpu;
    }
}
