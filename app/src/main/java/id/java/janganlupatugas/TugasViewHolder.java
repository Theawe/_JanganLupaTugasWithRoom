package id.java.janganlupatugas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TugasViewHolder extends RecyclerView.ViewHolder {

    private final TextView NamaItemView;
    private final TextView Deskripsi;
    private final TextView Deadline;
    ConstraintLayout mainLayout;

    private TugasViewHolder(View itemView){
        super(itemView);
        NamaItemView = itemView.findViewById(R.id.myText1);
        Deskripsi = itemView.findViewById(R.id.myText2);
        Deadline = itemView.findViewById(R.id.myText3);
        mainLayout = itemView.findViewById(R.id.mainLayout);
    }

    public void bind(String nama,String deskripsi,String deadline){
        NamaItemView.setText(nama);
        Deskripsi.setText(deskripsi);
        Deadline.setText(deadline);
    }

    static TugasViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_row,parent,false);
        return new TugasViewHolder(view);
    }

}
