package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Windows.Static.Component.CPUStaticCollection;
import uk.co.syski.client.JSON.JSONResponse;

import java.io.IOException;

public class ActionSTATICCPU extends Action
{
    public ActionSTATICCPU(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        System.out.println("[ACTION] - StaticCPU");
        if (properties != null)
        {
            try
            {
                JsonObject json = JSONResponse.getJSON(CPUStaticCollection.getCPUStaticInfo());
                //Send that JSON here.
            }
            catch (NullPointerException | IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
