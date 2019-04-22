package uk.co.syski.client.Action.Generic;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.ProcessCollection;
import uk.co.syski.client.JSON.JSONResponse;
import uk.co.syski.client.util.Output;

import java.io.IOException;

public class ActionPROCESSES extends Action
{
    public ActionPROCESSES(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - Processes");
        if (properties != null)
        {
            try
            {
                websocket.sendText(JSONResponse.getJSON(ProcessCollection.getProcesses()).toString());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
