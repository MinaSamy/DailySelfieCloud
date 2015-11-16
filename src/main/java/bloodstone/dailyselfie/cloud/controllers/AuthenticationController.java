package bloodstone.dailyselfie.cloud.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import bloodstone.dailyselfie.cloud.model.LoginResponse;
import bloodstone.dailyselfie.cloud.model.UserRegistration;
import bloodstone.dailyselfie.cloud.util.ImageUtils;

@Controller
public class AuthenticationController {

	private String[] users = new String[] { "user1@user.com", "user2@user.com", "user3@user.com" };
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody LoginResponse login(@RequestHeader String userName, @RequestHeader String password) {
		LoginResponse response = new LoginResponse();
		if (userName != null && password != null) {
			for (int i = 0; i < users.length; i++) {
				if (users[i].equalsIgnoreCase(userName)) {
					response.setResult(true);
					response.setUserId("User " + String.valueOf(i));
					break;
				}
			}
		}
		return response;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody boolean register(@RequestBody UserRegistration user) {
		boolean result = false;
		if (user.getUserName() != null && user.getPassowrd() != null && user.getDisplayName() != null) {
			result = true;
			for (int i = 0; i < users.length; i++) {
				if (users[i].equalsIgnoreCase(user.getUserName())) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	@RequestMapping(value="/applyeffect", method=RequestMethod.POST,produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public @ResponseBody byte[] applyEffect(@RequestParam("userid") String userId, @RequestParam("type") int effectType,@RequestParam("file") MultipartFile file){
		
		try {
		        byte[] bytes = file.getBytes();
		        File temp=new File(file.getName());
		        BufferedOutputStream stream =
		                new BufferedOutputStream(new FileOutputStream(temp));
		        stream.write(bytes);
		        stream.close();
		        File newFile=null;
		        if(effectType==1){
		        	newFile=ImageUtils.applyTint(userId, temp, 50);	
		        }else if(effectType==2){
		        	newFile=ImageUtils.applyEffect(userId, temp, 128);
		        }else if(effectType==3){
		        	newFile=ImageUtils.applyBlackWhiteEffect(userId,temp, 128);
		        }
		        
		        
		        
		        //java.nio.file.Path p= Paths.get(newFile.toURI());
		       
		        /*FileInputStream input=new FileInputStream(newFile);
		        response.setContentType("image/jpg");
		        response.setContentLength(42707);
		        response.getOutputStream().write(IOUtils.toByteArray(input));*/
		       
		        
		        FileInputStream input=new FileInputStream(newFile);
		        byte[]data=IOUtils.toByteArray(input);
		        
		        /*File ff=new File("D:/selfy/test.jpg");
		        FileOutputStream out=new FileOutputStream(ff);
		        out.write(data, 0, data.length);
		        out.close();*/
		        return data;
		       
		    } catch (Exception e) {
		    	System.out.println(e.toString());
		        return null;
		    }
	}
	
	

	
}
