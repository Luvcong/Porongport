package com.kh.porong.weather.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {

	public static final String SERVICEKEY = "e7bb6f29056cea75514ebd200f58625b";
	
	@ResponseBody
	@RequestMapping(value="weather", produces="application/json; charset=UTF-8")
	public String busanfood(int pageNo) throws IOException {
		String url = "https://api.openweathermap.org/data/2.5/weather";
		url += "?lat=126.9778";//서울
		url += "&lon=37.5683";//서울
		url += "&lang=kr";
		url += "&units=metric";
		url += "&appid="+SERVICEKEY;
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseText = br.readLine();
		
		br.close();
		urlConnection.disconnect();
		
		return responseText;
	}
	
}
