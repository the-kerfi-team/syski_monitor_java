package uk.co.syski.client.Action.Linux;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.CMDInterface;
import uk.co.syski.client.util.Output;

import java.io.IOException;

public class ActionRESTART extends Action
{
    public ActionRESTART(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        Output.printLineToConsole("[ACTION] - Restart");
        if (properties != null)
        {
            try
            {
                //Execute shutdown command.
                CMDInterface.execute("shutdown -r now");
            }
            catch (NullPointerException | IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
