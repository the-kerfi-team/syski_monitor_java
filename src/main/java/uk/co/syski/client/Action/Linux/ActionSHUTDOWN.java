package uk.co.syski.client.Action.Linux;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.CMDInterface;
import uk.co.syski.client.util.Output;

import java.io.IOException;

public class ActionSHUTDOWN extends Action
{
    public ActionSHUTDOWN(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - Shutdown");
        if (properties != null)
        {
            try
            {
                //Do Shutdown Action
                CMDInterface.execute("shutdown -h now");
            }
            catch (NullPointerException | IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
