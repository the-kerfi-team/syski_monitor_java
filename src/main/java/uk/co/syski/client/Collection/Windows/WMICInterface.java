package uk.co.syski.client.Collection.Windows;

import uk.co.syski.client.Collection.CMDInterface;

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
        String[][] output = new String[arraySize(outputValues, args[0])][args.length];

        for (int i = 0; i < args.length; i++)
        {
            int count = 0;
            for (int l = 0; l < outputValues.length; l++)
                if (outputValues[l].toLowerCase().startsWith(args[i]))
                {
                    output[count][i] = outputValues[l].substring(args[i].length() + 1);
                    outputValues[l] = "";
                    count++;
                }
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