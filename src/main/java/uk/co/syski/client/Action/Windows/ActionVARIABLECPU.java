package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Windows.Variable.Component.CPUVariableCollection;
import uk.co.syski.client.JSON.JSONResponse;

public class ActionVARIABLECPU extends Action
{
    public ActionVARIABLECPU(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        System.out.println("[ACTION] - CPU Data");
        if (properties != null)
        {
            websocket.sendText(JSONResponse.getJSON(CPUVariableCollection.getCurrentCPUVariableInfo()).toString());
        }
    }

}
