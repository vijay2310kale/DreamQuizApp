package com.DreamQuiz.DreamQuiz.AndroidController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DreamQuiz.DreamQuiz.AndroidRespopnce.CAReponce;
import com.DreamQuiz.DreamQuiz.AndroidRespopnce.ExamListResponce;
import com.DreamQuiz.DreamQuiz.AndroidRespopnce.LoginResponce;
import com.DreamQuiz.DreamQuiz.AndroidRespopnce.OldPaperResponce;
import com.DreamQuiz.DreamQuiz.AndroidRespopnce.RegiResponce;
import com.DreamQuiz.DreamQuiz.AndroidRespopnce.SubjectListResponce;
import com.DreamQuiz.DreamQuiz.AndroidRespopnce.TopiclistResponce;
import com.DreamQuiz.DreamQuiz.AndroidRespopnce.UserRegisterRepo;
import com.DreamQuiz.DreamQuiz.AndroidRespopnce.VideolistResponce;
import com.DreamQuiz.DreamQuiz.Configuration.MD5;
import com.DreamQuiz.DreamQuiz.Configuration.OTPServerMsg91;
import com.DreamQuiz.DreamQuiz.Configuration.TokenGenration;
import com.DreamQuiz.DreamQuiz.entity.CurrentAffairs;
import com.DreamQuiz.DreamQuiz.entity.Examdetails;
import com.DreamQuiz.DreamQuiz.entity.OldPaper;
import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;
import com.DreamQuiz.DreamQuiz.entity.UserRegistration;
import com.DreamQuiz.DreamQuiz.entity.Videodetails;
import com.DreamQuiz.DreamQuiz.serviceimpl.AndroidService;

@RestController
public class AndroidController {
	
	@Autowired
	AndroidService androidService;
	
	
	
