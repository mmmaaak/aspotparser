package dev.mobile.pavelsvedov.aspotviewer.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import dev.mobile.pavelsvedov.aspotviewer.R;
import dev.mobile.pavelsvedov.aspotviewer.entities.AbstractPrice;


public class PricesListActivity extends AppCompatActivity {
    private static final String TAG = "PricesListActivity";

    ArrayList<AbstractPrice> prices;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.prices_list_activity);
    }
}
