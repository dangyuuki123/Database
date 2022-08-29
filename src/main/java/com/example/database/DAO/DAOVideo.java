package com.example.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.database.entity.VideoEvent;

import java.util.List;

@Dao
public interface DAOVideo {
    @Insert
    void insertVideo(VideoEvent videoEvent);
    @Query("SELECT * FROM VideoEvent")
    List<VideoEvent> getListVideoEvent();
    @Delete
    void deleteVideoEventbyId(VideoEvent videoEvent);
    @Query("SELECT * FROM VideoEvent where VideoEvent.RecordedVideoPath=:RecordedVideoPath")
    VideoEvent checkVideoPath(String RecordedVideoPath);
    @Query(value = "SELECT * FROM VideoEvent where VideoEvent.TimeEnd<=:TimeOneWeek")
    List<VideoEvent> GetListVideoEventToDelete(int TimeOneWeek);
    @Delete
    void DeleteVideoList(List<VideoEvent> videoEvents);
}
