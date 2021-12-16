package mx.edu.tesoem.isc.g7s21hugo4295p8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    EditText txtnombre, txtedad, txtemail,txtgson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtemail = findViewById(R.id.txtemail);
        txtgson = findViewById(R.id.txtgson);
    }

    public void presiona(View v){
        switch (v.getId()){
            case R.id.btngson: agson();
                break;
            case R.id.btnclase: aclase();
                break;
        }
    }

    private void agson(){
        Datos datos = new Datos();
        Gson gson = new Gson();
        String cgson;
        datos.setNombre(txtnombre.getText().toString());
        datos.setEdad(Integer.parseInt(txtedad.getText().toString()));
        datos.setEmail(txtemail.getText().toString());
        cgson = gson.toJson(datos);
        txtgson.setText(cgson);
    }
    private void aclase(){
        Gson gson = new Gson();
        String cgson = txtgson.getText().toString();
        Datos datos = gson.fromJson(cgson,Datos.class);
        txtnombre.setText(datos.getNombre());
        txtedad.setText(String.valueOf(datos.getEdad()));
        txtemail.setText(datos.getEmail());
    }
}