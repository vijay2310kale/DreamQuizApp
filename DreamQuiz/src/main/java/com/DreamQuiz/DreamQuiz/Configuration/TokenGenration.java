package com.DreamQuiz.DreamQuiz.Configuration;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class TokenGenration {
	
	
	
	
	
	public String TokenGenration() throws Exception {
		
		String Stringtoken="Pravin@mps0987";
		MD5 md5 = new MD5();
		String passworddb = md5.getpass(Stringtoken);
		System.out.println("passworddb   "+passworddb);
		return passworddb;
		
		
	}
	
	public static void main(String ar[]) throws Exception {
		TokenGenration obj=new TokenGenration();
		
		obj.TokenGenration();
		//System.out.println("passworddb   "+passworddb);
}
}