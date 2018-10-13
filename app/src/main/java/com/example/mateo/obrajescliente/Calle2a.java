package com.example.mateo.obrajescliente;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Calle2a extends AppCompatActivity implements QrDialogo.OnDialogListener{

    Button btnA1,btnA2,btnA3,btnM1,btnM2,btnM3,btnM4,btnM5,btnM6,btnM7,btnM8,btnM9;
    String mensaje = "Calle 2 entre Av. Hernando Siles y Av. Hector Ormachea estacionamiento de ";

    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    private DatabaseReference myRef;
    String sector="SA",parqueo="",calle="2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calle2a);
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
    public void btnM1(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"moto M°1";
        String titulo = "Reservar";
        parqueo="M1";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }
    public void btnM2(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"moto M°2";
        String titulo = "Reservar";
        parqueo="M2";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }
    public void btnM3(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"moto M°3";
        String titulo = "Reservar";
        parqueo="M3";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }
    public void btnM4(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"moto M°4";
        String titulo = "Reservar";
        parqueo="M4";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }
    public void btnM5(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"moto M°5";
        String titulo = "Reservar";
        parqueo="M5";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }
    public void btnM6(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"moto M°6";
        String titulo = "Reservar";
        parqueo="M6";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }
    public void btnM7(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"moto M°7";
        String titulo = "Reservar";
        parqueo="M7";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }
    public void btnM8(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"moto M°8";
        String titulo = "Reservar";
        parqueo="M8";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }
    public void btnM9(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;
        mensaje = mensaje +"moto M°9";
        String titulo = "Reservar";
        parqueo="M9";
        if(fragment==null){
            fragment = new QrDialogo();

            Bundle bundle = new Bundle();
            bundle.putString(QrDialogo.MESSAGE,mensaje);
            bundle.putString(QrDialogo.TAG,titulo);
            fragment.setArguments(bundle);
        }
        fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
    }

    @Override
    public void OnPositiveButtonClicked() {
        Query query = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child(parqueo);
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
                        myRef = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child(parqueo);
                        myRef.child("hora_reserva").setValue(Calendar.getInstance().getTime() + "");
                        myRef.child("hora_fin").setValue("0");
                        myRef.child("hora_inicio").setValue("0");
                        myRef.child("placa").setValue("0");
                        myRef.child("usuario").setValue(currentFirebaseUser.getUid());
                        myRef.child("estado").setValue("Reservado");
                        Toast.makeText(getApplicationContext(), "Reserva Exitosa", Toast.LENGTH_SHORT).show();
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
        Query query = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("A1"); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
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

        btnA2 = (Button) findViewById(R.id.btnA2);
        Query query2 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("A2"); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
        FirebaseListOptions<Estados> options2 = new FirebaseListOptions.Builder<Estados>() //Este parámetro es el que nutre al Adaptador de Firebase para colocar los valores del Query
                .setLayout(R.layout.fragment_incio)
                .setQuery(query2, Estados.class)
                .build();
        query2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnA2.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnA2.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnA2.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

        btnA3 = (Button) findViewById(R.id.btnA3);
        Query query3 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("A3"); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
        FirebaseListOptions<Estados> options3 = new FirebaseListOptions.Builder<Estados>() //Este parámetro es el que nutre al Adaptador de Firebase para colocar los valores del Query
                .setLayout(R.layout.fragment_incio)
                .setQuery(query3, Estados.class)
                .build();
        query3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnA3.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnA3.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnA3.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        btnM1 = (Button) findViewById(R.id.btnM1);
        Query queryM1 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("M1");
        FirebaseListOptions<Estados> optionsM1 = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.fragment_incio)
                .setQuery(queryM1, Estados.class)
                .build();
        queryM1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnM1.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnM1.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnM1.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });



        btnM2 = (Button) findViewById(R.id.btnM2);
        Query queryM2 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("M2");
        FirebaseListOptions<Estados> optionsM2 = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.fragment_incio)
                .setQuery(queryM2, Estados.class)
                .build();
        queryM2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnM2.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnM2.setBackgroundResource(R.drawable.boton_redondo_a);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        btnM3 = (Button) findViewById(R.id.btnM3);
        Query queryM3 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("M3");
        FirebaseListOptions<Estados> optionsM3 = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.fragment_incio)
                .setQuery(queryM3, Estados.class)
                .build();
        queryM3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnM3.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnM3.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnM3.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });



        btnM4 = (Button) findViewById(R.id.btnM4);
        Query queryM4 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("M4");
        FirebaseListOptions<Estados> optionsM4 = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.fragment_incio)
                .setQuery(queryM4, Estados.class)
                .build();
        queryM4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnM4.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnM4.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnM4.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        btnM5 = (Button) findViewById(R.id.btnM5);
        Query queryM5 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("M5");
        FirebaseListOptions<Estados> optionsM5 = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.fragment_incio)
                .setQuery(queryM5, Estados.class)
                .build();
        queryM5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnM5.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnM5.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnM5.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        btnM6 = (Button) findViewById(R.id.btnM6);
        Query queryM6 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("M6");
        FirebaseListOptions<Estados> optionsM6 = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.fragment_incio)
                .setQuery(queryM6, Estados.class)
                .build();
        queryM6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnM6.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnM6.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnM6.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        btnM7 = (Button) findViewById(R.id.btnM7);
        Query queryM7 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("M7");
        FirebaseListOptions<Estados> optionsM7 = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.fragment_incio)
                .setQuery(queryM7, Estados.class)
                .build();
        queryM7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnM7.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnM7.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnM7.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        btnM8 = (Button) findViewById(R.id.btnM8);
        Query queryM8 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("M8");
        FirebaseListOptions<Estados> optionsM8 = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.fragment_incio)
                .setQuery(queryM8, Estados.class)
                .build();
        queryM8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnM8.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnM8.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnM8.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        btnM9 = (Button) findViewById(R.id.btnM9);
        Query queryM9 = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child("M9");
        FirebaseListOptions<Estados> optionsM9 = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.fragment_incio)
                .setQuery(queryM9, Estados.class)
                .build();
        queryM9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(value.getEstado().equals("Libre")){
                    btnM9.setBackgroundResource(R.drawable.boton_redondo_v);
                }else if(value.getEstado().equals("Reservado")){
                    btnM9.setBackgroundResource(R.drawable.boton_redondo_a);
                }else if(value.getEstado().equals("Ocupado")){
                    btnM9.setBackgroundResource(R.drawable.boton_redondo_r);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

    }
}
