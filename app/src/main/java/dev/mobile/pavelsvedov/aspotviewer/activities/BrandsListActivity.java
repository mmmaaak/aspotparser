package dev.mobile.pavelsvedov.aspotviewer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import dev.mobile.pavelsvedov.aspotviewer.AutospotClientAplication;
import dev.mobile.pavelsvedov.aspotviewer.R;
import dev.mobile.pavelsvedov.aspotviewer.adapters.BrandListArrayAdapter;
import dev.mobile.pavelsvedov.aspotviewer.entities.Brand;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class BrandsListActivity extends AppCompatActivity {
    private static final String TAG = "BrandsListActivity";

    private GridView brandsGridView;
    private ArrayList<Brand> brands;
    private BrandListArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.brands_list_activity);

        brandsGridView = (GridView)findViewById(R.id.brandsGridView);
        brands = new ArrayList<>();

        AutospotClientAplication.getAutospotService().getBrands()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse, this::handleError);

        adapter = new BrandListArrayAdapter(this, R.layout.brands_grid_item, brands);
        brandsGridView.setAdapter(adapter);

        brandsGridView.setOnItemClickListener((parent, view, position, id) -> {
            Brand b = (Brand)view.getTag(R.string.model_tag);
            Intent modelActivityIntent = new Intent(BrandsListActivity.this, ModelsListActivity.class);
            modelActivityIntent.putExtra("brand", b.getAlias());
            startActivity(modelActivityIntent);
        });
    }

    private void handleResponse(List<Brand> brands) {
        this.brands = new ArrayList<>(brands);
        adapter = new BrandListArrayAdapter(this, R.layout.brands_grid_item, this.brands);
        brandsGridView.setAdapter(adapter);
    }

    private void handleError(Throwable error) {
        Log.e(TAG, "handleError: " + error.getMessage());
        error.printStackTrace();
    }
}
