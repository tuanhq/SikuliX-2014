package org.sikuli.weston;
import org.junit.Test;

public class TestSSHClient {
	@Test
	public void testSsh() {
		try {
//			Shell shell = new SSHByPassword("192.168.1.2", 22, "root", null);
//			String stdout = new Shell.Plain(shell).exec("export XDG_RUNTIME_DIR=/run/user/root && weston-info");
//			//new Shell.
//			System.out.println(stdout);
//			
			
			String localPath = "C:/tmp/trang/";
			String remotePath = "/home/root/abc/";
			FTPExample ftp = new FTPExample("192.168.1.2", 22, "root", null);
			
			//FTPExample ftp = new FTPExample("192.168.1.2", 22, "root", null);
			
			//ftp.upload(localPath+"filetoupload.txt", remotePath);
			
			ftp.download(remotePath+"wayland-screenshot.png", localPath);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}
