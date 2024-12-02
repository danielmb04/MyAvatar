package es.studium.myavatar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class DialogoSexo extends DialogFragment
{
OnSexoDialogoListener mListener;
RadioGroup radioGroup;
RadioButton radioButtonHombre;
RadioButton radioButtonMujer;

    @SuppressLint("MissingInflatedId")
public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_sexo, null);
        radioGroup = myView.findViewById(R.id.radioGroup);
        radioButtonHombre = myView.findViewById(R.id.radioButtonHombre);
        radioButtonMujer = myView.findViewById(R.id.radioButtonMujer);
        builder.setView(inflater.inflate(R.layout.dialogo_sexo, null));

        builder.setView(myView);
        builder.setTitle("Sexo Avatar")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                        mListener.onSexoDialogoCancelarListener();
                    }
                })

                .setPositiveButton("Continuar", null);

        AlertDialog dialogSexo = builder.create();

        dialogSexo.setOnShowListener(dialogInterface -> {

            dialogSexo.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(getContext(), "Debes seleccionar un sexo", Toast.LENGTH_SHORT).show();
                    return; // Evita continuar si no se ha seleccionado nada
                }

                try {
                    // Aquí solo se ejecuta si se ha seleccionado una opción
                    String sexoSeleccionado = selectedId == radioButtonHombre.getId()
                            ? radioButtonHombre.getText().toString()
                            : radioButtonMujer.getText().toString();
                    mListener.onDataSetSexo(sexoSeleccionado);
                    mListener.onSexoDialogoContinuarListener();
                    dialogSexo.dismiss();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }
            });
        });

        return dialogSexo;

                }
    @Override
public void onAttach(Context context)
{

    super.onAttach(context);
    try {
        mListener = (OnSexoDialogoListener) context;
    }
    catch (ClassCastException e)
    {
        throw new ClassCastException(context.toString() + "must implement onSexoDialogoListener");
    }
}


}
