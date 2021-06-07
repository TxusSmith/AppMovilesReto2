package com.example.pokestorage_reto_2.model.pokemon;

public class Pokemon {

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
}
