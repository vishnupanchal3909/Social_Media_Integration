package com.vishnu.socialmediaintegration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.nio.charset.StandardCharsets;

public class Loginfacebook extends AppCompatActivity {

    ImageView userimage;
    TextView name,email;
    Button logout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginfacebook);


        name=findViewById(R.id.facebookname);
        email=findViewById(R.id.facebookemail);
        logout=findViewById(R.id.facebooklogout);
        userimage=findViewById(R.id.viewuserimageinimageviewfacebook);
        mAuth=FirebaseAuth.getInstance();
        final FirebaseUser muser=mAuth.getCurrentUser();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
                LoginManager.getInstance().logOut();
                finish();
            }
        });
        if(muser != null)
        {
            name.setText(muser.getDisplayName());
            email.setText(muser.getEmail());
            Picasso.with(Loginfacebook.this).load(muser.getPhotoUrl()).into(userimage);
        }

    }

}