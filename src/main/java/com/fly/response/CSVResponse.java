package com.fly.response;

import com.opencsv.bean.CsvBindByPosition;

public class CSVResponse {

    @CsvBindByPosition(position = 0)
    String title;

    @CsvBindByPosition(position = 1)
    Float rating;

    public CSVResponse(String title, Float rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
