package com.example.Erranda;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import androidx.appcompat.app.AppCompatActivity;

public class GooglePlaceAutoComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.googleplace );
        final TextView txtVw = findViewById( R.id.place_autocomplete_fragment );


        AutocompleteFilter filter = new AutocompleteFilter.Builder().setCountry( "GHANA" ).build();
        PlaceAutocompleteFragment autocompleteFragment = null;
        autocompleteFragment.setFilter( filter );
        autocompleteFragment = ( PlaceAutocompleteFragment ) getFragmentManager().findFragmentById( R.id.place_autocomplete_fragment );

        /*AutocompleteFilter filter = new AutocompleteFilter.Builder()
                .setCountry("IN")
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES)
                .build();
        autocompleteFragment.setFilter(filter);*/
        autocompleteFragment.setOnPlaceSelectedListener( new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                txtVw.setText( place.getName() );
            }

            @Override
            public void onError(Status status) {
                txtVw.setText( status.toString() );
            }
        } );
    }


}