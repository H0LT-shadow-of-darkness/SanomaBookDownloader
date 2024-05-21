import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class Book_Downloader {
	
	public Book_Downloader(String url1, String url2, int index, String titolo) throws URISyntaxException, IOException, DocumentException {
		download(url1,url2,index);
		convertPDF(index, titolo);
		deleteImg(index);
	}
	private void printStatus(int index, int i) {
		int barra = (int) Math.ceil(index/100);
		if(i%barra==0) {
			System.out.print("-");
		}
	}
	private void deleteImg(int index) {
		System.out.println("Eliminazione immagini in corso");
		File img;
		for(int i=0;i<index;i++) {
			img= new File("data/page"+i+".jpg"); 
			img.delete();
			printStatus(index, i);
		}
		System.out.println("Eliminazione immagini completato");
	}
	private void convertPDF(int index, String titolo) throws MalformedURLException, IOException, DocumentException {
		System.out.println("Creazione pdf in corso");
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("data/"+titolo+".pdf"));
		document.open();
		Image img;
		float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
		float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
		for(int i=0;i<index;i++) {
			img = Image.getInstance("data/page"+i+".jpg");
			img.scaleAbsolute(documentWidth, documentHeight);
			document.add(img);
			printStatus(index, i);
		}
		document.close();
		System.out.println("Creazione pdf completata");

	}
	private void download(String url1, String url2, int index) throws IOException, URISyntaxException {
		System.out.println("Download risorse in corso");
		String uri;
		URL url;
		File file;
		for(int i=0;i<index;i++) {
			uri = url1+i+url2;
			url = new URI(uri).toURL();	
			file = new File("data/page"+i+".jpg");
			FileUtils.copyURLToFile(url, file);
			printStatus(index, i);
		}
		System.out.println("Download risorse completato");
	}
}
