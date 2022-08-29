package com.example.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ObjectType")// ObjectType
public class ObjectType implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String ObjectType;

    public ObjectType(String ObjectType) {
        this.ObjectType = ObjectType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjectType() {
        return ObjectType;
    }

    public void setObjectType(String vehicleBrand) {
        this.ObjectType = ObjectType;
    }
}