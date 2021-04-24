package id.java.janganlupatugas;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tugas")
public class Tugas {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nama_tugas")
    private String nama_tugas;
    @NonNull
    @ColumnInfo(name = "deskripsi")
    private String deskripsi;
    @NonNull
    @ColumnInfo(name = "deadline")
    private String deadline;
    public Tugas(@NonNull String nama_tugas,String deskripsi,String deadline){
        this.nama_tugas = nama_tugas;
        this.deskripsi = deskripsi;
        this.deadline = deadline;
    }
    public String getNama_tugas(){return nama_tugas;}
    public String getDeskripsi(){return deskripsi;}
    public String getDeadline(){return deadline;}
}
