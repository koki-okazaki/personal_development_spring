package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	private final MyService myService;

	@Autowired
	FoodService foodService;

	public MyController(MyService myService) {
		this.myService = myService;

	}

	@GetMapping("/search")
	public String searchFood(Model model, @RequestParam String name) {
		Double proteinValue = myService.getProteinValue(name);

		model.addAttribute("mainfood", proteinValue);

		return "mainfood";
	}

	@GetMapping("/protein")
	public String getProteinValue(@RequestParam String name, Model model) {
		Double value = myService.getProteinValue(name);
		if (value != null) {
			model.addAttribute("foodName", name);
			model.addAttribute("proteinValue", value);
			return "nutritionInfo";
		} else {
			return "notFound";
		}
	}

	@RequestMapping("/mainfood")
	public String zipcodeForm(HttpSession session, Model model) {
		return "mainfood";
	}

	//	@RequestMapping(value = "/mainfood/confirm", method = RequestMethod.POST)
	//	public String zipcodeConfirm(HttpSession session, Model model,
	//			@RequestParam("mainfood") String zipcode) {
	//
	//		// 一応必須チェックのみ 数字・桁数チェックは省略
	//		// nullまたは空文字の場合、入力フォームにエラーメッセージを表示
	//		if (zipcode == null || zipcode.equals("")) {
	//			model.addAttribute("errorMessage", "食品名を入力してください。");
	//			return zipcodeForm(session, model);
	//		}
	//
	//		
	//		Search search = foodService.service(zipcode);
	//		// thymeleafでリストを展開して表示する
	//		model.addAttribute("foodlist", search.getResults());
	//		return "foodconfirm";
	//	}

	@GetMapping("/restcon")

	public String rescon(Model model) {
		return "RestCon";
	}
}
