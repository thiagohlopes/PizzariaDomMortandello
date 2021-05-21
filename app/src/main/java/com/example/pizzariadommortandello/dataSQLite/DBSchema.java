package com.example.pizzariadommortandello.dataSQLite;

import android.provider.BaseColumns;

public class DBSchema {

    public static final class Pizza implements BaseColumns {
        public static final String TABLENAME = "menuPizza";
        public static final String PRICE = "p_price";
        public static final String TIMESTAMP = "p_timestamp";
        public static final String NAME = "p_name";
        public static final String Description = "p_description";

        public static final String getCreationQuery() {
            return "CREATE TABLE " + TABLENAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME + " TEXT, " +
                    PRICE + " REAL, " +
                    Description + " TEXT," +
                    TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                    ")";
        }
    }

}