package com.fly.controller;

import com.fly.model.Channel;
import com.fly.response.CSVResponse;
import com.fly.service.ChannelService;
import com.fly.service.RatingService;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import com.opencsv.CSVWriter;

import static java.util.stream.Collectors.toMap;

@RestController
@RequestMapping("/v1/api")
public class ChannelController {

    @Autowired
    RatingService ratingService;

    @Autowired
    ChannelService channelService;


    @GetMapping("/populate")
    public @ResponseBody
    ResponseEntity<List<Channel>> create() {
        channelService.create();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/list")
    public @ResponseBody
    ResponseEntity<List<Channel>> list() {
        return new ResponseEntity<>(channelService.list(), HttpStatus.OK);
    }

    @GetMapping("/full/{id}")
    public @ResponseBody ResponseEntity<Channel> getFullDetail(@PathVariable("id") Long id) {
        return new ResponseEntity<>(channelService.getChannelById(id), HttpStatus.OK);
    }

    @GetMapping("/export-rating")
    public void exportCSV(HttpServletResponse response) throws Exception {

        String filename = "rating"+ System.currentTimeMillis()+".csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        StatefulBeanToCsv<CSVResponse> writer = new StatefulBeanToCsvBuilder<CSVResponse>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        List<Channel> channels = channelService.list();
        HashMap<String, Float> rating = ratingService.obtaingRatings(channels);

        Map<String, Float> sorted  = rating
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        for (Map.Entry<String, Float> entry : sorted.entrySet()) {
            writer.write(new CSVResponse(entry.getKey(), entry.getValue()));
        }

    }


}
