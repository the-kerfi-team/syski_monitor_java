package uk.co.syski.client.Action.Generic;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.co.syski.client.Action.Action;
import uk.co.syski.client.Configuration.SystemConfiguration;
import uk.co.syski.client.Configuration.ConfigurationLoader;
import uk.co.syski.client.Collection.Windows.Variable.Component.*;

public class ActionAUTHENTICATION extends Action
{
    public ActionAUTHENTICATION(WebSocket websocket, JsonObject properties)
    {
        super(websocket, properties);
    }

    @Override
    public void execute()
    {
        if (properties == null || properties.isEmpty())
        {
            System.out.println("[ACTION] - Authentication");
            if (SystemConfiguration.getSystemId().isEmpty() || SystemConfiguration.getSystemSecret().isEmpty())
            {
                // Check if system key and secret are empty
                Console console = System.console();
                String username = null;
                char password[] = null;
                if (console == null) {
                    //System.out.println("Couldn't get Console instance");
                    //System.exit(0);
                    System.out.println("Insecure Password Input!");
                    System.out.println("Insecure Password Will Be Shown in the Console");
                    Scanner scanner = new Scanner(System.in);
                    while (username == null || username.isEmpty())
                    {
                        System.out.print("Email: ");
                        username = scanner.nextLine();
                    }
                    while (password == null || password.length <= 6)
                    {
                        System.out.print("Password: ");
                        password = scanner.nextLine().toCharArray();
                    }
                }
                else
                {
                    while (username == null || username.isEmpty())
                    {
                        username = console.readLine("Email: ");
                    }
                    while (password == null || password.length <= 6)
                    {
                        password = console.readPassword("Password: ");
                    }
                }
                JsonObject json = Json.object()
                                      .add("action", "user-authentication")
                                      .add("properties", Json.object()
                                            .add("email", username)
                                            .add("password", String.valueOf(password)));
                websocket.sendText(json.toString());
            }
            else
            {
                JsonObject json = Json.object()
                                      .add("action", "system-authentication")
                                      .add("properties", Json.object()
                                            .add("system", SystemConfiguration.getSystemId())
                                            .add("secret", SystemConfiguration.getSystemSecret()));
                websocket.sendText(json.toString());
            }
        }
        else
        {
            try {
                SystemConfiguration.setSystemId(properties.getString("system", ""));
                SystemConfiguration.setSystemSecret(properties.getString("secret", ""));
                ConfigurationLoader.save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            CPUVariableCollection.startThreads(0);
            NetworkVariableCollection.startThreads(0);
            RAMVariableCollection.startThreads();
            StorageVariableCollection.startThreads(0);
        }
    }
}
