package org.sikuli.weston;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class FTPExample {
	
	private String host;
	private Integer port;
	private String user;
	private String password;
	
	private JSch jsch;
	private Session session;
	private Channel channel;
	private ChannelSftp sftpChannel;
	
	public FTPExample(String host, Integer port, String user, String password) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
	}

	public void connect() {
		
		System.out.println("connecting..."+host);
		try {
			jsch = new JSch();
			session = jsch.getSession(user, host,port);
			//session.setConfig("StrictHostKeyChecking", "no");
			JSch.setConfig("StrictHostKeyChecking", "no");
          //  JSch.setLogger(new JschLogger());
			session.setPassword(password);
			session.connect();

			
			
			channel = session.openChannel("sftp");
			sftpChannel = (ChannelSftp) channel;
			sftpChannel.connect();
			

		} catch (JSchException e) {
			e.printStackTrace();
		}

	}
	
	public void disconnect() {
		System.out.println("disconnecting...");
		sftpChannel.disconnect();
		channel.disconnect();
		session.disconnect();
	}
	
	public void upload(String fileName, String remoteDir) {

		FileInputStream fis = null;
		connect();
		try {
			// Change to output directory
			sftpChannel.cd(remoteDir);

			// Upload file
			File file = new File(fileName);
			fis = new FileInputStream(file);
			sftpChannel.put(fis, file.getName());

			fis.close();
			System.out.println("File uploaded successfully - "+ file.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}
		disconnect();
	}
	
	public void download(String fileName, String localDir) {

		byte[] buffer = new byte[1024];
		BufferedInputStream bis;
		connect();
		try {
			// Change to output directory
			String cdDir = fileName.substring(0, fileName.lastIndexOf("/") + 1);
			sftpChannel.cd(cdDir);

			File file = new File(fileName);
			bis = new BufferedInputStream(sftpChannel.get(file.getName()));

			File newFile = new File(localDir + "/" + file.getName());
			
			// Download file
			OutputStream os = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			int readCount;
			while ((readCount = bis.read(buffer)) > 0) {
				bos.write(buffer, 0, readCount);
			}
			bis.close();
			bos.close();
			System.out.println("File downloaded successfully - "+ file.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}
		disconnect();
	}

	public static void main(String[] args) {
		
		
		String localPath = "C:/temp/";
		String remotePath = "/export/home/madan/";
		
		FTPExample ftp = new FTPExample("10.100.12.14", 2222, "madan", "password");
		
		ftp.upload(localPath+"filetoupload.txt", remotePath);
		
		ftp.download(remotePath+"filetodownload.txt", localPath);

	}

}
