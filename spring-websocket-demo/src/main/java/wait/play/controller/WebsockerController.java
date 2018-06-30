package wait.play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wait.play.service.WebsocketService;

@Controller
public class WebsockerController {
	
	@Autowired
	private WebsocketService websocketService;
	
	@RequestMapping(value = { "/websocket" })
	public String websocket(Model model) {
		model.addAttribute("message", "Websocket dashboard!");
		return "websocket";
	}
	
	@RequestMapping(value = { "/websocket/start" })
	public String start(Model model) {
		websocketService.start();
		model.addAttribute("message", "Start Server!");
		return "websocket";
	}
	
	@RequestMapping(value = { "/websocket/stop" })
	public String stop(Model model) {
		websocketService.stop();
		model.addAttribute("message", "Stop Server!");
		return "websocket";
	}
	
	@RequestMapping(value = { "/websocket/record/start" })
	public String startRecord(Model model) {
		websocketService.send("Start Record");
		model.addAttribute("message", "Start Record!");
		return "websocket";
	}
	
	@RequestMapping(value = { "/websocket/record/stop" })
	public String stopRecord(Model model) {
		websocketService.send("Stop Record");
		model.addAttribute("message", "Stop Record!");
		return "websocket";
	}

}
