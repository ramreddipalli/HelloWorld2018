package com.hello;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ReceiveMessages {

    public static void receiveMessages() throws Exception {
        URL groupMeURL = new URL("https://api.groupme.com/v3/groups/44097445/messages?token=J2j1gvULxeVlhPo7axHTYGDUirPUQ7N6kGgtmcWI");
        HttpURLConnection connection = (HttpURLConnection) groupMeURL.openConnection();

        connection.setRequestMethod("GET");

        //sets parameters
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bot_id", Tyrone.botID);
        //parameters.put("before_id", );
        //parameters.put("since_id", ;
        //parameters.put("after_id", );
        //parameters.put("limit", ); //can put in limit as number of messages returned. max:100, default:20

        // Send parameters to GroupMe
        connection.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        connection.getInputStream();

        //String mostRecentMessage = "";
        //System.out.println();
    }
}