package com.mpsweb.Meeting.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.mpsweb.Meeting.Configuration.OTPServerMsg91;
import com.mpsweb.Meeting.Responce.AppJsopnResponse;
import com.mpsweb.Meeting.Responce.NewRegiRepo;
import com.mpsweb.Meeting.Service.AdminService;
import com.mpsweb.Meeting.entites.Banner;
import com.mpsweb.Meeting.entites.Meetingdetails;
import com.mpsweb.Meeting.entites.NewRegister;


@Controller
public class MeetingAController {
	
	@Autowired
	AdminService adminService;
	
	
	String uploadBannerDirectory = System.getProperty("user.dir") + "/Upload/Banner/";
	String serverip="http://34.227.188.60";
	
	
	
	
	@RequestMapping(value="/dashborard",method= RequestMethod.GET)
	public String dashboard() {
		System.out.println("dashboard");


			return "admin/index";
			}
	
	 @RequestMapping(value="/admin/newclientpage",method= RequestMethod.GET)
		public String addnewexam() {
			
			System.out.println("hello");
			
			return "admin/newclient";
			
		 
		}
	 
	 @RequestMapping(value = "/Adminfindallclient", method = RequestMethod.GET)
		@ResponseBody
		public List<NewRegister> Adminfindallclient() {
			
			
			System.out.println("@ResponseBody table show all old paper");
			return adminService.Adminfindallclient();
		}
	
	@RequestMapping(value = "/Addnewregister", method = RequestMethod.POST)
    @ResponseBody
  	public NewRegiRepo addnewregister(NewRegister newRegister) {
  		
  		NewRegiRepo resp = new NewRegiRepo();
  		String mob=newRegister.getPhone_no();
  		OTPServerMsg91 obj=new OTPServerMsg91();
	  
  		Long guserid=obj.generateTwoDigitMeetingid();
  		
	  	String convuid=String.valueOf(guserid); 
	  	String loginid=convuid+mob;
  		
//  		long lastprimaryid2= adminService.getlastnewregisterpid();
//  		String str = Long.toString(lastprimaryid2);
  	
  		newRegister.setLoginid(loginid);
  		
  		
  		
  		System.out.println("loginconvid  :  "+loginid);
  		String pass =obj.generatePassword();
  		System.out.println("pass      :  "+pass);
  		
  		//newRegister.setLoginid(loginconvid);
  		//newRegister.setPassword(pass);
  		long time = System.currentTimeMillis();
  		java.sql.Timestamp date = new java.sql.Timestamp(time);
  		String datetimespan=String.valueOf(date);
  		newRegister.setDatetimespan(datetimespan);
  		
  		adminService.savenewregi(newRegister);
  		
  		resp.setMessage(" succss   ");
  		resp.setStatus("True");
  		resp.setPassword(pass);
  		resp.setLoginid(loginid);
  		
  			return resp;
  			
  		}
   
	@RequestMapping(value = "/addmeetingdetails", method = RequestMethod.POST)
    @ResponseBody
  	public NewRegiRepo addmeetingdetails(Meetingdetails meetingdetails) {
  		
		NewRegiRepo resp = new NewRegiRepo();
  		
  		
  		//OTPServerMsg91 obj=new OTPServerMsg91();
  	//	Long meetingid=obj.generateFourDigitMeetingid();
  	//	String meetingconvid=meetingid.toString();
  		//System.out.println("meetingconvid  :  "+meetingconvid);
  		//long lastprimaryid= adminService.getlastinsertpid();
  		
  	//	String Mpassword=obj.generatePassword();
  	//	meetingdetails.setMpassword(Mpassword);
  		
  		//String meetingconvid2=str+meetingconvid;
  		//meetingdetails.setMeetingid(meetingconvid2);
		
		
  		long time = System.currentTimeMillis();
  		java.sql.Timestamp date = new java.sql.Timestamp(time);
  		String datetimespan=String.valueOf(date);
  		meetingdetails.setDatetimespan(datetimespan);
  		
  		adminService.SaveMeetingdetails(meetingdetails);
  		
  		resp.setMessage(" succss   ");
  		resp.setStatus("True");
  		
  		
  			return resp;
  			
  		}
	
	
	
