package org.sikuli.weston;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.sikuli.basics.Debug;
import org.sikuli.script.ScreenImage;
import org.sikuli.util.PropertiesUtil;

import se.vidstige.jadb.JadbException;

public class WestonDevice {
	private SSHClient sshClient;
	private static WestonDevice instance = null;
	public int waitAfterAction = 1;
	private int devW = -1;
	private int devH = -1;
	private WestonDevice(String host, int port, String user, String password) {
		// TODO Auto-generated constructor stub
		sshClient = SSHClient.getInstance(host, port, user, password);
	}
	public static WestonDevice getInstance(String host, int port, String user, String password) {
		if (instance == null) {
			instance = new WestonDevice(host, port, user, password);
		}
		return instance;
	}
	public Rectangle getBound() {
		Rectangle rect = new Rectangle(0, 0, 1920, 720);
		return rect;
	}
	private ScreenImage captureScreen() {
		return captureScreen(0,0, -1,-1);
	}
	public void tap(int x, int y) {
		String executeCommand = PropertiesUtil.getProperties("westonTap","/home/root/HUAutomation/westonClient click XXX YYY"); 
		executeCommand = executeCommand.replace("XXX", String.valueOf(x));
		executeCommand = executeCommand.replace("YYY", String.valueOf(y));
		sshClient.execCmd(executeCommand);
	}
	public void swipe(int x1, int y1, int x2, int y2) {
		String executeCommand = PropertiesUtil.getProperties("westonSwipe","/home/root/HUAutomation/westonClient drag XXX1 YYY1 XXX2 YYY2"); 
		executeCommand = executeCommand.replace("XXX1", String.valueOf(x1));
		executeCommand = executeCommand.replace("YYY1", String.valueOf(y1));
		executeCommand = executeCommand.replace("XXX2", String.valueOf(x2));
		executeCommand = executeCommand.replace("YYY2", String.valueOf(y2));
		sshClient.execCmd(executeCommand);
	}
	public void exeCmd(String cmd) {
		sshClient.execCmd(cmd);
	}
	public ScreenImage captureScreen(int x, int y, int width, int height) {
		BufferedImage img = null;	
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String strDate = sdf.format(date1);
		String executeCommand = PropertiesUtil.getProperties("capture","export XDG_RUNTIME_DIR=/run/user/root && /usr/libexec/weston-screenshooter /tmp/HUScreen.png");
		System.out.println(executeCommand);
		sshClient.execCmd(executeCommand);
		String localFile = System.getProperty("java.io.tmpdir")+"HUScreen.png";
		String remoteFile = "/tmp/HUScreen.png";
		sshClient.scpFrom(localFile, remoteFile);
		try {
			//Image in = Toolkit.getDefaultToolkit().getImage(localFile);//.createImage(localFile);
			BufferedImage orgImag = ImageIO.read(new File(localFile));
			// BufferedImage out = new BufferedImage(in.getWidth(null), in.getHeight(null), BufferedImage.TYPE_INT_RGB);
		    
		    if(width > 0 && height > 0) {
		      img = orgImag.getSubimage(x, y, width, height);
		    }else {
		    	img = orgImag;
		    }
		    ScreenImage scr = new ScreenImage(getBound(), img);
		    return scr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public void release() {
		sshClient.close();
	}
	
	/*
	public Mat captureDeviceScreenMat(int x, int y, int actW, int actH) {
		byte[] imagePrefix = new byte[12];
		byte[] image = new byte[0];
		Debug timer = Debug.startTimer();
		boolean isfullScreen = false;
		if (x == 0 && y == 0 && actW < 0 && actH < 0) {
			isfullScreen = true;
		}
		try {
			InputStream stdout = device.executeShell("screencap");
			stdout.read(imagePrefix);
			if (imagePrefix[8] != 0x01) {
				log(-1, "captureDeviceScreenMat: image type not RGBA");
				return null;
			}
			int currentW = byte2int(imagePrefix, 0, 4);
			int currentH = byte2int(imagePrefix, 4, 4);
			if (!((currentW == devW && currentH == devH) || (currentH == devW && currentW == devH))) {
				log(-1, "captureDeviceScreenMat: width or height differ from device values");
				return null;
			}
			if (isfullScreen) {
				actW = currentW;
				actH = currentH;
			} else {
				if (x + actW > currentW) {
					actW = currentW - x;
				}
				if (y + actH > currentH) {
					actH = currentH - y;
				}
			}
			image = new byte[actW * actH * 4];
			int lenRow = currentW * 4;
			byte[] row = new byte[lenRow];
			for (int count = 0; count < y; count++) {
				stdout.read(row);
			}
			boolean shortRow = x + actW < currentW;
			for (int count = 0; count < actH; count++) {
				if (shortRow) {
					stdout.read(row);
					System.arraycopy(row, x * 4, image, count * actW * 4, actW * 4);
				} else {
					stdout.read(image, count * actW * 4, actW * 4);
				}
			}
			long duration = timer.end();
			log(lvl, "captureDeviceScreenMat:[%d,%d %dx%d] %d", x, y, actW, actH, duration);
		} catch (IOException | JadbException e) {
			log(-1, "captureDeviceScreenMat: [%d,%d %dx%d] %s", x, y, actW, actH, e);
		}
		Mat matOrg = new Mat(actH, actW, CvType.CV_8UC4);
		matOrg.put(0, 0, image);
		Mat matImage = new Mat();
		Imgproc.cvtColor(matOrg, matImage, Imgproc.COLOR_RGBA2BGR, 3);
		return matImage;
	}
	*/

}
