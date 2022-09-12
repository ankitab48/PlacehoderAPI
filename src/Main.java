import java.io.IOException;

public class Main {

	public static void main(String[] args) { 
		ApiCall apicall = new ApiCall();
		try {
			apicall.posts();
		} catch (IOException | InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
