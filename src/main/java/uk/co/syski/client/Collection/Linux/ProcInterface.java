package uk.co.syski.client.Collection.Linux;

import uk.co.syski.client.Collection.CMDInterface;

import java.io.IOException;

public class ProcInterface
{
    public static String[] getInfo(String proc, String args[]) throws IOException
    {
        String[] outputValues = CMDInterface.executeWithResponse("cat /proc/" + proc);
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
}
