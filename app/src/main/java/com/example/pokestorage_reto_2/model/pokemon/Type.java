package com.example.pokestorage_reto_2.model.pokemon;

import android.os.Parcel;
import android.os.Parcelable;

public class Type implements Parcelable {

    private String name;

    public Type() {
    }

    public Type(String name) {
        this.name = name;
    }

    protected Type(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Type> CREATOR = new Creator<Type>() {
        @Override
        public Type createFromParcel(Parcel in) {
            return new Type(in);
        }

        @Override
        public Type[] newArray(int size) {
            return new Type[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
