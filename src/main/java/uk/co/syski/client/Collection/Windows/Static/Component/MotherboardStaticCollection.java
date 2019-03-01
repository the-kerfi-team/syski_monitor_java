package uk.co.syski.client.Collection.Windows.Static.Component;

import uk.co.syski.client.Collection.Windows.WMICInterface;
import uk.co.syski.client.System.Components.Static.MotherboardStatic;

import java.io.IOException;

public class MotherboardStaticCollection
{
    public static MotherboardStatic getMotherboardStaticInfo() throws IOException
    {
        MotherboardStatic mb = new MotherboardStatic();
        String[] result = WMICInterface.getInfo("baseboard", new String[] {"manufacturer", "product", "serialnumber"});
        mb.setManufacturer(result[0]);
        mb.setModel(result[1]);
        mb.setVersion(result[2]);
        return mb;
    }

    public static String getMotherboardManufacturer() throws IOException
    {
        return WMICInterface.getInfo("baseboard", new String[] {"manufacturer"})[0];
    }

    public static String getMotherboardModel() throws IOException
    {
        return WMICInterface.getInfo("baseboard", new String[] {"product"})[0];
    }

    public static String getMotherboardVersion() throws IOException
    {
        return WMICInterface.getInfo("baseboard", new String[] {"serialnumber"})[0];
    }
}
