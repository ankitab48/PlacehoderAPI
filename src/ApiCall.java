import java.io.IOException;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;  

public class ApiCall {
	Http http;	
	String url;
	
	public ApiCall(){
		http = new Http();
		url = "https://jsonplaceholder.typicode.com";
		
//		try {
//			getTodoById(3);
//			
//		} catch (IOException | InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
	
	public void getTodoById(int id) throws IOException, InterruptedException {
		String newUrl = url + "/todos/" + id;
		HttpResponse<String> response = http.getResponse(newUrl);
		System.out.println(response.statusCode());
		System.out.println(response.body());
	}
	
	public void getPostsById(int id) throws IOException, InterruptedException {
		String newUrl = url + "/posts/" + id;
		HttpResponse<String> response = http.getResponse(newUrl);
		System.out.println(response.body());
	}
	
	public void posts() throws IOException, InterruptedException {
		String newUrl = url + "/posts";
		HttpResponse<String> response = http.getResponse(newUrl);
		String str = response.body();
		
		JSONArray array = new JSONArray(str); 
		for(int i=0; i<6; i++) {
//			JSONObject object = array.getJSONObject(i);  
			System.out.println(array.get(i));
		}
	}
	
	
	
}
