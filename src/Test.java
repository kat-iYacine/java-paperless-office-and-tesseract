
import java.awt.Rectangle;
import java.io.File;

import javax.xml.stream.events.StartDocument;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Test {

	public static void recon(int x,int y, int w, int h,String path) throws TesseractException {
		String dataPath = "/usr/share/tesseract-ocr";
		File f = new File(path); 
		Rectangle rect = new Rectangle(x, y, w, h);
		
		Tesseract tess = new Tesseract();
		tess.setDatapath(dataPath);
		tess.setLanguage("eng");
			
		String result = tess.doOCR(f,rect);
		System.out.println(result);
	}

}