package dev.mobile.pavelsvedov.aspotviewer.services;

import java.util.List;

import dev.mobile.pavelsvedov.aspotviewer.entities.Brand;
import dev.mobile.pavelsvedov.aspotviewer.entities.Model;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pavelsvedov on 24.07.17.
 */

public interface AutospotService {

    @GET("/brands.json")
    Observable<List<Brand>> getBrands();

    @GET("/models/{brand}.json")
    Observable<List<Model>> getModels(@Path("brand") String brand);
}
