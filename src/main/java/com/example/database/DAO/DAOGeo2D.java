package com.example.database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.database.entity.*;

import java.util.List;

@Dao
public interface DAOGeo2D {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGeo2D(Geo2D geo2D);
    @Query("SELECT * FROM Geo2D")
    List<Geo2D> getListGeo2D();
    @Delete
    void deleteGeo2DbyId(Geo2D geo2D);
    @Query("SELECT * FROM Colour INNER JOIN Geo2D ON Colour.id = Geo2D.colorId WHERE Geo2D.colorId=:colorid")
    Colour getcolorInGeo2D(int colorid);

}