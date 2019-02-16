package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;

public class ActionAUTHENTICATION extends uk.co.syski.client.Action.Generic.ActionAUTHENTICATION
{
    public ActionAUTHENTICATION(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }
}
