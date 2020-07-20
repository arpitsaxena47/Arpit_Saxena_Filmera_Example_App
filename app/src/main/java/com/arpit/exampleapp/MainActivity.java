package com.arpit.exampleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference reference;
//    FirebaseFirestore db = FirebaseFirestore.getInstance();
     RecyclerView fetchProductRV;
     ArrayList<productAdapter> imageList ;
     ImageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchProductRV = findViewById(R.id.fetchProductRV);
        fetchProductRV.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        imageList = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference().child("Animals");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    productAdapter p = dataSnapshot.getValue(productAdapter.class);
                    imageList.add(p);
                }
                adapter = new ImageAdapter(imageList,MainActivity.this);
                fetchProductRV.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });



//
//        db.collection("Animals")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                               imageList.add(new productAdapter(document.get("Title").toString(),document.get("picture").toString(),
//                                       Integer.parseInt(document.getId())));
//                            }
//                        } else {
//                           Toast.makeText(MainActivity.this,"Retrieval is unsuccessful!!",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//        ImageAdapter imageAdapter =  ImageAdapter(MainActivity.this,imageList);
//        fetchProductRV.setLayoutManager(new LinearLayoutManager(this));
//        fetchProductRV.setAdapter(new ImageAdapter(MainActivity.this,imageList));
//        txtTitle.setText(imageList.get(0).getTitle());
//
//
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//
//
    }
}

