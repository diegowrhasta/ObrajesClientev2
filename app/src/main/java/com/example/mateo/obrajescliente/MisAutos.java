package com.example.mateo.obrajescliente;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MisAutos extends Fragment{
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    FirebaseAuth firebaseAuth;
    ListView lv1;
    FirebaseListAdapter adapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private ImageButton buttonAdd,buttonEd;


    int[] datosImg={R.mipmap.auto};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mis_autos, container, false);

        buttonAdd = (ImageButton) view.findViewById(R.id.btnAddAuto);
        buttonAdd.setOnClickListener(new View.OnClickListener()        {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor,new AgragarAutos());
                transaction.addToBackStack(null);
                transaction.commit();
            }

        });
        buttonEd = (ImageButton) view.findViewById(R.id.btnEdAuto);
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);


        lv1 = (ListView) view.findViewById(R.id.lv1);
        Query query = FirebaseDatabase.getInstance().getReference().child("Cliente").child(currentFirebaseUser.getUid()).child("auto"); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
        FirebaseListOptions<Auto> options = new FirebaseListOptions.Builder<Auto>() //Este parámetro es el que nutre al Adaptador de Firebase para colocar los valores del Query
                .setLayout(R.layout.elemento_lista)
                .setQuery(query, Auto.class)
                .build();
        adapter = new FirebaseListAdapter(options) { //El adaptador de Firebase para aplicarlo al item personalizado que hicimos: encargado.xml para los items del el listview en ListaEncargados
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) { //Esta funcion comienza a llenar los cambos del list view
                TextView datos = v.findViewById(R.id.tv1); /*Primero asigna los objectos con sus identificadores de encargado.xml */
                TextView estado = v.findViewById(R.id.tv2);

                Auto enc = (Auto) model; //El modelo es el cual se obtiene desde Firebase; del objeto: Con sus atributos, acá es donde entra la parte de case sensitive, si los nombres
                // de la clase local y los nombres en firebase difieren surgirá un error.
                datos.setText(""+enc.getmodelo().toString()+", " + enc.getcolor().toString()); /*Todos los valores los estamos manejando como Strings para facilitar el uso */
                estado.setText("" + enc.getestado().toString()); /*Todos los valores los estamos manejando como Strings para facilitar el uso */
            }
        };
        lv1.setAdapter(adapter); /*Una vez todos los valores se obtienen se lo aplican al listview que tenemos en la actividad */

        adapter.startListening();
    }
}
