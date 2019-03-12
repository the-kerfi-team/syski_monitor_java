package uk.co.syski.client.Action.Windows;

import uk.co.syski.client.Action.Action;
import uk.co.syski.client.JSON.JSONResponse;
import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Collection.Windows.Variable.Component.NetworkVariableCollection;

public class ActionVARIABLENETWORK extends Action
{
    public ActionVARIABLENETWORK(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }
    
    @Override
    public void execute()
    {
        System.out.println("[ACTION] - Network Data");
        if (properties != null)
        {
            websocket.sendText(JSONResponse.getJSON(NetworkVariableCollection.getNetworkVariableInfo()).toString());
        }
    }    
}
