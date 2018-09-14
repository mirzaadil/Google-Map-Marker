package com.mirzaadil.technicalassessmentwunder.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


/**
 * Created by Mirza Adil on 6/27/2018.
 * <p>
 * This is a model class for Location Data API.
 */

public class LocationDataModel implements Serializable {

    @SerializedName("placemarks")
    private List<PlacemarksItem> placemarks;

    public void setPlacemarks(List<PlacemarksItem> placemarks) {
        this.placemarks = placemarks;
    }

    public List<PlacemarksItem> getPlacemarks() {
        return placemarks;
    }

    @Override
    public String toString() {
        return
                "Response{" +
                        "placemarks = '" + placemarks + '\'' +
                        "}";
    }

//    private boolean error;
//    private String status;
//    private ArrayList<LocationData> locationData;
//
//    public boolean getError() {
//        return this.error;
//    }
//
//    public void setError(boolean error) {
//        this.error = error;
//    }
//
//    public String getStatus() {
//        return this.status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public ArrayList<LocationData> getLocationData() {
//        return this.locationData;
//    }
//
//    public void setLocationData(ArrayList<LocationData> locationData) {
//        this.locationData = locationData;
//    }
//
//    public class LocationData {
//
//
//        private String image;
//        private String id;
//        private String name;
//        private String latitude;
//        private String longitude;
//        private String addressOne;
//        private String addressTwo;
//        private String state;
//        private String country;
//        private String userLocation;
//        private String companyType;
//        private String category;
//        private boolean newJoined;
//
//        public String getImage() {
//            return this.image;
//        }
//
//        public void setImage(String image) {
//            this.image = image;
//        }
//
//
//        public String getId() {
//            return this.id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//
//        public String getName() {
//            return this.name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//
//        public String getLatitude() {
//            return this.latitude;
//        }
//
//        public void setLatitude(String latitude) {
//            this.latitude = latitude;
//        }
//
//
//        public String getLongitude() {
//            return this.longitude;
//        }
//
//        public void setLongitude(String longitude) {
//            this.longitude = longitude;
//        }
//
//
//        public String getAddressOne() {
//            return this.addressOne;
//        }
//
//        public void setAddressOne(String addressOne) {
//            this.addressOne = addressOne;
//        }
//
//
//        public String getAddressTwo() {
//            return this.addressTwo;
//        }
//
//        public void setAddressTwo(String addressTwo) {
//            this.addressTwo = addressTwo;
//        }
//
//
//        public String getState() {
//            return this.state;
//        }
//
//        public void setState(String state) {
//            this.state = state;
//        }
//
//
//        public String getCountry() {
//            return this.country;
//        }
//
//        public void setCountry(String country) {
//            this.country = country;
//        }
//
//
//        public String getUserLocation() {
//            return this.userLocation;
//        }
//
//        public void setUserLocation(String userLocation) {
//            this.userLocation = userLocation;
//        }
//
//
//        public String getCompanyType() {
//            return this.companyType;
//        }
//
//        public void setCompanyType(String companyType) {
//            this.companyType = companyType;
//        }
//
//
//        public String getCategory() {
//            return this.category;
//        }
//
//        public void setCategory(String category) {
//            this.category = category;
//        }
//
//
//        public boolean getNewJoined() {
//            return this.newJoined;
//        }
//
//        public void setNewJoined(boolean newJoined) {
//            this.newJoined = newJoined;
//        }
//    }

}
