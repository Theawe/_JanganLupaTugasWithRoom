package id.java.janganlupatugas;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import id.java.janganlupatugas.activity.DetailActivity;

public class TugasListAdapter extends ListAdapter<Tugas,TugasViewHolder> {
    Context context;
    public TugasListAdapter(@NonNull DiffUtil.ItemCallback<Tugas> diffCallback,Context ct){
        super(diffCallback);
        context = ct;
    }

    @Override
    public TugasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TugasViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TugasViewHolder holder, int position) {
        Tugas current = getItem(position);
        holder.bind(current.getNama_tugas(),current.getDeskripsi(),current.getDeadline());
                holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("tugas",current.getNama_tugas());
                intent.putExtra("catatan",current.getDeskripsi());
                intent.putExtra("deadline",current.getDeadline());
                context.startActivity(intent);
            }
        });
    }

    static public class TugasDiff extends DiffUtil.ItemCallback<Tugas> {

        @Override
        public boolean areItemsTheSame(@NonNull Tugas oldItem, @NonNull Tugas newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tugas oldItem, @NonNull Tugas newItem) {
            boolean same;
            same = oldItem.getNama_tugas().equals(newItem.getNama_tugas()) && oldItem.getDeskripsi().equals(newItem.getDeskripsi()) ;
            return same;
        }
    }
}
