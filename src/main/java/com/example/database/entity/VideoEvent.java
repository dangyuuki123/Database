package com.example.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "VideoEvent")
public class VideoEvent implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String RecordedVideoPath;
    private Integer TimeStart;
    private Integer TimeEnd;

    public VideoEvent(String RecordedVideoPath, Integer TimeStart, Integer TimeEnd) {
        this.RecordedVideoPath = RecordedVideoPath;
        this.TimeStart = TimeStart;
        this.TimeEnd = TimeEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecordedVideoPath() {
        return RecordedVideoPath;
    }

    public void setRecordedVideoPath(String recordedVideoPath) {
        RecordedVideoPath = recordedVideoPath;
    }

    public Integer getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(Integer timeStart) {
        TimeStart = timeStart;
    }

    public Integer getTimeEnd() {
        return TimeEnd;
    }

    public void setTimeEnd(Integer timeEnd) {
        TimeEnd = timeEnd;
    }
}
