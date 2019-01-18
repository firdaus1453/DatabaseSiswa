package me.firdaus1453.databasesiswa.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import me.firdaus1453.databasesiswa.model.KelasModel;

/**
 * Created by firdaus1453 on 1/17/2019.
 */
@Dao
public interface KelasDao {

    // Mengambil data
    @Query("SELECT * FROM KELAS ORDER BY nama_kelas DESC")
    List<KelasModel> select();

    // Memasukkan data
    @Insert
    void insert(List<KelasModel> kelasModels);

    // Menghapus data
    @Delete
    void delete(KelasModel kelasModel);

    // Mengupdate data
    @Update
    void update(KelasModel kelasModel);
}
