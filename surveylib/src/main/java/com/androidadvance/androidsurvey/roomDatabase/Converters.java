package com.androidadvance.androidsurvey.roomDatabase;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class Converters {

    @TypeConverter
    public static String fromSurveyRepository(SurveyRepository surveyRepository) {

        Gson gson = new Gson();
        String json = gson.toJson(surveyRepository);
        return json;
    }

    @TypeConverter
    public static SurveyRepository fromJsonToSurveyRepository(String value) {
        Type type = new TypeToken<SurveyRepository>() {
        }.getType();
        return new Gson().fromJson(value, type);
    }
}
