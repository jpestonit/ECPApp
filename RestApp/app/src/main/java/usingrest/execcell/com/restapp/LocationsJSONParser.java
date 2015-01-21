package usingrest.execcell.com.restapp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph.Pestonit on 12/3/2014.
 */
public class LocationsJSONParser {
    public static ArrayList<Locations> parseFeed (String content) {
        try {
            JSONArray ar = new JSONArray(content);
            ArrayList<Locations> locationsList = new ArrayList<Locations>();

            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                Locations loc = new Locations( );
                loc.setPrimeKey(obj.getInt("PrimeKey"));
                loc.setCode(obj.getString("Code"));


                locationsList.add(loc);
            }return locationsList;
        } catch (Exception e) {
            return null;
        }

    }
}
