package uk.co.syski.client.util;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Output {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
    
    public static void printLineToConsole(String output)
    {
        System.out.println("[" + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")) + "] " + output); 
    }
    
    public static void printToConsole(String output)
    {
        System.out.print("[" + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")) + "] " + output); 
    }
    
}
