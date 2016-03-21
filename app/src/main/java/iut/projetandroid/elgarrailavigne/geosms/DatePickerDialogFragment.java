package iut.projetandroid.elgarrailavigne.geosms;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.widget.DatePicker;
import android.os.Bundle;

/**
 * Created by POSTE on 12/03/2016.
 */
public class DatePickerDialogFragment extends DialogFragment{
    OnDateSetListener onDateSetListener;
    int mDay;
    int mMonth;
    int mYear;

    public DatePickerDialogFragment (){

    }

    public void setCallback(OnDateSetListener onDate){
        onDateSetListener=onDate;
    }

    @Override
    public void setArguments(Bundle args){
        super.setArguments(args);
        mYear=args.getInt("year");
        mMonth=args.getInt("month");
        mDay=args.getInt("day");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), onDateSetListener, mYear, mMonth, mDay);
    }

 /*   public interface Callbacks{
        void onDatePicked(Integer day, Integer month, Integer year);
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onDatePicked(Integer day, Integer month, Integer year) {
        }
    };

    private Callbacks mCallbacks = sDummyCallbacks;




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle b = getArguments();
        mDay=b.getInt("set_day");
        mMonth=b.getInt("set_month");
        mYear=b.getInt("set_year");

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mDay = dayOfMonth;
                mMonth = monthOfYear;
                mYear = year;

                Bundle b = new Bundle();
                b.putInt("set_day", mDay);
                b.putInt("set_month", mMonth);
                b.putInt("set_year", mYear);
                b.putString("set_date", "Set Date : " + Integer.toString(mDay) + " / " + Integer.toString(mMonth + 1) + " / " + Integer.toString(mYear));

                Message m = new Message();
                m.setData(b);
                mHandler.sendMessage(m);
            }
        };
        return new DatePickerDialog(getActivity(), listener, mYear, mMonth, mDay);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mCallbacks=sDummyCallbacks;
    }

    void showDialog(){
        DialogFragment newFragment = DatePickerDialogFragment.newInstance(R.string.alert_dialog_two_buttons_title);
        newFragment.show(getFragmentManager(),"dialog");
    }

    public void doPositiveClick(){

    }

    public void doNegativeClick(){

    }*/
}
