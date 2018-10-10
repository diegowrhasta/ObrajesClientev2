package com.example.mateo.obrajescliente;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AgragarAutos extends Fragment implements View.OnClickListener  {

    private EditText et1,et2,et3,et4,et5;
    private DatabaseReference myRef;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;
    //Definimos las listas para mostrar datos

    private Button buttonReg,buttonVol,buttonEscan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_agregar_autos, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseAuth.getInstance().getCurrentUser();
        et1 = (EditText) view.findViewById(R.id.tv1);
        et2 = (EditText) view.findViewById(R.id.tv2);
        et3 = (EditText) view.findViewById(R.id.et3);
        et4= (EditText) view.findViewById(R.id.et4);
        et5 = (EditText) view.findViewById(R.id.et5);

        progressDialog = new ProgressDialog(getContext());





        buttonReg = (Button) view.findViewById(R.id.btnReg);
        buttonReg.setOnClickListener(new View.OnClickListener()        {
            @Override
            public void onClick(View v)
            {

                final String marca = et1.getText().toString().trim();
                final String modelo = et2.getText().toString().trim();
                final String color = et3.getText().toString().trim();
                final String placa  = et4.getText().toString().trim();
                final String cprv  = et5.getText().toString().trim();
                final String idUsuario=firebaseAuth.getUid();
                final String estado="Libre";

                myRef = FirebaseDatabase.getInstance().getReference("Cliente").child(idUsuario).child("auto");
                myRef.child(placa).child("marca").setValue(marca);
                myRef.child(placa).child("modelo").setValue(modelo);
                myRef.child(placa).child("color").setValue(color);
                myRef.child(placa).child("cprv").setValue(cprv);
                myRef.child(placa).child("estado").setValue(estado);

                Toast.makeText(getContext(), "Su auto fue agragado con exito", Toast.LENGTH_SHORT).show();

                progressDialog.setMessage("Registrando...");
                progressDialog.show();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor,new MisAutos());
                transaction.addToBackStack(null);
                transaction.commit();
                progressDialog.dismiss();

            }

        });


        buttonVol = (Button) view.findViewById(R.id.btnVol);
        buttonVol.setOnClickListener(new View.OnClickListener()        {
            @Override
            public void onClick(View v)
            {


                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor,new MisAutos());
                transaction.addToBackStack(null);
                transaction.commit();
            }

        });
        buttonEscan = (Button) view.findViewById(R.id.escanear);
        buttonEscan.setOnClickListener(new View.OnClickListener()        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getContext(), Qr.class));
                getActivity().finish();
            }

        });
        return view;
    }

    @Override
    public void onClick(View view) {
    }
}
