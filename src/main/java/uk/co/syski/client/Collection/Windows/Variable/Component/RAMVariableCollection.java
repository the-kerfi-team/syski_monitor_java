package uk.co.syski.client.Collection.Windows.Variable.Component;

import uk.co.syski.client.Collection.CMDInterface;
import uk.co.syski.client.System.Components.Variable.RAMVariable;

import java.io.IOException;

public class RAMVariableCollection
{
    private static final RAMVariable ram = new RAMVariable();
    private static Thread freeThread;
    private static int sleepTime;
    private static boolean threadActive = false;

    public static RAMVariable getRAMVariableInfo()
    {
        return ram;
    }

    public static void startThreads()
    {
        if (threadActive || freeThread != null)
            throw new IllegalThreadStateException("Thread cannot be started while other thread of the same type is running.");
        initThreads();
        threadActive = true;
        freeThread.start();
    }

    public static void stopThreads()
    {
        threadActive = false;
    }

    private static void initThreads()
    {
        freeThread = new Thread()
        {
            @Override
            public void run()
            {
                while (threadActive)
                {
                    try
                    {
                        ram.setFree(getFree());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private static int getFree() throws IOException
    {
        return (int) Float.parseFloat(CMDInterface.executeWithResponse("typeperf \"\\Memory\\Available MBytes\" -sc 1")[2].replace("\"", "").split(",")[1]);
    }
}
