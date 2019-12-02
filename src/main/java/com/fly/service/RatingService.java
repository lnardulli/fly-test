package com.fly.service;

import com.fly.model.Channel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RatingService {

    public Float obtainRatingsPerChannel(Channel channel, List<Float> avg) {

        if(channel.getContentList() != null && channel.getContentList().size() > 0) {
            avg.add((float) channel.getContentList().stream()
                    .mapToDouble(content -> content.getRating() )
                    .average()
                    .orElse(Double.NaN));
        }

        if(channel.getSubchannel() != null && channel.getSubchannel().size() > 0) {
            for(Channel subchannel : channel.getSubchannel()) {
                    obtainRatingsPerChannel(subchannel, avg);
            }
        }

        return (float) avg.stream()
                .mapToDouble(num -> num)
                .average()
                .orElse(Double.NaN);
    }

    public Float obtainRatingsPerChannel(Channel channel) {

        List<Float> avg = new ArrayList<>();
        return obtainRatingsPerChannel(channel, avg);

    }

    public HashMap<String, Float> obtaingRatings(List<Channel> channels) {
        HashMap<String, Float> result = new HashMap<>();

        try {

            for(Channel channel : channels)
                result.put(channel.getTitle(), obtainRatingsPerChannel(channel));

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        return result;

    }

}
