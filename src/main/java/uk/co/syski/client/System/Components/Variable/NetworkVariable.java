package uk.co.syski.client.System.Components.Variable;

public class NetworkVariable
{
    private float packets, bytes, bandwidth;

    //Getters
    public float getPackets()
    {
        return packets;
    }

    public float getBytes()
    {
        return bytes;
    }

    public float getBandwidth()
    {
        return bandwidth;
    }

    //Setters
    public void setPackets(float p)
    {
        packets = p;
    }

    public void setBytes(float b)
    {
        bytes = b;
    }

    public void setBandwidth(float b)
    {
        bandwidth = b;
    }
}
