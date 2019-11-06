package com.androidadvance.androidsurvey.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.androidadvance.androidsurvey.models.SurveyPojo;
import com.androidadvance.androidsurvey.models.SurveyProperties;
import com.androidadvance.androidsurvey.roomDatabase.SurveyRepository;

import java.util.List;

public class SurveyPojoViewModel extends AndroidViewModel {

    private SurveyRepository mRepository;
    private LiveData<List<SurveyPojo>> mAllWords;


    public SurveyPojoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new SurveyRepository(application);
        mAllWords = mRepository.getmAllSurveys();
    }


    public LiveData<List<SurveyPojo>> getAllSurveys() {
        return mAllWords;
    }

    public void insert(SurveyPojo surveyPojo) {
        mRepository.insert(surveyPojo);
    }
}

