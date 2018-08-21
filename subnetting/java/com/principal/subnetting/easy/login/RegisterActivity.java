package com.principal.subnetting.easy.login;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.principal.subnetting.easy.messages.User;
import com.principal.subnetting.easy.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtName,edtEmail,edtPassword,edtRepeatedPass;
    private Button btRegister;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edt_Register_Name);
        edtEmail = findViewById(R.id.edt_Register_Email);
        edtPassword =  findViewById(R.id.edt_Register_Password);
        edtRepeatedPass =  findViewById(R.id.edt_Register_Pass_repeat);
        btRegister =  findViewById(R.id.bt_Register);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();



        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edtEmail.getText().toString();
                final String name = edtName.getText().toString();
                if(isValidEmail(email) && passwordRegister() && validateName(name)){
                    String password = edtPassword.getText().toString();
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(RegisterActivity.this, R.string.register_ok_activity, Toast.LENGTH_SHORT).show();
                                        //finish();
                                        User user = new User();
                                        user.setEmail(email);
                                        user.setName(name);
                                        FirebaseUser currentUser = mAuth.getCurrentUser();
                                        DatabaseReference reference = database.getReference("Usuarios/"+currentUser.getUid());
                                        reference.setValue(user);
                                        finish();



                                        // Intent intent = new Intent(RegistroActivity.this, LoginActivity.class );

                                        // startActivity(intent);





                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(RegisterActivity.this, R.string.error_register, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }else{
                    Toast.makeText(RegisterActivity.this, R.string.missing_fields, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public boolean passwordRegister(){
        String validatePassword, repeatedPassword;
        validatePassword = edtPassword.getText().toString();
        repeatedPassword = edtRepeatedPass.getText().toString();
        if(validatePassword.equals(repeatedPassword)){
            if(validatePassword.length()>=6 && validatePassword.length()<=16){
                return true;
            }else return false;
        }else return false;
    }

    public boolean validateName(String name){
        return !name.isEmpty();
    }

}



