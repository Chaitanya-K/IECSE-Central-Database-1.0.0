package com.androidtutorialshub.loginregister.model;

/**
 * Created by mahe on 4/10/2017.
 */

public class Event {

    private int eventID;
    private String name;
    private String venue;
    private String type;


    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
