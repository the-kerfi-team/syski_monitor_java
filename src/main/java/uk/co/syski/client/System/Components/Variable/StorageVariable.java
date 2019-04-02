package uk.co.syski.client.System.Components.Variable;

public class StorageVariable
{
    private float time, transfers, reads, writes, byteReads, byteWrites;

    //Getters
    public float getTime()
    {
        return time;
    }

    public float getTransfers()
    {
        return transfers;
    }

    public float getReads()
    {
        return reads;
    }

    public float getWrites()
    {
        return writes;
    }

    public float getByteReads()
    {
        return byteReads;
    }

    public float getByteWrites()
    {
        return byteWrites;
    }

    //Setters
    public void setTime(float t)
    {
        time = t;
    }

    public void setTransfers(float t)
    {
        transfers = t;
    }

    public void setReads(float r)
    {
        reads = r;
    }

    public void setWrites(float w)
    {
        writes = w;
    }

    public void setByteReads(float br)
    {
        byteReads = br;
    }

    public void setByteWrites(float bw)
    {
        byteWrites = bw;
    }
}
