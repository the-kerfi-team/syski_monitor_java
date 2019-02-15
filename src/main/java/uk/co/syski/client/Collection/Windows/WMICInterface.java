package uk.co.syski.client.Collection.Windows;

import java.io.IOException;

public class WMICInterface
{
    public static String[] getInfo(String component, String[] args) throws IOException
    {
        String commandArgs = "";
        for (String s : args)
            commandArgs += s + ",";
        commandArgs = commandArgs.substring(0, commandArgs.length() - 1);

        String[] outputValues = CMDInterface.executeWithResponse("wmic " + component + " get " + commandArgs + "/format:list");
        String[] output = new String[args.length];

        for (String line : outputValues)
            for (int i = 0; i < args.length; i++)
                if (line.toLowerCase().startsWith(args[i]))
                    output[i] = line.substring(args[i].length() + 1);

        return output;
    }
}