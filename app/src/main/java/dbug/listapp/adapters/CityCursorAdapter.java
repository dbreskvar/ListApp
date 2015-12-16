package dbug.listapp.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dbug.listapp.R;
import dbug.listapp.dataholders.City;

/**
 * Created by davidbreskvar on 16/12/15.
 */
public class CityCursorAdapter extends CursorAdapter {

    static class ViewHolder {
        TextView name, details;
        ImageView image;

        ViewHolder(View view) {
            name = (TextView) view.findViewById(R.id.city_name);
            details = (TextView) view.findViewById(R.id.city_details);
            image = (ImageView) view.findViewById(R.id.city_image);
        }
    }

    private Context context;
    private ArrayList<City> cities;
    ViewHolder mViewHolder;
    private LayoutInflater mInflater;

    public CityCursorAdapter(Context context, ArrayList<City> mCities) {
        super(context, null, true);
        this.context = context;
        this.cities = mCities;
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return mInflater.inflate(R.layout.city_row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        City city = cities.get(cursor.getPosition());
        mViewHolder = (ViewHolder) view.getTag();
        if (mViewHolder == null) {
            mViewHolder = new ViewHolder(view);
            mViewHolder.name.setText(city.getFullName());
            mViewHolder.details.setText(city.getDetails());
            Picasso.with(context).load(city.getImageID()).into(mViewHolder.image);
        }
    }
}
