package com.androidadvance.androidsurvey.roomDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.androidadvance.androidsurvey.models.SurveyPojo;

import java.util.List;

@Dao
public interface SurvyDao {


        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(SurveyPojo survey);

        @Query("DELETE FROM SurveyPojo")
        void deleteAll();

        @Query("SELECT * from SurveyPojo")
        LiveData<List<SurveyPojo>> getAllSurveys();
    }
