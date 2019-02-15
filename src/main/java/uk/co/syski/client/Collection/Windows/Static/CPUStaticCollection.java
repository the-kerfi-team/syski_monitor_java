package uk.co.syski.client.Collection.Windows.Static;

import uk.co.syski.client.Collection.Windows.WMICInterface;
import uk.co.syski.client.System.Components.Static.CPUStatic;

import java.io.IOException;

public class CPUStaticCollection
{
    public static CPUStatic getCPUStaticInfo()
    {
        CPUStatic cpu = new CPUStatic();
        return cpu;
    }

    public static String getCPUName() throws IOException
    {
        return WMICInterface.getInfo("cpu", new String[] {"name"})[0];
    }
}
