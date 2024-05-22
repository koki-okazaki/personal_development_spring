package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class RestCon {

	public static void main(String[] args) {
		SpringApplication.run(RestCon.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	//pQmDXa2WnHJYsdEYnFqYnekzDLdZeFtaYy4Svyth

	@GetMapping("/fetchJsonFromExternalApi")
	public String fetchJsonFromExternalApi() {
		// 外部APIのURL
		String apiURL = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key=DEMO_KEY&query=egg&pageSize=1";

		// RestTemplateのインスタンスを作成
		RestTemplate restTemplate = new RestTemplate();

		// 外部APIにHTTP GETリクエストを送信し、JSON応答を取得
		String jsonResponse = restTemplate.getForObject(apiURL, String.class);

		// JSON応答を返す
		return jsonResponse;
	}
}
