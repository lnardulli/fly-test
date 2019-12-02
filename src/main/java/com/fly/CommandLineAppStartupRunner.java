package com.fly;

import com.fly.service.RatingExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private RatingExportService ratingExportService;

    @Override
    public void run(String...args) throws Exception {

        if (args.length == 0) {
            return;
        }

        ratingExportService.download(args[0]);
        System.exit(0);

    }
}
