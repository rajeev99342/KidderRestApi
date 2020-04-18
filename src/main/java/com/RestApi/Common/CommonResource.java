package com.RestApi.Common;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import javax.xml.bind.DatatypeConverter;

public class CommonResource {
	@SuppressWarnings("unused")
	private static final Random generator = new Random();
	static final String IMAGEPATH="C:\\Users\\Rashtra Bhushan\\Desktop\\KidderImageStore\\";
	static final String SOURCE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
	static SecureRandom secureRnd = new SecureRandom();
	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length())));	
		}
		return sb.toString(); 
	}
	@SuppressWarnings("resource")
	public static String StoreBase64Image(String base64String, String imageName) {
		 String[] strings = base64String.split(",");
	        String extension;
	        extension = strings[0].substring(strings[0].indexOf("/")+1, strings[0].indexOf(";"));
	        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
	        String path = IMAGEPATH + imageName+"."+extension;
	        try {
	        	
//				File file = new File(path);
	        	 new FileOutputStream(path).write(data);
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return path;
	}
}
