package uk.co.syski.client.Collection.Windows.Static;

import uk.co.syski.client.System.CompleteSystemStatic;

import java.io.IOException;

public class CompleteSystemStaticCollection
{
    public static CompleteSystemStatic getCompleteSystemStaticInfo() throws IOException
    {
        CompleteSystemStatic css = new CompleteSystemStatic();
        css.setCPU(CPUStaticCollection.getCPUStaticInfo());
        css.setSystem(SystemStaticCollection.getSystemStaticInfo());
        return css;
    }
}
