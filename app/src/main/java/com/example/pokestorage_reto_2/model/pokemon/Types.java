package com.example.pokestorage_reto_2.model.pokemon;

import android.os.Parcel;
import android.os.Parcelable;

public class Types implements Parcelable {

    private Type type;

    public Types() {
    }

    public Types(Type type) {
        this.type = type;
    }

    protected Types(Parcel in) {
        type = in.readParcelable(Type.class.getClassLoader());
    }

    public static final Creator<Types> CREATOR = new Creator<Types>() {
        @Override
        public Types createFromParcel(Parcel in) {
            return new Types(in);
        }

        @Override
        public Types[] newArray(int size) {
            return new Types[size];
        }
    };

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(type, flags);
    }
}
