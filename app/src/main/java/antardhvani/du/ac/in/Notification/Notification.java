package antardhvani.du.ac.in.Notification;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import antardhvani.du.ac.in.Adapter.Child;
import antardhvani.du.ac.in.Adapter.Group;
import antardhvani.du.ac.in.Adapter.Notificaton_adapter;
import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 17/2/15.
 */
public class Notification extends Activity{

    private Notificaton_adapter noti;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expentable);
        ExpandList = (ExpandableListView) findViewById(R.id.activity_googlecards_listview);
        ExpListItems = SetStandardGroups(getResources().getStringArray(R.array.noncompetitiveHeads), getResources().getStringArray(R.array.noncompetitive));
        noti = new Notificaton_adapter(this, ExpListItems);
        ExpandList.setAdapter(noti);

    }

    public ArrayList<Group> SetStandardGroups(String[] event, String[] event1) {
        String group_names[] = event;
        String country_names[] = event1;

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

