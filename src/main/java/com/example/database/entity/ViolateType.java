package com.example.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ViolateType" )
public class ViolateType implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private  String violateName;
    private String violateDescription;

    public ViolateType(String violateName, String violateDescription) {
        this.violateName = violateName;
        this.violateDescription = violateDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getViolateName() {
        return violateName;
    }

    public void setViolateName(String violateName) {
        this.violateName = violateName;
    }

    public String getViolateDescription() {
        return violateDescription;
    }

    public void setViolateDescription(String violateDescription) {
        this.violateDescription = violateDescription;
    }
}

