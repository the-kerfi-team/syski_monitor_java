package uk.co.syski.client.Collection.Windows.Variable.Component;

import uk.co.syski.client.Collection.Windows.CMDInterface;
import uk.co.syski.client.System.Components.Variable.CPUVariable;

import java.io.IOException;

public class CPUVariableCollection
{
    public static CPUVariable getCPUVariableInfo() throws IOException
    {
        CPUVariable cpu = new CPUVariable();
        cpu.setLoad(getLoadFromCommand());
        cpu.setProcesses(CMDInterface.executeWithResponse("tasklist").length - 3);
        return cpu;
    }

    private static float getLoadFromCommand() throws IOException
    {
        String[] result = CMDInterface.executeWithResponse("typeperf \"Processor(_Total)\\% Processor Time\" -sc 1");
        return Float.parseFloat(result[2].split("\",\"")[1].replace("\"", ""));
    }
}
