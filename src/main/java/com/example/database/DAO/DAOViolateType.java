package com.example.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.database.entity.ViolateType;

import java.util.List;

@Dao
public interface DAOViolateType {
    @Insert
    void insertViolateType(ViolateType violateType);
    @Query("SELECT * FROM ViolateType")
    List<ViolateType> getListViolateType();
    @Delete
    void deleteViolateTypebyId(ViolateType violateType);
    @Query("SELECT * FROM ViolateType where ViolateType.violateName =:violateName")
    List<ViolateType> getListViolateName(String violateName);
    @Query(value = "SELECT violateName From ViolateType ")
    List<String> getViolateNames();
}