package dev.mobile.pavelsvedov.aspotviewer.adapters;

import android.content.Context;
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

import java.util.List;

import dev.mobile.pavelsvedov.aspotviewer.R;
import dev.mobile.pavelsvedov.aspotviewer.entities.Brand;


public class BrandListArrayAdapter extends ArrayAdapter<Brand> {

    private List<Brand> brands;
    private Context context;

    public BrandListArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Brand> objects) {
        super(context, resource, objects);
        brands = objects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return brands.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ViewHolder vh;
        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.brands_grid_item, null);
            vh = new ViewHolder();
            vh.brandImageView = (ImageView) v.findViewById(R.id.brandImageView);
            vh.brandTextView = (TextView) v.findViewById(R.id.brandTextView);
            v.setTag(R.string.view_holder_tag, vh);
        } else {
            vh = (ViewHolder)v.getTag(R.string.view_holder_tag);
        }

        Brand item = brands.get(position);
        if(item != null) {
            vh.brandTextView.setText(item.getName());
            Picasso.with(context).load(item.getImageURL()).into(vh.brandImageView);
            v.setTag(R.string.model_tag, item);
        }
        return v;
    }

    public class ViewHolder {
        public ImageView brandImageView;
        public TextView brandTextView;
    }
}
