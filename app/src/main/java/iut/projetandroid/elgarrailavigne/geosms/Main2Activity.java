package iut.projetandroid.elgarrailavigne.geosms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if(findViewById(R.id.master)!=null){
            if(savedInstanceState!=null){
                return;
            }
            MainMenuFragment firstFragment = new MainMenuFragment();
           // firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.master,firstFragment).commit();

        }
    }

    public void affichFragmentDestinataires (View sender) {
        if(findViewById(R.id.master)!=null){
            Destinataires destFragment = new Destinataires();
            getSupportFragmentManager().beginTransaction().add(R.id.master,destFragment).addToBackStack(null).commit();
        }
    }
}
