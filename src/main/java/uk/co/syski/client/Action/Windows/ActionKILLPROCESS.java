package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.CMDInterface;
import uk.co.syski.client.JSON.JSONResponse;
import uk.co.syski.client.System.Components.Static.BIOSStatic;
import uk.co.syski.client.util.Output;

public class ActionKILLPROCESS extends Action
{
    public ActionKILLPROCESS(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - Kill Process");
        if (properties != null)
        {
            try
            {
                if (properties.get("id") != null || !properties.get("id").equals("0"))
                CMDInterface.execute("taskkill /F /PID " + properties.get("id"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
