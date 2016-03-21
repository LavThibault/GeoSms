package iut.projetandroid.elgarrailavigne.geosms;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Date;

/**
 * Created by POSTE on 16/03/2016.
 */
public class DateFragment extends Fragment {

    OnDateSelectedListener mCallback;
    long time;

    public interface OnDateSelectedListener{
        public void onDateSelected(DatePicker datePicker);
    }

    @Override
    public void onAttach (Context context){
        super.onAttach(getContext());
        try{
            mCallback = (OnDateSelectedListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" must implement OnDateSelectedListener");
        }
    }

    public void updateDateView(Date date){
        time=date.getTime();
    }

    public DateFragment newInstance(int index) {
        DateFragment d = new DateFragment();

        Bundle args =new Bundle();
        args.putInt("index", index);
        d.setArguments(args);

        return d;
    }

    public int getShownIndex(){
        return getArguments().getInt("index",0);
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.datefragmentdialog,container, false);
    }
}
