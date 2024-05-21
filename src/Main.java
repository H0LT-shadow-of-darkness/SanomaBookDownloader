import java.io.IOException;
import java.net.URISyntaxException;

import com.itextpdf.text.DocumentException;

public class Main {

	public static void main(String[] args) throws URISyntaxException, IOException, DocumentException {
		
		String url1="https://d38l3k3yaet8r2.cloudfront.net/resources/products/epubs/generated/"+"CHANGE THIS WITH TEH UUID OF YOUR BOOK'S LINK"+"/foxit-assets/pages/page";
		String url2="?password=&accessToken=null&formMode=true";
		int pagine = 0; //number of pages (find this in the last page's link)
		String titolo = ""; //choose a title for your pdf book
		new Book_Downloader(url1,url2,pagine,titolo);

	}

}
