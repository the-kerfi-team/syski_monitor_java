package uk.co.syski.client.websocket;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.ParseException;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketExtension;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import uk.co.syski.client.Action.Action;

public class WebSocketClient implements Runnable
{
    
    private Thread thread = null;
    private boolean  running = false;
    private final LinkedBlockingQueue<Action> actionQueue = new LinkedBlockingQueue();
    
    private final String url;
    private final boolean secureSocketLayer;
    private static final int TIMEOUT = 1000;
    private WebSocket websocket = null;
    
    public WebSocketClient(String url, boolean SSL)
    {
        this.url = url;
        secureSocketLayer = SSL;
    }
    
    @Override
    public void run()
    {
        while (running)
        {
            try
            {
                actionQueue.take().execute();
            }
            catch (InterruptedException ie)
            {

            }
        }
    }
    
    public void start()
    {
        if (thread == null)
        {
            if (websocket == null)
            {
                connect();
            }
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    
    public void stop()
    {
        if (thread != null)
        {
            if (websocket != null)
            {
                disconnect();
            }
            thread.interrupt();
            running = false;
            thread = null;
        }
    }
    
    public void connect()
    {
        if (websocket == null)
        {
            try
            {
                websocket = createConnection();
            }
//            catch (IOException | NoSuchAlgorithmException | WebSocketException e)
//            {
//                // TODO Handle exception
//                e.printStackTrace();
//            }
            catch (IOException ioe)
            {
                // TODO Handle exception
                ioe.printStackTrace();
            } 
            catch (NoSuchAlgorithmException nsae)
            {
                // TODO Handle exception
                nsae.printStackTrace();
            } catch (WebSocketException wse)
            {
                // TODO Handle exception
                wse.printStackTrace();
            }
        }
    }

    public void disconnect()
    {
        if (websocket != null)
        {
           websocket.disconnect("Client Disconnected");
           websocket = null;
        }
    }
    
    private WebSocket createConnection() throws IOException, NoSuchAlgorithmException, WebSocketException
    {
        WebSocketFactory wsf = new WebSocketFactory();
        if (secureSocketLayer)
        {
            // Used for testing so can use a self signed certificate
            //wsf.setSSLContext(NaiveSSLContext.getInstance("TLS"));
            wsf.setVerifyHostname(true);
        }
        return wsf.setConnectionTimeout(TIMEOUT)
           .createSocket("ws" + (secureSocketLayer ? "s" : "") + "://" + url)
           .addListener(new WebSocketAdapter()
           {
                
                @Override
                public void onTextMessage(WebSocket websocket, String message)
                {
                    recieveMessage(websocket, message);
                }
                
                @Override
                public void onConnected(WebSocket websocket, Map<String, List<String>> headers)
                {
                    connected(websocket, headers);
                }    
                
                @Override
                public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer)
                {
                    disconnected(websocket, serverCloseFrame, clientCloseFrame, closedByServer);
                }
                
           })
           .addExtension(WebSocketExtension.PERMESSAGE_DEFLATE)
           .connect();
    }
    
    private void connected(WebSocket websocket, Map<String, List<String>> headers)
    {
        System.out.println("[CONNECTION] Connected [Server: " + websocket.getSocket().getInetAddress() + ":" + websocket.getSocket().getPort() + "]");
    }
    
    public void disconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer)
    {
        System.out.println("[CONNECTION] Disconnected [Code: " + clientCloseFrame.getCloseCode() + "][Reason: " + clientCloseFrame.getCloseReason() + "]");
    }
    
    private void recieveMessage(WebSocket websocket, String message)
    {
        try
        {
            JsonObject jsonObject = Json.parse(message).asObject();
            String actionName = jsonObject.get("action").asString().toLowerCase();
            JsonObject actionProperties = null;
            try
            {
                actionProperties = jsonObject.get("properties").asObject();
            }
            catch (NullPointerException npe)
            {
            }
            actionQueue.add(Action.Create(actionName, actionProperties, websocket));
        }
        catch (ParseException pe)
        {
            System.out.println("Not Valid Json Format");
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
