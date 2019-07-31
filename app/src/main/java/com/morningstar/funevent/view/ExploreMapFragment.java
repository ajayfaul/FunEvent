package com.morningstar.funevent.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.morningstar.funevent.R;
import com.morningstar.funevent.model.EventModel;
import com.morningstar.funevent.presenter.ClientAPI;
import com.morningstar.funevent.presenter.Event.EventAdapter;
import com.morningstar.funevent.presenter.RestAPI;


public class ExploreMapFragment extends Fragment {

//    private RecyclerView recyclerView;

    @BindView((R.id.txt_cari))
    EditText editText;

    @BindView(R.id.recylerViewEvent) RecyclerView recyclerViewEvent;
    private final static String base_url = "https://kostlab.id/project/fajarm/api/";
    Call<EventModel> call;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View myFragmentsView = inflater.inflate(R.layout.fragment_explore_map, container, false);
        ButterKnife.bind(this, myFragmentsView);

        loadData(null);
        //Setting recyclerView
//        recyclerView = myFragmentsView.findViewById(R.id.recylerViewHero);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);

        return myFragmentsView;

    }
    @OnClick(R.id.btn_search)
    public void search(){
        String cari = editText.getText().toString();
        if (cari.isEmpty()){
            Toast.makeText(getContext(), "Masukkan nama event yang ingin dicari", Toast.LENGTH_LONG).show();
            cari = null;
            loadData(cari);
        } else {
            loadData(cari);
        }
    }

    void loadData(String cari){
        RestAPI service = ClientAPI.get(base_url).create(RestAPI.class);
        if(cari==null){
            call = service.getdataAll();
        }else{
            call = service.getdataByNama(cari);
        }
        call.enqueue(new Callback<EventModel>() {
            @Override
            public void onResponse(Call<EventModel> call, Response<EventModel> response) {
                int totalResult = response.body().getTotal_result();
                if (totalResult==0){
                    Toast.makeText(getContext(), "Data tidak ditemukan", Toast.LENGTH_LONG).show();
                }else {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerViewEvent.setLayoutManager(linearLayoutManager);
                    recyclerViewEvent.setHasFixedSize(true);
                    EventAdapter eventAdapter = new EventAdapter(getContext(), response.body().getResults());
                    recyclerViewEvent.setAdapter(eventAdapter);
                }
            }

            @Override
            public void onFailure(Call<EventModel> call, Throwable t) {
            }
        });
    }
}
