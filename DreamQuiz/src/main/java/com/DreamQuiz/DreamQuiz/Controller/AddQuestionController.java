package com.DreamQuiz.DreamQuiz.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DreamQuiz.DreamQuiz.entity.AppJsopnResponse;
import com.DreamQuiz.DreamQuiz.entity.Queations;
import com.DreamQuiz.DreamQuiz.entity.SubTopics;
import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;
import com.DreamQuiz.DreamQuiz.serviceimpl.AddQuestionServiceImpl;


@RestController

public class AddQuestionController {

	@Autowired
	AddQuestionServiceImpl addQuestionService;
	
	String uploadProductDirectory = System.getProperty("user.dir") + "/uploads/product/";

	
	
	
	@RequestMapping(value = "/AddNewSubject", method = RequestMethod.POST)

	public AppJsopnResponse addNewSubject(Subject subject) {
		
		System.out.println("hello  \"/AddNewSubject\"   ");
		
			String subName=subject.getSubjectName();
			
			System.out.println("subject name "+subName);
			List<String> subjectfromdb = addQuestionService.getallsubject();
			System.out.println("size of subject list "+subjectfromdb.size());
			if(subjectfromdb.contains(subName))
			{
				
				AppJsopnResponse resp = new AppJsopnResponse();
				resp.setMessage("Subject Allready exits ");
				resp.setStatus("True");
				System.out.println("not save subject");
				return resp;
			}
			
			else {
				addQuestionService.addNewSubject(subject);
				System.out.println(" save subject success");
				AppJsopnResponse resp = new AppJsopnResponse();
				resp.setMessage("Queation save ");
				resp.setStatus("True");
				return resp;
			}
		

	}

