package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import java.io.IOException;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Windows.Static.Component.CPUStaticCollection;
import uk.co.syski.client.Collection.Windows.Static.Component.OSStaticCollection;
import uk.co.syski.client.JSON.JSONResponse;

public class ActionSTATICOS extends Action
{
    
    public ActionSTATICOS(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        System.out.println("[ACTION] - Static Operating System");
        if (properties != null)
        {
            try
            {
                websocket.sendText(JSONResponse.getJSON(OSStaticCollection.getOSStaticInfo()).toString());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
