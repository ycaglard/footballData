package com.example.smemo;

import com.example.smemo.dto.StatisticsDTO;
import com.example.smemo.service.ScrapeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class SmemoApplicationTests {
	@Autowired
	ScrapeService scrapeService;

	@Test
	void contextLoads() {
	}

	@Test
	void send_request_get_json(){
		try {
			scrapeService.getScores(new Date());
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}

	@Test
	void get_date_return_scores() throws JsonProcessingException {
		List<StatisticsDTO> statisticsDTOList = scrapeService.getScores(new Date());

		for (int i = 0; i < statisticsDTOList.size(); i++) {
			System.out.println(statisticsDTOList.get(i).getOutcome());
		}
	}

}
