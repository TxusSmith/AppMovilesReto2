package com.example.pokestorage_reto_2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ConstraintLayout root;
    private TextView pokeName;
    private ImageView  pokeSprite;
    private PokeAdapter.OnPokemonListener onPokemonListener;

    public PokemonView(ConstraintLayout root, PokeAdapter.OnPokemonListener onPokemonListener) {
        super(root);
        this.root=root;
        pokeName = root.findViewById(R.id.pokeName);
        pokeSprite = root.findViewById(R.id.pokeSprite);
        this.onPokemonListener=onPokemonListener;
        root.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        onPokemonListener.onPokemonClick(getAdapterPosition());
    }
}
