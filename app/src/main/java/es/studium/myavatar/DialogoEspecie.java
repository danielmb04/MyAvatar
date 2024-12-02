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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoEspecie extends DialogFragment {
    OnEspecieDialogoListener mListener;
    RadioGroup radioGroup;
    RadioButton radioButtonElfo;
    RadioButton radioButtonEnano;
    RadioButton radioButtonHobbit;
    RadioButton radioButtonHumano;

    @SuppressLint("MissingInflatedId")
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_especie, null);
        radioGroup = myView.findViewById(R.id.radioGroupEspecie);
        radioButtonElfo = myView.findViewById(R.id.radioButtonElfo);
        radioButtonEnano = myView.findViewById(R.id.radioButtonEnano);
        radioButtonHobbit = myView.findViewById(R.id.radioButtonHobbit);
        radioButtonHumano = myView.findViewById(R.id.radioButtonHumano);

        builder.setView(myView);
        builder.setTitle("Especie Avatar")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        mListener.onEspecieDialogoCancelarListener();
                    }
                })
                .setPositiveButton("Continuar", null);

        AlertDialog dialogEspecie = builder.create();

        dialogEspecie.setOnShowListener (dialogInterface -> {
            dialogEspecie.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(getContext(), "Debes seleccionar una especie", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    String especieSeleccionada = selectedId == radioButtonElfo.getId()
                            ? radioButtonElfo.getText().toString()
                            : selectedId == radioButtonEnano.getId()
                            ? radioButtonEnano.getText().toString()
                            : selectedId == radioButtonHobbit.getId()
                            ? radioButtonHobbit.getText().toString()
                            : radioButtonHumano.getText().toString();
                    mListener.onDataSetEspecie(especieSeleccionada);
                    mListener.onEspecieDialogoContinuarListener();
                    dialogEspecie.dismiss();
                }
                catch (Exception e){
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }

            });
        });

        return dialogEspecie;

    }
    @Override
public void onAttach(Context context)
        {
        super.onAttach(context);
        try {
            mListener = (OnEspecieDialogoListener) context;
        }
        catch (ClassCastException e){
        throw new ClassCastException(context.toString() + "must implement onEspecieDialogoListener");}
        }
}
