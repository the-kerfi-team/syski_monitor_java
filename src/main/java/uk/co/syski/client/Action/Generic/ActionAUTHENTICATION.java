package uk.co.syski.client.Action.Generic;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;

public class ActionAUTHENTICATION extends Action
{
    public ActionAUTHENTICATION(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        System.out.println("[ACTION] - Authentication");
        if (properties != null)
        {
            try
            {

            }
            catch (NullPointerException npe)
            {

            }
        }
    }
}
