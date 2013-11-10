package com.deloitte.google.medassist.data;

import android.os.Parcel;
import android.os.Parcelable;

public class DoctorsReview implements Parcelable {

    String reviewerName;
    int rating;
    String comments;

    public DoctorsReview(Parcel source) {
        readFromParcel(source);
    }

    public DoctorsReview(String pipeSeperatedString) {
        String[] data = pipeSeperatedString.split("|");
        reviewerName = data[0];
        rating = Integer.parseInt(data[1]);
        comments = data[2];
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(reviewerName);
        dest.writeInt(rating);
        dest.writeString(comments);

    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void readFromParcel(Parcel source) {
        reviewerName = source.readString();
        rating = source.readInt();
        comments = source.readString();
    }

    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public DoctorsReview createFromParcel(Parcel in) {
            return new DoctorsReview(in);
        }

        @Override
        public DoctorsReview[] newArray(int size) {
            return new DoctorsReview[size];
        }

    };

}
