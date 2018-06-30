package wait.play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wait.play.service.FileSocketService;

@Controller
public class FileSocketController {
	@Autowired
	private FileSocketService fileSocketService;
	private static final String UPLOADPATH = "./files/";
	
	@RequestMapping(value = { "/filesocket" })
	public String filesocket(Model model) {		
		model.addAttribute("message", "Filesocket Dashboard");
		return "filesocket";
	}
	
	
	@RequestMapping(value = { "/filesocket/start" })
	public String start(Model model) {		
		fileSocketService.setUploadPath(UPLOADPATH);
		fileSocketService.start();
		model.addAttribute("message", "Start File Socket Server!");
		return "filesocket";
	}
	
	@RequestMapping(value = { "/filesocket/stop" })
	public String stop(Model model) {
		fileSocketService.stop();
		model.addAttribute("message", "Stop File Socket Server!");
		return "filesocket";
	}
	

}
