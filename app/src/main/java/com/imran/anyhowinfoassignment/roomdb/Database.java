package com.imran.anyhowinfoassignment.roomdb;


import androidx.room.RoomDatabase;

import com.imran.anyhowinfoassignment.model.User;

@androidx.room.Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase
{
    public abstract MyDao getUserDao();
}
