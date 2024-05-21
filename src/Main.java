import java.io.IOException;
import java.net.URISyntaxException;

import com.itextpdf.text.DocumentException;

public class Main {

	public static void main(String[] args) throws URISyntaxException, IOException, DocumentException {
		
		String url1="https://d38l3k3yaet8r2.cloudfront.net/resources/products/epubs/generated/"+"77FDB511-4AAA-478D-8C56-B661675CD049"+"/foxit-assets/pages/page";
		String url2="?password=&accessToken=null&formMode=true";
		int pagine = 0;
		String titolo = "";
		new Book_Downloader(url1,url2,pagine,titolo);

	}

}
