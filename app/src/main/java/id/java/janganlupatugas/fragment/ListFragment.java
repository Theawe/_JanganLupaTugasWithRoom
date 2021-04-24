package id.java.janganlupatugas.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.java.janganlupatugas.MyAdapter;
import id.java.janganlupatugas.R;
import id.java.janganlupatugas.Tugas;
import id.java.janganlupatugas.TugasListAdapter;
import id.java.janganlupatugas.TugasViewModel;
import id.java.janganlupatugas.activity.AddTugasActivity;


public class ListFragment extends Fragment {

    private TugasViewModel mTugasViewModel;
    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        final TugasListAdapter adapter = new TugasListAdapter(new TugasListAdapter.TugasDiff(),view.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        mTugasViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(TugasViewModel.class);
        mTugasViewModel.getAllTugas().observe(getViewLifecycleOwner(),tugases -> {
            adapter.submitList(tugases);
        });

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddTugasActivity.class);
//                ListFragment listFragment = new ListFragment();
//                listFragment.startActivityForResult(intent,1);
//                getParentFragment().startActivityForResult(intent,1);
//                startActivity(intent);
                startActivityForResult(intent,1);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == -1){
            Tugas tugas = new Tugas(data.getStringExtra("tugas"),data.getStringExtra("catatan"),data.getStringExtra("deadline"));
            mTugasViewModel.insert(tugas);
            Toast.makeText(
                    getActivity().getApplicationContext(),
                    "MASUK PAK EKO",
                    Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(
                    getActivity().getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}