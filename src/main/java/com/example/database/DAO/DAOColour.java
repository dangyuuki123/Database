package com.example.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.database.entity.Colour;

import java.util.List;

@Dao
public interface DAOColour {
    @Insert
    void insertColor(Colour colour);
    @Query("SELECT * FROM Colour")
    List<Colour> getListColor();
    @Query("DELETE FROM Colour")
    void deleteallColor();
    @Query("SELECT * FROM Colour where Colour.ColorName =:colorName")
    Colour checkColor(String colorName);
    @Delete
    void DeleteColorbyId(Colour colour);
}
