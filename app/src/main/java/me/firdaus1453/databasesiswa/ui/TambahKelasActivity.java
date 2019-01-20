package me.firdaus1453.databasesiswa.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.firdaus1453.databasesiswa.R;
import me.firdaus1453.databasesiswa.db.SiswaDatabase;
import me.firdaus1453.databasesiswa.model.KelasModel;

public class TambahKelasActivity extends AppCompatActivity {

    @BindView(R.id.edtNamaKelas)
    EditText edtNamaKelas;
    @BindView(R.id.edtNamaWali)
    EditText edtNamaWali;
    @BindView(R.id.btnSimpan)
    Button btnSimpan;

    // TODO 1 Membuat variable yang dibutuhkan
    private SiswaDatabase siswaDatabase;

    private String namaKelas, namaWali;
    private int idKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kelas);
        ButterKnife.bind(this);

        // TODO 2 Mensetting judul activity
        setTitle("Add Kelas");

        // TODO 3 membuat object database SiswaDatabase
        siswaDatabase = SiswaDatabase.createDatabase(this);
    }

    @OnClick(R.id.btnSimpan)
    public void onViewClicked() {
        // TODO 4 Mengambil data input dari user
        getData();

        // TODO Proses menyimpanan data ke SQLite
        saveData();

        clearData();

        Toast.makeText(this, "Berhasil disimpan", Toast.LENGTH_SHORT).show();

        finish();
    }

    private void clearData() {
        edtNamaKelas.setText("");
        edtNamaWali.setText("");
    }

    private void saveData() {

        // Membuat variable List kelasModels
//        List<KelasModel> kelasModels = new ArrayList<>();

        // Membuat object KelasModel untuk menampung data
        KelasModel kelasModel = new KelasModel();

        // Memasukkan data ke dalam KelasModel
        kelasModel.setNama_kelas(namaKelas);
        kelasModel.setNama_wali(namaWali);

        // Memasukkan data yang sudah terkumpul di dalam KelasModel ke dalam List kelasModels
//        kelasModels.add(kelasModel);

        // Perintah untuk melakukan operasi Insert menggunakan siswaDatabase
        siswaDatabase.kelasDao().insert(kelasModel);
    }

    private void getData() {
        namaKelas = edtNamaKelas.getText().toString();
        namaWali = edtNamaWali.getText().toString();
    }
}
