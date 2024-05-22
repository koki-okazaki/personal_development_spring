//package com.example.demo;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//@RequestMapping("/api")
//public class MyRestController {
//	@GetMapping("/data")
//	public String getData() throws URISyntaxException {
//		//APIキーを含むhttpヘッダーを作成
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("X-Api-Key", "自分のAPIキー");
//
//		//HTTPリクエストを作成
//		RequestEntity<?> requestEntity = RequestEntity
//				.get(new URI(
//						"https://pQmDXa2WnHJYsdEYnFqYnekzDLdZeFtaYy4Svyth@developer.nrel.gov/api/alt-fuel-stations/v1.json?limit=1"))
//				.headers(headers)
//				.build();
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
//
//		return response;
//
//		//
//		//		RestTemplate restTemplate = new RestTemplate();
//		//		String response = restTemplate.exchange(requestEntity, String.class).getBody();
//		//		ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
//
//		//		String responseBody = responseEntity.getBody();
//
//		//		System.out.println("APIからのレスポンス：" + responseBody);
//
//		//		return response;
//		//		return ResponseEntity.ok(responseBody);
//
//	}
//}
