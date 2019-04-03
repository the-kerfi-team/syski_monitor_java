package uk.co.syski.client.Collection.Linux.Variable.Component;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import uk.co.syski.client.System.Components.Variable.NetworkVariable;

public class NetworkVariableCollection
{
    public static NetworkVariable getNetworkVariableInfo()
    {
        NetworkVariable network = new NetworkVariable();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        NetworkIF[] nets = hal.getNetworkIFs();
        for (NetworkIF net : nets)
        {
            network.setBandwidth(net.getSpeed());
            network.setBytes(net.getBytesRecv() + net.getBytesSent());
            network.setPackets(net.getPacketsRecv() + net.getPacketsSent());
        }
        return network;
    }
}
