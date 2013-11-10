package com.deloitte.google.medassist.data;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class Doctor implements Parcelable {

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

    public Doctor(Parcel source) {
        readFromParcel(source);
    }

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

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(area);
        dest.writeString(specialisation);
        dest.writeString(phone1);
        dest.writeString(phone2);
        dest.writeString(address);
        dest.writeString(timings);
        dest.writeString(daysOfWeeks);
        dest.writeList(reviews);

    }

    public void readFromParcel(Parcel source) {
        name = source.readString();
        id  = source.readString();
        area = source.readString();
        specialisation  = source.readString();
        phone1 = source.readString();
        phone2 = source.readString();
        address = source.readString();
        timings = source.readString();
        daysOfWeeks = source.readString();
        source.readList(reviews, this.getClass().getClassLoader());
    }

    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Doctor createFromParcel(Parcel in) {
            return new Doctor(in);
        }

        @Override
        public Doctor[] newArray(int size) {
            return new Doctor[size];
        }

    };

}
