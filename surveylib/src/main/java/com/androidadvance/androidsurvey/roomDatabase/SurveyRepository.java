package com.androidadvance.androidsurvey.roomDatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.androidadvance.androidsurvey.models.SurveyPojo;

import java.util.List;

public class SurveyRepository {


    private SurvyDao mSurvyDao;
    private LiveData<List<SurveyPojo>> mAllSurveys;


    public SurveyRepository(Application application) {
        SurveysRoomDataBase db = SurveysRoomDataBase.getDatabase(application);
        mSurvyDao = db.survyDao();
        mAllSurveys = mSurvyDao.getAllSurveys();
    }

    public LiveData<List<SurveyPojo>> getmAllSurveys() {
        return mAllSurveys;
    }


    public void insert (SurveyPojo surveyPojo) {
        new insertAsyncTask(mSurvyDao).execute(surveyPojo);
    }

    private static class insertAsyncTask extends AsyncTask<SurveyPojo, Void, Void> {

        private SurvyDao mAsyncTaskDao;

        insertAsyncTask(SurvyDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final SurveyPojo... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}