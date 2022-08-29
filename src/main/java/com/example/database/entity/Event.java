package com.example.database.entity;

import static androidx.room.ForeignKey.CASCADE;
import static androidx.room.ForeignKey.SET_NULL;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.*;

import java.io.Serializable;


@Entity(tableName = "Event", foreignKeys = {
        @ForeignKey(entity = Colour.class,
                parentColumns = "id",
                childColumns = "colorId",
                onUpdate = CASCADE , onDelete = SET_NULL),
        @ForeignKey(entity = ObjectType.class,
                parentColumns = "id",
                childColumns = "vehicleTypeId",
                onUpdate = CASCADE , onDelete = SET_NULL),
        @ForeignKey(entity = ObjectLabel.class,
                parentColumns = "id",
                childColumns = "vehicleBrandId",
                onUpdate = CASCADE , onDelete = SET_NULL),
        @ForeignKey(entity = ViolateType.class,
                parentColumns = "id",
                childColumns = "violetTypeId",
                onUpdate = CASCADE , onDelete = SET_NULL),
        @ForeignKey(entity = VideoEvent.class ,
                    parentColumns = "id",
                    childColumns = "VideoId",
                    onUpdate = CASCADE , onDelete = SET_NULL)
} ,
indices = @Index(value = "time"))
public class Event implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @Nullable
    private Long vehicleTypeId;
    @Nullable
    private Long colorId;
    @Nullable
    private Long vehicleBrandId;
    @Nullable
    private Long violetTypeId;
    private Long time;
    private String LPLabel;
    private String ImageFullPath;
    private String ImageCropVehiclePath;
    private Integer VideoId;
    long Id;
    long nameid;
    long shotTime;
    String Name;

    public Event(long id, long nameid, long shotTime, String name, ...) {
        this.Id = id;
        this.nameid = nameid;
        this.shotTime = shotTime;
        this.Name = name;
        ...;
    }
    public long getNameid() {
        return nameid;
    }

    public void setNameid(long nameid) {
        this.nameid = nameid;
    }

    public Event(Long vehicleTypeId, Long colorId, Long vehicleBrandId, Long violetTypeId, Long time, String LPLabel, String ImageFullPath, String ImageCropVehiclePath, Integer VideoId) {
        this.vehicleTypeId = vehicleTypeId;
        this.colorId = colorId;
        this.vehicleBrandId = vehicleBrandId;
        this.violetTypeId = violetTypeId;
        this.time = time;
        this.LPLabel = LPLabel;
        this.ImageFullPath = ImageFullPath;
        this.ImageCropVehiclePath = ImageCropVehiclePath;
        this.VideoId = VideoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public long getColorId() {
        return colorId;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }

    public long getVehicleBrandId() {
        return vehicleBrandId;
    }

    public void setVehicleBrandId(long vehicleBrandId) {
        this.vehicleBrandId = vehicleBrandId;
    }

    public long getVioletTypeId() {
        return violetTypeId;
    }

    public void setVioletTypeId(long violetTypeId) {
        this.violetTypeId = violetTypeId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getLPLabel() {
        return LPLabel;
    }

    public void setLPLabel(String LPLabel) {
        this.LPLabel = LPLabel;
    }

    public String getImageFullPath() {
        return ImageFullPath;
    }

    public void setImageFullPath(String imageFullPath) {
        ImageFullPath = imageFullPath;
    }

    public String getImageCropVehiclePath() {
        return ImageCropVehiclePath;
    }

    public void setImageCropVehiclePath(String imageCropVehiclePath) {
        ImageCropVehiclePath = imageCropVehiclePath;
    }

    public Integer getVideoId() {
        return VideoId;
    }

    public void setVideoId(Integer videoId) {
        VideoId = videoId;
    }
}



