package com.example.pokestorage_reto_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokestorage_reto_2.model.pokemon.Pokemon;
import com.example.pokestorage_reto_2.model.pokemon.Type;
import com.example.pokestorage_reto_2.model.pokemon.Types;

public class PokemonActivity extends AppCompatActivity {

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

        if(getIntent().hasExtra("pokemon")){
            pokemon = getIntent().getParcelableExtra("pokemon");

            pokemonName.setText(pokemon.getName());
            Log.e(">>>", pokemon.getTypes()[0].getType().getName());
            String types = "";
            if(pokemon.getTypes().length>1){
                types = "(" + pokemon.getTypes()[0].getType() + "," + pokemon.getTypes()[1].getType() + ")";
            }else{
                types = "(" + pokemon.getTypes()[0].getType() + ")";
            }
            typeText.setText(types);

            defText.setText(pokemon.getStats()[2].getBase_stat());
            atkText.setText(pokemon.getStats()[1].getBase_stat());
            spdText.setText(pokemon.getStats()[5].getBase_stat());
            hpText.setText(pokemon.getStats()[0].getBase_stat());
        }



        //GlideApp.with(pokeImage).load(pokemon.getSprites().getFront_default()).into(pokeImage);

    }
}