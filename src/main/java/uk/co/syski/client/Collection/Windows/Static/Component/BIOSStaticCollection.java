package uk.co.syski.client.Collection.Windows.Static.Component;

import uk.co.syski.client.Collection.Windows.WMICInterface;
import uk.co.syski.client.System.Components.Static.BIOSStatic;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BIOSStaticCollection
{
    public static BIOSStatic getBIOSStaticInfo() throws IOException, ParseException
    {
        BIOSStatic bios = new BIOSStatic();
        String[] result = WMICInterface.getInfo("bios", new String[] { "manufacturer", "caption", "smbiosbiosversion", "releasedate" });
        bios.setManufacturer(result[0]);
        bios.setCaption(result[1]);
        bios.setVersion(result[2]);
        bios.setDate(result[3]);
        return bios;
    }
}
