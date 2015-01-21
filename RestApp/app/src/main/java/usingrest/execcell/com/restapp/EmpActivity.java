package usingrest.execcell.com.restapp;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Joseph.Pestonit on 12/15/2014.
 */

public class EmpActivity extends ListActivity implements OnClickListener {
    ArrayList<working_Today> empList = new ArrayList<working_Today>();
    working_Today selectedEmp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        empList = bundle.getParcelableArrayList("id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp);
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
        findViewById(R.id.my_button).setOnClickListener(this);



        ArrayAdapter<working_Today> adapter = new ArrayAdapter<working_Today>(getApplicationContext(), R.layout.cust_textview, empList);
        setListAdapter(adapter);
    }

    public void onClick(View arg0) {
        Button b = (Button) findViewById(R.id.my_button);


        b.setClickable(false);
        this.finish();
    }

   /* protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        TextView et = (TextView)findViewById(R.id.textView);
        selectedEmp = empList.get(position);
        et.setText(selectedEmp.toString1());


    } */
}

