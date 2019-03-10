package uk.co.syski.client.Collection.Windows.Variable.Component;

import uk.co.syski.client.Collection.Windows.CMDInterface;
import uk.co.syski.client.System.Components.Variable.NetworkVariable;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class NetworkVariableCollection
{
    private static final NetworkVariable network = new NetworkVariable();

    public static NetworkVariable getNetworkVariableInfo() throws IOException
    {
        network.setBandwidth(0f);
        network.setBytes(0f);
        network.setPackets(0f);
        return network;
    }

    private static float getBandwidth() throws IOException
    {
        String[] result = CMDInterface.executeWithResponse("typepref \"\\Network Interface(*)\\Packets/sec\" -sc 1");
        return Float.parseFloat(result[2].split("\",\"")[1].replace("\"", ""));
    }
}
