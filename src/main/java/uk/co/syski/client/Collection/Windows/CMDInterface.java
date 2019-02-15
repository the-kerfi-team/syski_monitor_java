package uk.co.syski.client.Collection.Windows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class CMDInterface
{
    public static void execute(String args) throws IOException
    {
        Runtime.getRuntime().exec(args);
    }

    public static String[] executeWithResponse(String args) throws IOException
    {
        String line;
        Process process = Runtime.getRuntime().exec(args);
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        LinkedList<String> output = new LinkedList<>();
        while ((line = input.readLine()) != null)
        {
            output.add(line);
        }
        input.close();
        return output.toArray(new String[output.size()]);
    }
}
