package usingrest.execcell.com.restapp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph.Pestonit on 11/26/2014.
 */
public class TestJSONParser
{
    public static List<Test> parseFeed (String content) {
        try {
            JSONArray ar = new JSONArray(content);
            List<Test> testList = new ArrayList<Test>();

            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                Test test = new Test();
                test.setId(obj.getInt("id"));
                test.setLevel(obj.getInt("level"));
                test.setTime_in_secs(obj.getInt("time_in_secs"));
                test.setPar(obj.getInt("par"));
                test.setInitials(obj.getString("initials"));
                test.setQuote(obj.getString("quote"));
                test.setTime_stamp(obj.getString("time_stamp"));

                testList.add(test);
            }return testList;
        } catch (Exception e) {
            return null;
        }

    }

    /*public static List<Real> parseFeed(String content){

    }*/

}
