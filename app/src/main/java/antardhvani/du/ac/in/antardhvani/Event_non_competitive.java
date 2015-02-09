package antardhvani.du.ac.in.antardhvani;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import antardhvani.du.ac.in.Adapter.Googlecard_Adapter;
import antardhvani.du.ac.in.network.VolleySingleton;

/**
 * Created by Windows on 23-01-2015.
 */
public class Event_non_competitive extends Fragment {
    ListView listView;
    Googlecard_Adapter Adapter;

    public static Event_non_competitive getInstance(int position) {
        Event_non_competitive myFragment = new Event_non_competitive();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.event_non_competitive, container, false);
        listView = (ListView) layout.findViewById(R.id.activity_googlecards_listview);

        return layout;

    }

}