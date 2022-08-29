package com.example.database.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.database.DAO.DAOEvent;
import com.example.database.DAO.DAOViolateType;
import com.example.database.DAO.Database;
import com.example.database.entity.Event;
import com.example.database.entity.ViolateType;

import java.util.List;
import java.util.Map;

public class EventRepository {
    private DAOEvent daoEvent;
    private DAOViolateType daoViolateType;
    private List<Event> AllEvent;

    public  EventRepository(Application application){
        Database db = Database.getInstance(application);
        daoEvent = db.useEvent();
        daoViolateType = db.useViolateType();
        AllEvent = (List<Event>) daoEvent.getListEvent();

    }
    public List<Event> getAllEvent() {return AllEvent;}
    public void insert (Event event){

            daoEvent.insertEvent(event);

    }
//    public void AutoDeleteEvent(int timeDelete, int timeEnd) {
//        List<Event> event1s = daoEvent.getListEvent();
//        Long k = event1s.get(event1s.size() - 1).getTime() - event1s.get(0).getTime();
//        if (k >= timeEnd) {
//            Long m = event1s.get(0).getTime();
//            Long TimeOneWeek = m + timeDelete;
//            List<Event> EventToDelete = daoEvent.getListEventToDelete(TimeOneWeek);
//            daoEvent.DeleteListEvent(EventToDelete);
//        }
//    }
//    public List<Integer> ALLCountViolateInWeek(Integer timeStart , Integer timeEnd){
//        Integer timeOneDay = (timeEnd - timeStart) /7;
//        List<Integer> count = null;
//        for(int i = 0 ; i <7 ; i ++ ){
//            List<Event> events = daoEvent.listEventToNeed(null,timeStart + i * timeOneDay , timeEnd - (6 - i)*timeOneDay);
//            count.add(events.size());
//        }
//        return count;
//    }
//    public List<Integer> GetViolateInDay(Integer timeStart , Integer timeEnd){
//        Integer timeOneDay = (timeEnd - timeStart) ;
//        List<Integer> count = null;
//        List<String> AllViolate = daoViolateType.getViolateNames();
//        for (String name:AllViolate){
//            List<Event> ViolateName = daoEvent.getListEventInViolate(name , timeStart , timeEnd);
//            Integer k  = ViolateName.size();
//            count.add(k);
//        }
//        return count;
//    }
//    public Map<Integer , List<Integer>> GetViolateInWeek(Integer timeStart , Integer timeEnd) {
//        Integer timeOneDay = (timeEnd - timeStart) / 7;
//        Map<Integer,List<Integer>> count = null;
//        for (int i = 0 ; i < 7 ; i ++){
//            List<Integer> Ncount = GetViolateInDay(timeStart + i * timeOneDay , timeEnd -(6 - i)*timeOneDay);
//            count.put(i+1 , Ncount);
//        }
//    return count;
//    }
//    public void Graph2Dimensions(Integer timeStart , Integer timeEnd){
//        List<Integer> CountAllViolate = ALLCountViolateInWeek(timeStart ,timeEnd);
//        Map<Integer,List<Integer>> countTypeViolate = GetViolateInWeek(timeStart , timeEnd);
//    }

}
