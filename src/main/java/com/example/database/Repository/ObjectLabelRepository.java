package com.example.database.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.database.DAO.DAOObjectLabel;
import com.example.database.DAO.Database;
import com.example.database.entity.ObjectLabel;

import java.util.List;

public class ObjectLabelRepository {
    private DAOObjectLabel daoObjectLabel;
    private List<ObjectLabel> AllObjectLabel;

    public ObjectLabelRepository(Application application){
        Database db = Database.getInstance(application);
        daoObjectLabel = db.useObjectLabel();
        AllObjectLabel = (List<ObjectLabel>) daoObjectLabel.getListObjectLabel();
    }
    public List<ObjectLabel> getAllObjectLabel(){ return AllObjectLabel;}
    public void insert(ObjectLabel objectLabel){

            daoObjectLabel.insertObjectLabel(objectLabel);

    }
}
