package com.study.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		log.info("주석다는 법 이제 System.out.println();는 안녕!!");
		return "index.html";
	};
	
   @GetMapping("/index")
   public String index() {
	   log.info("index()");
      return "index2";
   }
}
