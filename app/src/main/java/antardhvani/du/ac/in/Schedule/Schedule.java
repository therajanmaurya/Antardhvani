package antardhvani.du.ac.in.Schedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import antardhvani.du.ac.in.antardhvani.R;
import antardhvani.du.ac.in.network.VolleySingleton;

/**
 * Created by Windows on 23-01-2015.
 */
public class Schedule extends Fragment {
    private TextView textView;

    public static Schedule getInstance(int position) {
        Schedule myFragment = new Schedule();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.schedule, container, false);
        textView = (TextView) layout.findViewById(R.id.position);
        Bundle bundle = getArguments();


        return layout;

    }

}