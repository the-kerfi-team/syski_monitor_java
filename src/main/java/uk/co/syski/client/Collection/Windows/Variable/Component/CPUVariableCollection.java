package uk.co.syski.client.Collection.Windows.Variable.Component;

import uk.co.syski.client.Collection.Windows.CMDInterface;
import uk.co.syski.client.System.Components.Variable.CPUVariable;

import java.io.IOException;

public class CPUVariableCollection implements Runnable
{
    private static final CPUVariable cpu = new CPUVariable();
    private static Thread thread;
    private static int sleepTime;
    private static boolean threadActive = false;

    public static CPUVariable getCurrentCPUVariableInfo()
    {
        return cpu;
    }

    private static float getLoad() throws IOException
    {
        String[] result = CMDInterface.executeWithResponse("typeperf \"Processor(_Total)\\% Processor Time\" -sc 1");
        return Float.parseFloat(result[2].split("\",\"")[1].replace("\"", ""));
    }

    public static void startThreads(int sleep)
    {
        if (threadActive || thread != null)
            throw new IllegalThreadStateException("Thread cannot be started while other thread of the same type is running.");
        sleepTime = sleep;
        threadActive = true;
        Runnable runnable = new CPUVariableCollection();
        thread = new Thread(runnable);
        thread.start();
    }

    public static void stopThreads()
    {
        threadActive = false;
    }

    @Override
    public void run()
    {
        while (threadActive)
        {
            try
            {
                cpu.setProcesses(CMDInterface.executeWithResponse("tasklist").length - 3);
                cpu.setLoad(getLoad());
                //Thread.sleep(sleepTime);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        thread = null;
    }
}
