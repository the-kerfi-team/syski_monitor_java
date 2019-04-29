package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Collection.Windows.Variable.Component.CPUVariableCollection;
import uk.co.syski.client.Collection.Windows.Variable.Component.NetworkVariableCollection;
import uk.co.syski.client.Collection.Windows.Variable.Component.RAMVariableCollection;
import uk.co.syski.client.Collection.Windows.Variable.Component.StorageVariableCollection;

public class ActionAUTHENTICATION extends uk.co.syski.client.Action.Generic.ActionAUTHENTICATION
{
    public ActionAUTHENTICATION(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }
    
    @Override
    public void execute()
    {
        super.execute();
        if (authenticated)
        {
            CPUVariableCollection.startThreads(0);
            NetworkVariableCollection.startThreads(0);
            RAMVariableCollection.startThreads();
            StorageVariableCollection.startThreads(0);
        }
    }
    
}
