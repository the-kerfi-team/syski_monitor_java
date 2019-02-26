package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.JSON.JSONResponse;
import java.io.IOException;
import uk.co.syski.client.Collection.Windows.Static.Component.SystemStaticCollection;

public class ActionSTATICSYSTEM extends Action
{
    public ActionSTATICSYSTEM(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        System.out.println("[ACTION] - StaticSystem");
        if (properties != null)
        {
            try
            {
                JsonObject json = JSONResponse.getJSON(SystemStaticCollection.getSystemStaticInfo());
                websocket.sendText(json.toString());
            }
            catch (NullPointerException | IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
