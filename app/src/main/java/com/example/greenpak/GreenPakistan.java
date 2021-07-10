package com.example.greenpak;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GreenPakistan extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_pakistan);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        //read the lats and longs from the database for all the trees
        int height = 100;
        int width = 100;
        BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.tree);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);


        mMap = googleMap;

        //Tree 1
        LatLng Tree1 = new LatLng(33.95, 71.41);
        mMap.addMarker(new MarkerOptions()
                .position(Tree1)
                .title("Tree In IMS")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        //Tree 2
        LatLng Tree2 = new LatLng(33.96, 71.41);
        mMap.addMarker(new MarkerOptions()
                .position(Tree2)
                .title("Tree In Judicial Complex")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        //Tree 3
        LatLng Tree3 = new LatLng(33.97, 71.43);
        mMap.addMarker(new MarkerOptions()
                .position(Tree3)
                .title("Tree Near Lalazar Market")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        //Tree 4
        LatLng Tree4 = new LatLng(33.95, 71.43);
        mMap.addMarker(new MarkerOptions()
                .position(Tree4)
                .title("Tree Near Nawab Market")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        //Tree 5
        LatLng Tree5 = new LatLng(33.99, 71.44);
        mMap.addMarker(new MarkerOptions()
                .position(Tree5)
                .title("Tree Near HMC")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        //Tree 6
        LatLng Tree6 = new LatLng(33.99, 71.43);
        mMap.addMarker(new MarkerOptions()
                .position(Tree6)
                .title("Tree Near RMI")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        //Tree 7
        LatLng Tree7 = new LatLng(33.98, 71.45);
        mMap.addMarker(new MarkerOptions()
                .position(Tree7)
                .title("Tree In Phase 3")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );


        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}