package usingrest.execcell.com.restapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Joseph.Pestonit on 12/23/2014.
 */
public class LocActivity extends ListActivity implements OnClickListener {
    ArrayList<Locations> locList = new ArrayList<Locations>();
    ArrayList<working_Today> empList = new ArrayList<working_Today>();
    static Locations loc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        locList = bundle.getParcelableArrayList("PrimeKey");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc);
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
        findViewById(R.id.my_button).setOnClickListener(this);


        /*Set listView with locations */
        ArrayAdapter<Locations> adapter = new ArrayAdapter<Locations>(getApplicationContext(),R.layout.cust_textview,locList);
        setListAdapter(adapter);
    }

    /* Back Button, Returns to Previous activity*/
    public void onClick(View arg0) {
        Button b = (Button)findViewById(R.id.my_button);


        b.setClickable(false);
      this.finish();

    }

    /* Gives Position of listView element (Store Selected), LongRunTask - Returns Employees Working
     * that Day (Shows Clocked in or Out)  */

     protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


        loc = locList.get(position);
        new LongRunTask().execute();

    }

    /* After AsyncTask Completes, called to start new Activity */
    protected void onLCEnd(){
        Intent na = new Intent(this,EmpActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("id",empList);
        na.putExtras(bundle);
        startActivity(na);

    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    } */

    private class LongRunTask extends AsyncTask<Void, Void, String> {
        protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
            InputStream in = entity.getContent();


            StringBuffer out = new StringBuffer();
            int n = 1;
            while (n>0) {
                byte[] b = new byte[4096];
                n =  in.read(b);


                if (n>0) out.append(new String(b, 0, n));
            }


            return out.toString();
        }


        @Override


        protected String doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            String adr ="https://webapi.executivecellularphones.com/api/workingatloc/";
            HttpGet httpGet = new HttpGet(adr +loc.getPrimeKey()); // LIST ITEM SELECTED
            String text = null;

            try {
                HttpResponse response = httpClient.execute(httpGet, localContext);
                HttpEntity entity = response.getEntity();
                text = getASCIIContentFromEntity(entity);

            } catch (Exception e) {
                return e.getLocalizedMessage();
            }


            return text;
        }


        protected void onPostExecute(String results) {
            if (results!=null) {
                //EditText et = (EditText)findViewById(R.id.my_edit);


                empList = working_TodayJSONParser.parseFeed(results);
                /*try{
                    wait(15);
                }catch(Exception e){

               */
                onLCEnd();
            }
        }

     }
}