package com.example.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.database.entity.ObjectLabel;

import java.util.List;

@Dao
public interface DAOObjectLabel {
    @Insert
    void insertObjectLabel(ObjectLabel objectLabel);
    @Query("SELECT * FROM ObjectLabel")
    List<ObjectLabel> getListObjectLabel();
    @Delete
    void deleteObjectLabelbyId(ObjectLabel objectLabel);
    @Query("SELECT * FROM ObjectLabel where ObjectLabel.ObjectLabel =:ObjectLabel")
    ObjectLabel checkObjectLabel(String ObjectLabel);
}