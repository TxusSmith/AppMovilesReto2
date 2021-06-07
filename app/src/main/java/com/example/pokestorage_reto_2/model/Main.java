package com.example.pokestorage_reto_2.model;

import com.example.pokestorage_reto_2.model.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private ArrayList<Trainer> trainers;
    private ArrayList<Pokemon> pokemon;

    public Main(ArrayList pokemon){
        trainers=new ArrayList<Trainer>();
        this.pokemon=pokemon;
    }

    public Trainer getTrainer(String trainer){
        for(Trainer i : trainers){
            if(trainer.equals(i.getUsername())){
                return i;
            }
        }
        Trainer n = new Trainer(trainer);
        trainers.add(n);
        return n;
    }

    public Trainer refreshTrainer(Trainer train){
        Collections.replaceAll(trainers, getTrainer(train.getUsername()), train);
        return train;
    }

    public Pokemon getPokemon(String poke){
        for(Pokemon i : pokemon){
            if(poke.equals(i.getName())){
                return i;
            }
        }
        return null;
    }

    public void addPokemon(String username, String poke){
        Trainer t = getTrainer(username);
        t.addPokemon(getPokemon(poke));
        Collections.replaceAll(trainers, getTrainer(username), t);
    }

    public void deletepokemon(String username, String poke){
        Trainer t = getTrainer(username);
        t.deletePokemon(poke);
        Collections.replaceAll(trainers, getTrainer(username), t);
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemon;
    }
}
