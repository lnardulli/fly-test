package com.fly.service;

import com.fly.model.Channel;
import com.fly.model.Content;
import com.fly.model.MovieContent;
import com.fly.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ChannelService {

    @Autowired
    ChannelRepository channelRepository;

    public List<Channel> list(){

        List<Channel> channels = channelRepository.findBySubchannelIsNull();

        return channels;

    }

    public Channel getChannelById(Long id) {

        Channel channel =  channelRepository.findById(id).get();
        System.out.println(channel);
        return channel;
    }

    public void create() {
        /*
        Channel channel = new Channel("SERIES", "ESP", "example.png");

        List<Channel> listSubChannels = new ArrayList<>();

        Channel channel_viaje = new Channel("Channel Viaje", "ESP", "example.png");

        Content contenviaje = new MovieContent(8f, "Chapter 1", "Charles Avila");
        Content contenviaje2 = new MovieContent(9f, "Chapter 2", "Charles Avila");
        Content contenviaje3 = new MovieContent(9f, "Chapter 2", "Charles Avila");
        Content contenviaje4 = new MovieContent(7f, "Chapter 2", "Charles Avila");

        List<Content> contentList = new ArrayList<>();
        contentList.add(contenviaje);
        contentList.add(contenviaje2);
        contentList.add(contenviaje3);
        contentList.add(contenviaje4);

        channel_viaje.setContentList(contentList);

        Channel channe_redbull = new Channel("RedBull", "ESP", "example.png");
        Channel channel_altres = new Channel("ALTRES", "ESP", "example.png");

        List<Channel> atresSubChannel = new ArrayList<>();

        Channel elClub = new Channel("El Club de la comedia", "ESP", "example.png");
        Channel elObjetivo = new Channel("El Objetivo", "ESP", "example.png");

        contentList = new ArrayList<>();
        Content contenElClub = new MovieContent(9f, "Chapter 1", "Santiago Segura");
        Content contenElClub2 = new MovieContent(8f, "Chapter 2", "Santiago Segura");

        contentList.add(contenElClub);
        contentList.add(contenElClub2);

        elClub.setContentList(contentList);

        Content contenElObjetivo = new MovieContent(8f, "Chapter 1", "Charles Avila");
        Content contenElObjetivo2 = new MovieContent(5f, "Chapter 2", "Charles Avila");
        Content contenElObjetivo3 = new MovieContent(9f, "Chapter 2", "Charles Avila");
        Content contenElObjetivo4 = new MovieContent(8f, "Chapter 2", "Charles Avila");

        contentList = new ArrayList<>();
        contentList.add(contenElObjetivo);
        contentList.add(contenElObjetivo2);
        contentList.add(contenElObjetivo3);
        contentList.add(contenElObjetivo4);
        //contentList.add(contenElObjetivo4);

        elObjetivo.setContentList(contentList);

        atresSubChannel.add(elClub);
        atresSubChannel.add(elObjetivo);

        channel_altres.setSubchannel(atresSubChannel);

        listSubChannels.add(channe_redbull);
        listSubChannels.add(channel_altres);
        listSubChannels.add(channel_viaje);

        channel.setSubchannel(listSubChannels);

        channelRepository.save(channel);

        */
        Channel channel = new Channel("PELICULAS", "ESP", "example.png");

        Content[] contenMovie = {
                new MovieContent(7.2f, "Movie 1", "Quentin Tarantino"),
                new MovieContent(4f, "Movie 2", "Quentin Tarantino"),
                new MovieContent(6f, "Movie 3", "Quentin Tarantino"),
                new MovieContent(6.5f, "Movie 4", "Quentin Tarantino")
        };

        channel.setContentList(Arrays.asList(contenMovie));

        channelRepository.save(channel);

    }


}
