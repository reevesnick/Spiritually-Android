package com.app.spritually.dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.app.spritually.model.HistoryModel;

import org.jetbrains.annotations.NotNull;

@Database(entities = {HistoryModel.class}, version = 1)
public abstract class HistoryDatabase extends RoomDatabase {

    private static HistoryDatabase instance;
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NotNull SupportSQLiteDatabase db){
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    public static synchronized HistoryDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), HistoryDatabase.class, "history_db").addCallback(roomCallback).build();
        }
        return instance;
    }
    
    public abstract HistoryDao historyDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private HistoryDao historyDao;
        private PopulateDbAsyncTask(HistoryDatabase db) {
            historyDao = db.historyDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
