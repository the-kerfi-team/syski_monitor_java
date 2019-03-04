package uk.co.syski.client.Collection.Windows.Static.Component;

import uk.co.syski.client.Collection.Windows.WMICInterface;
import uk.co.syski.client.System.Components.Static.RAMStatic;

import java.io.IOException;
import java.util.LinkedList;

public class RAMStaticCollection
{
    public static RAMStatic[] getRAMStaticInfo() throws IOException
    {
        LinkedList<RAMStatic> RAMCollection = new LinkedList<>();
        String[][] result = WMICInterface.getArrayInfo("memorychip", new String[] {"partnumber", "speed", "capacity"});
        for (String[] ram : result)
        {
            RAMStatic r = new RAMStatic();
            r.setModel(ram[0]);
            r.setSpeed(Integer.parseInt(ram[1]));
            r.setSize(Long.parseLong(ram[2]));
            RAMCollection.add(r);
        }

        RAMStatic[] arr = RAMCollection.toArray(new RAMStatic[RAMCollection.size()]);
        return arr;
        //return (RAMStatic[]) RAMCollection.toArray(); //WHY DOES THIS NOT WORK JAVA
    }
}
