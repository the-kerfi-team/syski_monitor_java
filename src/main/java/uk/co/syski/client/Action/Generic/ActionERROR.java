package uk.co.syski.client.Action.Generic;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.util.Output;

public class ActionERROR extends Action
{
    public ActionERROR(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        if (properties != null)
        {
            try
            {
                Output.printLineToConsole("[ERROR] " + properties.get("message").asString());
            }
            catch (NullPointerException npe)
            {

            }
            super.nextAction(properties);
        }
    }
}
