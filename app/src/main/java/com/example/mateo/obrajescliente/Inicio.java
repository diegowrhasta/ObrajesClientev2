package com.example.mateo.obrajescliente;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Inicio extends Fragment {
    String nom="asd";
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    private FirebaseAuth firebaseAuth;
    FirebaseListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_incio, container, false);

        final TextView nombre = view.findViewById(R.id.tv1);
        final TextView puntos = view.findViewById(R.id.tv2);


        Query query = FirebaseDatabase.getInstance().getReference().child("Cliente").child(currentFirebaseUser.getUid()).child("Usuario"); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
        FirebaseListOptions<UserInformation> options = new FirebaseListOptions.Builder<UserInformation>() //Este parámetro es el que nutre al Adaptador de Firebase para colocar los valores del Query
                .setLayout(R.layout.fragment_incio)
                .setQuery(query, UserInformation.class)
                .build();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserInformation value = dataSnapshot.getValue(UserInformation.class);
                nombre.setText("Bienvenido "+value.getnombre());
                puntos.setText("Puntuacion:  "+value.getpuntos());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        return view;
    }

}
