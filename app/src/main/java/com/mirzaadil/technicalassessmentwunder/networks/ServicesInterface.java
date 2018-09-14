package com.mirzaadil.technicalassessmentwunder.networks;



import com.mirzaadil.technicalassessmentwunder.models.LocationDataModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Mirza Adil on 9/09/2018.
 * <p>
 * This class contains the Services Interface of the API.
 * All of the attributes in this class shall be static. So, that they can be used from anywhere
 * without even declaring the object of this class.</p>
 */


public interface ServicesInterface {

    @GET
    Observable<Response<LocationDataModel>> fetchLocationData(@Url String url);


}
