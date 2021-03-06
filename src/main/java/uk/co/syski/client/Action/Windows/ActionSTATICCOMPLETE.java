package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Windows.Static.CompleteSystemStaticCollection;
import uk.co.syski.client.JSON.JSONResponse;

import java.io.IOException;
import uk.co.syski.client.util.Output;

public class ActionSTATICCOMPLETE extends Action
{
    public ActionSTATICCOMPLETE(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - Static Complete System");
        if (properties != null)
        {
            try
            {
                JsonObject json = JSONResponse.getJSON(CompleteSystemStaticCollection.getCompleteSystemStaticInfo());
                //Send that JSON here.
            }
            catch (NullPointerException | IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
