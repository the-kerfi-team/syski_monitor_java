package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject; 
import com.neovisionaries.ws.client.WebSocket;
import java.io.IOException;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Windows.Static.Component.RAMStaticCollection;
import uk.co.syski.client.JSON.JSONResponse;

public class ActionSTATICRAM extends Action
{
    public ActionSTATICRAM(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        System.out.println("[ACTION] - Static RAM");
        if (properties != null)
        {
            try
            {
                websocket.sendText(JSONResponse.getJSON(RAMStaticCollection.getRAMStaticInfo()).toString());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
