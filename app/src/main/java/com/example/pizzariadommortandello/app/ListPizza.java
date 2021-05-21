package com.example.pizzariadommortandello.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzariadommortandello.R;
import com.example.pizzariadommortandello.dataSQLite.DAOPizzas;
import com.example.pizzariadommortandello.dataSQLite.DBSchema;
import com.example.pizzariadommortandello.dataSQLite.Pizza;
import com.example.pizzariadommortandello.viewHolders.PizzaAdapter;

import java.util.ArrayList;

public class ListPizza extends AppCompatActivity  {

    ImageButton ib_back;
    Intent it_changeActivity;
    private RecyclerView rvPizza;
    private PizzaAdapter pizzaAdapter;
    private ArrayList<Pizza> pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);
        ib_back = findViewById(R.id.ib_back);
        this.rvPizza = findViewById(R.id.rvPizza);
        pizza= DAOPizzas.getAllPizzas(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.rvPizza.setLayoutManager(layoutManager);
        this.rvPizza.setHasFixedSize(true);
        this.pizzaAdapter = new PizzaAdapter(pizza, this);
        this.rvPizza.setAdapter(this.pizzaAdapter);
        Log.e(pizza.toString(),"Erro aqui");
    }

    public void onClick_ib_back (View v) {
        Intent it_changeActivity = new Intent(ListPizza.this, MainActivity.class);
        startActivity(it_changeActivity);
    };
}
