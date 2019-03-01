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

    public static String[][] getArrayInfo(String component, String[] args) throws IOException
    {
        String commandArgs = "";
        for (String s : args)
            commandArgs += s + ",";
        commandArgs = commandArgs.substring(0, commandArgs.length() - 1);

        String[] outputValues = CMDInterface.executeWithResponse("wmic " + component + " get " + commandArgs + "/format:list");
        String[][] output = new String[args.length][arraySize(outputValues, args[0])];

        for (int j = 0; j < arraySize(outputValues, args[0]); j++)
            for (int c = 0; c < outputValues.length;  c++)
                for (int i = 0, d = 0; i < args.length && d <= 0; i++)
                    if (outputValues[c].toLowerCase().startsWith(args[i]))
                    {
                        output[j][i] = outputValues[c].substring(args[i].length() + 1);
                        outputValues[c] = "";
                        d++;
                    }
        return output;
    }

    private static int arraySize(String[] result, String key)
    {
        int count = 0;
        for (String line : result)
            if (line.toLowerCase().startsWith(key))
                count++;
        return count;
    }
}