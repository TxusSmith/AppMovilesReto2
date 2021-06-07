package com.example.pokestorage_reto_2;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonView extends RecyclerView.ViewHolder {

    private ConstraintLayout root;
    private TextView pokeName;
    private ImageView  pokeSprite;

    public PokemonView(ConstraintLayout root) {
        super(root);
        this.root=root;
        pokeName = root.findViewById(R.id.pokeName);
        pokeSprite = root.findViewById(R.id.pokeSprite);
    }

    public ConstraintLayout getRoot() {
        return root;
    }

    public TextView getPokeName() {
        return pokeName;
    }

    public ImageView getPokeSprite() {
        return pokeSprite;
    }
}
