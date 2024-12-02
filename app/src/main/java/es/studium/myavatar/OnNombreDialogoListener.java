package es.studium.myavatar;

public interface OnNombreDialogoListener {
    public void onNombreDialogoContinuarListener();
    public void onNombreDialogoCancelarListener();
    public void onDataSet(String nombre);


    void onSexoDialogoContinuarListener();

    void onSexoDialogoCancelarListener();

    void onDataSetSexo(String sexo);
}
