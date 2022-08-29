package com.example.database.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.database.DAO.DAOObjectType;
import com.example.database.DAO.Database;
import com.example.database.entity.ObjectType;

import java.util.List;

public class ObjectTypeRepository {
    private DAOObjectType daoObjectType;
    private List<ObjectType> allObjectType;

    public ObjectTypeRepository(Application application){
        Database db = Database.getInstance(application);
        daoObjectType = db.useObjectType();
        allObjectType = (List<ObjectType>) daoObjectType.getListObjectType();
    }
    public List<ObjectType> getAllObjectType(){return  allObjectType;}
    public void insert(ObjectType objectType){

            daoObjectType.insertObjectType(objectType);

    }
}
