package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class FoodComponent {
	//	@Bean
	//	public RestTemplate zipCodeSearchRestTemplate() {
	//		RestTemplate restTemplate = new RestTemplate();
	//		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
	//		List<MediaType> supportedMediaTypes = new ArrayList<>(messageConverter.getSupportedMediaTypes());
	//		supportedMediaTypes.add(MediaType.TEXT_PLAIN); // text/plainのJacksonの処理対象にくわえる
	//		messageConverter.setSupportedMediaTypes(supportedMediaTypes);
	//		restTemplate.setMessageConverters(Collections.singletonList(messageConverter)); // カスタムしたHttpMessageConverterを適用
	//		return restTemplate;
	//	}

}
