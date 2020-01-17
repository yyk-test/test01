package com.example.demo.Cron;

import com.example.demo.Controller.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestScheduler {

    Logger log = LoggerFactory.getLogger(TestScheduler.class);

    @Autowired
    TestController controller;

    @PostConstruct
    public void init() {
        String cronJobExpression = "0/5 * * * * *";

        CronTrigger cronJobTrigger = new CronTrigger(cronJobExpression);

        final ConcurrentTaskScheduler taskScheduler = new ConcurrentTaskScheduler();

        final Runnable task = new Runnable() {

            @Override
            public void run() {
                log.info("This is cron");
                
            }
        };
        taskScheduler.schedule(task, cronJobTrigger);



    }
}

