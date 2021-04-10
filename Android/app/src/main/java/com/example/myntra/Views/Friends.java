package com.example.myntra.Views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.Adapters.UserAdapter;
import com.example.myntra.Model.Constants;
import com.example.myntra.Model.ImageInterface;
import com.example.myntra.Model.User;
import com.example.myntra.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class Friends extends AppCompatActivity{

    RecyclerView recyclerView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "Friends";
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 22;

    // instance for firebase storage and StorageReference
    FirebaseStorage storage;
    StorageReference storageReference;
//   ArrayList<String> friendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

//        User user = new User(Constants.NAME, Constants.EMAIL,Constants.CartList, Constants.WishList);
//        DocumentReference newUser = db.collection("Users").document();
//        newUser.set(user);

        recyclerView = findViewById(R.id.recycler_friend);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter(Constants.friendList,this);
        recyclerView.setAdapter(userAdapter);

    }


//    public void SelectImage()
//    {
//        storage = FirebaseStorage.getInstance();
//        storageReference = storage.getReference();
//
//        // Defining Implicit Intent to mobile gallery
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(
//                Intent.createChooser(
//                        intent,
//                        "Select Image"),
//                PICK_IMAGE_REQUEST);
//    }
//    // Override onActivityResult method
//    @Override
//    public void onActivityResult(int requestCode,
//                                    int resultCode,
//                                    Intent data)
//    {
//
//        super.onActivityResult(requestCode,
//                resultCode,
//                data);
//
//        // checking request code and result code
//        // if request code is PICK_IMAGE_REQUEST and
//        // resultCode is RESULT_OK
//        // then set image in the image view
//        if (requestCode == PICK_IMAGE_REQUEST
//                && resultCode == RESULT_OK
//                && data != null
//                && data.getData() != null) {
//
//            // Get the Uri of data
//            filePath = data.getData();
//            try {
//
//                // Setting image on image view using Bitmap
//                Bitmap bitmap = MediaStore
//                        .Images
//                        .Media
//                        .getBitmap(
//                                getContentResolver(),
//                                filePath);
//                //imageView.setImageBitmap(bitmap);
//            }
//
//            catch (IOException e) {
//                // Log the exception
//                e.printStackTrace();
//            }
//
//            uploadImage();
//        }
//    }
//
//    // UploadImage method
//    public void uploadImage()
//    {
//        if (filePath != null) {
//
//            // Defining the child of storageReference
//            StorageReference ref
//                    = storageReference
//                    .child(
//                            "images/"
//                                    + UUID.randomUUID().toString());
//
//            // adding listeners on upload
//            // or failure of image
//            ref.putFile(filePath)
//                    .addOnSuccessListener(
//                            taskSnapshot -> Toast
//                                    .makeText(Friends.this,
//                                            "Image Uploaded!!",
//                                            Toast.LENGTH_SHORT)
//                                    .show())
//
//                    .addOnFailureListener(e -> Toast
//                            .makeText(Friends.this,
//                                    "Failed " + e.getMessage(),
//                                    Toast.LENGTH_SHORT)
//                            .show());
//        }
//    }
}