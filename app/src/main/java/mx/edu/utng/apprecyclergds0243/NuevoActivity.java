package mx.edu.utng.apprecyclergds0243;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class NuevoActivity extends AppCompatActivity {
    //private Button btnAgregar, btnRegresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        final Button btnAgregar=(Button)findViewById(R.id.btnAgregar);
        final Button btnRegresar=(Button)findViewById(R.id.btnRegresar);
        final EditText etNombre=findViewById(R.id.etNombre);
        final EditText etPhoto=findViewById(R.id.etPhoto);
        final EditText etDireccion=findViewById(R.id.etDireccion);
        final RatingBar rbValoracion=findViewById(R.id.ratingBar);

       //Manejo del evento de Onclick a btnAgregar
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyOpenHelper dbHelper = new MyOpenHelper(NuevoActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if (db != null) {
                    // Hacer las operaciones que queramos sobre la base de datos
                    ContentValues cv = new ContentValues();
                    cv.put("nombre", etNombre.getText().toString());
                    cv.put("photo", etPhoto.getText().toString());
                    cv.put("valoracion", rbValoracion.getRating());
                    cv.put("direccion", etDireccion.getText().toString());
                    try {
                        db.insert("restaurante", null, cv);
                        etNombre.setText("");
                        etPhoto.setText("");
                        rbValoracion.setRating(0.0f);
                        etDireccion.setText("");
                        Toast.makeText(NuevoActivity.this, "Se ha agregado un nuevo Restaurante",
                                Toast.LENGTH_LONG).show();
                    }catch (Exception ex){
                        Toast.makeText(NuevoActivity.this, "Error:"+ex.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }finally {
                        db.close();
                    }

                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMain = new Intent(NuevoActivity.this, MainActivity.class);
                startActivity(intentMain);  //Inicia MainActivity
                finish(); //Finaliza NuevoActivity
            }
        });
    }
}