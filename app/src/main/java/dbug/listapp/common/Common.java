package dbug.listapp.common;

import java.util.ArrayList;

import dbug.listapp.R;
import dbug.listapp.dataholders.City;

/**
 * Created by davidbreskvar on 15/12/15.
 */
public class Common {

    public static ArrayList<City> populateData() {
        ArrayList<City> mCities = new ArrayList<>();

        City one = new City();
        one.setName("London");
        one.setDetails("London Luton Airport");
        one.setCode("LON");
        one.setImageID(R.drawable.london);

        City two = new City();
        two.setName("Athens");
        two.setDetails("Greece, Athens Airport");
        two.setCode("ATH");
        two.setImageID(R.drawable.athens);

        City three = new City();
        three.setName("Berlin");
        three.setDetails("Berlin Schönefeld Airport");
        three.setCode("SXF");
        three.setImageID(R.drawable.berlin);

        City four = new City();
        four.setName("Vienna");
        four.setDetails("Vienna International Airport");
        four.setCode("VIE");
        four.setImageID(R.drawable.wien);

        City five = new City();
        five.setName("Ljubljana");
        five.setDetails("Letalisce Jozeta Pucnika, Ljubljana");
        five.setCode("LJU");
        five.setImageID(R.drawable.ljubljana);

        City six = new City();
        six.setName("Phoenix");
        six.setDetails("Phoenix Sky Harbor International Airport");
        six.setCode("PHX");
        six.setImageID(R.drawable.phoenix);

        City seven = new City();
        seven.setName("Paris");
        seven.setDetails("Paris Charles De Gaulle Airport");
        seven.setCode("CDG");
        seven.setImageID(R.drawable.paris);

        City eight = new City();
        eight.setName("San Francisco");
        eight.setDetails("San Francisco International Airport");
        eight.setCode("SFO");
        eight.setImageID(R.drawable.san_francisco);

        mCities.add(one);
        mCities.add(two);
        mCities.add(three);
        mCities.add(four);
        mCities.add(five);
        mCities.add(six);
        mCities.add(seven);
        mCities.add(eight);

        return mCities;
    }
}
