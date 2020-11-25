package mx.edu.utng.apprecyclergds0243;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity  {
    FloatingActionButton fabUno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se relaciona con la vista
        fabUno=(FloatingActionButton)findViewById(R.id.fabUno);
        //Se maneja el evento OnClick


        fabUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para conectar con la otra Actividad
                Intent intNuevo = new Intent(MainActivity.this, NuevoActivity.class);
                startActivity(intNuevo);  //Inicia NuevoActivity
                finish(); //finaliza la actividad actual (MainActivity)
            }
        });
    }
}