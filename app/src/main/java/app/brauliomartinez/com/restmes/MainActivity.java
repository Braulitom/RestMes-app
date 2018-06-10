package app.brauliomartinez.com.restmes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Creacion de objetos
    private EditText etx1,etx2;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Casting de tipos de datos
        etx1 = (EditText) findViewById(R.id.editText);
        etx2 = (EditText) findViewById(R.id.editText2);
        btn = (Button) findViewById(R.id.button);

        //Llamado del click el boton
        btn.setOnClickListener(this);
    }

    //Método del botón
    @Override
    public void onClick(View v) {
        //Obtención de los datos de la vista grafica
        String usuario = etx1.getText().toString();
        String password = etx2.getText().toString();

        //Validación de datos
        switch (v.getId()){
            case R.id.button:
                if (usuario.equals("cliente") && password.equals("1234")){
                    Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    this.Menu();
                }
                else if (usuario.isEmpty() && password.isEmpty()){
                    Toast.makeText(this, "Debes ingresar un usuario y contraseña", Toast.LENGTH_LONG).show();
                }
                else if (usuario.isEmpty()) {
                    Toast.makeText(this, "Debes ingresar un usuario", Toast.LENGTH_SHORT).show();
                }
                else if (password.isEmpty()){
                    Toast.makeText(this, "Debes ingresar un password", Toast.LENGTH_SHORT).show();
                }
                else if (!usuario.equals("admin")){
                    Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                }
                else if (!password.equals("1234")){
                    Toast.makeText(this, "Password incorrecto", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void Menu() {
       Intent menu = new Intent(this, MenuActivity.class);
       startActivity(menu);
    }
    private void Chef() {
        Intent chef = new Intent(this, ChefActivity.class);
        startActivity(chef);
    }
}
