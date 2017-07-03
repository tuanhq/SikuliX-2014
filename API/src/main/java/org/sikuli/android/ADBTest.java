/*
 * Copyright (c) 2010-2017, sikuli.org, sikulix.com - MIT license
 */

package org.sikuli.android;

import java.awt.Rectangle;
import java.io.File;
import java.util.Date;

import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Image;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.RunTime;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
import org.sikuli.script.Sikulix;

import net.sourceforge.tess4j.ITessAPI.TessPageIteratorLevel;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * Created by RaiMan on 12.07.16.
 * <p>
 * Test for the basic ADB based features
 */
public class ADBTest {

	private static int lvl = 3;

	private static void log(int level, String message, Object... args) {
		Debug.logx(level, "ADBDevice: " + message, args);
	}

	private static void logp(String message, Object... args) {
		System.out.println(String.format(message, args));
	}

	private static RunTime rt = null;
	private static boolean runTests = true;

	public static void main(String[] args)   {

//		System.out.println(ADBTest.class.getResource("/log4j.properties"));
//		System.out.println(ADBTest.class.getClassLoader().getResource("."));
//		System.err.println(net.sourceforge.tess4j.Tesseract.class.getResource("./"));
//		System.err.println(net.sourceforge.tess4j.Tesseract.class.getClassLoader().getResource("."));
		RunTime.loadLibrary("libopencv_java248");
		RunTime.loadLibrary("VisionProxy");
		 Settings.OcrTextRead = true;
		 Settings.OcrTextSearch = true;
		// Screen scr = new Screen();
		 ADBScreen adbS = new ADBScreen("0123456789ABCDEF");
		 adbS.capture().save("C:\\tmp", "ANDROI");
		 adbS.aTapWord("Connection");
		 
		// Match m1 = adbS.getMatchByText("Clock",1,TessPageIteratorLevel.RIL_WORD);
		// m1.saveScreenCapture("C:\\tmp", "HILLO");
//		 Region m2 = m1.right();
//		 m2.saveScreenCapture("C:\\tmp", "HELLO");
//		 String str = m2.readText();
//		 System.err.println(str);
		 
		// System.out.println(adbS.getMatchByText("Firmware").right().readText());
		// adbS.capture().save("C:\\tmp", "firmwareDetail");
		 //adbS.findTextLine("System");
		// for(int i = 0;i <10 ;i++) {
//			 Date date1 = new Date();
//			 System.err.println("start project:"+date1.getTime());
//			 try {
//				adbS.aSwipeDownFrom("C:\\Users\\tuanhq\\projects\\java\\SikuliX-2014\\HUAutomation\\Images\\Settings\\Scroolbar.png");
//			} catch (FindFailed e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 Date date2 = new Date();
//			 System.err.println("end project:"+date2.getTime());
//			 System.out.println(date2.getTime() - date1.getTime());
		 
//		  try {
//			adbS.eventLongPress("C:/Users/tuanhq/projects/java/SikuliX-2014/HUAutomation/Images/Settings/FirmwareTitle/FirmwareTitle2.png", 4000);
//		} catch (FindFailed e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// }
		// adbS.aSwipeDownFrom("C:\\Users\\tuanhq\\projects\\java\\SikuliX-2014\\HUAutomation\\Images\\Settings\\Scroolbar.png");
			 
		 
//		 File file = new File("C:\\Users\\tuanhq\\projects\\java\\SikuliX-2014\\HUAutomation\\Images\\Settings\\AVAppIcon2.png");
//		 System.err.println(file.getName()+file.getAbsolutePath());
		// adbS.aTapCollection("C:\\Users\\tuanhq\\projects\\java\\SikuliX-2014\\HUAutomation\\Images\\Settings\\SettingBTN");
		// adbS.aTap("C:\\Users\\tuanhq\\projects\\java\\SikuliX-2014\\HUAutomation\\Images\\Settings\\AVAppIcon2.png");
		// adbS.capture().save("C:\\tmp", "firmwareDetail");
	//	 adbS.capture().save("C:\\tmp", "AVAppIcon");
		 
		// Match m= adbS.find("C:\\tmp\\firmware.jpg");
		 //adbS.findAllText(text)
		// Match m2 = adbS.find("Firmware");
		// System.out.println(m2.h+":"+m2.w+":"+m2.x+":"+m2.y);
		// m.saveScreenCapture("C:\\tmp", "FINDTEXT");
		 
		// Match m = adbS.find("C:\\tmp\\bluetooth.jpg");
		// m = adbS.find("");
		// System.out.println("Match region have height:"+m.h+" weight:"+m.w+" X:"+m.x+" Y:"+m.y);
//		 System.out.println(m.readText());
//		 System.out.println(m.getScreen().getW()+":"+m.getScreen().getH());
		// m.right().saveScreenCapture("C:\\tmp", "RIGHTLANCUOCUNGI");
		//System.err.println(m.right(400).readText()); 
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

	private static ADBScreen startTest() {
		Debug.on(3);
		rt = RunTime.get();
		ADBScreen adbs = new ADBScreen();
		if (adbs.isValid()) {
			adbs.wakeUp(2);
			adbs.wait(1f);
			if (runTests) {
				adbs.aKey(ADBDevice.KEY_HOME);
				adbs.wait(1f);
			}
		}
		return adbs;
	}

	private static void basicTest(ADBScreen adbs) throws FindFailed {
		log(lvl, "**************** running basic test");
		adbs.aSwipeLeft();
		adbs.aSwipeRight();
		adbs.wait(1f);
		ScreenImage sIMg = adbs.userCapture("Android");
		sIMg.save(RunTime.get().fSikulixStore.getAbsolutePath(), "android");
		adbs.aTap(new Image(sIMg));
	}

	/**
	 * used in SikuliIDE menu tool to run a test against an attached device
	 *
	 * @param aScr
	 */
	public static void ideTest(ADBScreen aScr) {
		String title = "Android Support - Testing device";
		Sikulix.popup("Take care\n\nthat device is on and unlocked\n\nbefore clicking ok", title);
		aScr.wakeUp(2);
		aScr.aKey(ADBDevice.KEY_HOME);
		if (Sikulix.popAsk(
				"Now the device should show the HOME screen.\n"
						+ "\nclick YES to proceed watching the test on the device" + "\nclick NO to end the test now",
				title)) {
			aScr.aSwipeLeft();
			aScr.aSwipeRight();
			aScr.wait(1f);
			if (Sikulix.popAsk("You should have seen a swipe left and a swipe right.\n"
					+ "\nclick YES to capture an icon from homescreen and then aTap it"
					+ "\nclick NO to end the test now", title)) {
				ScreenImage sIMg = aScr.userCapture("AndroidTest");
				sIMg.save(RunTime.get().fSikulixStore.getAbsolutePath(), "android");
				try {
					aScr.aTap(new Image(sIMg));
					Sikulix.popup("The image was found on the device's current screen"
							+ "\nand should have been tapped.\n" + "\nIf you think it worked, you can now try\n"
							+ "to capture needed images from the device.\n"
							+ "\nYou have to come back here and click Default!", title);
				} catch (FindFailed findFailed) {
					Sikulix.popError("Sorry, the image you captured was\nnot found on the device's current screen",
							title);
				}
			}
		}
	}

}
