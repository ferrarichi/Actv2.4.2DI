package com.example.juanjo.actv242di;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private boolean fondo = false;
    private boolean fondo_letras = false;

    private RelativeLayout relative;
    private Button boton_fondo;
    private Button boton_letra;
    private CheckBox check_mostrar;
    private TextView texto_oculto;
    private TextView text_largo;
    private RatingBar estrellas;
    private TextView text_numeros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relative = (RelativeLayout) findViewById(R.id.relative1);
        boton_fondo = (Button) findViewById(R.id.button_fondoRojo);
        boton_letra = (Button) findViewById(R.id.button_letrasNegras);
        check_mostrar = (CheckBox) findViewById(R.id.checkBox_mostrar);
        texto_oculto = (TextView) findViewById(R.id.textOculto);
        text_largo = (TextView) findViewById(R.id.textView_clickLargo);
        estrellas = (RatingBar) findViewById(R.id.ratingBar);
        text_numeros = (TextView) findViewById(R.id.text_numeros);

        text_largo.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                Toast t;
                t = Toast.makeText(getApplicationContext(), "Has clickado", Toast.LENGTH_SHORT);
                t.show();
                return false;

            }
        });

        estrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                text_numeros.setText("[" + Math.round(estrellas.getRating()) + "/5]");
            }
        });
    }


    public void onclick(View v){

        switch (v.getId()){

            //Si haces click en el boton fondo rojo
            case R.id.button_fondoRojo:
                //Si no esta pintado
                //Cambiar fondo de color
                boton_fondo.setText("Fondo blanco");
                if(!fondo){
                    relative.setBackground(getDrawable(R.color.rojo));
                    boton_fondo.setText("Fondo blanco");

                    fondo = true;

                    //Si esta pintado
                }else{

                    relative.setBackground(getDrawable(R.color.transparente));
                    boton_fondo.setText("Fondo rojo");

                    fondo = false;
                }
                break;

            case R.id.button_letrasNegras:
                if(!fondo_letras){

                boton_letra.setTextColor(getColor(R.color.negro));

                    fondo_letras = true;

                }else{


                    boton_letra.setTextColor(getColor(R.color.rojo));

                    fondo_letras = false;
                }
                break;

            case R.id.checkBox_mostrar:
                if (check_mostrar.isChecked()){
                    texto_oculto.setVisibility(View.VISIBLE);
            }else{
                texto_oculto.setVisibility(View.INVISIBLE);
            }
            break;

        }


    }




}
