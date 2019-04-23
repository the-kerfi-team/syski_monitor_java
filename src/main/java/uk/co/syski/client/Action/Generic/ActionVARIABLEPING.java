package uk.co.syski.client.Action.Generic;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.util.Output;

public class ActionVARIABLEPING extends Action
{

    public ActionVARIABLEPING(WebSocket websocket, JsonObject properties) {
        super(websocket, properties);
    }

    @Override
    public void execute() {
        Output.printLineToConsole("[ACTION] - Ping Data");
        JsonObject json = Json.object()
                .add("action", "variableping")
                .add("properties", Json.object());
        websocket.sendText(json.toString());
    }
    
}
