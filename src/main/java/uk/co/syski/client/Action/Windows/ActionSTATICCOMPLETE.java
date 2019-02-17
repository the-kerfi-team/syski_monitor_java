package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Windows.Static.CPUStaticCollection;
import uk.co.syski.client.Collection.Windows.Static.CompleteSystemStaticCollection;
import uk.co.syski.client.JSON.JSONResponse;
import uk.co.syski.client.System.CompleteSystemStatic;

import java.io.IOException;

public class ActionSTATICCOMPLETE extends Action
{
    public ActionSTATICCOMPLETE(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        System.out.println("[ACTION] - StaticComplete");
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
