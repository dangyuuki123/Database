package com.example.database.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.database.DAO.DAOGeo2D;
import com.example.database.DAO.Database;
import com.example.database.entity.Geo2D;

import java.util.List;

public class Geo2DRepository {
    private DAOGeo2D daoGeo2D;
    private List<Geo2D> allGeo2D;

    public Geo2DRepository(Application application){
        Database db = Database.getInstance(application);
        daoGeo2D = db.useGeo2D();
        allGeo2D = (List<Geo2D>) daoGeo2D.getListGeo2D();

    }
    public List<Geo2D> getAllGeo2D(){return allGeo2D;}
    public void insert(Geo2D geo2D){

            daoGeo2D.insertGeo2D(geo2D);

    }
    public void delete(Geo2D geo2D){
        daoGeo2D.deleteGeo2DbyId(geo2D);
    }
}
