package com.androidadvance.androidsurvey.models;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.androidadvance.androidsurvey.roomDatabase.Converters;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "SurveyPojo")
public class SurveyPojo implements Serializable {

    @PrimaryKey
    @NonNull
    public int id;


    @Ignore
    private String userName;


    @SerializedName("survey_properties")
    @Expose
//    @TypeConverters(Converters.class)
    @Ignore
    public SurveyProperties surveyProperties;


    @SerializedName("questions")
    @Expose
    @Ignore
    public List<Question> questions = new ArrayList<Question>();


}