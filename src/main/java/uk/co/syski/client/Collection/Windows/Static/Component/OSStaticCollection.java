package uk.co.syski.client.Collection.Windows.Static.Component;

import uk.co.syski.client.Collection.Windows.WMICInterface;
import uk.co.syski.client.System.Components.Static.OSStatic;

import java.io.IOException;

public class OSStaticCollection
{
    public static OSStatic getOSStaticInfo() throws IOException
    {
        OSStatic os = new OSStatic();
        String[] result = WMICInterface.getInfo("os", new String[] {"caption", "version", "osarchitecture"});
        os.setName(result[0]);
        os.setVersion(result[1]);
        os.setArchitecture(result[2]);
        return os;
    }

    public static String getOSName() throws IOException
    {
        return WMICInterface.getInfo("os", new String[] {"name"})[0];
    }

    public static String getOSVersion() throws IOException
    {
        return WMICInterface.getInfo("os", new String[] {"version"})[0];
    }

    public static String getOSArchitecture() throws IOException
    {
        return WMICInterface.getInfo("os", new String[] {"osarchitecture"})[0];
    }
}
