package me.firdaus1453.databasesiswa.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import me.firdaus1453.databasesiswa.model.KelasModel;
import me.firdaus1453.databasesiswa.model.SiswaModel;

/**
 * Created by firdaus1453 on 1/17/2019.
 */
@Database(entities = {KelasModel.class,SiswaModel.class}, version = 2)
public abstract class SiswaDatabase extends RoomDatabase {

    public abstract KelasDao kelasDao();

    private static SiswaDatabase INSTANCE;

    // Membuat method return untuk membuat database
    public static SiswaDatabase createDatabase(Context context){
        synchronized (SiswaDatabase.class){
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, SiswaDatabase.class, "db_siswa").allowMainThreadQueries().fallbackToDestructiveMigration().build();
            }
        }
        return INSTANCE;
    }
}