	private void selectallsubject() {
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(value = "/AddTopic", method = RequestMethod.POST)

	public AppJsopnResponse addnewtopic(Topics topics) {
		
		
		String topicfromuser=topics.getTopicname();
		long sid=topics.getSid();
		
		System.out.println(" topic name from user : "+topicfromuser);
		
		List<String> topicfromdb=addQuestionService.getAllTpoicfromdb(sid);
		System.out.println("size of subject list "+topicfromdb.size());
		if(topicfromdb.contains(topicfromuser)) {
			
			AppJsopnResponse resp = new AppJsopnResponse();
			resp.setMessage("Topic Allready exits ");
			resp.setStatus("True");
			System.out.println("not save topic");
			return resp;
		}
		else {	
			addQuestionService.addnewtopic(topics);
			
			AppJsopnResponse resp = new AppJsopnResponse();
			resp.setMessage("Save Topic  success ");
			resp.setStatus("True");
			System.out.println("success save topic");
			
			return resp;
		}
	
		}

	

	@RequestMapping(value = "/AddsubTopic", method = RequestMethod.POST)

	public AppJsopnResponse addnewsubtopic(SubTopics subTopics) {
		
		
		String Subtopicfromuser=subTopics.getSubtopicname();
		long tid=subTopics.getTid();
		System.out.println(" SubTopic name from user : "+Subtopicfromuser);
		List<String> subtopicfromdb=addQuestionService.findsubtopicfromdb(tid);
		System.out.println(" SubTopic name listsize user : "+subtopicfromdb);
		
		if(subtopicfromdb.contains(Subtopicfromuser)) {
			AppJsopnResponse resp = new AppJsopnResponse();
			resp.setMessage("SubTopic Allready exits ");
			resp.setStatus("True");
			System.out.println("not save SubTopic");
			return resp;
			
		}
		else {		
		addQuestionService.addnewsubtopic(subTopics);
		
		AppJsopnResponse resp = new AppJsopnResponse();
		resp.setMessage("Save SubTopic  success ");
		resp.setStatus("True");
		System.out.println("success save SubTopic");
		
		return resp;
		}

	}

	

	@RequestMapping(value = "/findallSubject", method = RequestMethod.GET)
	public List<Subject> findalaSubject() {
		return addQuestionService.getstudent();
		
		
	}

	

	
	@RequestMapping(value = "/findQueationBysubTopicId/{stid}", method = RequestMethod.GET)

	public List<Queations> getQueationbysubtopicid(@PathVariable Long stid) {
		System.out.println("check Id" + stid);

		return addQuestionService.getBysubtopicid(stid);

	}

	
	

	

	/*
	 * @RequestMapping(value = "/Addnewqueation", method = RequestMethod.POST)
	 * 
	 * public void addnewqueationwithimg(@ModelAttribute("form") Queations
	 * queations) { System.out.println("hello  11111");
	 * addQuestionService.addnewqueation(queations);
	 * 
	 * }}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @RequestMapping(value = "/QueationImageUpload", method = RequestMethod.POST)
	 * public void insertProduct(Queations queations, @RequestParam
	 * List<MultipartFile> imagefile1,@RequestParam List<MultipartFile> imagefile2
	 * ,@RequestParam List<MultipartFile> imagefile3,@RequestParam
	 * List<MultipartFile> imagefile4,@RequestParam List<MultipartFile> imagefile5)
	 * throws IOException {
	 * 
	 * 
	 * List<String> list = new ArrayList<>();
	 * 
	 * String photoQ=List<MultipartFile> imagefile1;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * String path = "E://DQImage/";
	 * 
	 * for (MultipartFile multipartFile : imagefile) { String filename =
	 * multipartFile.getOriginalFilename(); Random random = new Random(); String
	 * randomnumber = String.format("%04d", random.nextInt(10000)); filename =
	 * randomnumber + "" + filename; System.out.println(path + " " + filename); try
	 * { System.out.println("file image "); byte barr[] = multipartFile.getBytes();
	 * BufferedOutputStream bout = new BufferedOutputStream(new
	 * FileOutputStream(path + "/" + filename)); bout.write(barr); bout.flush();
	 * bout.close(); System.out.println("filename=" + filename); String imagepath =
	 * path + filename; //imagepath = "http://34.87.81.128/Files/" + filename; //
	 * 34.87.81.128
	 * 
	 * imagepath = "E://DQImage/" + filename;
	 * 
	 * // int fileupload = service.insertImageFile(uid, imagepath);
	 * //System.out.println("file upload " + fileupload);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } } if (uid != "0") { bean = new ResponseBean("1",
	 * "success");
	 * 
	 * } else { bean = new ResponseBean("0", "fail");
	 * 
	 * } Gson gson = new Gson(); String success = gson.toJson(bean);
	 * response.getWriter().write(success); }
	 
	 * }
	 */
	

	@RequestMapping(value = "/save-newQueation", method = RequestMethod.POST)
	@ResponseBody
	public AppJsopnResponse saveNewQueation(Queations queations,BindingResult bindingResult,
			@RequestParam("imgQeation") MultipartFile imgQeation,
			@RequestParam("imgOptionA") MultipartFile imgOptionA,
			@RequestParam("imgOptionB") MultipartFile imgOptionB,
			@RequestParam("imgOptionC") MultipartFile imgOptionC,
			@RequestParam("imgOptionD") MultipartFile imgOptionD,HttpSession session) throws IOException {
		
		if (!imgQeation.isEmpty() && imgQeation != null) {

			//String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName =   "QueationImage-"
					+ imgQeation.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, imgQeation.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			queations.setImgQeation(originalFileName);
		} else {

			queations.setImgQeation("");
		}

		if (!imgOptionA.isEmpty() && imgOptionA != null) {

			//String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName =   "OptionImageA-"
					+ imgOptionA.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, imgOptionA.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			queations.setImgOptionA(originalFileName);
			
		} else {

			queations.setImgOptionA("");
		}

		if (!imgOptionB.isEmpty() && imgOptionB != null) {

			//String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName =   "imgOptionB-"
					+ imgOptionB.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, imgOptionB.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			queations.setImgOptionB(originalFileName);
			
		} else {

			queations.setImgOptionB("");
		}

		if (!imgOptionD.isEmpty() && imgOptionD != null) {

			//String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName =   "imgOptionD-"
					+ imgOptionD.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, imgOptionD.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			queations.setImgOptionD(originalFileName);
			
		} else {

			queations.setImgOptionD("");
		}
		
		
		if (!imgOptionC.isEmpty() && imgOptionC != null) {

			//String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName =   "imgOptionC-"
					+ imgOptionC.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, imgOptionC.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			queations.setImgOptionC(originalFileName);
			
		} else {

			queations.setImgOptionC("");
		}
		
		addQuestionService.addnewqueation(queations);
		AppJsopnResponse resp = new AppJsopnResponse();
		resp.setMessage("Queation   saved successfully");
		resp.setStatus("True");
		return resp;
		
		
		}
	



	
	@RequestMapping(value = "/findTopicbysid/{sid}", method = RequestMethod.GET)

	public List<Topics> getTopicbysid(@PathVariable Long sid) {
		System.out.println("check Id" + sid);

		return addQuestionService.getTopicbysid(sid);

	}


	
	@RequestMapping(value = "/findSubTopicbytid/{tid}", method = RequestMethod.GET)
	public List<SubTopics> getSubTopicsbytid(@PathVariable Long tid){
		return addQuestionService.getSubTopicsbytid(tid);
		
	}
	
	
	








}
