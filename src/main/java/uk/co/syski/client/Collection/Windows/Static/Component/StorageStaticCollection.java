package uk.co.syski.client.Collection.Windows.Static.Component;

import uk.co.syski.client.Collection.Windows.WMICInterface;
import uk.co.syski.client.System.Components.Static.StorageStatic;

import java.io.IOException;
import java.util.LinkedList;

public class StorageStaticCollection
{
    public static StorageStatic[] getStorageStaticInfo() throws IOException
    {
        LinkedList<StorageStatic> storage = new LinkedList<>();
        String[][] result = WMICInterface.getArrayInfo("diskdrive", new String[] {"caption", "manufacturer", "size", "interfacetype"});
        for (String[] str : result)
        {
            StorageStatic s = new StorageStatic();
            s.setModel(str[0]);
            s.setManufacturer(str[1]);
            s.setSize(Long.parseLong(str[2]));
            s.setType(str[3]);
            storage.add(s);
        }

        StorageStatic[] arr = storage.toArray(new StorageStatic[storage.size()]);
        return arr;
    }
}
