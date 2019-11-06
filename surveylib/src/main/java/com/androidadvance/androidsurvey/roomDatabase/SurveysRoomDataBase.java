package com.androidadvance.androidsurvey.roomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.androidadvance.androidsurvey.models.SurveyPojo;

@Database(entities = {SurveyPojo.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class SurveysRoomDataBase extends RoomDatabase {

    public abstract SurvyDao survyDao();


    private static volatile SurveysRoomDataBase INSTANCE;

    static SurveysRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SurveysRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SurveysRoomDataBase.class, "surveys_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

