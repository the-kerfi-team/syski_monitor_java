package uk.co.syski.client.Collection.Windows.Static.Component;

import uk.co.syski.client.Collection.Windows.CMDInterface;
import uk.co.syski.client.Collection.Windows.WMICInterface;
import uk.co.syski.client.System.Components.Static.SystemStatic;

import java.io.IOException;

public class SystemStaticCollection
{
    public static SystemStatic getSystemStaticInfo() throws IOException
    {
        SystemStatic ss = new SystemStatic();

        String[] csProductResult = WMICInterface.getInfo("csproduct", new String[] {"version", "vendor"});
        String[] enclosureResult = WMICInterface.getInfo("systemenclosure", new String[] {"chassistypes"});
        String[] hostname = CMDInterface.executeWithResponse("hostname");

        ss.setID(0);
        ss.setModel(checkUnfilledField(csProductResult[0]));
        ss.setManufacturer(checkUnfilledField(csProductResult[1]));
        ss.setType(Integer.parseInt(removeBrackets(enclosureResult[0])));
        ss.setHostName(hostname[0]);

        return ss;
    }

    private static String removeBrackets(String s)
    {
        String value = "";
        for (char c : s.toCharArray())
        {
            if (c != '{' && c != '}')
            {
                value += c;
            }
        }
        return value;
    }

    private static String checkUnfilledField(String s)
    {
        if (s.startsWith("To Be Filled"))
        {
            return "";
        }
        return s;
    }
}
