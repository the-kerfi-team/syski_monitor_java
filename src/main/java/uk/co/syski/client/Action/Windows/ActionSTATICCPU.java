package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.JSON.JSONResponse;
import java.io.IOException;
import uk.co.syski.client.Collection.Windows.Static.Component.CPUStaticCollection;

public class ActionSTATICCPU extends Action
{
    
    public ActionSTATICCPU(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        System.out.println("[ACTION] - Static CPU");
        if (properties != null)
        {
            try
            {
                websocket.sendText(JSONResponse.getJSON(CPUStaticCollection.getCPUStaticInfo()).toString());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
