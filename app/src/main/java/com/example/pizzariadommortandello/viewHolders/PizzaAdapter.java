package com.example.pizzariadommortandello.viewHolders;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzariadommortandello.dataSQLite.Pizza;

import java.util.ArrayList;
import com.example.pizzariadommortandello.R;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaViewHolder>{

    private ArrayList<Pizza> pizzas;
    private Activity activity;

    public interface OnClickProdutoListener {
        void onClickProduto(Pizza pizza);
    }

    public PizzaAdapter(ArrayList<Pizza> Pizzas, Activity activity) {
        this.pizzas = Pizzas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_view_holder_pizza, parent, false);
        PizzaViewHolder viewHolder = new PizzaViewHolder(itemView, activity);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {
        holder.bind(this.pizzas.get(position));
    }

    @Override
    public int getItemCount() {
        if(this.pizzas!=null)
            return this.pizzas.size();
        else return 0;
    }
}
