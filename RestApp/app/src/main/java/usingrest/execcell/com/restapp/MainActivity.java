package usingrest.execcell.com.restapp;


import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

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


public class MainActivity extends ListActivity implements OnClickListener {


    static ArrayList<Locations> locList= new ArrayList<Locations>();
    static ArrayList<Transactions> tranList = new ArrayList<Transactions>();




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);


        findViewById(R.id.my_button).setOnClickListener(this);
        findViewById(R.id.transactions).setOnClickListener(this);
        /* CAN ADD MORE BUTTONS WITH onCLICK FUNCs here */


    }


    @Override


    /*public void onClick(View arg0) {
        Button b = (Button)findViewById(R.id.my_button);


        b.setClickable(false);
        new LongRunningGetIO().execute();

    } */

    public void onClick(View V) {
        switch(V.getId()){
            case R.id.my_button : {
                Button b = (Button)findViewById(R.id.my_button);


                b.setClickable(false);
                new LongRunningGetIO().execute();
                break;
            }
            case R.id.transactions : {
                Button b = (Button)findViewById(R.id.transactions);


                b.setClickable(false);
                new LongRunningGetIO2().execute();
            }
        }


    }


    private class LongRunningGetIO extends AsyncTask <Void, Void, String> {
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
            HttpGet httpGet = new HttpGet("https://webapi.executivecellularphones.com/api/locations");
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


                locList = LocationsJSONParser.parseFeed(results);

                 onLCEnd();

            }

            Button b = (Button)findViewById(R.id.my_button);


          b.setClickable(true);

        }


    }
    protected void onLCEnd(){
        Intent na = new Intent(this,LocActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("PrimeKey",locList);
        na.putExtras(bundle);
        startActivity(na);

    }

    private class LongRunningGetIO2 extends AsyncTask <Void, Void, String> {
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
            HttpGet httpGet = new HttpGet("http://webapi.executivecellularphones.com/api/gp/2015-01-01/2015-01-02");
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


                tranList = TransactionsJSONParser.parseFeed(results);

                //onLCEnd();

            }

            Button b = (Button)findViewById(R.id.transactions);


            b.setClickable(true);

        }


    }

    /* ----------------------------------------------------------------------------------------------------------------------------
    * *****************************************************************************************************************************
    * **************************************    END  OF   MAIN_ACTIVITY  ***********************************************************
    * **************************************   OLD  CODE   BELOW    ****************************************************************
    * -----------------------------------------------------------------------------------------------------------------------------/

    /*
    WHEN YOU CLICK ON A LIST ITEM IT GETS THE POSITION OF THE ELEMENT USED TO GEN THE CORRECT HTTPGET
    REQUEST FOR THE SELECTED STORE */

   /*
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


        loc = locList.get(position);
        new LongRunTask().execute();

}

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
/*
    private class LongRunTask extends AsyncTask <Void, Void, String> {
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
                 try{
                     wait(15);
                 }catch(Exception e){

                 }
                //Bundle bundle = new Bundle();
               // bundle.putParcelableArrayList("id",empList);

                //et.setText(results);
                // et.setText(locList.toString());

               /* Context context = getApplicationContext();
                ArrayAdapter<working_Today> adapter1 = new ArrayAdapter<working_Today>(context, R.layout.cust_textview,empList);
                setListAdapter(adapter1);

                Intent intent = new Intent(getApplicationContext(),EmpActivity.class);
                startActivity(intent); */

                /* Calls Func to Create a new Intent and Start EMP Activity */ /*
                onLCEnd();
            }



            Button b = (Button)findViewById(R.id.my_button);


            b.setClickable(true);

        }



    }
    */
}

