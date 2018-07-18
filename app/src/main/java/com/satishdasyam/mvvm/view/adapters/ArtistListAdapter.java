package com.satishdasyam.mvvm.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.satishdasyam.mvvm.R;
import com.satishdasyam.mvvm.databinding.ArtistListCellBinding;
import com.satishdasyam.mvvm.model.Search;

import java.util.ArrayList;
import java.util.List;

public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.ViewHolder> {

    private List<Search.Artist> mArtistList;

    public ArtistListAdapter() {
        this.mArtistList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArtistListCellBinding cellBinding = DataBindingUtil.inflate(LayoutInflater.
                from(parent.getContext()), R.layout.artist_list_cell, parent, false);
        return new ViewHolder(cellBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cellBinding.setArtist(mArtistList.get(position));
    }

    @Override
    public int getItemCount() {
        return mArtistList == null ? 0 : mArtistList.size();
    }

    public void setArtistList(List<Search.Artist> userList) {
        this.mArtistList.clear();
        this.mArtistList.addAll(userList);
        this.notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ArtistListCellBinding cellBinding;

        public ViewHolder(ArtistListCellBinding cellBinding) {
            super(cellBinding.getRoot());
            this.cellBinding = cellBinding;
        }
    }
}
