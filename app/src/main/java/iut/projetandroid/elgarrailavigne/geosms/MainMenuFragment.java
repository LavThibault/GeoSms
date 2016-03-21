package iut.projetandroid.elgarrailavigne.geosms;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

/**
 * Created by POSTE on 12/03/2016.
 */
public class MainMenuFragment extends Fragment{

    private View InflatedView;
    private TextView textLieu;

    public MainMenuFragment newInstance(int index) {
        MainMenuFragment m = new MainMenuFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);
        m.setArguments(args);

        return m;
    }

  /*  public void setText(){
        textLieu = (TextView)InflatedView.findViewById(R.id.lieuActuel);
        textLieu.setText("Ca marche enfin !");
    }*/

    private void showDatePicker(){
        DatePickerDialogFragment date = new DatePickerDialogFragment();
        Calendar calendar = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calendar.get(Calendar.YEAR));
        args.putInt("month", calendar.get(Calendar.MONTH));
        args.putInt("day", calendar.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);

        date.setCallback(onDate);
        date.show(getFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener onDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {

            Toast.makeText(
                    getActivity(),
                    String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year), Toast.LENGTH_LONG).show();
        }
    };

    public int getShownIndex(){
        return getArguments().getInt("index",0);
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        InflatedView = inflater.inflate(R.layout.mainfragment,container, false);
        InflatedView.findViewById(R.id.affichDatePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
     //   textLieu = (TextView)InflatedView.findViewById(R.id.lieuActuel);
   //     textLieu.setText("pouet");
        return InflatedView;
    }
}
