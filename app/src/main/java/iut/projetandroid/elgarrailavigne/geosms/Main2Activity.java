package iut.projetandroid.elgarrailavigne.geosms;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import java.util.Calendar;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

import java.util.Date;

public class Main2Activity extends FragmentActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
  //  implements DateFragment.OnDateSelectedListener {

    private GoogleApiClient myClient;
    private Location currentLocation;
    private LocationRequest myLocationRequest;
    private LocationSettingsRequest.Builder builder;

    private TextView placeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

     //   placeTextView = (TextView)findViewById(R.id.lieuActuel);
//        placeTextView.setText("Aucun lieu mon gars");

        myClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        if(findViewById(R.id.master)!=null){
            if(savedInstanceState!=null){
                return;
            }
            MainMenuFragment firstFragment = new MainMenuFragment();
           // firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.master, firstFragment).commit();

        }
    }

    @Override
    protected void onStart() {
        myClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        myClient.disconnect();
        super.onStop();
    }

    public void affichFragmentDestinataires (View sender) {
        if(findViewById(R.id.master)!=null) {
            Destinataires destFragment = new Destinataires();
            getSupportFragmentManager().beginTransaction().add(R.id.master, destFragment).addToBackStack(null).commit();
        }
    }

    public void affichDatePicker (View sender){
        if(findViewById(R.id.master)!=null){
            DateFragment dateFragment = new DateFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.master, dateFragment).addToBackStack(null).commit();
        }
    }

    protected void createLocationRequest() {
        myLocationRequest = new LocationRequest();
        myLocationRequest.setInterval(1);
        myLocationRequest.setFastestInterval(5);
        myLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    protected void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(myClient, myLocationRequest, this);
    }

    public void afficherLocation() {

        createLocationRequest();
        startLocationUpdates();
        if (myLocationRequest != null) {
            builder = new LocationSettingsRequest.Builder().addLocationRequest(myLocationRequest);
        } else {
            Log.d("pbLocRequest", "Y a point de locationRequest");
        }

        if (builder != null) {
            PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(myClient, builder.build());
        } else {
            Log.d("pbLocBuilder", "Y a point de builder");
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        currentLocation = LocationServices.FusedLocationApi.getLastLocation(myClient);

        if (currentLocation != null) {
            Log.d("FGDFEMDFFF", "CURRENTLOCATIONPASNUL");
        } else {
            Log.d("oulala", "Y a point de location");
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    afficherLocation();
                } else {
                    return;
                }
                return;
            }
            default:
                return;
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.d("GEO", "ONCONNECTED");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    0);

        } else {

            afficherLocation();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {
            currentLocation = location;

            String latitude = new Double(currentLocation.getLatitude()).toString();
            String longitude = new Double(currentLocation.getLongitude()).toString();
//            placeTextView.setText(latitude + " - " + longitude);
        Toast.makeText(
                getApplicationContext(),
                latitude + " - " + longitude, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

  /*  public void recupDate (View sender){
       onDateSelected((DatePicker)findViewById(R.id.datePick));
    }

   /* @Override
    public void onDateSelected(DatePicker datePicker) {
        DateFragment dateFragment = (DateFragment)getSupportFragmentManager().findFragmentById(R.id.master);
        Date date = new Date();
        date.setTime(datePicker.getDayOfMonth()+datePicker.getMonth()+datePicker.getYear());

        if(dateFragment!=null){
            dateFragment.updateDateView(date);
        } else {
            MainMenuFragment newFragment = new MainMenuFragment();
            Bundle args = new Bundle();
            args.putLong("newDate", date.getTime());
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.master, newFragment).commit();
        }
    }*/
}
