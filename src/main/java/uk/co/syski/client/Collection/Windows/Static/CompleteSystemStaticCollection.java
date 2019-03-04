package uk.co.syski.client.Collection.Windows.Static;

import uk.co.syski.client.Collection.Windows.Static.Component.*;
import uk.co.syski.client.System.CompleteSystemStatic;

import java.io.IOException;

public class CompleteSystemStaticCollection
{
    public static CompleteSystemStatic getCompleteSystemStaticInfo() throws IOException
    {
        CompleteSystemStatic css = new CompleteSystemStatic();
        css.setCPU(CPUStaticCollection.getCPUStaticInfo());
        css.setSystem(SystemStaticCollection.getSystemStaticInfo());
        css.setOS(OSStaticCollection.getOSStaticInfo());
        css.setGPU(GPUStaticCollection.getGPUStaticInfo());
        css.setMotherboard(MotherboardStaticCollection.getMotherboardStaticInfo());
        css.setRAM(RAMStaticCollection.getRAMStaticInfo());
        css.setStorage(StorageStaticCollection.getStorageStaticInfo());
        return css;
    }
}
