package com.COC_Project.COC_project.controller;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulerController {

	@Scheduled(fixedDelay = 5000)
	public void handler() {
		Date date = new Date();
		System.out.println(date);
	}
	
	@Scheduled(cron = "0/10 * * * * ?")
	public void handler1() {
		Date date = new Date();
		System.out.println("handler1 :"+date);
	}
}
