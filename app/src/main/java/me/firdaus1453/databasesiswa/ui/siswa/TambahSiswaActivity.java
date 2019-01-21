package me.firdaus1453.databasesiswa.ui.siswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.firdaus1453.databasesiswa.R;
import me.firdaus1453.databasesiswa.db.Constant;
import me.firdaus1453.databasesiswa.db.SiswaDatabase;
import me.firdaus1453.databasesiswa.model.SiswaModel;

public class TambahSiswaActivity extends AppCompatActivity {

    @BindView(R.id.edtNamaSiswa)
    EditText edtNamaSiswa;
    @BindView(R.id.edtUmur)
    EditText edtUmur;
    @BindView(R.id.radio_laki)
    RadioButton radioLaki;
    @BindView(R.id.radio_perempuan)
    RadioButton radioPerempuan;
    @BindView(R.id.edtAsal)
    EditText edtAsal;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.btnSimpan)
    Button btnSimpan;
    @BindView(R.id.radio_jenis_kelamin)
    RadioGroup radioJenisKelaminGroup;
    RadioButton radioJenisKelaminButton;

    private SiswaDatabase siswaDatabase;

    private int id_kelas;
    private String namaSiswa, asal, umur, jenis_kelamin, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_siswa);
        ButterKnife.bind(this);

        setTitle("Add Siswa");
        id_kelas = getIntent().getIntExtra(Constant.KEY_ID_KELAS,0);

        siswaDatabase = SiswaDatabase.createDatabase(this);
    }

    @OnClick(R.id.btnSimpan)
    public void onViewClicked() {
        getData();

        saveData();

        clearData();

        Toast.makeText(this, "Berhasil disimpan", Toast.LENGTH_SHORT).show();

        finish();
    }

    private void clearData() {
        edtAsal.setText("");
        edtEmail.setText("");
        edtNamaSiswa.setText("");
        edtUmur.setText("");
        radioJenisKelaminGroup.clearCheck();
    }

    private void saveData() {
        SiswaModel siswaModel = new SiswaModel();

        siswaModel.setId_kelas(id_kelas);
        siswaModel.setNama_siswa(namaSiswa);
        siswaModel.setAsal(asal);
        siswaModel.setUmur(umur);
        siswaModel.setEmail(email);
        siswaModel.setJenis_kelamin(jenis_kelamin);

        siswaDatabase.kelasDao().insertSiswa(siswaModel);
    }

    private void getData() {
        namaSiswa = edtNamaSiswa.getText().toString();
        asal = edtAsal.getText().toString();
        umur = edtUmur.getText().toString();
        email = edtEmail.getText().toString();
    }

    @OnClick({R.id.radio_laki, R.id.radio_perempuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radio_laki:
                jenis_kelamin = radioLaki.getText().toString();
                break;
            case R.id.radio_perempuan:
                jenis_kelamin = radioPerempuan.getText().toString();
                break;
        }
    }


}
