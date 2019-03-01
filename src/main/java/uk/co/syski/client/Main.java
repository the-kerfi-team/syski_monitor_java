package uk.co.syski.client;

import uk.co.syski.client.Collection.Windows.WMICInterface;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        /*try {
            ConfigurationLoader.loadINI();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ConfigurationLoader.loadAllConfigurations();
        WebSocketClient wsc = new WebSocketClient(APIConfiguration.getURL() + ":" + APIConfiguration.getPort() + "/websocket", true);
        wsc.start();*/

        String[][] response = WMICInterface.getArrayInfo("memorychip", new String[] {"capacity"});
        for (String[] s : response)
            for (String str : s)
                System.out.println(str);
    }
}
