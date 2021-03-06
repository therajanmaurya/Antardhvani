package antardhvani.du.ac.in.Schedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import antardhvani.du.ac.in.Adapter.Child;
import antardhvani.du.ac.in.Adapter.Group;
import antardhvani.du.ac.in.Adapter.Schedule_pre_event_adapter;
import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 13/2/15.
 */
public class Schedule_pre_event extends Fragment {

    private Schedule_pre_event_adapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;


    public static Schedule_pre_event getInstance(int position) {
        Schedule_pre_event myFragment = new Schedule_pre_event();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.schedule_expandable, container, false);

        ExpandList = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview_Schedule);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new Schedule_pre_event_adapter(getActivity(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        return layout;

    }

    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Rock Band ","DU Artist","Choreography","Classical Dance","Creative Writing and Translation","Debate-Vaad Vivaad","Folk Dance"
                ,"Group Songs","Instrumental Music - Solo" , "Music - Vocal Solo","Photography","Quiz Time -Prashnottri", "Rangoli", "Short Film"};

        String country_names[] = {"Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n\n culturecouncil_du@rediffmail.com"

                ,"The exhibits/painting to be submitted by 17 February 4 PM, NCWEB Office, II Floor Tutorial Building, Arts Faculty, North Campus, Delhi University.\n\n anjjuguptaa@rediffmail.com\n Shakhuranag@gmail.com"


                ,"Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n\n  culturecouncil_du@rediffmail.com"


                ,"Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n\n  culturecouncil_du@rediffmail.com"


                ,"Entries must be Submitted by 9 February 2015 through Email at msaleemir@gmail.com\n\n  msaleemir@gmail.com"


                ,"All registered participants are requested to report at 9.30 AM Conference Centre, Opposite Botany Department on 16.02.15 and 17.02.15 as per Schedule to be displayed on Antardhvani Website.\n\n  amrita.dse@gmail.com, rakeshp@email.com"


                ,"Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n\n  culturecouncil_du@rediffmail.com"


                ,"Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n\n  culturecouncil_du@rediffmail.com"

                
                ,"Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n\n  culturecouncil_du@rediffmail.com"


                ,"Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n\n  culturecouncil_du@rediffmail.com"


                ,"The Photographs to be submitted by 17 February 3 PM, Conference Centre, Opposite Botany Department, North Campus\n\n  gstuteja@gmail.com"


                ,"All registered participants for the quiz are required to report at the university Indoor Stadium at 12.30 PM on the 17th of February 2015 for verification of their college ID Cards.\n\n  premksri@gmail.com, gitschawla@gmail.com ",


                "Registered candidates report at venue directly on the day of event.\n\n  amrita.dse@gmail.com"


                ,"Final cut of the Film to be submitted by 17 February 3PM, Conference Centre, Opposite Botany Department, North Campus.\n\n  gstuteja@gmail.com"
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

}
