package iut.projetandroid.elgarrailavigne.geosms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void affichCalendar(View sender) {
        ((Button)findViewById(R.id.button)).setVisibility(View.GONE);
        ((DatePicker)findViewById(R.id.datePicker)).setVisibility(View.VISIBLE);
    }
}
