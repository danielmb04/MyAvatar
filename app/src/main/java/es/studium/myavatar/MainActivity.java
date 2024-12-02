package es.studium.myavatar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnNombreDialogoListener, OnSexoDialogoListener, OnEspecieDialogoListener, OnProfesionDialogoListener {
    DialogoNombre dialogoNombre;
    DialogoSexo dialogoSexo;
    DialogoEspecie dialogoEspecie;
    DialogoProfesion dialogoProfesion;
    Button btnEmpezar;
    Button btnResetear;


    private String avatarNombre;
    private String avatarSexo;
    private String avatarEspecie;
    private String avatarProfesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnEmpezar = findViewById(R.id.button);
        btnResetear = findViewById(R.id.button2);

        btnEmpezar.setOnClickListener(this);
        btnResetear.setOnClickListener(this);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.imagenpordefecto);
        TextView estadisticasTextView = findViewById(R.id.estadisticasTextView);
        String estadisticas = "Vida: 0-100 \n " +
                "Magia: 0-10 \n  " +
                "Fuerza: 0-20  \n  " +
                "Velocidad: 0-5";
        estadisticasTextView.setText(estadisticas);

        //   Vida: Cantidad de vida, entre 0 y 100.
// Magia: Cantidad de magia, entre 0 y 10.
//Fuerza: Cantidad de fuerza, entre 0 y 20.
//Velocidad: Cantidad de velocidad, entre 0 y 5
    }

    @Override
    public void onClick(View view) {


        btnResetear.setOnClickListener(v -> {
            avatarNombre = null;
            avatarSexo = null;
            avatarEspecie = null;
            avatarProfesion = null;
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.imagenpordefecto); // Imagen predeterminada
            TextView estadisticasTextView = findViewById(R.id.estadisticasTextView);
            estadisticasTextView.setText("");
            Toast.makeText(this, "Opciones reiniciadas", Toast.LENGTH_SHORT).show();
        });

        btnEmpezar.setOnClickListener(v -> {
            dialogoNombre = new DialogoNombre();
            dialogoNombre.setCancelable(false);
            dialogoNombre.show(getSupportFragmentManager(), "Nombre");

    });
    }
@Override
public void onNombreDialogoContinuarListener()
    {

            dialogoSexo = new DialogoSexo();
            dialogoSexo.setCancelable(false);
            dialogoSexo.show(getSupportFragmentManager(), "Sexo");
        }


