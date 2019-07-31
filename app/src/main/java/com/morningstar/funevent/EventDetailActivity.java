package com.morningstar.funevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        ButterKnife.bind(this);

        String gambar = getIntent().getExtras().getString("gambar");
        String nama_event = getIntent().getExtras().getString("nama_event");
        String tanggal_mulai = getIntent().getExtras().getString("tanggal_mulai");
        String tanggal_selesai = getIntent().getExtras().getString("tanggal_selesai");
        String jam_mulai = getIntent().getExtras().getString("jam_mulai");
        String jam_selesai = getIntent().getExtras().getString("jam_selesai");
        String kota = getIntent().getExtras().getString("kota");
        String alamat = getIntent().getExtras().getString("alamat");
        String deskripsi = getIntent().getExtras().getString("deskripsi");

        ImageView gambarp = (ImageView)findViewById(R.id.gambar);
        TextView nama_eventp = (TextView)findViewById(R.id.nama_event);
        TextView tanggal_mulaip = (TextView)findViewById(R.id.tanggal_mulai);
        TextView tanggal_selesaip = (TextView)findViewById(R.id.tanggal_selesai);
        TextView jam_mulaip = (TextView)findViewById(R.id.jam_mulai);
        TextView jam_selesaip = (TextView)findViewById(R.id.jam_selesai);
        TextView kotap = (TextView)findViewById(R.id.kota);
        TextView alamatp = (TextView)findViewById(R.id.alamat);
        TextView deskripsip = (TextView) findViewById(R.id.deskripsi);

        nama_eventp.setText(nama_event);
        tanggal_mulaip.setText(tanggal_mulai);
        tanggal_selesaip.setText(tanggal_selesai);
        jam_mulaip.setText(jam_mulai);
        jam_selesaip.setText(jam_selesai);
        kotap.setText(kota);
        alamatp.setText(alamat);
        deskripsip.setText(deskripsi);


        Glide.with(this)
                .load("https://kostlab.id/project/fajarm/xfile/gambar/"+gambar)
                .apply(new RequestOptions().override(100,100).centerCrop())
                .into(gambarp);

    }

    @OnClick(R.id.btn_back)
    public void back(){
        Intent in = new Intent(EventDetailActivity.this, MainActivity.class);
        in.putExtra("source", "detail");
        startActivity(in);
    }


}