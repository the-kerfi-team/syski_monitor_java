package uk.co.syski.client.Collection.Linux.Variable.Component;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import uk.co.syski.client.System.Components.Variable.CPUVariable;

public class CPUVariableCollection
{
    public static CPUVariable getCurrentCPUVariableInfo()
    {
        CPUVariable cpu = new CPUVariable();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor proc = hal.getProcessor();
        ComputerSystem com = hal.getComputerSystem();
        cpu.setLoad((float) proc.getSystemCpuLoad() * 100);
        cpu.setProcesses(si.getOperatingSystem().getProcessCount());
        return cpu;
    }
}
