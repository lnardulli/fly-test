package com.fly.service;

import com.fly.model.Channel;
import com.fly.model.Content;
import com.fly.model.MovieContent;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class RatingServiceTest {

    @Test
    void testobtainRatingsPerChannel() {

        RatingService ratingService = new RatingService();

        List<Channel> channelList = new ArrayList<>();
        List<Channel> listSubChannels = new ArrayList<>();
        List<Channel> atresSubChannel = new ArrayList<>();

        Content[] contenviaje = {
                new MovieContent(8f, "Chapter 1", "Charles Avila"),
                new MovieContent(9f, "Chapter 2", "Charles Avila"),
                new MovieContent(9f, "Chapter 3", "Charles Avila"),
                new MovieContent(7f, "Chapter 4", "Charles Avila")
        };

        Content[] contenElObjetivo = {
                new MovieContent(8f, "Chapter 1", "Albert Gery"),
                new MovieContent(5f, "Chapter 2", "Albert Gery"),
                new MovieContent(9f, "Chapter 3", "Albert Gery")
        };

        Content[] contentElClub = {
                new MovieContent(9f, "Chapter 1", "Almodobar"),
                new MovieContent(8f, "Chapter 2", "Almodobar")
        };

        Channel channel = new Channel("SERIES", "ESP", "example.png");
        Channel channe_redbull = new Channel("RedBull", "ESP", "example.png");
        Channel channel_altres = new Channel("ALTRES", "ESP", "example.png");
        Channel channel_viaje = new Channel("Channel Viaje", "ESP", "example.png");

        channel_viaje.setContentList(Arrays.asList(contenviaje));


        Channel elClub = new Channel("El Club de la comedia", "ESP", "example.png");
        Channel elObjetivo = new Channel("El Objetivo", "ESP", "example.png");

        elClub.setContentList(Arrays.asList(contentElClub));
        elObjetivo.setContentList(Arrays.asList(contenElObjetivo));

        atresSubChannel.add(elClub);
        atresSubChannel.add(elObjetivo);

        channel_altres.setSubchannel(atresSubChannel);

        listSubChannels.add(channe_redbull);
        listSubChannels.add(channel_altres);
        listSubChannels.add(channel_viaje);

        channel.setSubchannel(listSubChannels);

        Channel channel2 = new Channel("PELICULAS", "ESP", "example.png");

        Content[] contenMovie = {
                new MovieContent(7.2f, "Movie 1", "Quentin Tarantino"),
                new MovieContent(4f, "Movie 2", "Quentin Tarantino"),
                new MovieContent(6f, "Movie 3", "Quentin Tarantino"),
                new MovieContent(6.5f, "Movie 4", "Quentin Tarantino")
        };

        channel2.setContentList(Arrays.asList(contenMovie));

        channelList.add(channel);
        channelList.add(channel2);

        HashMap<String, Float> result = ratingService.obtaingRatings(channelList);

        assertEquals(2, result.size());
        assertEquals(new Double("8.027777671813965"), (Double) result.get("SERIES").doubleValue());
        assertEquals(new Double("5.925000190734863"), (Double) result.get("PELICULAS").doubleValue());

    }

}