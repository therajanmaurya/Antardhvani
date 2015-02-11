package antardhvani.du.ac.in.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import antardhvani.du.ac.in.antardhvani.NavigationDrawerFragment;
import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 10/2/15.
 */

public class Map extends Fragment {

    MapView mapView;

    GoogleMap googleMap;

    public static Map getInstance(int position) {
        Map myFragment = new Map();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.map, container, false);

        mapView = (MapView) layout.findViewById(R.id.map);

        mapView.onCreate(savedInstanceState);

        if(mapView!=null)
        {
            googleMap = mapView.getMap();

            googleMap.getUiSettings().setMyLocationButtonEnabled(false);

            googleMap.setMyLocationEnabled(true);

            googleMap.addMarker(new MarkerOptions().position(new LatLng( 28.690976,77.214166)).title("Marker"));

            googleMap.getUiSettings().setZoomControlsEnabled(true);
        }

        return layout;

    }

    @Override
    public void onResume()
    {
        mapView.onResume();

        super.onResume();
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();

        mapView.onDestroy();
    }
    @Override
    public void onLowMemory()
    {
        super.onLowMemory();

        mapView.onLowMemory();
    }



    }



