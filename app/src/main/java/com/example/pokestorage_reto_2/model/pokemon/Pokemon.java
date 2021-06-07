package com.example.pokestorage_reto_2.model.pokemon;

import android.os.Parcel;
import android.os.Parcelable;

public class Pokemon implements Parcelable {

    private int id;
    private String name;

    private Sprites sprites;
    private Types[] types;
    private Stats[] stats;
    //0 = hp, 1 = attack, 2 = defense, 5 = speed

    public Pokemon() {
    }

    public Pokemon(int id, String name, Sprites sprites, Types[] types, Stats[] stats) {
        this.id = id;
        this.name = name;
        this.sprites = sprites;
        this.types = types;
        this.stats = stats;
    }

    protected Pokemon(Parcel in) {
        id = in.readInt();
        name = in.readString();
        sprites = in.readParcelable(Sprites.class.getClassLoader());
        types = in.createTypedArray(Types.CREATOR);
        stats = in.createTypedArray(Stats.CREATOR);
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public Types[] getTypes() {
        return types;
    }

    public void setTypes(Types[] types) {
        this.types = types;
    }

    public Stats[] getStats() {
        return stats;
    }

    public void setStats(Stats[] stats) {
        this.stats = stats;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(sprites, flags);
        dest.writeTypedArray(types, flags);
        dest.writeTypedArray(stats, flags);
        dest.writeInt(id);
        dest.writeString(name);

    }
}
