package com.learning.gsonexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by marcin on 09.10.13.
 */
public class JsonData {

    @SerializedName("Events")
    private List<Event> eventList;

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
