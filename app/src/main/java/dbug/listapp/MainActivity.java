package dbug.listapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import dbug.listapp.adapters.CityAdapter;
import dbug.listapp.common.Common;
import dbug.listapp.dataholders.City;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.cities_list) RecyclerView list;
    private ArrayList<City> mCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mCities = Common.populateData();

        list.setHasFixedSize(true);
        RecyclerView.LayoutManager mManager = new LinearLayoutManager(this);
        list.setLayoutManager(mManager);
        list.setAdapter(new CityAdapter(Common.populateData(), this));

        list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int position = manager.findFirstVisibleItemPosition();
                CityAdapter.ViewHolder holder = (CityAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(position);
                View holderView = holder.itemView;
                float topY = 0;
                if (holderView != null) {
                    topY = (holderView.getTop() * 0.5f);
                   // Log.e("Holder", "Height: " + holderView.getHeight() + " top: " + holderView.getTop() + " and Y: " + holderView.getY());
                   // Log.e("SetY", "Y should be at: " + (holderView.getTop() * 0.5f));
                    holderView.setY(topY);

                    int count = (manager.findLastVisibleItemPosition() + 1) - position;
                   // Log.e("count", "Count is : " + count);

                    for (int i = 1; i < count; i++) {
                        try {
                            CityAdapter.ViewHolder nextHolder = (CityAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(position + i);
                            View nextView = nextHolder.itemView;
                            if (nextView != null) {
                                //nextView.setY(holderView.getY());
                               // Log.e("Next", "Next View getTop(): " + nextView.getTop() + " and getY = " + nextView.getY());
                                if (nextView.getY() != nextView.getTop()) {
                                    nextView.setY(nextView.getTop());
                                }
                            }
                        } catch (IndexOutOfBoundsException e) {
                            Log.e("Error", "There is no next view");
                        }
                    }


                }
            }
        });

    }
}
