package iut.projetandroid.elgarrailavigne.geosms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by POSTE on 09/03/2016.
 */
public class TitlesFragment extends ListFragment {
    boolean mDualPane;
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
      /*  super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1));

        View detailsFrame = getActivity().findViewById(R.id.master);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if (mDualPane) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurCheckPosition);
        }*/
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        showDetails(position);
    }

    void showDetails(int index){
    /*    mCurCheckPosition = index;

        if(mDualPane){
            getListView().setItemChecked(index, true);

            Destinataires details = (Destinataires)getFragmentManager().findFragmentById(R.id.dest);
            if(details == null || details.getShownIndex()!=index){
                details=Destinataires.newInstance(index);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                if(index==0){
                    ft.replace(R.id.dest, details);
                } else {
                    ft.replace(R.id.dest, details);
                }
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(),Main2Activity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }*/
    }
}
