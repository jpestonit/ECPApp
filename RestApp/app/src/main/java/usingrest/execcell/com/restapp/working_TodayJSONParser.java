package usingrest.execcell.com.restapp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph.Pestonit on 12/22/2014.
 */
public class working_TodayJSONParser {
    public static ArrayList<working_Today> parseFeed (String content) {
        try {
            JSONArray ar = new JSONArray(content);
            ArrayList<working_Today> working_List = new ArrayList<working_Today>();

            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                working_Today work = new working_Today( );
                work.setId(obj.getString("id"));
                work.setUserKey(obj.getInt("UserKey"));
                work.setLogInDateTime(obj.getString("LogInDateTime"));
                work.setLogOutDateTime(obj.getString("LogOutDateTime"));
                work.setLunchOutDateTime(obj.getString("LunchOutDateTime"));
                work.setLunchInDateTime(obj.getString("LunchInDateTime"));
                work.setLunch_Duration(obj.getString("Lunch_Duration"));
                work.setWorking_at(obj.getString("Working at"));
                work.setStatus(obj.getString("status"));


              working_List.add(work);
            }return working_List;
        } catch (Exception e) {
            return null;
        }

    }
}
