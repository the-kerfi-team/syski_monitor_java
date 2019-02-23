package uk.co.syski.client.Collection.Windows.Static.Component;

import uk.co.syski.client.Collection.Windows.WMICInterface;
import uk.co.syski.client.System.Components.Static.CPUStatic;

import java.io.IOException;

public class CPUStaticCollection
{
    public static CPUStatic getCPUStaticInfo() throws IOException
    {
        CPUStatic cpu = new CPUStatic();
        String[] result = WMICInterface.getInfo("cpu", new String[] {"name", "manufacturer", "addresswidth", "maxclockspeed", "numberofcores", "numberoflogicalprocessors"});
        cpu.setID(0);
        cpu.setModel(result[0]);
        cpu.setManufacturer(result[1]);
        cpu.setArchitecture(result[2]);
        cpu.setClock(Integer.parseInt(result[3]));
        cpu.setCoreCount(Integer.parseInt(result[4]));
        cpu.setThreadCount(Integer.parseInt(result[5]));
        return cpu;
    }

    public static String getCPUName() throws IOException
    {
        return WMICInterface.getInfo("cpu", new String[] {"name"})[0];
    }

    public static String getManufacturer() throws IOException
    {
        return WMICInterface.getInfo("cpu", new String[] {"manufacturer"})[0];
    }

    public static String getArchitecture() throws IOException
    {
        return WMICInterface.getInfo("cpu", new String[] {"addresswidth"})[0];
    }

    public static String getClockSpeed() throws IOException
    {
        return WMICInterface.getInfo("cpu", new String[] {"maxclockspeed"})[0];
    }

    public static int getCoreCount() throws IOException
    {
        return Integer.parseInt(WMICInterface.getInfo("cpu", new String[] {"numberofcores"})[0]);
    }

    public static int getThreadCount() throws IOException
    {
        return Integer.parseInt(WMICInterface.getInfo("cpu", new String[] {"numberoflogicalprocessors"})[0]);
    }
}
