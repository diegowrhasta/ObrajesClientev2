package com.example.mateo.obrajescliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Calle2b extends AppCompatActivity implements QrDialogo.OnDialogListener{

    Button btnA1,btnA2,btnA3,btnA4,btnA5,btnA6,btnA7,btnA8,btnA9;
    String mensaje = "Calle 2 entre Av. Hernando Siles y Av. 14 de Septiembre estacionamiento  de ";

    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    private DatabaseReference myRef;
    String sector="B",parqueo="",calle="2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calle2b);
        getSupportActionBar().hide();
        estados();
    }
    public void btnA1(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"auto N°1";
        String titulo = "Reservar";
        parqueo="A1";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }
    public void btnA2(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"auto N°2";
        String titulo = "Reservar";
        parqueo="A2";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }
    public void btnA3(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"auto N°3";
        String titulo = "Reservar";
        parqueo="A3";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }

    //COPIAR DEMAS BOTONES

    @Override
    public void OnPositiveButtonClicked() {
        Query query = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_B").child(parqueo);
        FirebaseListOptions<Estados> options = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.fragment_incio)
                .setQuery(query, Estados.class)
                .build();
            query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(parqueo!="") {
                    if (value.getEstado().equals("Ocupado") || value.getEstado().equals("Reservado")) {
                        Toast.makeText(getApplicationContext(), "Espacio no disponible", Toast.LENGTH_SHORT).show();
                    } else {
                        myRef = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_B").child(parqueo);
                        myRef.child("hora_reserva").setValue(Calendar.getInstance().getTime() + "");
                        myRef.child("hora_fin").setValue("0");
                        myRef.child("hora_inicio").setValue("0");
                        myRef.child("placa").setValue("0");
                        myRef.child("usuario").setValue(currentFirebaseUser.getUid());
                        myRef.child("estado").setValue("Reservado");
                        Toast.makeText(getApplicationContext(), "Reserva Exitosa", Toast.LENGTH_SHORT).show();
                        String sector="Sector_B";
                        startActivity(new Intent(getApplicationContext(), Timer.class));
                        parqueo = "";

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }

    @Override
    public void OnNegativeButtonClicked() {
        Toast.makeText(this,"No se pudo realizar la reserva",Toast.LENGTH_SHORT).show();
    }
    public void estados(){
        btnA1 = (Button) findViewById(R.id.btnA1);
        Query query = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_"+calle).child("Sector_"+sector).child("A1"); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
        FirebaseListOptions<Estados> options = new FirebaseListOptions.Builder<Estados>() //Este parámetro es el que nutre al Adaptador de Firebase para colocar los valores del Query
                .setLayout(R.layout.fragment_incio)
                .setQuery(query, Estados.class)
                .build();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnA1.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnA1.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnA1.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

        //COPIAR DEMAS ESADOS

    }
}
