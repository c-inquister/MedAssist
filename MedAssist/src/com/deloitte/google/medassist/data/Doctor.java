package com.deloitte.google.medassist.data;

import java.util.List;

public class Doctor {

    public String name;
    public String id;
    public String area;
    public String specialisation;
    public String phone1;
    public String phone2;
    public String address;

    public String timings;
    public String daysOfWeeks;

    public List<DoctorsReview> reviews;

    public Doctor(String id, String name, String area, String phone1, String phone2, String specialisation,
            String address, String timings, String daysOfWeeks, List<DoctorsReview> reviews) {
        super();
        this.name = name;
        this.id = id;
        this.area = area;
        this.specialisation = specialisation;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;
        this.timings = timings;
        this.daysOfWeeks = daysOfWeeks;
        this.reviews = reviews;
    }

    public Doctor(String id, String name, String area, String specialisation, String phone1, String phone2, String address, String timings, String daysOfWeeks) {
        super();
        this.name = name;
        this.id = id;
        this.area = area;
        this.specialisation = specialisation;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;
        this.timings = timings;
        this.daysOfWeeks = daysOfWeeks;
    }

}
