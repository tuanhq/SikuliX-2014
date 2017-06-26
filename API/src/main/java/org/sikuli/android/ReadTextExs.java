package org.sikuli.android;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.RunTime;
import org.sikuli.script.Screen;

public class ReadTextExs {
	public static void main(String[] args) throws FindFailed {
		RunTime.loadLibrary("libopencv_java248");
		RunTime.loadLibrary("VisionProxy");
		 Settings.OcrTextRead = true;
		 Settings.OcrTextSearch = true;
		 Screen scr = new Screen();
		 ADBScreen adbS = new ADBScreen("0123456789ABCDEF");
		 adbS.eventPressHardKey(13);
		// adbS.capture().save("C:\\tmp", "firmwareDetail");
		 
		// Match m= adbS.find("C:\\tmp\\firmware.jpg");
		 //adbS.findAllText(text)
		// Match m2 = adbS.find("Firmware");
		// System.out.println(m2.h+":"+m2.w+":"+m2.x+":"+m2.y);
		// m.saveScreenCapture("C:\\tmp", "FINDTEXT");
		 
		// Match m = adbS.find("C:\\tmp\\bluetooth.jpg");
		// m = adbS.find("");
		 //System.out.println("Match region have height:"+m.h+" weight:"+m.w+" X:"+m.x+" Y:"+m.y);
//		 System.out.println(m.readText());
//		 System.out.println(m.getScreen().getW()+":"+m.getScreen().getH());
		// m.right().saveScreenCapture("C:\\tmp", "RIGHTLANCUOCUNGI");
		//System.err.println(m.right().readText()); 
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

}
