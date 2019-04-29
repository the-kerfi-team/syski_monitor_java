package uk.co.syski.client.Action.Linux;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Linux.Static.Component.CPUStaticCollection;
import uk.co.syski.client.JSON.JSONResponse;
import uk.co.syski.client.System.Components.Static.BIOSStatic;
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
                websocket.sendText(JSONResponse.getJSON(new BIOSStatic()).toString());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
