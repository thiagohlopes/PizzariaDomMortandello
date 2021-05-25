package com.example.pizzariadommortandello.app;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzariadommortandello.dataSQLite.DAOPizzas;
import com.example.pizzariadommortandello.dataSQLite.Pizza;
import com.example.pizzariadommortandello.R;

import java.util.ArrayList;

public class NewPizza extends AppCompatActivity {

    Button btn_save;
    TextView tv_description_new_pizza;
    TextView tv_name_new_pizza;
    TextView tv_price_new_pizza;
    private Pizza pizza;
    private Activity activity;

    private ArrayList<Pizza> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pizza);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_save = findViewById(R.id.btn_save);
        tv_description_new_pizza = findViewById(R.id.tv_description_new_pizza);
        tv_name_new_pizza = findViewById(R.id.tv_name_new_pizza);
        tv_price_new_pizza = findViewById(R.id.tv_price_new_pizza);
        this.activity = this;
        this.btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float price = Float.parseFloat(tv_price_new_pizza.getText().toString());
                Pizza pizza = new Pizza(price, tv_name_new_pizza.getText().toString(),tv_description_new_pizza.getText().toString());
                DAOPizzas.insertPizza(activity, pizza);
                finish();
            }
        });
    }
    public void bind(final Pizza pizza) {
        this.pizza = pizza;
        this.tv_name_new_pizza.setText(this.pizza.getName());
        this.tv_price_new_pizza.setText(Double.toString(this.pizza.getPrice()));
        this.tv_description_new_pizza.setText(this.pizza.getDescription());
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
