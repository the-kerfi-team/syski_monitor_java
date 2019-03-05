package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import java.io.IOException;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Windows.Static.Component.CPUStaticCollection;
import uk.co.syski.client.Collection.Windows.Static.Component.GPUStaticCollection;
import uk.co.syski.client.JSON.JSONResponse;

/**
 *
 * @author jordan
 */
public class ActionSTATICGPU extends Action
{
    
    public ActionSTATICGPU(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        System.out.println("[ACTION] - Static GPU");
        if (properties != null)
        {
            try
            {
                websocket.sendText(JSONResponse.getJSON(GPUStaticCollection.getGPUStaticInfo()).toString());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
