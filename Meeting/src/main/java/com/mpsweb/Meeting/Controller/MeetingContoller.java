package com.mpsweb.Meeting.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpsweb.Meeting.Configuration.OTPServerMsg91;
import com.mpsweb.Meeting.Responce.AppJsopnResponse;
import com.mpsweb.Meeting.Responce.GetAllMeetingResonce;
import com.mpsweb.Meeting.Responce.GetBannerResponce;
import com.mpsweb.Meeting.Responce.MbGenUidResponce;
import com.mpsweb.Meeting.Responce.NewRegiRepo;
import com.mpsweb.Meeting.Responce.userRegiResponce;
import com.mpsweb.Meeting.Service.MeetingService;
import com.mpsweb.Meeting.entites.Banner;
import com.mpsweb.Meeting.entites.Mbgenarateuid;
import com.mpsweb.Meeting.entites.Mbregistration;
import com.mpsweb.Meeting.entites.Meetingdetails;
import com.mpsweb.Meeting.entites.NewRegister;

@RestController
public class MeetingContoller {
	
	@Autowired
	MeetingService meetingService;
	
	String uploadBannerDirectory = System.getProperty("user.dir") + "/Upload/Banner/";
	
	 @RequestMapping(value="/api/newregilogin",method = RequestMethod.POST)
		public NewRegiRepo newregilogin(@RequestBody NewRegister newRegister)throws Exception{
		
		 
		 
		 String loginid=newRegister.getLoginid();
		 String password=newRegister.getPassword();
		 String deviceid=newRegister.getDeviceid();
		 NewRegiRepo loginresponce =new NewRegiRepo();
		 NewRegister getallbyloginid=meetingService.getallbyloginid(loginid);
		
		 
		 String mjn1=getallbyloginid.getMjoinigname1();
		 String mjn2=getallbyloginid.getMjoinigname2();
		 String mjn3=getallbyloginid.getMjoinigname3();
		 List<String> loginidfromdb=meetingService.findloginidfromdb();
		 System.out.println("******************");
		 if(getallbyloginid.getDeviceid().equals(deviceid)) {
			 
			 
			 try {	
				 String passwordfromdb =getallbyloginid.getPassword();
				 if(getallbyloginid.getPassword().equals(password)) {
			
					loginresponce.setMessage("You have login successfully");
					loginresponce.setStatus("1");
					loginresponce.setMjoinigname1(mjn1);
					loginresponce.setMjoinigname2(mjn2);
					loginresponce.setMjoinigname3(mjn3);
					
				}else {
					loginresponce.setMessage("password not match");
					loginresponce.setStatus("2");
				
				}}
				    
				catch (Exception e) {

					e.printStackTrace();
				}

			 
		 }else {
			 
			 try {	
				 
				 getallbyloginid.setDeviceid(deviceid);
				
				 meetingService.updatedivceid(getallbyloginid);
				 
				 String passwordfromdb =getallbyloginid.getPassword();
				 if(getallbyloginid.getPassword().equals(password)) {
			
					loginresponce.setMessage("You have login successfully");
					loginresponce.setStatus("3");
					loginresponce.setMjoinigname1(mjn1);
					loginresponce.setMjoinigname2(mjn2);
					loginresponce.setMjoinigname3(mjn3);
					
				}else {
					loginresponce.setMessage("password not match");
					loginresponce.setStatus("4");
				
				}
				 
				    
				
			}
				catch (Exception e) {

					e.printStackTrace();
				}

			 
		 }
		
					return loginresponce;
		
		}
		
	
	 
	 @RequestMapping(value="/api/logoutAPI",method = RequestMethod.POST)
		public NewRegiRepo logoutAPI(String loginid,String deviceid)throws Exception{
		
		 NewRegiRepo loginresponce =new NewRegiRepo();
		 NewRegister getallbyloginid=meetingService.getallbyloginid(loginid);
		 
		 List<String> loginidfromdb=meetingService.findloginidfromdb();
		 
		 try {	
		 if(getallbyloginid.getDeviceid().equals(deviceid)) {
			 
			 loginresponce.setMessage("Stay Login");
					loginresponce.setStatus("1");
					loginresponce.setStatus("true");
					
					
				}else {
					loginresponce.setMessage("Device Id Not Match ");
					loginresponce.setStatus("0");
					loginresponce.setStatus("false");
				
				}
				
			}
				catch (Exception e) {

					e.printStackTrace();
				}
		return loginresponce;
	 
		 }
	
	 
	 
	 
	 @RequestMapping(value = "/api/getallMeetingdetails", method = RequestMethod.GET)
		public GetAllMeetingResonce getalloldpaper()throws Exception   {
		 GetAllMeetingResonce listresp= new GetAllMeetingResonce();
			
			try {
			
		     
	       	List<Meetingdetails> meetinglist=meetingService.getallmeeting();
	    	
	       	
	       	listresp.setStatus("1");	
	       	listresp.setMessage("all meeting list...");
			listresp.setGetAllMeetingResonce(meetinglist);
				
		}catch (Exception e) {

			e.printStackTrace();
		}
			 
		
		return listresp;
		
	 }

	 
	 
