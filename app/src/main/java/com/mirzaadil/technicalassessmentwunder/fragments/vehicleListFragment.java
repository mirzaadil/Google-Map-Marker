package com.mirzaadil.technicalassessmentwunder.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mirzaadil.technicalassessmentwunder.R;
import com.mirzaadil.technicalassessmentwunder.adapters.VehicleAdapter;
import com.mirzaadil.technicalassessmentwunder.models.LocationDataModel;
import com.mirzaadil.technicalassessmentwunder.models.PlacemarksItem;
import com.mirzaadil.technicalassessmentwunder.networks.RestClient;
import com.mirzaadil.technicalassessmentwunder.networks.ServicesInterface;
import com.mirzaadil.technicalassessmentwunder.utils.UtilityFunction;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link vehicleListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link vehicleListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vehicleListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ServicesInterface apiInterface;
    public static List<PlacemarksItem> locationDataList;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private VehicleAdapter allCategoryAdapter;
    private ProgressDialog progressDialog;
    private Context context;
    private OnFragmentInteractionListener mListener;


    public vehicleListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vehicleListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static vehicleListFragment newInstance(String param1, String param2) {
        vehicleListFragment fragment = new vehicleListFragment();
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

        context = getActivity();
        apiInterface = RestClient.getRetrofitClient().create(ServicesInterface.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vehicle_list, container, false);
        initView(view);


        if (UtilityFunction.isNetworkAvailable()) {
            UtilityFunction.showProgressDialog(progressDialog);
            callAllProductsAPI();
        } else {
            UtilityFunction.showToast("Please connect Internet Connection");
        }


        return view;
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


    private void callAllProductsAPI() {
        apiInterface = RestClient.getRetrofitClient().create(ServicesInterface.class);
        final Observable<Response<LocationDataModel>> locationdataCall = apiInterface.fetchLocationData("locations.json");
        locationdataCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<LocationDataModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        UtilityFunction.showLogs(d.toString());
                    }

                    @Override
                    public void onNext(Response<LocationDataModel> value) {


                        if (value.isSuccessful()) {
                            locationDataList = value.body().getPlacemarks();
                            UtilityFunction.dismissProgressDialog(progressDialog);
                            if (locationDataList != null) {
                                allCategoryAdapter = new VehicleAdapter(locationDataList, context);
                                recyclerView.setAdapter(allCategoryAdapter);
                            } else {

                                UtilityFunction.showToast("All Category Data Not Received ");
                            }
                        }

                    }


                    @Override
                    public void onError(Throwable e) {

                        UtilityFunction.showLogs(e.toString());
                        UtilityFunction.dismissProgressDialog(progressDialog);
                    }

                    @Override
                    public void onComplete() {

                        UtilityFunction.dismissProgressDialog(progressDialog);
                    }
                });
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.all_category_list);
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);

        progressDialog = new ProgressDialog(context);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setMessage("Loading please wait...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
    }
}
