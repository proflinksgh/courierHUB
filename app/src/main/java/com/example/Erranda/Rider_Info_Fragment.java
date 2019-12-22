package com.example.Erranda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Rider_Info_Fragment extends Fragment implements View.OnClickListener {

    private Button button, button2;
    TextView title, list, status;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_rider_info, container, false );

        button = ( Button ) rootView.findViewById( R.id.btnExit );
        button2 = ( Button ) rootView.findViewById( R.id.btnMap );
        TextView name = (TextView)rootView.findViewById( R.id.tvstat );
        TextView contact = (TextView)rootView.findViewById( R.id.tvstat2 );
        TextView warning = (TextView)rootView.findViewById( R.id.tvsta );


        button.setOnClickListener( ( View.OnClickListener ) this );
        button2.setOnClickListener( ( View.OnClickListener ) this );


       if(Constant.data.equals("[]")){

           warning.setVisibility( View.VISIBLE );
           button2.setVisibility( View.INVISIBLE );
           name.setText("Not Available yet");
           contact.setText("Not Available yet");
       }


       else {
           name.setText( Constant.Firstname + "\t" + Constant.Surname );
           contact.setText( Constant.Phone );
       }return rootView;
    }

    @Override

    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.btnExit:

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.addToBackStack( null );
                fr.replace( R.id.fragment_container, new TaskList_Fragment());
                fr.commit();

                break;

            case R.id.btnMap:


                break;
        }
    }
}