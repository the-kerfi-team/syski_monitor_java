package uk.co.syski.client.Action.Windows;

import uk.co.syski.client.Action.Action;
import uk.co.syski.client.JSON.JSONResponse;
import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Collection.Windows.Variable.Component.NetworkVariableCollection;
import uk.co.syski.client.util.Output;

public class ActionVARIABLENETWORK extends Action
{
    public ActionVARIABLENETWORK(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }
    
    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - Network Data");
        if (properties != null)
        {
            websocket.sendText(JSONResponse.getJSON(NetworkVariableCollection.getNetworkVariableInfo()).toString());
        }
    }    
}
