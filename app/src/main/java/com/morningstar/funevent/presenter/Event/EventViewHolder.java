package com.morningstar.funevent.presenter.Event;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.morningstar.funevent.EventDetailActivity;
import com.morningstar.funevent.R;
import com.morningstar.funevent.model.ResultEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.img_event)
    ImageView img_event;
    @BindView(R.id.tv_tanggal_mulai)
    TextView tv_tanggal_mulai;
    @BindView(R.id.tv_nama_event)
    TextView tv_nama_event;
    @BindView(R.id.tv_lokasi)
    TextView tv_lokasi;

    private List<ResultEvent> resultEventList = new ArrayList<>();

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void setItem(List<ResultEvent> item){
        resultEventList = item;

    }
    @OnClick()
    void click(@NonNull View itemView){
        int position = getAdapterPosition();
        String gambar = resultEventList.get(position).getGambar();
        String nama_event = resultEventList.get(position).getNama_event();
        String tanggal_mulai = resultEventList.get(position).getTanggal_mulai();
        String tanggal_selesai = resultEventList.get(position).getTanggal_selesai();
        String jam_mulai = resultEventList.get(position).getJam_mulai();
        String jam_selesai = resultEventList.get(position).getJam_selesai();
        String kota = resultEventList.get(position).getKota();
        String alamat = resultEventList.get(position).getAlamat();
        String deskripsi = resultEventList.get(position).getDeskripsi();


        Intent intent = new Intent(itemView.getContext(), EventDetailActivity.class);
        intent.putExtra("gambar", gambar);
        intent.putExtra("nama_event", nama_event);
        intent.putExtra("tanggal_mulai", tanggal_mulai);
        intent.putExtra( "tanggal_selesai", tanggal_selesai);
        intent.putExtra("jam_mulai", jam_mulai);
        intent.putExtra("jam_selesai", jam_selesai);
        intent.putExtra("kota", kota);
        intent.putExtra("alamat", alamat);
        intent.putExtra("deskripsi", deskripsi);
        itemView.getContext().startActivity(intent);
    }
}
