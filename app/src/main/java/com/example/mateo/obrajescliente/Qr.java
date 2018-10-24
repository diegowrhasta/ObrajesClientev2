package com.example.mateo.obrajescliente;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Qr extends AppCompatActivity implements ZXingScannerView.ResultHandler, QrDialogo.OnDialogListener {
    private ZXingScannerView mScannerView;
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

    private Result result;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }
    @Override
    public void onPause(){
        super.onPause();
        mScannerView.startCamera();
    }
    @Override
    public void handleResult(Result result) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment)fragmentManager.findFragmentByTag(QrDialogo.TAG) ;


        String string = result.getText()+"";
        String[] parts = string.split("/");
        Log.e("Item",""+parts[0]);
        if(parts.length>1)
        {
            String part1 = parts[0];
            String part2 = parts[1];
            String part3 = parts[2];
            String part4 = parts[3];
            String part5 = parts[4];
            String mensaje = "Marca: "+part1+"\nModelo: "+part2+"\nColor: "+part3+"\nPlaca: "+part4+"\nCRPVA: "+part5;

            myRef = FirebaseDatabase.getInstance().getReference("Cliente").child(currentFirebaseUser.getUid()).child("auto");
            myRef.child(part4).child("marca").setValue(part1);
            myRef.child(part4).child("modelo").setValue(part2);
            myRef.child(part4).child("color").setValue(part3);
            myRef.child(part4).child("cprv").setValue(part5);
            myRef.child(part4).child("estado").setValue("libre");

            String titulo = "Es correcta esta informacion?";
            if(fragment==null){
                fragment = new QrDialogo();

                Bundle bundle = new Bundle();
                bundle.putString(QrDialogo.MESSAGE,mensaje);
                bundle.putString(QrDialogo.TAG,titulo);

                fragment.setArguments(bundle);
            }

            fragment.show(getSupportFragmentManager(),QrDialogo.TAG);
        }
        else
        {
            Toast.makeText(this, "Código no válido", Toast.LENGTH_SHORT).show();
            mScannerView.setResultHandler(this);
            mScannerView.startCamera();
        }

    }

    @Override
    public void OnPositiveButtonClicked() {
        startActivity(new Intent(getApplicationContext(), Bienvenido.class));
        Toast.makeText(this,"Agregado Correctamente",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnNegativeButtonClicked() {
        startActivity(new Intent(getApplicationContext(), Bienvenido.class));
        Toast.makeText(this,"No se pudo Agregar",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), Bienvenido.class));
        Toast.makeText(this,"No se pudo Agregar",Toast.LENGTH_SHORT).show();
    }
}
