package antardhvani.du.ac.in.Event;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import antardhvani.du.ac.in.Adapter.Event_non_competitive_adapter;
import antardhvani.du.ac.in.antardhvani.R;


public class Event_competitive extends Fragment {
    private TextView textView;
    ExpandableListView exap;
    Event_non_competitive_adapter exo;
    public static Event_competitive getInstance(int position) {
        Event_competitive myFragment = new Event_competitive();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.expentable, container, false);
        exap = (ExpandableListView)layout.findViewById(R.id.activity_googlecards_listview);
        exo = new Event_non_competitive_adapter( getActivity());
        exap.setAdapter(exo);



        return layout;

    }

}