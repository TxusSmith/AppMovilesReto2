package com.example.pokestorage_reto_2.model.pokemon;

import android.os.Parcel;
import android.os.Parcelable;

public class Sprites implements Parcelable {

    private String front_default;

    public Sprites() {
    }

    public Sprites(String front_default) {
        this.front_default = front_default;
    }

    protected Sprites(Parcel in) {
        front_default = in.readString();
    }

    public static final Creator<Sprites> CREATOR = new Creator<Sprites>() {
        @Override
        public Sprites createFromParcel(Parcel in) {
            return new Sprites(in);
        }

        @Override
        public Sprites[] newArray(int size) {
            return new Sprites[size];
        }
    };

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(front_default);
    }
}
