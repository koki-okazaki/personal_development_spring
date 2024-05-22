package com.example.demo;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Serch {

	private int status;

	private String message;
	private List<SearchData> results;

}