	TokenGenration obj=new TokenGenration();
	//015ae58f333335b879fa3d57699d308c
	String gtoken="015ae58f333335b879fa3d57699d308c";
	@RequestMapping(value="/api/signup",method = RequestMethod.POST)
    public RegiResponce createAccount(@ModelAttribute  UserRegistration regi) throws IOException, NoSuchAlgorithmException
    {
		RegiResponce responce =new RegiResponce();
		
		String upassword=regi.getPassword();
		
		long time = System.currentTimeMillis();
		java.sql.Timestamp date = new java.sql.Timestamp(time);
		String datetimespan=String.valueOf(date);
		
		regi.setDatetimespan(datetimespan);
		
		MD5 md5 = new MD5();
		String passworddb = md5.getpass(upassword);
		
		regi.setPassword(passworddb);
		
		String umail=regi.getEmail();
		String umobile=regi.getPhone_no();
		List<String> findemailfromdb=androidService.findemailfromdb();
		List<String> findmobilenofromdb=androidService.findmobilenofromdb();
		System.out.println("size of emil "+findemailfromdb.size());
        try {
		if(findemailfromdb.contains(umail) ||findmobilenofromdb.contains(umobile) ){
			
			
			responce.setMessage(" user Email Or Phone allready Present ");
			responce.setStatus("0");
		
	
		}
		
		else {
			 androidService.newregisteration(regi);
			
			 String user_id=androidService.finduserid(umail,umobile);
			 
			 
			 Random random = new Random();
				int otp = random.nextInt(10000);
				String otpnew = Integer.toString(otp);
				if (otp < 999) {
					otpnew = otp + "0";
				}
				String message = "Your DreamQuiz OTP is " + otpnew;
				OTPServerMsg91 obj = new OTPServerMsg91();
				regi.setOtp(otpnew);
				 androidService.newregisteration(regi);
			//	androidService.updateotpforuaer(otpnew,user_id);
				// This message sendMessage
				int result = obj.sendMessage(umobile, message);
				if (result != 0) {
					
					responce.setMessage("You have registered successfully please verify ");
					responce.setStatus("1");
					responce.setUser_id(user_id);
					responce.setOtp(otpnew);
					
					
				}else {
					responce.setMessage("otp msg not send ");
					
				}
				

		}
        }
        
        catch (Exception e) {

			e.printStackTrace();
		}
       
       return responce;
    }

	
	@RequestMapping(value="/api/verify",method = RequestMethod.POST)
	public RegiResponce verifyOTP( String otp, String user_id)throws Exception{
		
		RegiResponce responce =new RegiResponce();
		String otpfromdb=androidService.getotpfromdb(user_id);
		try {
		if(otpfromdb.equals(otp)) {
			responce.setMessage("Verify Successfully ");
			responce.setStatus("1");
		
		}
		
		else {
			responce.setMessage("otp not match ");
			responce.setStatus("0");
			
			
		}
		
		}
		
		catch (Exception e) {

			e.printStackTrace();
		}
		 return responce;
	}
	
//	
//	@RequestMapping(value="/api/ReSendOTP",method = RequestMethod.POST)
//	public RegiResponce ReSendOTP(String user_id)throws Exception{
//		
//		RegiResponce responce =new RegiResponce();
//		
//		try {
//		
//		
//		Random random = new Random();
//			int otp = random.nextInt(10000);
//			String otpnew = Integer.toString(otp);
//			if (otp < 999) {
//				otpnew = otp + "0";
//			}
//			String message = "Your DreamQuiz OTP is " + otpnew;
//			OTPServerMsg91 obj = new OTPServerMsg91();
//			UserRegistration.setOtp(otpnew);
//			 UserRegistrationService.newregisteration(UserRegistration);
//		//	UserRegistrationService.updateotpforuaer(otpnew,user_id);
//			// This message sendMessage
//			int result = obj.sendMessage(umobile, message);
//			if (result != 0) {
//				
//				responce.setMessage("You have registered successfully please verify ");
//				responce.setStatus("1");
//				responce.setUser_id(user_id);
//				responce.setOtp(otpnew);
//				
//				
//			else {
//				responce.setMessage("otp msg not send ");
//				
//			}
//			
//
//	}
// 
// 
// catch (Exception e) {
//
//		e.printStackTrace();
//	}
//
//return responce;
//
//		
//	
//}
	
	
	@RequestMapping(value="/api/login",method = RequestMethod.POST)
	public LoginResponce login(String phone_no,String password,String device_token,String device_type)throws Exception{
	
		LoginResponce loginresponce =new LoginResponce();
		UserRegistration getalldatabyphone=androidService.getallbyphone_no(phone_no);
		try {
		
			List<String> phonefromdb=androidService.findmobilenofromdb();
		
			if(phonefromdb.contains(phone_no)) {
				//***********token**********
				//String generatedtoken="015ae58f333335b879fa3d57699d308c";
				
			   System.out.println("generatedtoken  "+ gtoken);
		
		String passfromdb=androidService.getpassbyphoneno(phone_no);
		long userid=androidService.getuserid(phone_no);
	
		
		MD5 md5 = new MD5();
		String passworddb = md5.getpass(password);
		if(passworddb.equals(passfromdb)) {
			
			
			 
			
			 getalldatabyphone.setDevice_token(device_token);
			 getalldatabyphone.setDevice_type(device_type);
			
			 System.out.println("currect password");
			//UserRegistrationService.updateuser(device_token,device_type,token,phone_no);
			 androidService.updatedata(getalldatabyphone);
			
			loginresponce.setMessage("You have login successfully");
			loginresponce.setStatus("1");
			loginresponce.setUser_id(userid);
			loginresponce.setToken(gtoken);
		
		}else {
			loginresponce.setMessage("password not match");
			loginresponce.setStatus("0");
			loginresponce.setUser_id(userid);
			//loginresponce.setToken("token");
			
		}
		
		}
		else {
			loginresponce.setMessage("Do UserRegistration first... ");
			loginresponce.setStatus("2");
			
			
		}
	}
		catch (Exception e) {

			e.printStackTrace();
		}
		return loginresponce;
	
	}
	
	
	@RequestMapping(value="/api/forgotpassword",method = RequestMethod.POST)
	public RegiResponce forgotpassword(String phone_no)throws Exception{
		
		RegiResponce responce =new RegiResponce();
		UserRegistration getalldatabyphone=androidService.getallbyphone_no(phone_no);
		long userid=getalldatabyphone.getUser_id();
		String uid=String.valueOf(userid);
		try {
			
			List<String> phonefromdb=androidService.findmobilenofromdb();
			
			if(phonefromdb.contains(phone_no)) {
				
				
				 Random random = new Random();
					int otp = random.nextInt(10000);
					String otpnew = Integer.toString(otp);
					if (otp < 999) {
						otpnew = otp + "0";
					}
					String message = "Your DreamQuiz OTP is " + otpnew;
					OTPServerMsg91 obj = new OTPServerMsg91();
					getalldatabyphone.setOtp(otpnew);
					androidService.newregisteration(getalldatabyphone);
				//	UserRegistrationService.updateotpforuaer(otpnew,user_id);
					// This message sendMessage
					 System.out.println("OTP IS "+otpnew);
					int result = obj.sendMessage(phone_no, message);
					if (result != 0) {
						
						responce.setMessage("Otp has been send to registered mobile No ");
						responce.setStatus("1");
						responce.setUser_id(uid);
						responce.setOtp(otpnew);
						
						
					}else {
						responce.setMessage("otp msg not send ");
						
					}
					
				
			}else {
				responce.setMessage("Mobile No Not Invalid or Not found... ");
				responce.setStatus("2");
				
				
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return responce;
	}
	
	@RequestMapping(value="/api/resetpassword",method = RequestMethod.POST)
	public RegiResponce resetpassword(String password,String otp,String user_id)throws Exception{
	
		RegiResponce responce =new RegiResponce();
		try {
				
		long uid=Long.valueOf(user_id);
		
		UserRegistration regi=androidService.getalldatabyuid(uid);
		String otpfromdb=regi.getOtp();
		String dbpassword=regi.getPassword();
		MD5 md5 = new MD5();
		String passworddb = md5.getpass(password);
		if(otpfromdb.equals(otp)) {
			
			//regi.setOtp("");
			regi.setPassword(passworddb);
			
			androidService.newregisteration(regi);
			 System.out.println("resetpassword1111");
			 responce.setMessage("Password Reset Successfully... ");
			 responce.setStatus("1");
			
			
		}else {
			 System.out.println("resetpassword");
			responce.setMessage("In valid OTP ... ");
			responce.setStatus("2");
		
		}
	}
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return responce;
	
	}
	
//**********21/1/2022********
	
	@RequestMapping(value="/api/getuserdatabyid",method = RequestMethod.GET)
	public UserRegisterRepo getuserdatabyid(@RequestHeader("token") String token,@RequestHeader("user_id")long user_id)throws Exception{
		
		UserRegisterRepo urrepo=new UserRegisterRepo();
		 long uid=Long.valueOf(user_id);
		 List<Long> uidfrondb=androidService.findalluserid();
		String generatedtoken=obj.TokenGenration();
		try {
		if(token.equals(gtoken)) {
			if(uidfrondb.contains(uid)) {
			
			
			 System.out.println("getuserdatabyid");
				Optional<UserRegistration> alluserlist= androidService.getalldataofuser(user_id);
				 urrepo.setMessage("All User List");
				 urrepo.setStatus("1");
				 urrepo.setUserRegistration(alluserlist);
			}
			else {
				 urrepo.setMessage("User Id Not Present");
				 urrepo.setStatus("1");
				
			}
		}
		else {
			urrepo.setMessage("Invalid Token");
			 urrepo.setStatus("0");
			
		}
		}catch (Exception e) {

			e.printStackTrace();
		}
		return urrepo;
	}
			 
	
	
//	@RequestMapping(value = "/findallSubject", method = RequestMethod.GET)
//	public List<Subject> findalaSubject() {
//		return androidService.getstudent();
//		
//		
//	}
	
	@RequestMapping(value = "/api/getalloldpaper", method = RequestMethod.GET)
	public OldPaperResponce getalloldpaper(@RequestHeader("token") String token,@RequestHeader("user_id")String user_id)throws Exception   {
		
		
		
		OldPaperResponce listresp= new OldPaperResponce();
         long uid=Long.valueOf(user_id);
	try {
		List<Long> uidfrondb=androidService.findalluserid();
		
		if(token.equals(gtoken)) {
		
			if(uidfrondb.contains(uid)) {
			
			List<OldPaper> oldpaperilst=androidService.getalloldpaper();
			
			listresp.setMessage("list of old paper");
			listresp.setStatus("1");
			
			listresp.setOldPaperResponce(oldpaperilst);
		}
		else {
			listresp.setMessage("Usewr not Register");
			listresp.setStatus("2");
			
			
		}
		}
		else {
			listresp.setMessage("Your Are Not Authorized User!");
			listresp.setStatus("0");
			
			
		}
		
	
	}catch (Exception e) {

		e.printStackTrace();
	}
		 
	
	return listresp;
	}



	
	@RequestMapping(value = "/api/getallCA", method = RequestMethod.GET)
	public CAReponce getallCA(@RequestHeader("user_id") String user_id,@RequestHeader("token") String token) throws Exception {
		
		
	
		//String generatedtoken=obj.TokenGenration();
		CAReponce listresp= new CAReponce();
		try {
             long uid=Long.valueOf(user_id);
		
		List<Long> uidfrondb=androidService.findalluserid();
		if(token.equals(gtoken)) {
		if(uidfrondb.contains(uid)) {
			
			List<CurrentAffairs> CAList=androidService.getallCA();
			
			listresp.setMessage("list of CAPDF");
			listresp.setStatus("1");
			
			listresp.setCaresponce(CAList);
		}
		else {
			listresp.setMessage("User not Register");
			listresp.setStatus("0");
			
			
		}
		}else {
			listresp.setMessage("invalid token");
			listresp.setStatus("0");
			
			
		}
		 
		}catch (Exception e) {

			e.printStackTrace();
		}
	return listresp;
	}


	
	@RequestMapping(value = "/api/getallVideolist", method = RequestMethod.GET)
	public VideolistResponce getallvideodetails(@RequestHeader("user_id") String user_id,@RequestHeader("token") String token)throws Exception {
		
		
		
		VideolistResponce resp= new VideolistResponce();
		
       try {
		
		long uid=Long.valueOf(user_id);
		
		List<Long> uidfrondb=androidService.findalluserid();
		if(token.equals(gtoken)) {
		if(uidfrondb.contains(uid)) {
			
			List<Videodetails> videoList=androidService.videoList();
			
			resp.setMessage("list of videos");
			resp.setStatus("1");
		    resp.setVideodetailsresponce(videoList);
			
		
		}
		else {
			resp.setMessage("User not Register");
			resp.setStatus("0");
			
			
		}
		
		}else {
			resp.setMessage("invalid token");
			resp.setStatus("0");
			
			
			
		}
       }catch (Exception e) {

			e.printStackTrace();
		}
	return resp;
	}


	
	
	@RequestMapping(value = "/api/examlist", method = RequestMethod.GET)
	public ExamListResponce examlist(@RequestHeader("user_id") String user_id,@RequestHeader("token") String token)throws Exception {
		
		
		
		ExamListResponce resp= new ExamListResponce();
        try {
		long uid=Long.valueOf(user_id);
		
		List<Long> uidfrondb=androidService.findalluserid();
		if(token.equals(gtoken)) {
		if(uidfrondb.contains(uid)) {
			
			List<Examdetails> Examdetails=androidService.Examdetails();
			
			resp.setMessage("list of Exam");
			resp.setStatus("1");
		    resp.setExamdetails(Examdetails);
			
		
		}
		else {
			resp.setMessage("User not Register");
			resp.setStatus("0");
			
			
		}
		}
		else {
			resp.setMessage("invalid token");
			resp.setStatus("0");
			
		}
        }
        catch (Exception e) {

			e.printStackTrace();
		}
	return resp;
	}

	
	
	@RequestMapping(value = "/api/Subjectlist", method = RequestMethod.GET)
	public SubjectListResponce Subjectlist(@RequestHeader("user_id") String user_id,@RequestHeader("token") String token)throws Exception {
		
	
		
		SubjectListResponce resp= new SubjectListResponce();
        try {
		long uid=Long.valueOf(user_id);
		
		List<Long> uidfrondb=androidService.findalluserid();
		if(token.equals(gtoken)) {
		if(uidfrondb.contains(uid)) {
			
			List<Subject> Subjectlist=androidService.subjectList();
			
			resp.setMessage("list of All Subject");
			resp.setStatus("1");
		   resp.setSubjectlist(Subjectlist);
			
		
		}
		else {
			resp.setMessage("User not Register");
			resp.setStatus("0");
			
			
		}
		}
		else {
			resp.setMessage("Invalid token");
			resp.setStatus("0");
			
		}
        }catch (Exception e) {

			e.printStackTrace();
		}
	return resp;
	}

	
	
	@RequestMapping(value = "/api/Topiclist", method = RequestMethod.GET)
	public TopiclistResponce Topiclist(@RequestHeader("user_id") String user_id,@RequestHeader("token") String token,@RequestHeader("subjectid") String subjectid) throws Exception{
		
		
		
		TopiclistResponce resp= new TopiclistResponce();
      try {
		
		long uid=Long.valueOf(user_id);
         long sid=Long.valueOf(subjectid);
		
		List<Long> uidfrondb=androidService.findalluserid();
		
		if(token.equals(gtoken)) {
		if(uidfrondb.contains(uid)) {
			
			List<Topics> alltoipcbysid=androidService.alltoipcbysid(sid);
			
			resp.setMessage("list of All topic by sid");
			resp.setStatus("1");
		   resp.setTopiclist(alltoipcbysid);
			
		
		}
		else {
			resp.setMessage("User not Register");
			resp.setStatus("0");
			
			
		}}
		else {
			resp.setMessage("Invalid token");
			resp.setStatus("0");
			
		}
      }catch (Exception e) {

			e.printStackTrace();
		}
	return resp;
	}

}


