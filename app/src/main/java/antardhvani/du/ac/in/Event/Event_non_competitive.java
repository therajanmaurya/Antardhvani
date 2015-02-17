package antardhvani.du.ac.in.Event;

/**
 * Created by rajanmaurya on 11/2/15.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import antardhvani.du.ac.in.Adapter.Child;
import antardhvani.du.ac.in.Adapter.Event_non_competitive_adapter;
import antardhvani.du.ac.in.Adapter.Group;
import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 11/2/15.
 */

/**
 * Created by Windows on 23-01-2015.
 */
public class Event_non_competitive extends Fragment {
    private Event_non_competitive_adapter ExpAdapter,ExpAdapter1,ExpAdapter2;
    private ArrayList<Group> ExpListItems ,ExpListItems1,ExpListItems2;
    private ExpandableListView ExpandList ,ExpandList1,ExpandList2;

    public static Event_non_competitive getInstance(int position) {
        Event_non_competitive myFragment = new Event_non_competitive();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.expentable, container, false);

        Bundle bundle = getArguments();
        if ( bundle.getInt("position") == 0){
            ExpandList = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview);
            ExpListItems = SetStandardGroups();
            ExpAdapter = new Event_non_competitive_adapter(getActivity(), ExpListItems);
            ExpandList.setAdapter(ExpAdapter);
        }else if(bundle.getInt("position") == 1){

            ExpandList1 = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview);
            ExpListItems1 = SetStandardGroups1();
            ExpAdapter1 = new Event_non_competitive_adapter(getActivity(), ExpListItems1);
            ExpandList1.setAdapter(ExpAdapter1);

        }else if(bundle.getInt("position") == 2){

            ExpandList2 = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview);
            ExpListItems2 = SetStandardGroups2();
            ExpAdapter2 = new Event_non_competitive_adapter(getActivity(), ExpListItems2);
            ExpandList2.setAdapter(ExpAdapter2);

        }

        return layout;

    }


    public ArrayList<Group> SetStandardGroups1() {
        String group_names[] = getResources().getStringArray(R.array.competitiveHeads);
        String country_names[] = getResources().getStringArray(R.array.competitive);
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

    public ArrayList<Group> SetStandardGroups2() {
        String group_names[] = getResources().getStringArray(R.array.specialHeads);
        String country_names[] = getResources().getStringArray(R.array.special);
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

    public ArrayList<Group> SetStandardGroups() {
        String group_names[] = getResources().getStringArray(R.array.noncompetitiveHeads);
        String country_names[] = getResources().getStringArray(R.array.noncompetitive);

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


