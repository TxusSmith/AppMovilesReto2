package com.example.pokestorage_reto_2.model.pokemon;

import android.os.Parcel;
import android.os.Parcelable;

public class Stats implements Parcelable {

    private int base_stat;

    public Stats() {
    }

    public Stats(int base_stat) {
        this.base_stat = base_stat;
    }

    protected Stats(Parcel in) {
        base_stat = in.readInt();
    }

    public static final Creator<Stats> CREATOR = new Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(base_stat);
    }
}
