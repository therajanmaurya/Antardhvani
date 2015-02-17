package antardhvani.du.ac.in.Schedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import antardhvani.du.ac.in.Adapter.Child;
import antardhvani.du.ac.in.Adapter.Group;
import antardhvani.du.ac.in.Adapter.Schedule_day_adapter;
import antardhvani.du.ac.in.Adapter.Schedule_pre_event_adapter;
import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by Windows on 23-01-2015.
 */
public class Schedule_20th_FEB_2015 extends Fragment {

    private Schedule_day_adapter ExpAdapter, ExpAdapter1, ExpAdapter2, ExpAdapter3, ExpAdapter4, ExpAdapter5, ExpAdapter6;
    private ArrayList<Group> ExpListItems, ExpListItems1, ExpListItems2, ExpListItems3, ExpListItems4, ExpListItems5, ExpListItems6;
    private ExpandableListView ExpandList, ExpandList1, ExpandList2, ExpandList3, ExpandList4, ExpandList5, ExpandList6;


    public static Schedule_20th_FEB_2015 getInstance(int position) {
        Schedule_20th_FEB_2015 myFragment = new Schedule_20th_FEB_2015();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.schedule_20th, container, false);


        View layout = inflater.inflate(R.layout.schedule_expandable, container, false);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int height = display.getHeight();
        height = height - 36;
        height = height / 5;
        Bundle bundle = getArguments();
        if (bundle.getInt("position") == 0) {
            ExpandList = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview_Schedule);
            ExpListItems = SetStandardGroups(getResources().getStringArray(R.array.day11));
            ExpAdapter = new Schedule_day_adapter(getActivity(), ExpListItems, height);
            ExpandList.setAdapter(ExpAdapter);
        } else if (bundle.getInt("position") == 1) {

            ExpandList1 = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview_Schedule);
            ExpListItems1 = SetStandardGroups(getResources().getStringArray(R.array.day12));
            ExpAdapter1 = new Schedule_day_adapter(getActivity(), ExpListItems1, height);
            ExpandList1.setAdapter(ExpAdapter1);
        }else if (bundle.getInt("position") == 2){

            ExpandList2 = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview_Schedule);
            ExpListItems2 = SetStandardGroups(getResources().getStringArray(R.array.day13));
            ExpAdapter2 = new Schedule_day_adapter(getActivity(), ExpListItems2, height);
            ExpandList2.setAdapter(ExpAdapter2);
        }else if (bundle.getInt("position") == 3){

            ExpandList3 = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview_Schedule);
            ExpListItems3 = SetStandardGroups(getResources().getStringArray(R.array.day14));
            ExpAdapter3 = new Schedule_day_adapter(getActivity(), ExpListItems3, height);
            ExpandList3.setAdapter(ExpAdapter3);
        }else if (bundle.getInt("position") == 4){

            ExpandList4 = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview_Schedule);
            ExpListItems4 = SetStandardGroups(getResources().getStringArray(R.array.day15));
            ExpAdapter4 = new Schedule_day_adapter(getActivity(), ExpListItems4, height);
            ExpandList4.setAdapter(ExpAdapter4);
        }else if (bundle.getInt("position") == 5){

            ExpandList5 = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview_Schedule);
            ExpListItems5 = SetStandardGroups(getResources().getStringArray(R.array.day16));
            ExpAdapter5 = new Schedule_day_adapter(getActivity(), ExpListItems5, height);
            ExpandList5.setAdapter(ExpAdapter5);
        }else if (bundle.getInt("position") == 6){

            ExpandList6 = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview_Schedule);
            ExpListItems6 = SetStandardGroups(getResources().getStringArray(R.array.day17));
            ExpAdapter6 = new Schedule_day_adapter(getActivity(), ExpListItems6, height);
            ExpandList6.setAdapter(ExpAdapter6);
        }
        ExpandList = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview_Schedule);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new Schedule_pre_event_adapter(getActivity(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

//        ExpandList = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview_Schedule);
//        ExpListItems = SetStandardGroups();
//        ExpAdapter = new Schedule_pre_event_adapter(getActivity(), ExpListItems);
//        ExpandList.setAdapter(ExpAdapter);

        return layout;

    }


    public ArrayList<Group> SetStandardGroups(String[] data) {

    public ArrayList<Group> SetStandardGroups() {



/*        String group_names[] = {"INAUGURAL CEREMONY", " DU ART GALLERY/ IGNCA/ RANGOLI /Equal Opportunity Cell", "INNOVATION PLAZA", "CLUSTER INNOVATION\n" +
                "CENTRE ON PATIO", "Creative Writing and Translation", "Debate-Vaad Vivaad", "Folk Dance"
<<<<<<< HEAD
                , "Group Songs", "Instrumental Music - Solo", "Music - Vocal Solo", "Photography", "Quiz Time -Prashnottri", "Rangoli", "Short Film"};*/

        String group_names[] = {"INAUGURAL CEREMONY",
                " DU ART GALLERY/ IGNCA/ RANGOLI /Equal Opportunity Cell",
                "INNOVATION PLAZA", "CLUSTER INNOVATION" +
                "CENTRE ON PATIO", "CLASSICAL DANCE Debate-Vaad Vivaad", " DU ART GALLERY/ IGNCA/ RANGOLI/EOC"
                , "CREATIVE  WRITING/ TRANSLATION", "INNOVATION PLAZA / 12 noon Inauguration", "NSDC /SKILL COUNSELLING", "ROCK BAND", "DEBATE", "INSTRUMENTAL MUSIC", "DU ART GALLERY/ IGNCA/ RANGOLI /EOC","CREATIVE WRITING/TRANSLATION"
        ,"INNOVATION PLAZA","NSDC SKILL COUNSELLING " , "VOCAL SOLO" ,"DEBATE" ,"FOLK DANCE" ,"DU ART GALLERY/ IGNCA/ RANGOLI EOC /","CREATIVE WRITING/ TRANSLATION"
        ,"INNOVATION PLAZA","SHORT FILM-LIFE IN DU" , "DEBATE" , "CHOREGRAPHY" ,"DU ART GALLERY/ IGNCA/ RANGOLI/EOC" ,"CREATIVE WRITING/TRANSLATION","INNOVATION PLAZA"
        ,"SHORT FILM-LIFE IN DU" ,"DEBATE"};

                , "Group Songs", "Instrumental Music - Solo", "Music - Vocal Solo", "Photography", "Quiz Time -Prashnottri", "Rangoli", "Short Film"};





        String country_names[] = {"Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n\n culturecouncil_du@rediffmail.com"

                , "The exhibits/painting to be submitted by 17 February 4 PM, NCWEB Office, II Floor Tutorial Building, Arts Faculty, North Campus, Delhi University.\n\n anjjuguptaa@rediffmail.com\n Shakhuranag@gmail.com"


                , "Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n\n  culturecouncil_du@rediffmail.com"


                , "Meeting on 16 February at 3:00 PM at Multipurpose Hall, University Stadium  to confirm their participation.\n\n  culturecouncil_du@rediffmail.com"


                , "Entries must be Submitted by 9 February 2015 through Email at msaleemir@gmail.com\n\n  msaleemir@gmail.com"


                , "All registered participants are requested to report at 9.30 AM Conference Centre, Opposite Botany Department on 16.02.15 and 17.02.15 as per Schedule to be displayed on Antardhvani Website.\n\n  amrita.dse@gmail.com, rakeshp@email.com"



        String group_names[] = data;


        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 1;
        int j = 0;

        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);
            list.add(gru);

            size = size + 1;
        }

        return list;
    }


}
