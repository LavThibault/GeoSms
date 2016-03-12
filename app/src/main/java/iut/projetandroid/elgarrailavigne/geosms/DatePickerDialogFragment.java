package iut.projetandroid.elgarrailavigne.geosms;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by POSTE on 12/03/2016.
 */
public class DatePickerDialogFragment extends DialogFragment {

    DatePickerDialogFragment newIntance(String title){
        DatePickerDialogFragment d = new DatePickerDialogFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        return d;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int style = DialogFragment.STYLE_NORMAL, theme = 0 ;
        setStyle(style,theme);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceBundle){
        int title = getArguments().getInt("title");

        return new DatePickerDialog.Builder(getActivity())
                .setTitle(title)
                .setPositiveButton(R.string.alert_dialog_ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((DatePickerDialogFragment)getActivity()).doPositiveClick();
                            }
                        }
                )
                .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((DatePickerDialogFragment)getActivity()).doNegativeClick();
                            }
                        }
                )
                .create();
    }

    void showDialog(){
        DialogFragment newFragment = DatePickerDialogFragment.newInstance(R.string.alert_dialog_two_buttons_title);
        newFragment.show(getFragmentManager(),"dialog");
    }

    public void doPositiveClick(){

    }

    public void doNegativeClick(){

    }
}
