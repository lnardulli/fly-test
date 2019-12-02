package com.fly;

import com.fly.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class MainApplication {

    //@Autowired
    //RatingService ratingService;


	/*
	@Autowired
	CalculateAverageService calculateAverageService;


	public static void main(String[] args) {
		Channel channel = new Channel("SERIE", "ESP", "example.png");

		Channel subchanel = new Channel("Series Argentinas", "ESP", "example.png");

		Channel subchanel1 = new Channel("Drama", "ESP", "example.png");

		Channel subchanel2 = new Channel("El marginal", "ESP", "example.png");


		List<Content> contenidoList = new ArrayList<>();

		MovieContent movieContent = new MovieContent(2.8f);
		contenidoList.add(movieContent);
		MovieContent movieContent2 = new MovieContent(2.2f);
		contenidoList.add(movieContent2);
		MovieContent movieContent3 = new MovieContent(3.7f);
		contenidoList.add(movieContent3);
		MovieContent movieContent4 = new MovieContent(4.3f);
		contenidoList.add(movieContent4);

		List<Content> contenidoList2 = new ArrayList<>();

		movieContent = new MovieContent(2.8f);
		contenidoList2.add(movieContent);
		movieContent2 = new MovieContent(2.2f);
		contenidoList2.add(movieContent2);
		movieContent3 = new MovieContent(2.7f);
		contenidoList2.add(movieContent3);
		movieContent4 = new MovieContent(1.3f);
		contenidoList2.add(movieContent4);


		channel.setSubchannel(subchanel);
		channel.getSubchannel().setContentList(contenidoList);
		channel.getSubchannel().setSubchannel(subchanel1);
		channel.getSubchannel().getSubchannel().setSubchannel(subchanel2);
		channel.getSubchannel().getSubchannel().getSubchannel().setContentList(contenidoList);

		System.out.println("Channel ----------");
		System.out.println(channel);
		System.out.println("------------------");

		Float result = obtainRatingsPerContent(channel);

		System.out.println("-----");
		System.out.println(channel.getTitle() + ": Rating: "  + result);
		System.out.println("-----");

	}
	public static Float calculateAvgTotal(List<Float> listAvg) {

		Float avgFinal = 0f;
		for(int i = 1; i < listAvg.size(); i++)
			avgFinal += listAvg.get(i);

		return (avgFinal > 0) ? avgFinal / listAvg.size() : 0.0f;

	}
	public static float calculateAvg(List<Content> content) {
		float avg = 0f;

		if(content != null && content.size() > 0) {
			for (Content cont : content) {
				avg = avg + cont.getRating();
			}
			avg = avg / content.size();
		}
		return avg;
	}

	public static Float obtainRatingsPerContent(Channel channel, List<Float> avg) {

		if(channel.getContentList() != null && channel.getContentList().size() > 0)
			avg.add(calculateAvg(channel.getContentList()));


		if (channel.getSubchannel() != null)
			return obtainRatingsPerContent(channel.getSubchannel(), avg);

		return calculateAvgTotal(avg);
	}

	public static Float obtainRatingsPerContent(Channel channel) {

		List<Float> avg = new ArrayList<Float>();
		return obtainRatingsPerContent(channel, avg);

	}*/



}
