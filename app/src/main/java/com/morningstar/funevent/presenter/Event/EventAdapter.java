package com.morningstar.funevent.presenter.Event;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.morningstar.funevent.R;
import com.morningstar.funevent.model.ResultEvent;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {


    private Context context;
    private List<ResultEvent> resultEventList;

    public EventAdapter(Context context, List<ResultEvent> resultEventList){
        this.context = context;
        this.resultEventList = resultEventList;
    }
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event, viewGroup, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder eventViewHolder, int i) {
        ResultEvent resultEvent = resultEventList.get(i);

        eventViewHolder.tv_nama_event.setText(resultEvent.getNama_event());
        eventViewHolder.tv_tanggal_mulai.setText(resultEvent.getTanggal_mulai());
        eventViewHolder.tv_lokasi.setText(resultEvent.getKota());
        Glide.with(context)
                .load("https://kostlab.id/project/fajarm/xfile/gambar/"+resultEvent.getGambar())
                .apply(new RequestOptions().override(100,100).centerCrop())
                .into(eventViewHolder.img_event);
        eventViewHolder.setItem(resultEventList);
    }

    @Override
    public int getItemCount() {
        return resultEventList.size();
    }
}
