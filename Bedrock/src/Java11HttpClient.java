import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Java11HttpClient {
    //private static final String ENDPOINT = "https://cat-fact.herokuapp.com/facts";
    private static final String ENDPOINT = "https://postman-echo.com/get";

    public static void main(String[] args) throws Exception {
        /*
        New JDK internal client
         */
        var newHttpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.of(30, ChronoUnit.SECONDS))
                .build();
        var newHttpRequest = HttpRequest.newBuilder()
                .uri(new URI(ENDPOINT))
                .header("header1", "value1")
                .GET()
                .build();
        var newHttpResponse = newHttpClient.send(newHttpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + newHttpResponse);
        System.out.println("Response Body: " + newHttpResponse.body());
    }
}
