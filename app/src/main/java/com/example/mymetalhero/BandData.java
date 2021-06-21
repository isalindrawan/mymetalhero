package com.example.mymetalhero;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;

public class BandData implements Parcelable {

    private String band, origin, status, genre, label, year, about;
    private int image;

    public BandData(String band, String origin,
                    String status, String genre, String label,
                    String year, String about, int image) {

        this.band = band;
        this.origin = origin;
        this.status = status;
        this.genre = genre;
        this.label = label;
        this.year = year;
        this.about = about;
        this.image = image;
    }

    protected BandData(Parcel in) {
        band = in.readString();
        origin = in.readString();
        status = in.readString();
        genre = in.readString();
        label = in.readString();
        year = in.readString();
        about = in.readString();
        image = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(band);
        dest.writeString(origin);
        dest.writeString(status);
        dest.writeString(genre);
        dest.writeString(label);
        dest.writeString(year);
        dest.writeString(about);
        dest.writeInt(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BandData> CREATOR = new Creator<BandData>() {
        @Override
        public BandData createFromParcel(Parcel in) {
            return new BandData(in);
        }

        @Override
        public BandData[] newArray(int size) {
            return new BandData[size];
        }
    };

    public String getBand() {
        return band;
    }

    public String getOrigin() {
        return origin;
    }

    public String getStatus() {
        return status;
    }

    public String getGenre() {
        return genre;
    }

    public String getLabel() {
        return label;
    }

    public String getYear() {
        return year;
    }

    public String getAbout() { return about; }

    public int getImage() { return image; }
}
