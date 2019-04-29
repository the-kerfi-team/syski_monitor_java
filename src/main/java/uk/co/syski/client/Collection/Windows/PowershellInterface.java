package uk.co.syski.client.Collection.Windows;

import java.io.IOException;
import uk.co.syski.client.Collection.CMDInterface;

public class PowershellInterface
{
    public static String[] getInfo(String ps, String args[]) throws IOException
    {
        String[] outputValues = CMDInterface.executeWithResponse("powershell.exe " + ps);
        String[] output = new String[args.length];

        for (String line : outputValues)
            for (int i = 0; i < args.length; i++)
                if (line.toLowerCase().startsWith(args[i]))
                {
                    output[i] = line.split(":")[1].trim();
                    break;
                }


        return output;
    }
    
    public static String[][] getArrayInfo(String ps, String args[]) throws IOException
    {
        String[] outputValues = CMDInterface.executeWithResponse("powershell.exe " + ps);
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
