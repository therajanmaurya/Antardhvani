package antardhvani.du.ac.in.Map;


import android.location.Location;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 10/2/15.
 */

public class Map extends Fragment implements LocationListener {

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
        MapsInitializer.initialize(getActivity());
        mapView.onCreate(savedInstanceState);

        if(mapView!=null)
        {
            googleMap = mapView.getMap();

            googleMap.getUiSettings().setMyLocationButtonEnabled(true);

            googleMap.setMyLocationEnabled(true);


            googleMap.addMarker(new MarkerOptions().position(new LatLng( 28.690976,77.214166)).title("Cluster Innovation centre"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng( 28.690976,77.214166),16));


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


    @Override
    public void onLocationChanged(Location location) {

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        googleMap.addMarker(new MarkerOptions().position(latLng));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        //locationTv.setText("Latitude:" + latitude + ", Longitude:" + longitude);

    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status,getActivity(), 0).show();
            return false;
        }
    }
}



