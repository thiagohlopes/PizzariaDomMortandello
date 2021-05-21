package com.example.pizzariadommortandello.dataSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DAOPizzas {

    public static final void execQueryPizza(Context context, String sql) {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    public static final void insertPizza(Context context, Pizza pizza) {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DBSchema.Pizza.PRICE, pizza.getPrice());
        cv.put(DBSchema.Pizza.NAME, pizza.getName());
        cv.put(DBSchema.Pizza.Description, pizza.getDescription());
        db.insert(DBSchema.Pizza.TABLENAME, null, cv);
        db.close();
    }


    public static final ArrayList<Pizza> getAllPizzas(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Pizza> pizzas = new ArrayList<>();

        // SELECT * FROM pizza;

        Cursor cursor = db.query(
                DBSchema.Pizza.TABLENAME,
                null,
                null,
                null,
                null,
                null,
                DBSchema.Pizza.TIMESTAMP
        );

        while(cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(DBSchema.Pizza._ID));
            float price = cursor.getFloat(cursor.getColumnIndex(DBSchema.Pizza.PRICE));
            String timeStamp = cursor.getString(cursor.getColumnIndex(DBSchema.Pizza.TIMESTAMP));
            String name = cursor.getString(cursor.getColumnIndex(DBSchema.Pizza.NAME));
            String description = cursor.getString(cursor.getColumnIndex(DBSchema.Pizza.Description));
            Pizza pizza = new Pizza( id,  price,  name,  timeStamp,  description);
            pizzas.add(pizza);
            Log.e(pizza.toString(),"PIZZZZZZZZZAAAAAAAAAAAAAAAA");
        }

        cursor.close();
        db.close();

        return pizzas;
    }
}
