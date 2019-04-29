package uk.co.syski.client.Action.Linux;

import com.eclipsesource.json.JsonObject; 
import com.neovisionaries.ws.client.WebSocket;
import java.io.IOException;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Linux.Static.Component.RAMStaticCollection;
import uk.co.syski.client.JSON.JSONResponse;
import uk.co.syski.client.util.Output;

public class ActionSTATICRAM extends Action
{
    public ActionSTATICRAM(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - Static RAM");
        if (properties != null)
        {
            try
            {
                websocket.sendText(JSONResponse.getJSON(RAMStaticCollection.getRAMStaticInfo()).toString());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