	 @RequestMapping(value = "/AdminfindallMeeting", method = RequestMethod.GET)
		@ResponseBody
		public List<Meetingdetails> AdminfindallMeeting() {
			
			
			System.out.println("@ResponseBody table show all old paper");
			return adminService.AdminfindallMeeting();
		}
	 
	 
	 @RequestMapping(value="/admin/newMeetingpage",method= RequestMethod.GET)
		public String newMeetingpage() {
			
			System.out.println(" Meeting Page hello");
			
			return "admin/AddNewMeeting";
			
			
		}

	 
	 @RequestMapping(value = "/AddBanner", method = RequestMethod.POST)
	 @ResponseBody
	  	public AppJsopnResponse saveBanner(Banner banner,BindingResult bindingResult,@RequestParam List<MultipartFile> filepath,HttpSession session) {
		 AppJsopnResponse resp = new AppJsopnResponse();
	    	 
				File f2 = new File(uploadBannerDirectory);
				if (!f2.exists()) {
					f2.mkdirs();
				}
				System.out.println("listsize  "+filepath.size());
				
				for(MultipartFile multipartFile : filepath) {
					
					String filename = multipartFile.getOriginalFilename();
					
					Random random = new Random();
					String randomnumber = String.format("%04d", random.nextInt(10000));
					filename = randomnumber + "" + filename;
					
					
					
					Path bannerfileNameAndPath = Paths.get(uploadBannerDirectory, filename);
					String path=serverip+"/Upload/Banner/"+filename;
					try {
		  				Files.write(bannerfileNameAndPath, filename.getBytes());
		  			} catch (IOException e) {
		  				e.printStackTrace();
		  			}
				
					String bannerfilepath=path.toString();
					
					banner.setBid(0l);
					banner.setFilepath(bannerfilepath);
					adminService.SaveBanner(banner);
				
	  	}
			    	 resp.setMessage("file save in db...");
			  		resp.setStatus("True");
			  		resp.setData("");
				return resp;
	 
	 
	 }
	 
	 
	 
 
	 
	 @RequestMapping(value = "/UpdateMeetingDetails", method = RequestMethod.POST)
	    @ResponseBody
	  	public Meetingdetails UpdateMeetingDetails(Long mid,String meetingid,String mpassword,String meetingname,String status  ) {
	  		
		 
		 Meetingdetails meetingdetails=adminService.getmeetingbyid(mid);
		 meetingdetails.setMeetingid(meetingid);
		 meetingdetails.setMpassword(mpassword);
		 meetingdetails.setMeetingname(meetingname);
		 meetingdetails.setStatus(status);
		
	  		long time = System.currentTimeMillis();
	  		java.sql.Timestamp date = new java.sql.Timestamp(time);
	  		String datetimespan=String.valueOf(date);
	  		meetingdetails.setDatetimespan(datetimespan);
	  		adminService.SaveMeetingdetails(meetingdetails);
	  		return meetingdetails;	
	  		
  		}	 
	 
	 
	 @RequestMapping(value = "/adminfindmeetingdatabybid/{bid}", method = RequestMethod.GET)
		@ResponseBody
		public Optional<Meetingdetails> adminfindmeetingdatabybid(@PathVariable long bid) {
			return adminService.adminfindmeetingdatabybid(bid);
		}
	 
	 
	 
	 @RequestMapping(value = "/getmeetingbyid", method = RequestMethod.GET)
		@ResponseBody
		public Meetingdetails getMeetingdetails(Long mid) {
		 
		 System.out.println(" Meeting Page hello   "+mid);
		 
			return adminService.getmeetingbyid(mid);
			
		}
	 
	 
	 
	 
	 @RequestMapping(value = "/getclientbyid", method = RequestMethod.GET)
		@ResponseBody
		public NewRegister getclientbyid(Long uid) {
		 
		 System.out.println(" Meeting Page hello   "+uid);
		 
			return adminService.getclientbyid(uid);
			
		}
	 
	 
	 
	 
	 @RequestMapping(value = "/UpdateUserDetails", method = RequestMethod.POST)
	    @ResponseBody
	  	public NewRegister UpdateUserDetails(Long uid,String mjoinigname1,String mjoinigname2,String mjoinigname3,String password,String status) {
	  		
		 
		 NewRegister newRegister=adminService.getclientbyid(uid);
		 newRegister.setMjoinigname1(mjoinigname1);
		 newRegister.setMjoinigname2(mjoinigname2);
		 newRegister.setMjoinigname3(mjoinigname3);
		 newRegister.setStatus(status);
		 newRegister.setPassword(password);
		 
		 
	  		long time = System.currentTimeMillis();
	  		java.sql.Timestamp date = new java.sql.Timestamp(time);
	  		String datetimespan=String.valueOf(date);
	  		newRegister.setDatetimespan(datetimespan);
	  		adminService.SaveUserdetails(newRegister);
	  		return newRegister;	
	  		
		}
	 
	 @RequestMapping(value = "/delete-meeting", method = RequestMethod.POST)
		@ResponseBody
		public AppJsopnResponse deleteBanner(Model model, HttpServletRequest request, @RequestParam("mid") Long mid) {
		 
		 
		 System.out.println(" mid for delete meeting "+mid);
		 adminService.deleteMeeting(mid);
			AppJsopnResponse resp = new AppJsopnResponse();
			resp.setMessage("Meeting Deleted Successfully");
			resp.setStatus("True");
			resp.setData("");
			return resp;
		}

	 
	 
	 
	 }






