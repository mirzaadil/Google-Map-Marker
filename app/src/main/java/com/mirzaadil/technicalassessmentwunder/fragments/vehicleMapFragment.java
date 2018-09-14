package com.mirzaadil.technicalassessmentwunder.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mirzaadil.technicalassessmentwunder.R;
import com.mirzaadil.technicalassessmentwunder.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link vehicleMapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link vehicleMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vehicleMapFragment extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private LatLng latlng;
    private LinearLayout linearLayout;
    private GoogleMap googleMap;
    private TextView vehicle_name;
    private boolean IsPinClick;


    private OnFragmentInteractionListener mListener;

    public vehicleMapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vehicleMapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static vehicleMapFragment newInstance(String param1, String param2) {
        vehicleMapFragment fragment = new vehicleMapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_vehicle_map, container, false);
        linearLayout = rootView.findViewById(R.id.map_layout);
        vehicle_name = rootView.findViewById(R.id.location_name);
        rootView.findViewById(R.id.location_name);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {


        for (int i = 0; i < vehicleListFragment.locationDataList.size(); i++) {
            latlng = new LatLng(Double.valueOf(vehicleListFragment.locationDataList.get(i).getCoordinates().get(0)), Double.valueOf(vehicleListFragment.locationDataList.get(i).getCoordinates().get(1)));
            googleMap.addMarker(new MarkerOptions().position(latlng)
                    .title(vehicleListFragment.locationDataList.get(i).getName()));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 14f));
        }

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {



                if (!IsPinClick) {
                    IsPinClick = true;
                    googleMap.clear();
                    Double lat = marker.getPosition().latitude;
                    Double lng = marker.getPosition().longitude;
                    LatLng latLng = new LatLng(lat, lng);
                    googleMap.addMarker(new MarkerOptions().position(latLng));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 14.0f));

                    for (int i = 0; i < vehicleListFragment.locationDataList.size(); i++) {
                        if (marker.getPosition().latitude == vehicleListFragment.locationDataList.get(i).getCoordinates().get(0) &&
                                marker.getPosition().longitude == vehicleListFragment.locationDataList.get(i).getCoordinates().get(1)) {
                            linearLayout.setVisibility(View.VISIBLE);
                            vehicle_name.setText(vehicleListFragment.locationDataList.get(i).getName());
                            break;
                        }
                    }
                    return true;
                } else {
                    IsPinClick = false;
                    linearLayout.setVisibility(View.GONE);
                    for (int i = 0; i < vehicleListFragment.locationDataList.size(); i++) {
                        Double lat = vehicleListFragment.locationDataList.get(i).getCoordinates().get(0);
                        Double lng = vehicleListFragment.locationDataList.get(i).getCoordinates().get(1);
                        LatLng latLng = new LatLng(lat, lng);
                        googleMap.addMarker(new MarkerOptions().position(latLng));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 14.0f));
                    }
                    return true;
                }
            }
        });
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
