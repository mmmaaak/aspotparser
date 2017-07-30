package dev.mobile.pavelsvedov.aspotviewer.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dev.mobile.pavelsvedov.aspotviewer.R;
import dev.mobile.pavelsvedov.aspotviewer.entities.Model;


public class ModelsListArrayAdapter extends ArrayAdapter<Model> {

    private ArrayList<Model> models;
    private Context context;

    public ModelsListArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Model> objects) {
        super(context, resource, objects);
        models = new ArrayList<>(objects);
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ViewHolder vh;
        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.models_list_item, null);
            vh = new ViewHolder();
            vh.modelNameTextView = (TextView)v.findViewById(R.id.modelNameTextView);
            vh.modelOffersTextView = (TextView)v.findViewById(R.id.modelOffersTextView);
            vh.modelImageView = (ImageView)v.findViewById(R.id.modelImageView);
            v.setTag(vh);
        } else {
            vh = (ViewHolder)v.getTag();
        }

        Model item = models.get(position);
        if(item != null) {
            vh.modelNameTextView.setText(item.getName());
            vh.modelOffersTextView.setText(context.getResources().getString(R.string.offers_0, item.getOffers()));
            Picasso.with(context).load(item.getImageURL()).into(vh.modelImageView);
        }
        return v;
    }

    private class ViewHolder {
        TextView modelNameTextView;
        TextView modelOffersTextView;
        ImageView modelImageView;
    }
}
