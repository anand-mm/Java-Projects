import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HTTPURLConnectionExample {

    public static void main(String[] args) throws IOException {

        Map<String, Object> getresult = HttpGETMethod();
        System.out.println(getresult);
        Map<String,Object> postresult = HttpPOSTMethod(5, "Sai");
        System.out.println(postresult);

    }

    public static Map<String, Object> HttpGETMethod() throws IOException {
        Map<String, Object> resultmap = new HashMap<>();
        String url = "https://tntenders.gov.in/nicgep/app";
        URL apiURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
        connection.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Response from the HTTPURLConnection" + response.toString());
            resultmap.put("Result", response);
        } finally {
            connection.disconnect();
        }
        return resultmap;
    }

        public static Map<String, Object> HttpPOSTMethod(int id,String name) throws IOException {
        Map<String, Object> resultmap = new HashMap<>();
                String postData = "id="+id+"&name="+name;
        System.out.println(postData);
        String url = "http://localhost:8081/dora/postRequest";
        URL apiURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
            outputStream.write(postDataBytes);
            outputStream.close();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Response from the HTTPURLConnection" + response.toString());
            resultmap.put("Result", response);
        } finally {
            connection.disconnect();
        }
        return resultmap;
    }

}
