package me.firdaus1453.databasesiswa.ui.siswa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.firdaus1453.databasesiswa.R;
import me.firdaus1453.databasesiswa.adapter.SiswaAdapter;
import me.firdaus1453.databasesiswa.db.Constant;
import me.firdaus1453.databasesiswa.db.SiswaDatabase;
import me.firdaus1453.databasesiswa.model.SiswaModel;

public class MainSiswaActivity extends AppCompatActivity {

    @BindView(R.id.rvSiswa)
    RecyclerView rvSiswa;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private SiswaDatabase siswaDatabase;
    private List<SiswaModel> siswaModelList;
    private int id_kelas;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_siswa);
        ButterKnife.bind(this);

        setTitle("Data siswa");

        bundle = getIntent().getExtras();

        if (bundle != null) {
            id_kelas = bundle.getInt(Constant.KEY_ID_KELAS);
        }

        siswaDatabase = SiswaDatabase.createDatabase(this);

        siswaModelList = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        siswaModelList.clear();
        getData();
        rvSiswa.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        rvSiswa.setLayoutManager(new LinearLayoutManager(this));
        rvSiswa.setAdapter(new SiswaAdapter(this, siswaModelList));
    }

    private void getData() {
        siswaModelList = siswaDatabase.kelasDao().selectSiswa(id_kelas);
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        startActivity(new Intent(this, TambahSiswaActivity.class).putExtra(Constant.KEY_ID_KELAS, id_kelas));
    }
}
