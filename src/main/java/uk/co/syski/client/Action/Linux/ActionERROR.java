package uk.co.syski.client.Action.Linux;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;

public class ActionERROR extends uk.co.syski.client.Action.Generic.ActionERROR
{
    public ActionERROR(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }
}
