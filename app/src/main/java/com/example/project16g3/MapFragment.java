package com.example.project16g3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback{

    private MapView mapView;
    private GoogleMap mMap;
    LatLng userLatLong;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_map_fragment, container, false);
        SupportMapFragment mapci =(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapView);
        mapci.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        userLatLong = new LatLng(45.186521, 5.736446);
        float zoomLevel = 11.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLatLong, zoomLevel));

        mMap.addMarker(new MarkerOptions()
                .position(userLatLong)
                .title("Ma localisation"));

        LatLng maCoop = new LatLng(45.243016, 5.825143);
        mMap.addMarker(new MarkerOptions()
                .position(maCoop)
                .title("Ma Coop"));

        LatLng marcheMeylan = new LatLng(45.208885, 5.763458);
        mMap.addMarker(new MarkerOptions()
                .position(marcheMeylan)
                .title("Marché bio de Meylan"));

        LatLng fermeBonne = new LatLng(45.183101, 5.725094);
        mMap.addMarker(new MarkerOptions()
                .position(fermeBonne)
                .title("La Ferme de Bonne"));

        LatLng vercorsLait = new LatLng(45.159863, 5.693457);
        mMap.addMarker(new MarkerOptions()
                .position(vercorsLait)
                .title("Vercors Lait"));

        LatLng marcheGieres = new LatLng(45.182218, 5.793064);
        mMap.addMarker(new MarkerOptions()
                .position(marcheGieres)
                .title("Marché de Gières"));
    }
}