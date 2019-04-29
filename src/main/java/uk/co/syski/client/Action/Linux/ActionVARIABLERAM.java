package uk.co.syski.client.Action.Linux;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Collection.Linux.Variable.Component.RAMVariableCollection;
import uk.co.syski.client.JSON.JSONResponse;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.util.Output;

public class ActionVARIABLERAM extends Action
{
    public ActionVARIABLERAM(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - RAM Data");
        if (properties != null)
        {
            websocket.sendText(JSONResponse.getJSON(RAMVariableCollection.getRAMVariableInfo()).toString());
        }
    }
}
