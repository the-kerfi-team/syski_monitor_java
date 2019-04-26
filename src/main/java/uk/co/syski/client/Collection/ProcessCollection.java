package uk.co.syski.client.Collection;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import uk.co.syski.client.System.RunningProcess;

import java.io.IOException;
import java.util.List;

public class ProcessCollection
{
    public static RunningProcess[] getProcesses() throws IOException
    {
        SystemInfo si = new SystemInfo();
        OperatingSystem hal = si.getOperatingSystem();
        OSProcess[] procs = hal.getProcesses(0, OperatingSystem.ProcessSort.CPU);
        RunningProcess[] processes = new RunningProcess[procs.length];
        for (int i = 0; i < procs.length; i++)
        {
            processes[i] = new RunningProcess();
            processes[i].setName(procs[i].getName());
            processes[i].setParent(procs[i].getParentProcessID());
            processes[i].setPath(procs[i].getPath());
            processes[i].setThreadCount(procs[i].getThreadCount());
            processes[i].setUptime(procs[i].getUpTime());
            processes[i].setSize(procs[i].getResidentSetSize());
            processes[i].setID(procs[i].getProcessID());
            processes[i].setKernaltime(procs[i].getKernelTime());
        }
        return processes;
    }
}
