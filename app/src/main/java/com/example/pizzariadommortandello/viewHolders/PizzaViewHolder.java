package com.example.pizzariadommortandello.viewHolders;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzariadommortandello.dataSQLite.Pizza;
import com.example.pizzariadommortandello.R;

public class PizzaViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    private TextView tv_name_pizza;
    private TextView tv_price_pizza;
    private TextView tv_description_pizza;
    private Pizza pizza;
    private Activity activity;
    private PizzaAdapter.OnClickProdutoListener listener;

    public PizzaViewHolder(View itemView, final Activity activity){
        super(itemView);
        this.tv_name_pizza = itemView.findViewById(R.id.tv_name_pizza);
        this.tv_price_pizza = itemView.findViewById(R.id.tv_price_pizza);
        this.tv_description_pizza = itemView.findViewById(R.id.tv_description_pizza);
        this.activity = activity;

        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bind(final Pizza pizza) {
        this.pizza = pizza;
        this.tv_name_pizza.setText(this.pizza.getName());
        this.tv_price_pizza.setText(Double.toString(this.pizza.getPrice()));
        this.tv_description_pizza.setText(this.pizza.getDescription());

    }


    @Override
    public void onClick(View view) {
        this.listener.onClickProduto(this.pizza);
    }
}
