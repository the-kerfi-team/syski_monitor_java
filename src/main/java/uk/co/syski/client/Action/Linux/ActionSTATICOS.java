package uk.co.syski.client.Action.Linux;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import java.io.IOException;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Linux.Static.Component.OSStaticCollection;
import uk.co.syski.client.JSON.JSONResponse;
import uk.co.syski.client.util.Output;

public class ActionSTATICOS extends Action
{
    
    public ActionSTATICOS(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - Static Operating System");
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
