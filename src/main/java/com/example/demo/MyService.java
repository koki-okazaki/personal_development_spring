package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class MyService {

	private final RestTemplate restTemplate;
	private final String apiUrl;

	public MyService(RestTemplate restTemplate,
			@Value("${https://api.nal.usda.gov/fdc/v1/foods/search}") String apiUrl) {
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
	}

	public Double getProteinValue(String name) {
		// APIリクエストを送信
		String url = apiUrl + "?api_key=DEMO_KEY&query=" + name + "&pageSize=1";
		ResponseEntity<FoodSearchResponse> response = restTemplate.getForEntity(url, FoodSearchResponse.class);

		// タンパク質の値を抽出
		if (response.getBody() != null && response.getBody().foods != null && !response.getBody().foods.isEmpty()) {
			Food food = response.getBody().foods.get(0);
			List<FoodNutrient> nutrients = food.foodNutrients;
			for (FoodNutrient nutrient : nutrients) {
				if ("Protein".equalsIgnoreCase(nutrient.nutrientName)) {
					return nutrient.value;
				}
			}
		}

		return null;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class FoodSearchResponse {
	@JsonProperty("foods")
	public List<Food> foods;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Food {
	@JsonProperty("foodNutrients")
	public List<FoodNutrient> foodNutrients;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class FoodNutrient {
	@JsonProperty("nutrientName")
	public String nutrientName;

	@JsonProperty("value")
	public Double value;
}
