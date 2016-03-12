package iut.projetandroid.elgarrailavigne.geosms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by POSTE on 12/03/2016.
 */
public class MainMenuFragment extends Fragment{
    public MainMenuFragment newInstance(int index) {
        MainMenuFragment m = new MainMenuFragment();

        Bundle args =new Bundle();
        args.putInt("index", index);
        m.setArguments(args);

        return m;
    }

    public int getShownIndex(){
        return getArguments().getInt("index",0);
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.mainfragment,container, false);
    }
}
