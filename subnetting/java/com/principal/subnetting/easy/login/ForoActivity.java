package com.principal.subnetting.easy.login;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.principal.subnetting.easy.AdapterMessage;
import com.principal.subnetting.easy.messages.MessageSend;
import com.principal.subnetting.easy.messages.ReceiveMessage;
import com.principal.subnetting.easy.messages.User;
import com.principal.subnetting.easy.R;

public class ForoActivity extends AppCompatActivity {

   // private CircleImageView pictureProfile;
    private TextView tvName;
    private RecyclerView rvMessage;
    private EditText edtMessage;
    private Button btSubmit,btSignOff;
    private AdapterMessage adapter;
   // private ImageButton btnSubmitPhoto;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private static final int PHOTO_SEND = 1;
    private static final int PHOTO_PERFIL = 2;
    private String chainPhotoProfile;

    private FirebaseAuth mAuth;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foro);

        //pictureProfile = findViewById(R.id.profilePicture);
        tvName = findViewById(R.id.tv_name);
        rvMessage =  findViewById(R.id.rvMessage);
        edtMessage =  findViewById(R.id.edt_message);
        btSubmit =  findViewById(R.id.bt_send);
        //btnSubmitPhoto = findViewById(R.id.btnSendPhoto);
        btSignOff = findViewById(R.id.bt_sign_off);
        chainPhotoProfile = "";

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("chatV3");//Sala de chat (name) version 2
        storage = FirebaseStorage.getInstance();
        mAuth = FirebaseAuth.getInstance();

        adapter = new AdapterMessage(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMessage.setLayoutManager(l);
        rvMessage.setAdapter(adapter);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.push().setValue(new MessageSend(edtMessage.getText().toString(),username,chainPhotoProfile,"1", ServerValue.TIMESTAMP));
                edtMessage.setText("");
            }
        });

        btSignOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                returnLogin();
            }
        });


        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ReceiveMessage m = dataSnapshot.getValue(ReceiveMessage.class);
                adapter.addMessage(m);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        verifyStoragePermissions(this);

    }

    private void setScrollbar(){
        rvMessage.scrollToPosition(adapter.getItemCount()-1);
    }

    public static boolean verifyStoragePermissions(Activity activity) {
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        int REQUEST_EXTERNAL_STORAGE = 1;
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
            return false;
        }else{
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PHOTO_SEND && resultCode == RESULT_OK){
            Uri u = data.getData();
            storageReference = storage.getReference("imagenes_chat");//imagenes_chat
            final StorageReference referencePhoto = storageReference.child(u.getLastPathSegment());
            referencePhoto.putFile(u).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri u = taskSnapshot.getDownloadUrl();
                    MessageSend m = new MessageSend(username+getString(R.string.send_photo),u.toString(),username,chainPhotoProfile,"2",ServerValue.TIMESTAMP);
                    databaseReference.push().setValue(m);
                }
            });
        }else if(requestCode == PHOTO_PERFIL && resultCode == RESULT_OK){
            Uri u = data.getData();
            storageReference = storage.getReference("foto_perfil");//imagenes_chat
            final StorageReference referencePhoto = storageReference.child(u.getLastPathSegment());
            referencePhoto.putFile(u).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri u = taskSnapshot.getDownloadUrl();
                    chainPhotoProfile = u.toString();
                    MessageSend m = new MessageSend(username+getString(R.string.update_photo),u.toString(),username,chainPhotoProfile,"2",ServerValue.TIMESTAMP);
                    databaseReference.push().setValue(m);
                    //Glide.with(ForoActivity.this).load(u.toString()).into(pictureProfile);
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            btSubmit.setEnabled(false);
            DatabaseReference reference = database.getReference("Usuarios/"+currentUser.getUid());
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    username = user.getName();
                    tvName.setText(username);
                    btSubmit.setEnabled(true);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }else{
            returnLogin();
        }
    }

    private void returnLogin(){
        startActivity(new Intent(ForoActivity.this, LoginActivity.class));
        finish();
    }
}



