package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Windows.Static.Component.BIOSStaticCollection;
import uk.co.syski.client.JSON.JSONResponse;
import uk.co.syski.client.util.Output;

import java.io.IOException;

public class ActionSTATICBIOS extends Action
{
    public ActionSTATICBIOS(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - Static BIOS");
        if (properties != null)
        {
            try
            {
                websocket.sendText(JSONResponse.getJSON(BIOSStaticCollection.getBIOSStaticInfo()).toString());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
