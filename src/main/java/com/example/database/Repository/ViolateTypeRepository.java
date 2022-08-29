package com.example.database.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.database.DAO.DAOViolateType;
import com.example.database.DAO.Database;
import com.example.database.entity.ViolateType;

import java.util.List;

public class ViolateTypeRepository {
    private DAOViolateType daoViolateType;
    private List<ViolateType> allViolateType;
    private List<String> AllViolateName;

    public ViolateTypeRepository(Application application){
        Database db = Database.getInstance(application);
        daoViolateType = db.useViolateType();
        allViolateType = (List<ViolateType>) daoViolateType.getListViolateType();
        AllViolateName = daoViolateType.getViolateNames();
    }
    public List<ViolateType> getAllViolateType(){
        return allViolateType;
    }
    public List<String> getAllViolateName(){ return  AllViolateName;}
    public void insert (ViolateType violateType){

            daoViolateType.insertViolateType(violateType);

    }
}
