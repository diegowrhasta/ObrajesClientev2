package com.example.mateo.obrajescliente;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroUser extends AppCompatActivity {
    private EditText et1,et2,et3,et4,et5,et6;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_user);
        et1 = (EditText) findViewById(R.id.tv1);
        et2 = (EditText) findViewById(R.id.tv2);
        et3 = (EditText) findViewById(R.id.et3);
        et4= (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);

        databaseCliente = FirebaseDatabase.getInstance().getReference("Cliente");

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
    }
    public void AddUser(View view){

        //getting email and password from edit texts
        final String nombre = et1.getText().toString().trim();
        final String apellido = et2.getText().toString().trim();
        final String email = et3.getText().toString().trim();
        final String password  = et4.getText().toString().trim();
        final String password2  = et5.getText().toString().trim();
        final String ci  = et6.getText().toString().trim();

        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(nombre)||TextUtils.isEmpty(apellido)||TextUtils.isEmpty(password)||TextUtils.isEmpty(password2)||TextUtils.isEmpty(ci)){
            Toast.makeText(this,"Ingrese todos los datos",Toast.LENGTH_LONG).show();
            return;
        }
        //verfiicar contraseñas iguales
        if(password.equals(password2)){
            progressDialog.setMessage("Registrando...");
            progressDialog.show();


            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                finish();
                                startActivity(new Intent(getApplicationContext(), Login.class));

                                //objeto que indica los datos del usuario
                                String id = databaseCliente.push().getKey();
                                UserInformation userInformation = new UserInformation(nombre,apellido,ci,email,0);

                                //se ingresan los datos del usuario en la base
                                databaseCliente.child(firebaseAuth.getUid()).child("Usuario").setValue(userInformation);

                                databaseCliente.child(firebaseAuth.getUid()).child("Usuario").child("tipo").setValue("UsuarioNormal");


                            }else{

                                Toast.makeText(RegistroUser.this,"Ya existe una cuenta con ese correo o la contraseña es muy corta",Toast.LENGTH_LONG).show();
                            }
                            progressDialog.dismiss();
                        }
                    });
        }else{
            Toast.makeText(this,"Las Contraseñas Son Diferentes",Toast.LENGTH_LONG).show();

        }
    }
}
