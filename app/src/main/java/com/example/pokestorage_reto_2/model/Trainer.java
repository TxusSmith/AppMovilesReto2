package com.example.pokestorage_reto_2.model;

import com.example.pokestorage_reto_2.model.pokemon.Pokemon;

import java.util.ArrayList;

public class Trainer {

    private String username;
    private ArrayList<Pokemon> pokemon;

    public Trainer(String username){
        this.username=username;
        pokemon = new ArrayList<Pokemon>();
    }

    public String getUsername(){
        return username;
    }

    public  ArrayList<Pokemon> getPokemon(){
        return pokemon;
    }

    public void addPokemon(Pokemon poke){
        pokemon.add(poke);
    }

    public void deletePokemon(String poke){
        if(!poke.isEmpty()){
            for (Pokemon i : pokemon){
                if(poke.equals(i.getName())){
                    pokemon.remove(i);
                }
            }
        }
    }
}
