package uk.co.syski.client;

import java.io.IOException;
import uk.co.syski.client.Configuration.APIConfiguration;
import uk.co.syski.client.Configuration.ConfigurationLoader;
import uk.co.syski.client.websocket.WebSocketClient;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        try {
            ConfigurationLoader.loadINI();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ConfigurationLoader.loadAllConfigurations();
        WebSocketClient wsc = new WebSocketClient(APIConfiguration.getURL() + ":" + APIConfiguration.getPort() + "/websocket", true);
        wsc.start();
    }
}
