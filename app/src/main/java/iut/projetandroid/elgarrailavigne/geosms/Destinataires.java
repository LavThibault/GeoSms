package iut.projetandroid.elgarrailavigne.geosms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by POSTE on 08/03/2016.
 */
public class Destinataires extends Fragment {

    ArrayAdapter<Object> monAdaptater = new ArrayAdapter<Object>(getContext(),android.R.layout.simple_list_item_1);

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragmentdestinataires,container);
    }
}
