package com.morningstar.funevent.presenter;

import android.util.EventLog;

import com.morningstar.funevent.model.EventModel;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface RestAPI {
    //@FormUrlEncoded
    //@POST("{url_endpoint}")
    //Call<NamaModel> login(@Field("nama_field_di_api") String nama_field, @Field("nama_field_di_api") String nama_field);

    //@Multipart
    //@POST("{url_endpoint}")
    //Call<PostModels> uploadPhotoMultipartWithPosts(@Part MultipartBody.Part nama_field,@Part MultipartBody.Part nama_field);

    //@GET("{url_endpoint}")
    //Call <NamaModel> getdata(@Query("nama_field_di_api") String nama_field);

    @GET("funevent/getdata")
    Call<EventModel> getdataAll();

    @GET("funtevent/getdata")
    Call<EventModel> getdataByNama(@Query("nama_event") String nama_event);
}