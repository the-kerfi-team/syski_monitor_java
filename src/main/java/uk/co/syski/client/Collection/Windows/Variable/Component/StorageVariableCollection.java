package uk.co.syski.client.Collection.Windows.Variable.Component;

import uk.co.syski.client.Collection.Windows.CMDInterface;
import uk.co.syski.client.System.Components.Variable.StorageVariable;

import java.io.IOException;

public class StorageVariableCollection
{
    private static StorageVariable[] storage;
    private static Thread timeThread, transfersThread, readsThread, writesThread, byteReadsThread, byteWritesThread;
    private static int sleepTime;
    private static boolean threadActive = false;

    static
    {
        try
        {
            //Maybe fix this init function? It takes one second to setup the static class, maybe an array list?
            int size = getStorageSize();
            storage = new StorageVariable[size];
            for (int i = 0; i < size; i++)
                storage[i] = new StorageVariable();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static StorageVariable[] getStorageVariableInfo()
    {
        return storage;
    }

    private static int getStorageSize() throws IOException
    {
        String[] args = CMDInterface.executeWithResponse("typeperf \"\\PhysicalDisk(*)\\% Disk Time\" -sc 1");
        return args[2].split(",").length;
    }

    public static void startThreads(int sleep)
    {
        if (threadActive || timeThread != null || transfersThread != null || readsThread != null || writesThread != null || byteReadsThread != null || byteWritesThread != null)
            throw new IllegalThreadStateException("Thread cannot be started while other thread of the same type is running.");
        initThreads();
        threadActive = true;
        timeThread.start();
        readsThread.start();
        writesThread.start();
        byteReadsThread.start();
        byteWritesThread.start();
    }

    public static void stopThreads()
    {
        threadActive = false;
    }

    private static void initThreads()
    {
        //Time Thread
        timeThread = new Thread()
        {
            public void run()
            {
                while(threadActive)
                {
                    try
                    {
                        float[] f = getTime();
                        for (int i = 0; i < f.length; i++)
                            storage[i].setTime(f[i]);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        //Transfers Thread
        transfersThread = new Thread()
        {
            public void run()
            {
                while(threadActive)
                {
                    try
                    {
                        float[] f = getTransfers();
                        for (int i = 0; i < f.length; i++)
                            storage[i].setTransfers(f[i]);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        //Reads Thread
        readsThread = new Thread()
        {
            public void run()
            {
                while(threadActive)
                {
                    try
                    {
                        float[] f = getReads();
                        for (int i = 0; i < f.length; i++)
                            storage[i].setReads(f[i]);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        //Writes Thread
        writesThread = new Thread()
        {
            public void run()
            {
                while(threadActive)
                {
                    try
                    {
                        float[] f = getWrites();
                        for (int i = 0; i < f.length; i++)
                            storage[i].setWrites(f[i]);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        //ByteReads Thread
        byteReadsThread = new Thread()
        {
            public void run()
            {
                while(threadActive)
                {
                    try
                    {
                        float[] f = getByteReads();
                        for (int i = 0; i < f.length; i++)
                            storage[i].setByteReads(f[i]);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        //ByteWrites Thread
        byteWritesThread = new Thread()
        {
            public void run()
            {
                while(threadActive)
                {
                    try
                    {
                        float[] f = getByteWrites();
                        for (int i = 0; i < f.length; i++)
                            storage[i].setByteWrites(f[i]);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private static float[] getTime() throws IOException
    {
        return parseResult(CMDInterface.executeWithResponse("typeperf \"\\PhysicalDisk(*)\\% Disk Time\" -sc 1"));
    }

    private static float[] getTransfers() throws IOException
    {
        return parseResult(CMDInterface.executeWithResponse("typeperf \"\\PhysicalDisk(*)\\Disk Transfers/sec\" -sc 1"));
    }

    private static float[] getReads() throws IOException
    {
        return parseResult(CMDInterface.executeWithResponse("typeperf \"\\PhysicalDisk(*)\\Disk Reads/sec\" -sc 1"));
    }

    private static float[] getWrites() throws IOException
    {
        return parseResult(CMDInterface.executeWithResponse("typeperf \"\\PhysicalDisk(*)\\Disk Writes/sec\" -sc 1"));
    }

    private static float[] getByteReads() throws IOException
    {
        return parseResult(CMDInterface.executeWithResponse("typeperf \"\\PhysicalDisk(*)\\Avg. Disk Bytes/Read\" -sc 1"));
    }

    private static float[] getByteWrites() throws IOException
    {
        return parseResult(CMDInterface.executeWithResponse("typeperf \"\\PhysicalDisk(*)\\Avg. Disk Bytes/Write\" -sc 1"));
    }

    private static float[] parseResult(String[] args) throws IOException
    {
        String[] result = args[2].replace("\"", "").split(",");
        float[] resultf = new float[args[2].split(",").length];
        for (int i = 1; i < result.length; i++)
        {
            resultf[i] = Float.parseFloat(result[i]);
        }
        return resultf;
    }
}
