package uk.co.syski.client.Collection.Linux.Static.Component;

import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import uk.co.syski.client.System.Components.Static.StorageStatic;
import uk.co.syski.client.System.Components.Static.SystemStatic;

import java.io.IOException;

public class StorageStaticCollection
{
    public static StorageStatic[] getStorageStaticInfo() throws IOException
    {

        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        HWDiskStore[] disk = hal.getDiskStores();
        StorageStatic[] storage = new StorageStatic[disk.length];
        for (int i = 0; i < disk.length; i++)
        {
            storage[i] = new StorageStatic();
            storage[i].setModel(disk[i].getModel());
            storage[i].setSize(disk[i].getSize());
        }
        return storage;
    }
}
