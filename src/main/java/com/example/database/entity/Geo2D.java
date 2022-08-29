package com.example.database.entity;

import static androidx.room.ForeignKey.CASCADE;
import static androidx.room.ForeignKey.SET_NULL;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Geo2D"
        , foreignKeys = @ForeignKey(entity = Colour.class , parentColumns = "id" , childColumns = "colorId" , onUpdate = CASCADE , onDelete = SET_NULL)
)
public class Geo2D implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int geoType;
    private String pointList;
    @Nullable
    private Long colorId;
    private String label;

    public Geo2D(int geoType, String pointList, String label , Long colorId) {
        this.geoType = geoType;
        this.pointList = pointList;
        this.label = label;
        this.colorId = colorId;
    }
    @Ignore
    public Geo2D(int geoType, String pointList, String label) {
        this.geoType = geoType;
        this.pointList = pointList;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeoType() {
        return geoType;
    }

    public void setGeoType(int geoType) {
        this.geoType = geoType;
    }

    public String getPointList() {
        return pointList;
    }

    public void setPointList(String pointList) {
        this.pointList = pointList;
    }

    public long getColorId() {
        return colorId;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
