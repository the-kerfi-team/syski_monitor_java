package uk.co.syski.client.Collection.Windows.Variable.Component;

import uk.co.syski.client.Collection.Windows.CMDInterface;
import uk.co.syski.client.System.Components.Variable.NetworkVariable;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class NetworkVariableCollection
{
    private static final NetworkVariable network = new NetworkVariable();
    private static Thread bandwidthThread, bytesThread, packetsThread;
    private static int sleepTime;
    private static boolean threadActive = false;

    public static NetworkVariable getNetworkVariableInfo() throws IOException
    {
        return network;
    }

    public static void startThreads(int sleep)
    {
        if (threadActive || bandwidthThread != null || bytesThread != null || packetsThread != null)
            throw new IllegalThreadStateException("Thread cannot be started while other thread of the same type is running.");
        initThreads();
        threadActive = true;
        bandwidthThread.start();
        bytesThread.start();
        packetsThread.start();
    }

    public static void stopThreads()
    {
        threadActive = false;
    }

    private static void initThreads()
    {
        //Bandwidth Thread
        bandwidthThread = new Thread()
        {
            @Override
            public void run()
            {
                while(threadActive)
                {
                    try
                    {
                        network.setBandwidth(getBandwidth());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                bandwidthThread = null;
            }
        };

        //Bytes Thread
        bytesThread = new Thread()
        {
            @Override
            public void run()
            {
                while(threadActive)
                {
                    try
                    {
                        network.setBytes(getBytes());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                bandwidthThread = null;
            }
        };

        //Packets Thread
        packetsThread = new Thread()
        {
            @Override
            public void run()
            {
                while (threadActive)
                {
                    try
                    {
                        network.setPackets(getPackets());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                bandwidthThread = null;
            }
        };
    }



    private static float getBandwidth() throws IOException
    {
        String[] result = CMDInterface.executeWithResponse("typeperf \"\\Network Interface(*)\\Current Bandwidth\" -sc 1");
        return Float.parseFloat(result[2].split("\",\"")[1].replace("\"", ""));
    }

    private static float getBytes() throws IOException
    {
        String[] result = CMDInterface.executeWithResponse("typeperf \"\\Network Interface(*)\\Bytes Total/sec\" -sc 1");
        return Float.parseFloat(result[2].split("\",\"")[1].replace("\"", ""));
    }

    private static float getPackets() throws IOException
    {
        String[] result = CMDInterface.executeWithResponse("typeperf \"\\Network Interface(*)\\Packets/sec\" -sc 1");
        return Float.parseFloat(result[2].split("\",\"")[1].replace("\"", ""));
    }
}
