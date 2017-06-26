/*
 * Copyright (c) 2010-2017, sikuli.org, sikulix.com - MIT license
 */

package org.sikuli.ide;

import java.io.File;
import java.security.CodeSource;

import javax.swing.JOptionPane;

import org.sikuli.android.ADBScreen;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.RunTime;
import org.sikuli.script.Screen;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;



public class Sikulix {

	public static void main1(String[] args) {
		String jarName = "";

		CodeSource codeSrc = SikuliIDE.class.getProtectionDomain().getCodeSource();
		if (codeSrc != null && codeSrc.getLocation() != null) {
			jarName = codeSrc.getLocation().getPath();
		}

		if (jarName.contains("sikulixsetupIDE")) {
			JOptionPane.showMessageDialog(null, "Not useable!\nRun setup first!", "sikulixsetupIDE",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		// Screen.ignorePrimaryAtCapture = true;
		// Settings.TraceLogs = true;
		SikuliIDE.run(args);
	}

	public static void main(String[] args) throws FindFailed {
		
//		RunTime.loadLibrary("gsdll64");
//		RunTime.loadLibrary("libtesseract400");
//		RunTime.loadLibrary("liblept1742");
//		RunTime.loadLibrary("libopencv_java248");
//		RunTime.loadLibrary("VisionProxy");
//		System.out.println(ADBTest.class.getResource("/log4j.properties"));
//		System.out.println(ADBTest.class.getClassLoader().getResource("."));
//		System.err.println(net.sourceforge.tess4j.Tesseract.class.getResource("./"));
//		System.err.println(net.sourceforge.tess4j.Tesseract.class.getClassLoader().getResource("."));
		RunTime.loadLibrary("libopencv_java248");
		RunTime.loadLibrary("VisionProxy");
		 Settings.OcrTextRead = true;
		 Settings.OcrTextSearch = true;
		 Screen scr = new Screen();
		 ADBScreen adbS = new ADBScreen("0123456789ABCDEF");
		// adbS.capture().save("C:\\tmp", "firmwareDetail");
		 
		 Match m= adbS.find("C:\\tmp\\firmware.jpg");
		 //adbS.findAllText(text)
		// Match m2 = adbS.find("Firmware");
		// System.out.println(m2.h+":"+m2.w+":"+m2.x+":"+m2.y);
		// m.saveScreenCapture("C:\\tmp", "FINDTEXT");
		 
		// Match m = adbS.find("C:\\tmp\\bluetooth.jpg");
		// m = adbS.find("");
		 System.out.println("Match region have height:"+m.h+" weight:"+m.w+" X:"+m.x+" Y:"+m.y);
//		 System.out.println(m.readText());
//		 System.out.println(m.getScreen().getW()+":"+m.getScreen().getH());
		 m.right().saveScreenCapture("C:\\tmp", "RIGHTLANCUOCUNGI");
		 System.err.println(m.right(500).readText());
//		 System.out.println("Match region have height:"+m1.h+" weight:"+m1.w+" X:"+m1.x+" Y:"+m1.y);
//		 m.getScreen().capture(new Rectangle(245, 102, 550, 52)).save("C:\\tmp", "RIGHTLANCUOI");
		 
		// m.getScreen().capture(m1).save("C:\\tmp", "RIGHTLANCUOI");
		// Region r = adbS.setROI(X, Y, W, H);
		// System.err.println(m1.readText());
		// m1.saveScreenCapture("C:\\tmp", "screenRIGHT");
		 
		// Region m2 = new Region(374,174,400,53,m.getScreen());
		// m2.saveScreenCapture("C:\\tmp", "RIGHT");
//		 System.out.println(m1.h+":"+m1.w+":"+m1.x+":"+m1.y);
//		 m.right().saveScreenCapture("C:\\tmp", "right");
//		 System.out.println( m.right().readText());
		// System.out.println( m.below().readText());
		// m.getScreen().capture(m2).save("C:\\tmp", "RIGHTAVX");

		// ********* playground
	}

	public static void main3(String[] args) {
		// System.loadLibrary("VisionProxy");
		RunTime.loadLibrary("libopencv_java248");
		RunTime.loadLibrary("VisionProxy");
		
		// System.out.println(System.getProperty("java.library.path"));
		// ADBScreen adb = new ADBScreen("4b133ee0e814924e");
		 Settings.OcrTextRead = true;
		 Settings.OcrTextSearch = true;
		 
		 Screen scr = new Screen();
		 try {
		// adb.aTap("C:\\tmp\\menu.jpg");
		// Match m = adb.find("C:\\tmp\\menu.jpg");
		 Match m = scr.find("C:\\tmp\\hello.jpg");
		 System.out.println("TEXT:"+m.text());
		
		 System.out.println(m.getX()+":"+m.getY()+":"+m.getH()+":"+m.getW());
		 } catch (FindFailed e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

//		File imageFile = new File("C:\\tmp\\abc-1496978303687.png");
//		Tesseract instance = Tesseract.getInstance(); // JNA Interface Mapping
//		instance.setLanguage("eng");
//		try {
//			String result = instance.doOCR(imageFile);
//			System.out.println(result);
//		} catch (TesseractException e) {
//			System.err.println(e.getMessage());
//		}

		// try {
		// adb.aTap("C:\\tmp\\menu.jpg");
		//// Match m = adb.find("C:\\tmp\\menu.jpg");
		//// System.out.println(m.getX()+":"+m.getY()+":"+m.getH()+":"+m.getW());
		// } catch (FindFailed e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// Screen scr = new Screen();
		// try {
		// Pattern pt = new Pattern("C:\\tmp\\Computer.jpg");
		//
		// scr.doubleClick("C:\\tmp\\Computer.jpg");
		// } catch (FindFailed e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		/*
		 * ADBScreen adb1 = new ADBScreen("4d000b1448084069");
		 * System.out.println(System.getProperty("java.library.path"));
		 * adb.aKey(ADBDevice.KEY_HOME); adb1.aKey(ADBDevice.KEY_HOME); adb1.aKey(24);
		 * adb.aKey(24);
		 * 
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * adb.aKey(ADBDevice.KEY_HOME); adb1.aKey(ADBDevice.KEY_HOME); adb1.aKey(24);
		 * adb.aKey(24);
		 * 
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * adb.aKey(ADBDevice.KEY_HOME); adb1.aKey(ADBDevice.KEY_HOME); adb1.aKey(24);
		 * adb.aKey(24);
		 * 
		 * 
		 * adb.capture().save("C:\\tmp","adb"); adb1.capture().save("C:\\tmp","adb1");
		 */

	}
}
