package uk.co.syski.client.Collection.Linux.Static.Component;

import uk.co.syski.client.Collection.Linux.ProcInterface;
import uk.co.syski.client.System.Components.Static.CPUStatic;

import java.io.IOException;

public class CPUStaticCollection
{
    public static CPUStatic getCPUStaticInfo() throws IOException
    {
        CPUStatic cpu = new CPUStatic();
        String[] result = ProcInterface.getInfo("cpuinfo", new String[] {"vendor_id", "model name", "cpu mhz", "cpu cores", "siblings", "cache_alignment"});
        cpu.setID(0);
        cpu.setManufacturer(result[0]);
        cpu.setModel(result[1]);
        cpu.setClock((int) Double.parseDouble(result[2]));
        cpu.setCoreCount(Integer.parseInt(result[3]));
        cpu.setThreadCount(Integer.parseInt(result[4]));
        cpu.setArchitecture(result[5]);
        return cpu;
    }
}
