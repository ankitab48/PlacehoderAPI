import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CliParameters {

	public static void main(String[] args) {
		CommandLineParser parser = new DefaultParser();
		Options options = new Options();
		
		options.addOption("posts", false, "Show 10 posts");
		options.addOption("post", true, "Show post by id");
		options.addOption("h", "help", false, "Shows help");
		
		
		try {
			CommandLine cmdLine = parser.parse(options, args);
			
			if(cmdLine.hasOption("h")) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("Command Line Parameters", options);
			}
			
			ApiCall apicall = new ApiCall();
			
//			show 10 posts
			if(cmdLine.hasOption("posts")) {
				apicall.posts();
			}
			
//			show post by id
			if(cmdLine.hasOption("post")) {
				String res = cmdLine.getOptionValue("post");
				apicall.getPostsById(Integer.parseInt(res));
			}
			
			
		} catch (ParseException | IOException | InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
