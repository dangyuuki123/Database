package com.example.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.database.entity.ObjectType;

import java.util.List;

@Dao
public interface DAOObjectType {
    @Insert
    void insertObjectType(ObjectType objectType);
    @Query("SELECT * FROM ObjectType")
    List<ObjectType> getListObjectType();
    @Delete
    void deleteObjectTypebyId(ObjectType objectType);
    @Query("SELECT * FROM ObjectType where ObjectType.ObjectType =:type")
    List<ObjectType> getListObjectType(String type);

}