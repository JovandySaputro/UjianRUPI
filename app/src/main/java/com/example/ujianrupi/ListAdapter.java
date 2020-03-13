package com.example.ujianrupi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

@SuppressLint("SetTextI18n")
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    Context mContext;
    private ArrayList<ListInfo> listInfos;


    public ListAdapter(Context mContext, ArrayList<ListInfo> listInfos) {
        super();
        this.mContext = mContext;
        this.listInfos = listInfos;
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int i) {
        holder.tvNumber.setText("Id : " + listInfos.get(i).getNumberInvoice());
        holder.tvName.setText("Nama : " + listInfos.get(i).getNameOrder());
        holder.tvDate.setText("Tanggal : " + listInfos.get(i).getDateOrder());
        holder.tvTime.setText(listInfos.get(i).getTimeRespon() + " Jam");
    }

    @Override
    public int getItemCount() {
        return listInfos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        private TextView tvNumber, tvName, tvDate, tvTime;
        public ViewHolder(View itemView) {
            super(itemView);
//            imgproduk = itemView.findViewById(R.id.imageViewHeader);
            tvNumber = itemView.findViewById(R.id.tvNoInvoice);
            tvName = itemView.findViewById(R.id.tvNameCus);
            tvDate = itemView.findViewById(R.id.tvTglOrder);
            tvTime = itemView.findViewById(R.id.tvTimeRespon);

        }

    }
}
