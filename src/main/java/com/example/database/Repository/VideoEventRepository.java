package com.example.database.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.database.DAO.DAOVideo;
import com.example.database.DAO.Database;
import com.example.database.entity.VideoEvent;

import java.util.List;

public class VideoEventRepository {
    private DAOVideo daoVideo;
    private List<VideoEvent> allVideoEvent;

    public VideoEventRepository(Application application){
        Database db = Database.getInstance(application);
        daoVideo = db.useVideoEvent();
        allVideoEvent = (List<VideoEvent>) daoVideo.getListVideoEvent();
    }
    public List<VideoEvent> getAllVideoEvent(){
        return allVideoEvent;

    }
    public void insert(VideoEvent videoEvent){

            daoVideo.insertVideo(videoEvent);

    }
    public void AUtoDeleteVideo(int TimeDelete, int timeEnd) {
        List<VideoEvent> videoEvents = daoVideo.getListVideoEvent();
        Integer k = videoEvents.get(videoEvents.size() - 1).getTimeEnd() - videoEvents.get(0).getTimeStart();
        if (k >= timeEnd) {
            int m = videoEvents.get(0).getTimeStart();
            int TimeOneWeek = m + TimeDelete;
            List<VideoEvent> VideoToDelete = daoVideo.GetListVideoEventToDelete(TimeOneWeek);
           daoVideo.DeleteVideoList(VideoToDelete);
        }

    }
}
