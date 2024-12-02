package es.studium.myavatar;

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

public class DialogoProfesion extends DialogFragment {
    OnProfesionDialogoListener mListener;
    RadioGroup radioGroup;
    RadioButton radioButtonArquero;
    RadioButton radioButtonGuerrero;
    RadioButton radioButtonMago;
    RadioButton radioButtonHerrero;
    RadioButton radioButtonMinero;


    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_profesion, null);
        radioGroup = myView.findViewById(R.id.radioGroupProfesion);
        radioButtonArquero = myView.findViewById(R.id.radioButtonArquero);
        radioButtonGuerrero = myView.findViewById(R.id.radioButtonGuerrero);
        radioButtonMago = myView.findViewById(R.id.radioButtonMago);
        radioButtonHerrero = myView.findViewById(R.id.radioButtonHerrero);
        radioButtonMinero = myView.findViewById(R.id.radioButtonMinero);

        builder.setView(myView);
        builder.setTitle("Profesión Avatar")
                 .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            dialogInterface.dismiss();
            mListener.onProfesionDialogoCancelarListener();
        }
    })

            .setPositiveButton("Continuar", null);

    AlertDialog dialogProfesion = builder.create();

        dialogProfesion.setOnShowListener(dialogInterface -> {

        dialogProfesion.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(getContext(), "Debes seleccionar una profesión", Toast.LENGTH_SHORT).show();
                return;
            }
            try {

                String profesionSeleccionada = selectedId == radioButtonArquero.getId()
                        ? radioButtonArquero.getText().toString()
                        : selectedId == radioButtonGuerrero.getId()
                        ? radioButtonGuerrero.getText().toString()
                        : selectedId == radioButtonMago.getId()
                        ? radioButtonMago.getText().toString()
                        : selectedId == radioButtonHerrero.getId()
                        ? radioButtonHerrero.getText().toString()
                        : radioButtonMinero.getText().toString();
                mListener.onDataSetProfesion(profesionSeleccionada);
                mListener.onProfesionDialogoContinuarListener();
                dialogProfesion.dismiss();
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }

        });
    });

        return dialogProfesion;
}
                @Override
    public void onAttach(Context context)
                {
                    super.onAttach(context);
try {
    mListener = (OnProfesionDialogoListener) context;
}
catch (ClassCastException e){
    throw new ClassCastException(context.toString() + "must implement onProfesionDialogoListener");
}
                }

}
