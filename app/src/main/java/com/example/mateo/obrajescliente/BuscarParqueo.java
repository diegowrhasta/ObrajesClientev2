package com.example.mateo.obrajescliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BuscarParqueo extends Fragment {
    private Button btn2a,btn2b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_buscar_parqueo, container, false);


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


        return view;
    }

}
