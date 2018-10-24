package com.example.mateo.obrajescliente;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class QrDialogo extends DialogFragment {
    public static final String TAG="Titulo";
    public static final String MESSAGE="MensajeDelDialogo";

    public interface OnDialogListener{
        void OnPositiveButtonClicked();
        void OnNegativeButtonClicked();
    }

    private String  mensaje,titulo;

    private OnDialogListener onDialogListener;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        onDialogListener= (OnDialogListener)getActivity();
        mensaje=getArguments().getString(MESSAGE,"algo esta mal");
        titulo=getArguments().getString(TAG,"algo esta mal T");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());


        builder.setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton("Si, Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onDialogListener.OnPositiveButtonClicked();
                        startActivity(new Intent(getContext(), MisAutos.class));
                    }
                })
                .setNegativeButton("No, Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onDialogListener.OnNegativeButtonClicked();
                        startActivity(new Intent(getContext(), Inicio.class));
                    }
                });
        return builder.create();
    }
}
