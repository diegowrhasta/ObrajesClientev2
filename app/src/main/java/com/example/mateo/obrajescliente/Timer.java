package com.example.mateo.obrajescliente;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

public class Timer extends AppCompatActivity {
    private int i=0;
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    private DatabaseReference myRef;
    private String sector,parqueo;
    private static final int idUnico = 2424;
    NotificationCompat.Builder notificacion;
    /*TIMER*/
    private TextView timer,titulo;
    private Button cancelar;
    private CountDownTimer countDownTimer;
    /*--------------------------*/

    /*Notificacion*/
    private String NOTIFICATION_CHANNEL_ID;
    private long tiemporestante = 600000;
    private boolean tiempocorriendo;
    private NotificationManager notificationManager;
    private NotificationCompat.Builder notificationBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        timer = findViewById(R.id.timer);
        cancelar = findViewById(R.id.cancelar);
        titulo = findViewById(R.id.titulo);

        Bundle datos = this.getIntent().getExtras();
        sector = datos.getString("sector");
        parqueo = datos.getString("parqueo");
        String titulotxt = datos.getString("titulo");
        titulo.setText(titulotxt);
        /*NOTIFIACION*/

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_HIGH);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        notificationBuilder.setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("Su reserva termina");


        iniciar(); /*esto inicia el timer, osea es lo que primero se deberia ejecutar*/
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tiempocorriendo) {
                    cancellreserva();
                    detener();
                }
            }
        });
    }


    public void cancellreserva(){
        Query query = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child(sector).child(parqueo);
        FirebaseListOptions<Estados> options = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.activity_timer)
                .setQuery(query, Estados.class)
                .build();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(parqueo!="" && sector!="") {
                    if (value.getEstado().equals("Ocupado")) {
                        Toast.makeText(getApplicationContext(), "Espacio Ocupado", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        myRef = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child(sector).child(parqueo);
                        myRef.child("hora_reserva").setValue("0");
                        myRef.child("hora_fin").setValue("0");
                        myRef.child("hora_inicio").setValue("0");
                        myRef.child("placa").setValue("0");
                        myRef.child("usuario").setValue(currentFirebaseUser.getUid());
                        myRef.child("estado").setValue("Libre");

                        Toast.makeText(getApplicationContext(), "Espacio Liberado", Toast.LENGTH_SHORT).show();
                        sector = "";
                        parqueo = "";
                        finish();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }
    public void iniciar() {
        countDownTimer = new CountDownTimer(tiemporestante, 1000) {
            @Override
            public void onTick(long l) {
                tiemporestante = l;
                update();

            }

            @Override
            public void onFinish() {
                cancellreserva();
            }
        }.start();
        tiempocorriendo = true;
    }

    public void detener() {
        cancellreserva();

        countDownTimer.cancel();
    }

    public void update() {
        /*Actualiza el Texto mostrado en pantalla*/
        int minutos = (int) tiemporestante / 60000;
        int segundos = (int) tiemporestante % 60000 / 1000;
        check();


        if (((5 == minutos || minutos == 3 || minutos==1) && segundos == 0) || (minutos==9 && segundos == 45)) {
            notificationBuilder.setTicker("Quedan "+minutos+" Minutos").setContentText("Le quedan "+minutos+" minutos en su reserva");
            //     .setPriority(Notification.PRIORITY_MAX)

            notificationManager.notify(/*notification id*/1, notificationBuilder.build());
        }
        if(minutos==0 && segundos==0){
            notificationBuilder.setTicker("Su reserva termino").setContentText("La reserva a terminado");
            //     .setPriority(Notification.PRIORITY_MAX)

            notificationManager.notify(/*notification id*/1, notificationBuilder.build());
        }
        String timelefttext;
        timelefttext = "" + minutos;
        timelefttext += ":";
        if (segundos < 10) timelefttext += "0";
        timelefttext += segundos;

        timer.setText(timelefttext);
    }
    public  void  check(){

        Query query = FirebaseDatabase.getInstance().getReference("Cliente").child("Parqueo").child("Calle_2").child(sector).child(parqueo);
        FirebaseListOptions<Estados> options = new FirebaseListOptions.Builder<Estados>()
                .setLayout(R.layout.activity_timer)
                .setQuery(query, Estados.class)
                .build();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Estados value = dataSnapshot.getValue(Estados.class);
                if(parqueo!="" && sector!="") {
                    if (value.getEstado().equals("Ocupado")&& i==0) {
                        i++;
                        notificationBuilder.setTicker("Su espacio reservado fue ocupado").setContentText("La reserva a terminado").setContentTitle("El espacio que resrvo fue Ocupado");

                        notificationManager.notify(/*notification id*/1, notificationBuilder.build());
                        countDownTimer.cancel();
                        finish();

                    }
                    else{
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

    }

}
