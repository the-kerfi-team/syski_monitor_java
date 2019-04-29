package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;

public class ActionPROCESSES extends uk.co.syski.client.Action.Generic.ActionPROCESSES
{
    public ActionPROCESSES(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }
}
