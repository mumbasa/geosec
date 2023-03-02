package com.security.guard.securitygaurdadmin.helpers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.security.guard.securitygaurdadmin.models.AdminUser;
import com.security.guard.securitygaurdadmin.models.Client;
import com.security.guard.securitygaurdadmin.models.Guard;
import com.security.guard.securitygaurdadmin.models.Supervisor;


@Component
public class Utilities {
	@Value("${file.upload-dir}")
	String attachmentFolder;
	
	public boolean getSimImage(Guard requester) {
		String[] strings = requester.getPicture().split(",");
		String extension;
		switch (strings[0]) {// check image's extension
		case "data:image/jpeg;base64":
			extension = ".jpeg";
			break;
		case "data:image/png;base64":
			extension = ".png";
			break;
		default:// should write cases for more images types
			extension = ".jpg";
			break;
		}
		// convert base64 string to binary data
		byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);

		String fname =(System.currentTimeMillis() + extension);

		String path = attachmentFolder + fname;
		File file = new File(path);
		try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
			outputStream.write(data);
			requester.setPicture(fname);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	
	public boolean getSimImage(Client requester) {
		String[] strings = requester.getPicture().split(",");
		String extension;
		switch (strings[0]) {// check image's extension
		case "data:image/jpeg;base64":
			extension = ".jpeg";
			break;
		case "data:image/png;base64":
			extension = ".png";
			break;
		default:// should write cases for more images types
			extension = ".jpg";
			break;
		}
		// convert base64 string to binary data
		byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);

		String fname =(System.currentTimeMillis() + extension);

		String path = attachmentFolder + fname;
		File file = new File(path);
		try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
			outputStream.write(data);
			requester.setPicture(fname);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	
	
	public boolean getSimImage(Supervisor requester) {
		String[] strings = requester.getPicture().split(",");
		String extension;
		switch (strings[0]) {// check image's extension
		case "data:image/jpeg;base64":
			extension = ".jpeg";
			break;
		case "data:image/png;base64":
			extension = ".png";
			break;
		default:// should write cases for more images types
			extension = ".jpg";
			break;
		}
		// convert base64 string to binary data
		byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);

		String fname =(System.currentTimeMillis() + extension);

		String path = attachmentFolder + fname;
		File file = new File(path);
		try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
			outputStream.write(data);
			requester.setPicture(fname);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean getSimImage(AdminUser requester) {
		String[] strings = requester.getPicture().split(",");
		String extension;
		switch (strings[0]) {// check image's extension
		case "data:image/jpeg;base64":
			extension = ".jpeg";
			break;
		case "data:image/png;base64":
			extension = ".png";
			break;
		default:// should write cases for more images types
			extension = ".jpg";
			break;
		}
		// convert base64 string to binary data
		byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);

		String fname =(System.currentTimeMillis() + extension);

		String path = attachmentFolder + fname;
		File file = new File(path);
		try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
			outputStream.write(data);
			requester.setPicture(fname);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

}
