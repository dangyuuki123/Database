package com.example.database.DAO;

import android.content.Context;

import androidx.room.RoomDatabase;

import com.example.database.entity.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {Event.class , Colour.class , Geo2D.class, ObjectLabel.class , ObjectType.class , ViolateType.class, VideoEvent.class}, version = 2)

public abstract class Database extends RoomDatabase {
private static final  String DATABASE_NAME = "Event.db";
private static Database instance;
public static synchronized Database getInstance(Context context){
    if(instance == null){
        instance = androidx.room.Room.databaseBuilder(context.getApplicationContext() , Database.class , DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }
    return instance;
}



    public abstract DAOEvent useEvent();
    public abstract DAOColour useColour();
    public abstract DAOGeo2D useGeo2D();
    public abstract DAOObjectLabel useObjectLabel();
    public abstract DAOObjectType useObjectType();
    public abstract DAOViolateType useViolateType();
    public abstract DAOVideo useVideoEvent();



}
