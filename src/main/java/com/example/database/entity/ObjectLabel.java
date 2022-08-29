package com.example.database.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ObjectLabel")//Brand -> ObjectLabel

public class ObjectLabel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String ObjectLabel;

    public ObjectLabel(String ObjectLabel) {
        this.ObjectLabel = ObjectLabel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjectLabel() {
        return ObjectLabel;
    }

    public void setObjectLabel(String objectLabel) {
        ObjectLabel = objectLabel;
    }
}
