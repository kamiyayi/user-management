
package com.example.kadai_01.app.top;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Component
@RequestMapping(value = "top")
public class MenuController {

	@GetMapping
	public String menu() {
		return "top/menu";
	}
}
