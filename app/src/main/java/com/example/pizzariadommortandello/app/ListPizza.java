package com.example.pizzariadommortandello.app;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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

    private RecyclerView rvPizza;
    private PizzaAdapter pizzaAdapter;
    private ArrayList<Pizza> pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.rvPizza = findViewById(R.id.rvPizza);
        pizza= DAOPizzas.getAllPizzas(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.rvPizza.setLayoutManager(layoutManager);
        this.rvPizza.setHasFixedSize(true);
        this.pizzaAdapter = new PizzaAdapter(pizza, this);
        this.rvPizza.setAdapter(this.pizzaAdapter);
        Log.e(pizza.toString(),"Erro aqui");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
