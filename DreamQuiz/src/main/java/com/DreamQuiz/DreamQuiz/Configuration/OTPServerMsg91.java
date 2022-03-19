package com.DreamQuiz.DreamQuiz.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

public class OTPServerMsg91 {
	
	
	
	private static String otp;

	// Base URL
	public static String baseUrl = "https://sendotp.msg91.com/api";

	// Your application key
	public static String applicationKey = "KUpLmlZ-lvannpvd3psrYQnrvQe1jTwY8qHV2dumT_i3Xjwfz_0o5QnAge4BgPawxTfh5QEYy5_nBhLL9oWXPVQZclkptgPU2kAy849oHo4ApkHtWu_baI3qn_c3xhyy5lqV72Hy3OgHsOGcmUSvxxhcWJnvewl3QrWvDtak2hk=";

	/**
	 * This function is used to send OTP message on mobile number
	 * 
	 * @return
	 */

	/*
	 * This function is used to send OTP message on mobile number
	 */
	@SuppressWarnings("null")
	public int sendMessage(String mobile, String message) {
		int a = 0;
		String senderId = "QUIZAPP";
		String route = "4";

		/* String pinotp = Integer.toString(value); */
//Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

//encoding message 
		String encoded_message = URLEncoder.encode(message);

//Send SMS API
		String mainUrl = "https://control.msg91.com/api/sendhttp.php?";

//Prepare parameter string 
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		String authkey = "220958AV5oFKgxkQ5b2662a3";
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobile);
		sbPostData.append("&message=" + encoded_message);

		sbPostData.append("&route=" + route);
		sbPostData.append("&sender=" + senderId);

//final string
		mainUrl = sbPostData.toString();
		System.out.println(mainUrl);
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;

			while ((response = reader.readLine()) != null)
				// print response
				System.out.println("Send message successfully=" + response);
				response=response.valueOf(response);
			if(response.equals("Please Enter valid mobile no")) {
				
			}else {
				a = 1;
			}
			// finally close connection
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;

	}

	public void sendMessageDreamtrack(String mobile, String message) {
		String senderId = "TEST";
		String route = "4";
		/* String pinotp = Integer.toString(value); */
		// Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		// encoding message
		String encoded_message = URLEncoder.encode(message);

		// Send SMS API
		String mainUrl = "https://control.msg91.com/api/sendhttp.php?";

		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		String authkey = "220958AV5oFKgxkQ5b2662a3";
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobile);
		sbPostData.append("&message=" + encoded_message);

		sbPostData.append("&route=" + route);
		sbPostData.append("&sender=" + senderId);

		// final string
		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response = null;
			while ((response = reader.readLine()) != null)
				// print response
				System.out.println("Send message successfully=" + response);

			// finally close connection
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void verifyOTP(String oneTimePassword) {
		try {
			// fetch your oneTimePassword from session or db
			// and compare it with the OTP sent from clien
			if (otp.equalsIgnoreCase(oneTimePassword)) {
				System.out.println("Verified");
			} else {
				System.out.println("Invalid code");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String ar[]) {
//		OTPServerMsg91 obj=new OTPServerMsg91();
//		obj.sendMessage("8983267336", "hello");
//	}
	public String generatePassword() {
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";
		String values = Capital_chars + Small_chars + numbers + symbols;
		Random rndm_method = new Random();
		char[] password = new char[10];
		for (int i = 0; i < 10; i++) {
			password[i] = values.charAt(rndm_method.nextInt(values.length()));
		}
		String generatedPassword = new String(password);
		return generatedPassword;
	}
	
	public Long generateSixDigitloginid() {
		String values = "0123456789";
		Random rndm_method = new Random();
		char[] obj = new char[9];
		for (int i = 0; i < 9; i++) {
			obj[i] = values.charAt(rndm_method.nextInt(values.length()));
		}
		String data = new String(obj);
		long loginid = Long.parseLong(data);
		return loginid;
	}

}
