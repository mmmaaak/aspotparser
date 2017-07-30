package dev.mobile.pavelsvedov.aspotviewer.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import dev.mobile.pavelsvedov.aspotviewer.R;
import dev.mobile.pavelsvedov.aspotviewer.entities.AbstractPrice;
import dev.mobile.pavelsvedov.aspotviewer.enums.PriceType;


public class PricesListArrayAdapter extends ArrayAdapter<AbstractPrice> {

    private static final int DISCOUNT_PRICE_TYPE = 0;
    private static final int NORMAL_PRICE_TYPE = 1;
    private static final int PRICE_TYPE_COUNT = NORMAL_PRICE_TYPE + 1;

    private ArrayList<AbstractPrice> prices;
    private Context context;

    public PricesListArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<AbstractPrice> objects) {
        super(context, resource, objects);
        this.context = context;
        prices = new ArrayList<>(objects);
    }

    @Override
    public int getViewTypeCount() {
        return PRICE_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return prices.get(position).getType() == PriceType.DISCOUNT ? DISCOUNT_PRICE_TYPE : NORMAL_PRICE_TYPE;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        int type = getItemViewType(position);
        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(type == DISCOUNT_PRICE_TYPE ? R.layout.discount_price_list_item : R.layout.normal_price_list_item, null);
        } else {

        }
        return v;
    }

    private class DiscountViewHolder {

    }

    private class NormalViewHolder {

    }


}
