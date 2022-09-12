import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {
	private HttpRequest request;
	private HttpClient client;
	
	
	public HttpResponse<String> getResponse(String url) throws IOException, InterruptedException{
		
		request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		client = HttpClient.newBuilder().build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response;	
	}
}
