package me.firdaus1453.databasesiswa.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.firdaus1453.databasesiswa.R;
import me.firdaus1453.databasesiswa.model.SiswaModel;

/**
 * Created by firdaus1453 on 1/21/2019.
 */
public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {

    private final Context context;
    private final List<SiswaModel> siswaModelList;

    private Bundle bundle;
    private String firstName;

    public SiswaAdapter(Context context, List<SiswaModel> siswaModelList) {
        this.context = context;
        this.siswaModelList = siswaModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_siswa, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // memindahkan data yang dipilih ke dalam list
        final SiswaModel siswaModel = siswaModelList.get(position);

        // Menampilkan data ke layar
        holder.txtNameSiswa.setText(siswaModel.getNama_siswa());

        // Mengambil huruf pertama
        String nama = siswaModel.getNama_siswa();
        if (!nama.isEmpty()){
            firstName = nama.substring(0, 1);
        }else {
            firstName = " ";
        }

        ColorGenerator generator = ColorGenerator.MATERIAL;
        // generate random color
        int color = generator.getRandomColor();

        TextDrawable drawable = TextDrawable.builder().buildRound(firstName, color);
        holder.imgView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return siswaModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_view)
        ImageView imgView;
        @BindView(R.id.txt_name_siswa)
        TextView txtNameSiswa;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
