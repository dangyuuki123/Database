package com.example.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Fts4;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.database.entity.Event;

import java.util.List;

@Dao
public interface DAOEvent {
    @Insert
    void insertEvent(Event event);

    @Query("SELECT * FROM Event")
    List<Event> getListEvent();

    @Query("DELETE FROM Event")
    void deleteallEvent();

    @Delete
    void DeleteEventbyId(Event event);
    @Query(value = "SELECT * FROM Event inner join Colour on Event.colorId = Colour.id " +
            "INNER JOIN ViolateType on Event.violetTypeId = Violatetype.id " +
            "INNER JOIN ObjectType on Event.vehicleTypeId = ObjectType.id " +
            "INNER Join ObjectLabel on Event.vehicleBrandId = ObjectLabel.id" +

            " where Event.time between 10000 and 200000 and Colour.ColorValue =:colorValue and violatetype.violateName =:violateName and ObjectType.ObjectType=:vehicletype and ObjectLabel.ObjectLabel =:vehiclebrand ")
    List<Event> getListEventbyViolateName(String colorValue , String violateName , String vehicletype, String vehiclebrand );
    @Query (value = "SELECT * FROM Event where Event.time <= :timeOneWeek")
    List<Event> getListEventToDelete(int timeOneWeek);
    @Delete
    void DeleteListEvent(List<Event> events);
    @Query(value = "SELECT * FROM Event inner join Colour on Event.colorId = Colour.id " +
            "INNER JOIN ViolateType on Event.violetTypeId = Violatetype.id " +
            " where Event.time >=:timeStart and Event.time <= :timeEnd and violatetype.violateName !=:violateName")
    List<Event> listEventToNeed(String violateName , Integer timeStart , Integer timeEnd);
    @Query(value = "SELECT * FROM Event inner join ViolateType on Event.violetTypeId = ViolateType.id " +
            "where Event.time >=:timeStart and Event.time <= :timeEnd and violatetype.violateName =:violateName")
    List<Event> getListEventInViolate(String violateName , Integer timeStart , Integer timeEnd);
    @Query(value = "SELECT * FROM Event inner join ObjectLabel on Event.vehicleBrandId = ObjectLabel.id " +
            "where Event.time >=:timeStart and Event.time <= :timeEnd and ObjectLabel.ObjectLabel =:ObjectLabel")
    List<Event> ListEventObjectLabel(String ObjectLabel , Integer timeStart , Integer timeEnd);




}
