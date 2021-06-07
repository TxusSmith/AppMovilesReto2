package com.example.pokestorage_reto_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pokestorage_reto_2.comm.HTTPSWebUtilDomi;
import com.example.pokestorage_reto_2.model.Main;
import com.example.pokestorage_reto_2.model.pokemon.Pokemon;
import com.example.pokestorage_reto_2.model.Trainer;
import com.google.gson.Gson;

import java.util.ArrayList;

public class StorageActivity extends AppCompatActivity implements View.OnClickListener, PokeAdapter.OnPokemonListener {

    private EditText catchPokeText;
    private Button catchButton;
    private EditText searchPokeText;
    private Button searchButton;
    private RecyclerView pokemonList;
    private LinearLayoutManager layoutManager;
    private PokeAdapter adapter;

    private Main main;
    private Trainer trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        catchPokeText = findViewById(R.id.catchPokeText);
        catchButton = findViewById(R.id.catchButton);

        searchPokeText = findViewById(R.id.searchPokeText);
        searchButton = findViewById(R.id.searchButton);

        pokemonList = findViewById(R.id.pokemonList);
        pokemonList.setHasFixedSize(true);
        pokemonList.setOnClickListener(this);

        catchButton.setOnClickListener(this);

        layoutManager = new LinearLayoutManager(this);
        pokemonList.setLayoutManager(layoutManager);

        main = new Main(new ArrayList<Pokemon>());
        String user = getIntent().getExtras().getString("username");

        trainer = main.getTrainer(user);

        adapter = new PokeAdapter(this);
        pokemonList.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch ( (v.getId())){
            case R.id.catchButton:
                new Thread(

                        ()->{
                            Gson gson = new Gson();
                            HTTPSWebUtilDomi utilDomi = new HTTPSWebUtilDomi();
                            String json = utilDomi.GETrequest("https://pokeapi.co/api/v2/pokemon/"+catchPokeText.getText().toString().toLowerCase());
                            Pokemon pokemon = gson.fromJson(json, Pokemon.class);

                            Log.e(">>>", pokemon.getName());
                            Log.e(">>>", pokemon.getSprites().getFront_default());
                            Log.e(">>>", pokemon.getTypes()[0].getType().getName());

                            runOnUiThread(()->{
                                trainer.addPokemon(pokemon);
                                adapter.addPoke(pokemon);
                            });
                        }

                ).start();

                break;
        }
    }

    @Override
    public void onPokemonClick(int position) {
        Intent intent = new Intent(this, PokemonActivity.class);
        intent.putExtra("pokemon", trainer.getPokemon().get(position));
        startActivity(intent);
    }
}