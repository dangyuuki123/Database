package com.example.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Colour" )
public class Colour implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private  String ColorValue;
    private String ColorName;

    public Colour(String ColorValue, String ColorName) {
        this.ColorValue = ColorValue;
        this.ColorName = ColorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorValue() {
        return ColorValue;
    }

    public void setColorValue(String colorValue) {
        ColorValue = colorValue;
    }

    public String getColorName() {
        return ColorName;
    }

    public void setColorName(String colorName) {
        ColorName = colorName;
    }
}
