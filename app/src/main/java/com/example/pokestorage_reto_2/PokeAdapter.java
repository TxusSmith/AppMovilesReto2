package com.example.pokestorage_reto_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokestorage_reto_2.model.pokemon.Pokemon;
import com.example.pokestorage_reto_2.model.pokemon.Sprites;
import com.example.pokestorage_reto_2.model.pokemon.Stats;
import com.example.pokestorage_reto_2.model.pokemon.Types;

import java.util.ArrayList;

public class PokeAdapter extends RecyclerView.Adapter<PokemonView> {

    private ArrayList<Pokemon> pokemon;

    public PokeAdapter(){
        pokemon = new ArrayList<>();
        pokemon.add(new Pokemon(25,"pikachu", new Sprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"),new Types[1], new Stats[5]));
    }

    public void addPoke(Pokemon poke){
        pokemon.add(poke);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.pokerow,parent,false);
        ConstraintLayout rowroot = (ConstraintLayout) row;
        PokemonView pokemonView = new PokemonView(rowroot);

        return pokemonView;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonView holder, int position) {
        holder.getPokeName().setText(pokemon.get(position).getName());
        String url = pokemon.get(position).getSprites().getFront_default();
        GlideApp.with(holder.getPokeSprite()).load(url).into(holder.getPokeSprite());
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

}
