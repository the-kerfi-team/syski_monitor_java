package uk.co.syski.client.Collection.Linux.Variable.Component;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import uk.co.syski.client.System.Components.Variable.StorageVariable;

public class StorageVariableCollection
{
    public static StorageVariable getStorageVariableInfo()
    {
        StorageVariable storage = new StorageVariable();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        HWDiskStore[] disks = hal.getDiskStores();
        for (HWDiskStore d : disks)
        {
            storage.setReads(storage.getReads() + d.getReads());
            storage.setWrites(storage.getWrites() + d.getWrites());
            storage.setTime(storage.getTime() + d.getTransferTime());
            storage.setByteReads(storage.getByteReads() + d.getReadBytes());
            storage.setByteWrites(storage.getByteWrites() + d.getWriteBytes());
        }
        return storage;
    }
}
