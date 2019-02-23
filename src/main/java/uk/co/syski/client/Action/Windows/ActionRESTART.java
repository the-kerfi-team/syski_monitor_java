package uk.co.syski.client.Action.Windows;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Collection.Windows.CMDInterface;

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
        System.out.println("[ACTION] - Restart");
        if (properties != null)
        {
            try
            {
                //Execute shutdown command.
                CMDInterface.execute("shutdown /r");
            }
            catch (NullPointerException | IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
