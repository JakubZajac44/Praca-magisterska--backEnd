package com.ar.backend.backeend.model.device;


import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;


public class Device {


    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private String name;

    @Getter
    @Setter
    private String sample;

    @Setter
    @Getter
    private double lat;

    @Setter
    @Getter
    private double lon;

    @Setter
    @Getter
    private String updatetime;

    public Device() {
    }

    public Device(int id, String name, String sample, double lat, double lon, Date date) {
        this.id = id;
        this.name = name;
        this.sample = sample;
        this.lat = lat;
        this.lon = lon;
        this.updatetime = this.getDateAsString(date);
    }

    private String getDateAsString(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        StringBuilder dateString = new StringBuilder();
        dateString.append(cal.get(Calendar.DAY_OF_MONTH)).append(".").append(cal.get(Calendar.MONTH)+1).append(".")
                .append(cal.get(Calendar.YEAR)).append(", ").append(cal.get(Calendar.HOUR)).append(":").append(cal.get(Calendar.MINUTE));
        return dateString.toString();
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sample='" + sample + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", date=" + updatetime +
                '}';
    }
}
