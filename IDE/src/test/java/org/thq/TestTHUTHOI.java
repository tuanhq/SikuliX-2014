package org.thq;

import org.sikuli.android.ADBDevice;
import org.sikuli.android.ADBScreen;

public class TestTHUTHOI {
	public static void main1(String[] args) {
		ADBScreen adb = new ADBScreen("4b133ee0e814924e");
		adb.aKey(ADBDevice.KEY_HOME);
	}

}
