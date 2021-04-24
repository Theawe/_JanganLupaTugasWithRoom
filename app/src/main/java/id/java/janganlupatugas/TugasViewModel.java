package id.java.janganlupatugas;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TugasViewModel extends AndroidViewModel {

    private TugasRepository mRepository;

    private final LiveData<List<Tugas>> mAllTugas;

    public TugasViewModel(Application application){
        super(application);
        mRepository = new TugasRepository(application);
        mAllTugas = mRepository.getAllTugas();
    }

    public LiveData<List<Tugas>> getAllTugas(){return mAllTugas;}

    public void insert(Tugas tugas){
        mRepository.insert(tugas);
    }



}