@Override
    public void onNombreDialogoCancelarListener()
    {
        Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataSet(String nombre) {
        avatarNombre = nombre;

        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onSexoDialogoContinuarListener() {
        dialogoEspecie = new DialogoEspecie();
        dialogoEspecie.setCancelable(false);
        dialogoEspecie.show(getSupportFragmentManager(), "Especie");

    }

    @Override
    public void onSexoDialogoCancelarListener() {
        Toast.makeText(this, "Seleccionar sexo cancelado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataSetSexo(String sexo) {
        avatarSexo = sexo;

        Toast.makeText(this, "Sexo: " + sexo, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEspecieDialogoContinuarListener() {
        dialogoProfesion = new DialogoProfesion();
        dialogoProfesion.setCancelable(false);
        dialogoProfesion.show(getSupportFragmentManager(), "Profesion");
    }

    @Override
    public void onEspecieDialogoCancelarListener() {
        Toast.makeText(this, "Seleccionar especie cancelado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataSetEspecie(String especie) {
        avatarEspecie = especie;

        Toast.makeText(this, "Especie: " + especie, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onProfesionDialogoContinuarListener() {

    }

    @Override
    public void onProfesionDialogoCancelarListener() {
        Toast.makeText(this, "Seleccionar profesión cancelado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataSetProfesion(String profesion) {
        avatarProfesion = profesion;
        actualizarImageView();
        Toast.makeText(this, "Profesión: " + profesion, Toast.LENGTH_SHORT).show();
    }




    private void actualizarImageView() {
        ImageView imageView = findViewById(R.id.imageView);
        TextView estadisticasTextView = findViewById(R.id.estadisticasTextView);
        int imageResource = R.drawable.imagenpordefecto; // Imagen por defecto

        if ("Hombre".equals(avatarSexo)) {
            if ("Elfo".equals(avatarEspecie)) {
                if ("Arquero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hea;
                } else if ("Guerrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.heg;
                } else if ("Herrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.heh;
                } else if ("Mago".equals(avatarProfesion)) {
                    imageResource = R.drawable.hem;
                } else if ("Minero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hemi;
                }
            }

            imageView.setImageResource(imageResource);
            if ("Enano".equals(avatarEspecie)) {
                if ("Arquero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hena;
                } else if ("Guerrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.heng;
                } else if ("Herrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.henh;
                } else if ("Mago".equals(avatarProfesion)) {
                    imageResource = R.drawable.henm;
                } else if ("Minero".equals(avatarProfesion)) {
                    imageResource = R.drawable.henmi;
                }
            }
            imageView.setImageResource(imageResource);
            if ("Hobbit".equals(avatarEspecie)) {
                if ("Arquero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hha;
                } else if ("Guerrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hhg;
                } else if ("Herrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hhh;
                } else if ("Mago".equals(avatarProfesion)) {
                    imageResource = R.drawable.hhm;
                } else if ("Minero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hhmi;
                }
            }
            imageView.setImageResource(imageResource);
            if ("Humano".equals(avatarEspecie)) {
                if ("Arquero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hpa;
                } else if ("Guerrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hpg;
                } else if ("Herrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hph;
                } else if ("Mago".equals(avatarProfesion)) {
                    imageResource = R.drawable.hpm;
                } else if ("Minero".equals(avatarProfesion)) {
                    imageResource = R.drawable.hpm;
                }
            }
            imageView.setImageResource(imageResource);

        } else if ("Mujer".equals(avatarSexo)) {
            if ("Elfo".equals(avatarEspecie)) {
                if ("Arquero".equals(avatarProfesion)) {
                    imageResource = R.drawable.mea;
                } else if ("Guerrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.meg;
                } else if ("Herrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.meh;
                } else if ("Mago".equals(avatarProfesion)) {
                    imageResource = R.drawable.mem;

                } else if ("Minero".equals(avatarProfesion)) {
                    imageResource = R.drawable.memi;
                }
            }
            imageView.setImageResource(imageResource);
            if ("Enano".equals(avatarEspecie)) {
                if ("Arquero".equals(avatarProfesion)) {
                    imageResource = R.drawable.mena;
                } else if ("Guerrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.meng;
                } else if ("Herrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.menh;
                } else if ("Mago".equals(avatarProfesion)) {
                    imageResource = R.drawable.menm;
                } else if ("Minero".equals(avatarProfesion)) {
                    imageResource = R.drawable.menmi;
                }
            }
            imageView.setImageResource(imageResource);
            if ("Hobbit".equals(avatarEspecie)) {
                if ("Arquero".equals(avatarProfesion)) {
                    imageResource = R.drawable.mha;
                } else if ("Guerrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.mhg;
                } else if ("Herrero".equals(avatarProfesion)) {
                    imageResource = R.drawable.mhh;
                } else if ("Mago".equals(avatarProfesion)) {
                    imageResource = R.drawable.mhm;
                } else if ("Minero".equals(avatarProfesion)) {
                    imageResource = R.drawable.mhmi;

                }
            }
                imageView.setImageResource(imageResource);
                if ("Humano".equals(avatarEspecie)) {
                    if ("Arquero".equals(avatarProfesion)) {
                        imageResource = R.drawable.mpa;
                    } else if ("Guerrero".equals(avatarProfesion)) {
                        imageResource = R.drawable.mpg;
                    } else if ("Herrero".equals(avatarProfesion)) {
                        imageResource = R.drawable.mph;
                    } else if ("Mago".equals(avatarProfesion)) {
                        imageResource = R.drawable.mpm;
                    } else if ("Minero".equals(avatarProfesion)) {
                        imageResource = R.drawable.mpmi;
                    }
                    imageView.setImageResource(imageResource);
                }

        }
        int vida = (int) (Math.random() * 101); // Entre 0 y 100
        int magia = (int) (Math.random() * 11); // Entre 0 y 10
        int fuerza = (int) (Math.random() * 21); // Entre 0 y 20
        int velocidad = (int) (Math.random() * 6); // Entre 0 y 5

        // Muestra las estadísticas en el TextView
        String estadisticas = avatarNombre + "\n" +
                avatarSexo + " " + avatarEspecie +" "+ avatarProfesion + "\n" +
                "Estadísticas:\n" +
                "Vida: " + vida + "\n" +
                "Magia: " + magia + "\n" +
                "Fuerza: " + fuerza + "\n" +
                "Velocidad: " + velocidad;
        estadisticasTextView.setText(estadisticas);
    }
//   Vida: Cantidad de vida, entre 0 y 100.
// Magia: Cantidad de magia, entre 0 y 10.
//Fuerza: Cantidad de fuerza, entre 0 y 20.
//Velocidad: Cantidad de velocidad, entre 0 y 5
}
