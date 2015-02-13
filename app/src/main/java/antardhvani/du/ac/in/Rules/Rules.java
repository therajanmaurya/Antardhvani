package antardhvani.du.ac.in.Rules;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import antardhvani.du.ac.in.Adapter.Child;
import antardhvani.du.ac.in.Adapter.Group;
import antardhvani.du.ac.in.Adapter.Rules_adapter;
import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 13/2/15.
 */
public class Rules extends ActionBarActivity {

    public static final String TAG = "Antardhvani";
    private Rules_adapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ExpandList = (ExpandableListView) findViewById(R.id.activity_googlecards_listview_Schedule);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new Rules_adapter(this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
    }


    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Rock Band ", "DU Artist\n", "Choreography", "Classical Dance\n", "Creative Writing and Translation\n", "Debate-Vaad Vivaad\n", "Folk Dance\n"
                , "Group Songs\n", "Instrumental Music - Solo\n", "Music - Vocal Solo\n", "Photography\n", "Quiz Time -Prashnottri\n", "Rangoli\n", "Short Film\n"};

        String country_names[] = {"Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n culturecouncil_du@rediffmail.com\n"

                , "The exhibits/painting to be submitted by 17 February 4 PM, NCWEB Office, II Floor Tutorial Building, Arts Faculty, North Campus, Delhi University.\n anjjuguptaa@rediffmail.com, Shakhuranag@gmail.com\n"


                , "Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n  culturecouncil_du@rediffmail.com\n"


                , "Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n  culturecouncil_du@rediffmail.com\n"


                , "Entries must be Submitted by 9 February 2015 through Email at msaleemir@gmail.com\n  msaleemir@gmail.com\n"


                , "All registered participants are requested to report at 9.30 AM Conference Centre, Opposite Botany Department on 16.02.15 and 17.02.15 as per Schedule to be displayed on Antardhvani Website.\n  amrita.dse@gmail.com, rakeshp@email.com\n"


                , "Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n  culturecouncil_du@rediffmail.com\n"


                , "Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n  culturecouncil_du@rediffmail.com\n"


                , "Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n  culturecouncil_du@rediffmail.com\n"


                , "Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n  culturecouncil_du@rediffmail.com\n"


                , "The Photographs to be submitted by 17 February 3 PM, Conference Centre, Opposite Botany Department, North Campus\n  gstuteja@gmail.com\n"


                , "All registered participants for the quiz are required to report at the university Indoor Stadium at 12.30 PM on the 17th of February 2015 for verification of their college ID Cards.\n  premksri@gmail.com), gitschawla@gmail.com \n",


                "Registered candidates report at venue directly on the day of event.\n  amrita.dse@gmail.com\n"


                , "Final cut of the Film to be submitted by 17 February 3PM, Conference Centre, Opposite Botany Department, North Campus.\n  gstuteja@gmail.com\n"
        };


        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 1;
        int j = 0;

        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            for (; j < size; j++) {
                Child ch = new Child();
                ch.setName(country_names[j]);
                ch_list.add(ch);
            }
            gru.setItems(ch_list);
            list.add(gru);

            size = size + 1;
        }

        return list;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        if (id == android.R.id.home) {
//            NavUtils.navigateUpFromSameTask(this);
//        }
//        return super.onOptionsItemSelected(item);
//    }


}
