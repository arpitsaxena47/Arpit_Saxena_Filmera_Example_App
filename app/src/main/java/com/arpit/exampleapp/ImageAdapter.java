package com.arpit.exampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

private  ArrayList<productAdapter>  imageList ;
private Context context;
//private StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();

    public ImageAdapter(ArrayList<productAdapter> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_fetch_images,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txtViewTitle.setText(imageList.get(position).getTitle());
        Picasso.get().load(imageList.get(position).getPicture()+"").into(holder.imgView);

    }


    @Override
    public int getItemCount() {
        return imageList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder  {

        public  TextView txtViewTitle;
        public  ImageView imgView;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.txtTitle);
            imgView = (ImageView) itemLayoutView.findViewById(R.id.imgPic);
        }
    }

}
