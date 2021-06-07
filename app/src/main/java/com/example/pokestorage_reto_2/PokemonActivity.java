package com.example.pokestorage_reto_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokestorage_reto_2.model.pokemon.Pokemon;
import com.example.pokestorage_reto_2.model.pokemon.Type;
import com.example.pokestorage_reto_2.model.pokemon.Types;

public class PokemonActivity extends AppCompatActivity implements View.OnClickListener {

    private Button releaseButton;
    private ImageView pokeImage;
    private TextView pokemonName;
    private TextView typeText;
    private TextView defText;
    private TextView atkText;
    private TextView spdText;
    private TextView hpText;

    private Pokemon pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        releaseButton = findViewById(R.id.releaseButton);
        pokeImage = findViewById(R.id.pokeImage);
        pokemonName = findViewById(R.id.pokemonName);
        typeText = findViewById(R.id.typeText);
        defText = findViewById(R.id.defText);
        atkText = findViewById(R.id.atkText);
        spdText = findViewById(R.id.spdText);
        hpText = findViewById(R.id.hpText);

        releaseButton.setOnClickListener(this);

        if(getIntent().hasExtra("pokemon")){
            pokemon = getIntent().getParcelableExtra("pokemon");
            GlideApp.with(pokeImage).load(pokemon.getSprites().getFront_default()).into(pokeImage);

            pokemonName.setText(pokemon.getName());
            Log.e(">>>", pokemon.getTypes()[0].getType().getName());
            String types = "";
            if(pokemon.getTypes().length>1){
                types = "(" + pokemon.getTypes()[0].getType().getName() + "," + pokemon.getTypes()[1].getType().getName() + ")";
            }else{
                types = "(" + pokemon.getTypes()[0].getType().getName() + ")";
            }
            typeText.setText(types);

            defText.setText(Integer.toString(pokemon.getStats()[2].getBase_stat()));
            atkText.setText(Integer.toString(pokemon.getStats()[1].getBase_stat()));
            spdText.setText(Integer.toString(pokemon.getStats()[5].getBase_stat()));
            hpText.setText(Integer.toString(pokemon.getStats()[0].getBase_stat()));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.releaseButton:


                finish();

                break;
        }
    }
}