package org.sikuli.weston;

import java.awt.Rectangle;

import org.sikuli.script.FindFailed;
import org.sikuli.script.IRobot;
import org.sikuli.script.IScreen;
import org.sikuli.script.Location;
import org.sikuli.script.Region;
import org.sikuli.script.RunTime;
import org.sikuli.script.ScreenImage;

public class WestonScreen extends Region implements IScreen {
	private WestonDevice westonDevice;
	// private final IRobot robot;
	private ScreenImage lastScreenImage;
	public int waitAfterAction = 1;

	public WestonScreen(String host, int port, String user, String password) {
		// TODO Auto-generated constructor stub
		super();
		setOtherScreen(this);
		westonDevice = WestonDevice.getInstance(host, port, user, password);
		Rectangle bounds = westonDevice.getBound();
	     w = bounds.width;
	     h = bounds.height;
	}

	public WestonDevice getWestonDevice() {
		return this.westonDevice;
	}

	@Override
	public IRobot getRobot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return westonDevice.getBound();
	}

	@Override
	public ScreenImage capture() {
		// TODO Auto-generated method stub
		return capture(0, 0, -1, -1);
	}

	@Override
	public ScreenImage capture(int x, int y, int w, int h) {
		// TODO Auto-generated method stub
		ScreenImage img = westonDevice.captureScreen(x, y, w, h);
		lastScreenImage = img;
		return img;
	}

	@Override
	public IScreen getScreen() {
		return this;
	}

	@Override
	public ScreenImage capture(Rectangle rect) {
		// TODO Auto-generated method stub
		return capture(rect.x, rect.y, rect.width, rect.height);
	}

	@Override
	public ScreenImage capture(Region reg) {
		// TODO Auto-generated method stub
		return capture(reg.x, reg.y, reg.w, reg.h);
	}

	@Override
	public void showTarget(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ScreenImage getLastScreenImageFromScreen() {
		// TODO Auto-generated method stub
		return lastScreenImage;
	}

	@Override
	public ScreenImage userCapture(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIdFromPoint(int srcx, int srcy) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void release() {
		westonDevice.release();
	}

	public <PFRML> void aTap2(PFRML target) throws FindFailed {
		try {
			Location loc = getLocationFromTarget(target);
			
			if (loc != null) {
				System.err.println("loc.x:"+ loc.x+ "loc.y:"+loc.y);
				westonDevice.tap(loc.x, loc.y);
				RunTime.pause(westonDevice.waitAfterAction);
			}else {
				System.err.println("Loc null roi");
			}
			
		} catch (Exception e) {
			System.err.println("Have error when getlocaltion");
			e.printStackTrace();
		}

	}

}
