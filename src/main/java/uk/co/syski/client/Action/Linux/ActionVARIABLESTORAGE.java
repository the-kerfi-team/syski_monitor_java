package uk.co.syski.client.Action.Linux;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Linux.Variable.Component.StorageVariableCollection;
import uk.co.syski.client.JSON.JSONResponse;
import uk.co.syski.client.util.Output;

public class ActionVARIABLESTORAGE extends Action
{
    public ActionVARIABLESTORAGE(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }
    
    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - Storage Data");
        if (properties != null)
        {
            websocket.sendText(JSONResponse.getJSON(StorageVariableCollection.getStorageVariableInfo()).toString());
        }
    }
}
