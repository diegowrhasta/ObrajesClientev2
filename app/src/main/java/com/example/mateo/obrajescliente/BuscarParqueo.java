package com.example.mateo.obrajescliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class BuscarParqueo extends Fragment {
    private Button btn2a,btn2b;
    private FirebaseAuth firebaseAuth;
    int c=0,c1=0;
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_buscar_parqueo, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        btn2a = (Button) view.findViewById(R.id.btn2a);
        btn2a.setOnClickListener(new View.OnClickListener()        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getContext(), Calle2a.class));
            }

        });

        btn2b = (Button) view.findViewById(R.id.btn2b);
        btn2b.setOnClickListener(new View.OnClickListener()        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getContext(), Calle2b.class));
            }

        });

//Creas tu adapter y recycler y agregamos el listener
        Query query = FirebaseDatabase.getInstance().getReference().child("Cliente").child("Parqueo").child("Calle_2").child("Sector_A"); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
        FirebaseListOptions<Parqueo> options = new FirebaseListOptions.Builder<Parqueo>() //Este parámetro es el que nutre al Adaptador de Firebase para colocar los valores del Query
                .setLayout(R.layout.fragment_buscar_parqueo)
                .setQuery(query, Parqueo.class)
                .build();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                Parqueo value = snapshot.getValue(Parqueo.class);
                if(value.getEstado().equals("Ocupado")||value.getEstado().equals("Reservado")){
                    c++;
                }
                   else if(value.getEstado().equals("Libre")){
                        c1++;
                    }
                }
                if(c>=10){
                    btn2a.setBackgroundResource(R.drawable.rojo);
                }
                else if(c>=5){
                    btn2a.setBackgroundResource(R.drawable.amarillo);
                }
               else if(c>=0){
                    btn2a.setBackgroundResource(R.drawable.verde);
                }
                c=0;


            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }

        });
        return view;
    }

}
