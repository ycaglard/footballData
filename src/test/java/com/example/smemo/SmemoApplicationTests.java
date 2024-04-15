package com.example.smemo;

import com.example.smemo.dto.StatisticsDTO;
import com.example.smemo.service.ScrapeService;
import com.example.smemo.service.StatisticsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SmemoApplicationTests {
	@Autowired
	ScrapeService scrapeService;

	@Autowired
	StatisticsService statisticsService;

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

	@Test
	void get_scores_return_biggest_gap() throws JsonProcessingException, ParseException {
		String dateString = "2024-04-14";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateString);
		StatisticsDTO statisticsDTO = statisticsService.findLargestScoreGap(scrapeService.getScores(date));

	}
	@Test
	void get_scores_return_max_goal() throws ParseException, JsonProcessingException {
		String dateString = "2024-04-14";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateString);
		StatisticsDTO statisticsDTO = statisticsService.findMostGoalsScored(scrapeService.getScores(date));
	}

}
