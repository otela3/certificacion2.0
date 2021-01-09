package com.example.certificacion20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.certificacion20.databinding.ItemNovaBinding;
import com.example.certificacion20.model.Nova;

import java.util.ArrayList;

public class NovaAdapter extends RecyclerView.Adapter<NovaAdapter.NovaViewHolder> {
    private Context mContext;
    private ArrayList<Nova> mList;
    private ItemNovaBinding binding;

    public NovaAdapter(Context mContext, ArrayList<Nova> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }
    @NonNull
    @Override
    public NovaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = ItemNovaBinding.inflate(inflater,parent,false);
        return new NovaViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull NovaAdapter.NovaViewHolder holder, int position) {
        holder.itemBinding.novaName.setText(mList.get(position).getName());
        Glide.with(mContext).load(mList.get(position).getImage())
                .into(holder.itemBinding.imageNova);
    }

    @Override
    public int getItemCount() {
        return mList == null? 0 : mList.size();
    }

    public class NovaViewHolder extends RecyclerView.ViewHolder {
        private ItemNovaBinding itemBinding;

        public NovaViewHolder(ItemNovaBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
    public  void updateList(ArrayList<Nova> updatedList){
        mList = updatedList;
        notifyDataSetChanged();
    }
    public  Nova getNovaAt(int position){
        return mList.get(position);
    }
}
