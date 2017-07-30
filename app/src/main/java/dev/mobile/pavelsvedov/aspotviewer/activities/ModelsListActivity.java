package dev.mobile.pavelsvedov.aspotviewer.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dev.mobile.pavelsvedov.aspotviewer.AutospotClientAplication;
import dev.mobile.pavelsvedov.aspotviewer.R;
import dev.mobile.pavelsvedov.aspotviewer.adapters.ModelsListArrayAdapter;
import dev.mobile.pavelsvedov.aspotviewer.entities.Model;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ModelsListActivity extends AppCompatActivity {
    private static final String TAG = "ModelsListActivity";

    private ArrayList<Model> models;
    private ModelsListArrayAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.models_list_activity);

        models = new ArrayList<>();


        adapter = new ModelsListArrayAdapter(this, R.layout.models_list_item, models);
        listView = (ListView)findViewById(R.id.modelsListView);
        listView.setAdapter(adapter);

        AutospotClientAplication.getAutospotService().getModels(getIntent().getStringExtra("brand"))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse, this::handleError);
    }

    private void handleResponse(List<Model> models) {
        this.models = new ArrayList<>(models);
        adapter = new ModelsListArrayAdapter(this, R.layout.models_list_item, this.models);
        listView.setAdapter(adapter);
    }

    private void handleError(Throwable error) {
        Log.e(TAG, "handleError: " + error.getMessage());
        error.printStackTrace();
    }
}
