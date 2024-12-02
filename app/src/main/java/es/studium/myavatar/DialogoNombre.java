package es.studium.myavatar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class DialogoNombre extends DialogFragment {

    OnNombreDialogoListener mlistener;
    EditText nombre;

    @SuppressLint("MissingInflatedId")
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_nombre, null);

        nombre = myView.findViewById(R.id.editTextNombre);
        builder.setView(myView);

        builder.setTitle("Nombre Avatar")
                .setNegativeButton("Cancelar", (dialogInterface, which) -> {
                    mlistener.onNombreDialogoCancelarListener();
                    dialogInterface.dismiss();
                })
                .setPositiveButton("Continuar", null); // Dejamos en null para personalizar el comportamiento más tarde

        AlertDialog dialogNombre = builder.create();

        // Personalizar el botón positivo para validar el nombre
        dialogNombre.setOnShowListener(dialogInterface -> {
            dialogNombre.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
                String nombreTexto = nombre.getText().toString().trim();

                if (nombreTexto.isEmpty()) {
                    // Mostrar un error en el EditText si el nombre está vacío
                    nombre.setError("Debes introducir un nombre");
                } else {
                    // Si el nombre es válido, enviar los datos y cerrar el diálogo
                    mlistener.onDataSet(nombreTexto);
                    mlistener.onNombreDialogoContinuarListener();
                    dialogNombre.dismiss();
                }
            });
        });

        return dialogNombre;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mlistener = (OnNombreDialogoListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnNombreDialogoListener");
        }
    }
}
