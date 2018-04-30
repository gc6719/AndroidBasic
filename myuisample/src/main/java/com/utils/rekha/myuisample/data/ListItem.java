package com.utils.rekha.myuisample.data;

/**
 * Created by Gururaj on 4/28/2018.
 */

public class ListItem {
    private String title;
    private String dateAndTime ;
    private int resourceId;

    public ListItem(String title, String dateAndTime, int resourceId) {
        this.title = title;
        this.dateAndTime = dateAndTime;
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
