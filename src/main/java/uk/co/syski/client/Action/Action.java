package uk.co.syski.client.Action;

import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class Action
{
    protected static final boolean isWindowsSystem = System.getProperty("os.name").startsWith("Windows");

    protected final JsonObject properties;
    protected final WebSocket websocket;

    public Action(WebSocket websocket, JsonObject properties)
    {
        this.properties = properties;
        this.websocket = websocket;
    }

    public abstract void execute();

    protected final void nextAction(JsonObject properties)
    {
        if (properties != null)
        {
            if (!properties.isEmpty())
            {
                try
                {
                    if (properties.get("action") != null)
                    {
                        String actionName = properties.get("action").asString().toLowerCase();
                        JsonObject actionProperties = null;
                        try
                        {
                            actionProperties = properties.get("properties").asObject();
                        }
                        catch (NullPointerException npe)
                        {
                        }
                        Action.Create(actionName, actionProperties, websocket).execute();
                    }
                }
                catch (NullPointerException npe)
                {
                    System.out.println("Not Valid Action Format");
                }
                catch (ClassNotFoundException cnfe)
                {
                    System.out.println("Not Valid Action");;
                }
            }
        }
    }

    public static Action Create(String action, JsonObject properties, WebSocket websocket) throws ClassNotFoundException
    {
        Action result = null;
        Constructor<? extends Action> actionClass = null;
        try
        {
            Class[] cArg = new Class[2];
            cArg[0] = WebSocket.class;
            cArg[1] = JsonObject.class;
            actionClass = (Constructor<? extends Action>) Class.forName("uk.co.jlscott.syski.monitor.action." + (isWindowsSystem ? "win" : "unix") + ".Action" + action.toUpperCase()).getConstructor(cArg);
        }
        catch (NoSuchMethodException ex)
        {
            ex.printStackTrace();
        }
        catch (SecurityException ex)
        {
            ex.printStackTrace();
        }

        if (actionClass != null)
        {
            try
            {
                result = actionClass.newInstance(websocket, properties);
            }
            catch (SecurityException ex)
            {
                ex.printStackTrace();
            }
            catch (InvocationTargetException ex)
            {
                ex.printStackTrace();
            }
            catch (InstantiationException ex)
            {
                ex.printStackTrace();
            }
            catch (IllegalAccessException ex)
            {
                ex.printStackTrace();
            }
            catch (IllegalArgumentException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }

}

