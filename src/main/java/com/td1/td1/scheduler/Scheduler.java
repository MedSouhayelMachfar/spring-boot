package com.td1.td1.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Scheduler {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTimeUsingRate() {
        log.info("FixedRate : The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTimeUsingDelay() {
        log.info("FixedDelay : The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void cronMethod() {
        log.info("Method with cron expression");
    }
}