	 @RequestMapping(value = "/api/getallbannerbyid", method = RequestMethod.GET)
		public GetBannerResponce getallbannerbyid(String bannerid)throws Exception   {
		 GetBannerResponce listresp= new GetBannerResponce();
			
			try {
			
		     
	       	List<Banner> bannerlist=meetingService.allBannerList(bannerid);
				
				listresp.setMessage("List Of All Banner By Id!");
				listresp.setStatus("0");
				listresp.setGetAllBanner(bannerlist);
				
		}catch (Exception e) {

			e.printStackTrace();
		}
			 
		
		return listresp;
		
	 }
	 
	 
	 @RequestMapping(value="/api/UserRegistration",method = RequestMethod.POST)
		public AppJsopnResponse UserRegistration( Mbregistration registration)throws Exception{
			
		 AppJsopnResponse responce =new AppJsopnResponse();
		
			OTPServerMsg91 obj=new OTPServerMsg91();
		  	Long guserid=obj.generateTwoDigitMeetingid();
		  	String convuid=String.valueOf(guserid); 
		  	String userid=convuid+registration.getMobileno();
		  	List<String> mobilelist=meetingService.getallmobilenumber();
		 // 	System.out.println("mobilelist1"+mobilelist.get(0));
		  //	System.out.println("mobilelist2"+mobilelist.get(2));
		  
		 
		  	try {
				
					
		  	if(mobilelist.contains(registration.getMobileno())) {
		  		
		  		responce.setMessage("mobile number allready exits");
			    responce.setStatus("1");
		  		
		  		
		  		
		  	}else {
		  		
		  		registration.setUserid(userid);
		  		// long priid=meetingService.lastgeprimaryid();
				 long time = System.currentTimeMillis();
			  	java.sql.Timestamp date = new java.sql.Timestamp(time);
			  	String datetimespan=String.valueOf(date);
			  	registration.setDatetimespan(datetimespan);
			  	
			  	meetingService.saveuserinfo(registration);
			  	
			  	responce.setMessage("Register success ");
				responce.setStatus("1");
			  		
		  		
		  	}
		  		
			}
			
			catch (Exception e) {

				e.printStackTrace();
			}
			 return responce;
		}

	
	 
	 
	 
	 @RequestMapping(value="/api/Userlogin",method = RequestMethod.POST)
		public userRegiResponce UserRegistration( String mobileno,String password)throws Exception{
			
		 userRegiResponce responce =new userRegiResponce();
		 System.out.println("mobileno 1::"+mobileno);
			List<String> mobilelist=meetingService.getallmobilenumber();
		  	try {
		  	
		  		if(!mobilelist.contains(mobileno)) {
		  			responce.setMessage("Do Registration first to login ");
				    responce.setStatus("1");
		  			
		  			  
		  		
		  	}else {
		  		
		  		
			    Mbregistration databymobileno=meetingService.getdatabymno(mobileno);
	 		  	  String dbpassword=databymobileno.getPassword();
	 		      System.out.println("databymobileno.getPassword() ::"+dbpassword);
	 		
	  			     if(dbpassword.equals(password)) {
	  				 System.out.println("databymobileno.getPassword() ::"+databymobileno.getPassword());
			  		responce.setMessage(" login Successfully ");
				    responce.setStatus("1");
				    responce.setUserid(databymobileno.getUserid());
	  			}else {
	  			
	  		responce.setMessage("password dosenot match... ");
		    responce.setStatus("1");
	  		
	  			}
		  	}
		  		
			}
			
			catch (Exception e) {

				e.printStackTrace();
			}
			 return responce;
		}
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value="/api/UserGengMyId",method = RequestMethod.POST)
		public MbGenUidResponce UserGengMyId(@RequestBody Mbgenarateuid mbgenarateuid)throws Exception{
			
		 MbGenUidResponce responce =new MbGenUidResponce();
		
		
			try {
		 String s="Mps";
		 String uname=mbgenarateuid.getUsername();
		 String mobileno=mbgenarateuid.getWhatsupno();
	      System.out.println("mobileno  :"+mobileno.length());
	
	      String lastFourDigits = "";   
	 
	        if (mobileno.length() > 4) 
	         {
	            lastFourDigits = mobileno.substring(mobileno.length() - 4);
	          } 
	            else
	             {
	              lastFourDigits = mobileno;
	             }
	
		          String genuid=s+uname+lastFourDigits;
		 
		 System.out.println("mobileno  :"+genuid);
		 mbgenarateuid.setGenid(genuid);
		 mbgenarateuid.setGpassword("Mps112233"); 
		 long time = System.currentTimeMillis();
		  	java.sql.Timestamp date = new java.sql.Timestamp(time);
		  	String datetimespan=String.valueOf(date);
		  	mbgenarateuid.setDatetimespan(datetimespan);
		  	
			meetingService.saveandgenuid(mbgenarateuid);
			
			responce.setMessage("Create id successfully");
		    responce.setStatus("1");
		    responce.setGenid(genuid);
            }
			
			catch (Exception e) {

				e.printStackTrace();
			}
			 return responce;
		}
		  
				
					
		  	
	 @RequestMapping(value = "/api/getallGenmyid", method = RequestMethod.GET)
		public MbGenUidResponce getallGenmyid(String userid)throws Exception   {
		 MbGenUidResponce listresp= new MbGenUidResponce();
			
			try {
			
		     
	       	List<Mbgenarateuid> listbyuserid=meetingService.listbyuserid(userid);
				
				listresp.setMessage("List Of All My Id By userid!");
				listresp.setStatus("0");
				listresp.setGetallmyid(listbyuserid);
				
		}catch (Exception e) {

			e.printStackTrace();
		}
			 
		
		return listresp;
		
	 }
	
		  		
		  		
		  		
		  		
		  
			


	 
	 
	 
	 
}
