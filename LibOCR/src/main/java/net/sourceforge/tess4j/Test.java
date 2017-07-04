package net.sourceforge.tess4j;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		String datapath = "C:\\Users\\tuanhq\\projects\\java\\SikuliX-2014\\tess4j\\target\\classes";
		
		String testResourcesDataPath = "src/test/resources/test-data";
		ITesseract instance;
		instance = new Tesseract();
		//new File(datapath).getPath()
		//instance.setDatapath(datapath);
		
		File imageFile = new File(testResourcesDataPath, "eurotext.png");
		
		String expResult = "The (quick) [brown] {fox} jumps!\nOver the $43,456.78 <lazy> #90 dog";
		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
