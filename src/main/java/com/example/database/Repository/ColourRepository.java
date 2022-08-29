package com.example.database.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.database.DAO.DAOColour;
import com.example.database.DAO.Database;
import com.example.database.entity.Colour;

import java.util.List;

public class ColourRepository {

    private DAOColour daoColour;
    private List<Colour> AllColor;

    public ColourRepository(Application application) {
        Database db = Database.getInstance(application);
        daoColour = db.useColour();
        AllColor = (List<Colour>) daoColour.getListColor();
    }

    public List<Colour> getAllColor() {
        return AllColor;
    }

    public void insertColor(Colour colour) {
        daoColour.insertColor(colour);
    }
}
