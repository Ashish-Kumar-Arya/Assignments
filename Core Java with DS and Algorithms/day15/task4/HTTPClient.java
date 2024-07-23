package assignments.day15.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HTTPClient {
    public static void main(String[] args) throws IOException {
        String urlString="https://www.google.com/";
        URL url=new URL(urlString);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode=connection.getResponseCode();
        System.out.println("Response code: "+responseCode);

        //Get response headers
        Map<String, List<String>> headers=connection.getHeaderFields();
        for(Entry<String, List<String>>  entry: headers.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        
        //Get the response body
        BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder reponse=new StringBuilder();
        while((inputLine=in.readLine())!=null) {
            reponse.append(inputLine).append("\n");
        }
        in.close();
        System.out.println("Response Body:");
        System.out.println(reponse.toString());
    }
}
