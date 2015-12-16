package dbug.listapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dbug.listapp.R;
import dbug.listapp.dataholders.City;

/**
 * Created by davidbreskvar on 15/12/15.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, detail;

        public ViewHolder(View item) {
            super(item);
            image = (ImageView) item.findViewById(R.id.city_image);
            name = (TextView) item.findViewById(R.id.city_name);
            detail = (TextView) item.findViewById(R.id.city_details);
        }
    }

    ArrayList<City> mCities;
    Context context;

    public CityAdapter(ArrayList<City> cities, Context context) {
        this.mCities = cities;
        this.context = context;
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {
        holder.name.setText(mCities.get(position).getFullName());
        holder.detail.setText(mCities.get(position).getDetails());
        Picasso.with(context)
                .load(mCities.get(position).getImageID())
                .error(R.drawable.error)
                .placeholder(R.drawable.loading)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }
}