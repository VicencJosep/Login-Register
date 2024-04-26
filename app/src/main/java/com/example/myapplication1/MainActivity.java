package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String nombreUsuario;
    String contraseñaUsuario;
    HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
    //List<String> usuarios = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
   public void registerbtnClick(View v)
   {
       EditText editTextNombre = findViewById(R.id.editTextNombre);
        nombreUsuario = editTextNombre.getText().toString();

       EditText editTextContraseña = findViewById(R.id.editTextContraseña);
        contraseñaUsuario = editTextContraseña.getText().toString();
        Usuario usuario = new Usuario(nombreUsuario, contraseñaUsuario);
        usuarios.put(nombreUsuario, usuario);

       Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();


   }
   public void loginbtnClick(View v)
   {
       EditText editTextNombre = findViewById(R.id.editTextNombre);
        nombreUsuario = editTextNombre.getText().toString();

       EditText editTextContraseña = findViewById(R.id.editTextContraseña);
        contraseñaUsuario = editTextContraseña.getText().toString();

        if(usuarios.containsKey(nombreUsuario))
        {
            Usuario usuario = usuarios.get(nombreUsuario);

            if(usuario.getContraseña().equals(contraseñaUsuario))
            {
                System.out.println("Usuario logeado");
                Toast.makeText(this, "Usuario logeado con éxito", Toast.LENGTH_SHORT).show();


                // Iniciar la actividad del menú
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);

            }
            else
            {
                System.out.println("Contraseña incorrecta");
                Toast.makeText(this, "La contraseña no es correcta", Toast.LENGTH_SHORT).show();

            }
        }
        else
        {
            System.out.println("Usuario no existe");
            Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();

        }

   }
}