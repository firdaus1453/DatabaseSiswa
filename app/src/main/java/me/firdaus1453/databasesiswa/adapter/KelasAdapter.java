package me.firdaus1453.databasesiswa.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.firdaus1453.databasesiswa.R;
import me.firdaus1453.databasesiswa.model.KelasModel;

/**
 * Created by firdaus1453 on 1/17/2019.
 */
public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.ViewHolder> {

    // Membuat variable untuk menampung context
    private final Context context;
    // Membuat variable list dengan cetakan KelasModel
    private final List<KelasModel> kelasModelList;

    // Membuat variable bundle untuk membawa data
    private Bundle bundle;

    public KelasAdapter(Context context, List<KelasModel> kelasModelList) {
        this.context = context;
        this.kelasModelList = kelasModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_kelas, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Memindahkan data di dalam list dengan index position ke dalam KelasModel
        final KelasModel kelasModel = kelasModelList.get(position);
        // Menampilkan data ke layar
        holder.tvNamaWali.setText(kelasModel.getNama_wali());
        holder.tvNamaKelas.setText(kelasModel.getNama_kelas());

        // kita buat variable random
        Random random = new Random();
        // membuat color Argb alpha red green blue
        int color = Color.argb(255, random.nextInt(255), random.nextInt(255),
                random.nextInt(255));

        // mesetting color background cardview
        holder.cvKelas.setCardBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return kelasModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNamaKelas)
        TextView tvNamaKelas;
        @BindView(R.id.tvNamaWali)
        TextView tvNamaWali;
        @BindView(R.id.cvKelas)
        CardView cvKelas;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
