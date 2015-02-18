package antardhvani.du.ac.in.Notification;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import antardhvani.du.ac.in.Adapter.CardAdapter;
import antardhvani.du.ac.in.Database.MyResult;
import antardhvani.du.ac.in.Database.NotificationSQL;
import antardhvani.du.ac.in.antardhvani.R;


public class Notification extends ActionBarActivity {
    ArrayList<String> nonCom=new ArrayList<String>();
    ArrayList<String> nonCom1=new ArrayList<String>();

    private static final String TAG = "NotificationActivity";

    private RecyclerView mRecyclerView;
    private CardAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_card);
         toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Notification");
        mRecyclerView = (RecyclerView) findViewById(R.id.list_main);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Log.d(TAG, "Layout manager set");
        mLayoutManager.scrollToPosition(1); // TODO: Remove this when preview SDK has abstract method.
        mRecyclerView.setLayoutManager(mLayoutManager);


        new ReadFromData().execute();
    }


    private class ReadFromData extends AsyncTask<Void, Void, ArrayList<MyResult>> {

        @Override
        protected ArrayList<MyResult> doInBackground(Void... v) {
        ArrayList<MyResult> my=null;
        NotificationSQL db =new NotificationSQL(getApplication());
        my=db.getAllNoti();

            return my;
        }

        @Override
        protected void onPostExecute(ArrayList<MyResult> my) {
            Log.d(TAG, "Inside onPostExecute()");
            for(int y=0;y<my.size();y++){
                for(int i=0;i<=1;i++){
                    if (i==0){
                        nonCom.add(my.get(y).getFirst());
                    }
                    if(i==1){
                        nonCom1.add(my.get(y).getSecond());
                    }
                }
            }

            mAdapter = new CardAdapter(getApplicationContext(), nonCom,nonCom1);
            Log.d(TAG, "List size = " + nonCom.size());
            // This sets the color displayed for card titles and header actions by default

            if (nonCom.size() > 0) {
                Log.d(TAG, "Inside onPostExecute()");

                mRecyclerView.setAdapter(mAdapter);
                ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
                mProgressBar.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
            }
            if(nonCom.size()==0){
                Log.d(TAG, "Inside onPostExecute()");


                ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
                mProgressBar.setVisibility(View.GONE);
                TextView x=(TextView)findViewById(R.id.tvNo);
                x.setVisibility(View.VISIBLE);

            }

        }
    }

}