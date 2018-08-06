package com.example.Springbootcrud.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GitHubService {

	RestTemplate resttemplate = new RestTemplate();

	public String getUserNameByloginName(String loginName) {

		String url = "https://api.github.com/search/users?q=" + loginName;
		String jsonString = resttemplate.getForObject(url, String.class);
		System.out.println(jsonString);
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();
		JsonParser parser;
		try {
			parser = factory.createParser(jsonString);
			JsonNode actualObj = mapper.readTree(parser);
			int repoCount = actualObj.get("total_count").asInt();
			String ss = actualObj.get("items").get(0).get("login").asText();
			System.out.println(repoCount + "loginName=" + ss);
			return ss;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonString;
	}

}
