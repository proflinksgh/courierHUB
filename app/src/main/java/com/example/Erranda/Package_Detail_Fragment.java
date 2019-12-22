
//Package_Detail_Fragment Displays Customer Request Input Paths. For Entering Item and Quantity

package com.example.Erranda;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Package_Detail_Fragment extends Fragment {

    EditText pack, quantity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_package_detail, container, false );

        pack = ( EditText ) rootView.findViewById( R.id.etPackage );
        quantity = ( EditText ) rootView.findViewById( R.id.etQuantiy );

        Button next = rootView.findViewById( R.id.btnLogin );



        //Button turn on Listener
        next.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Constant.item = pack.getText().toString();
                Constant.quantity = quantity.getText().toString();

                //PACK INFO CONDITIONS

                Constant.StrCnt1 = Constant.item.length();

                Constant.CheckPack = (!Constant.item.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" ));
                Constant.CheckPack1 = Constant.item == null || Constant.Package == "";
                Constant.CheckPack2 = (Constant.item.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" )) && (Constant.StrCnt1 < 3);
                Constant.CheckPack3 = Constant.item.matches( "[0-9]+" );
                Constant.CheckPack4 = (Constant.item.matches( "[a-zA-Z]+" )) && (Constant.StrCnt1 < 3);
                Constant.CheckQty =  (!Constant.quantity.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" ));

                Log.d("Output", "Quantity check "+ Constant.CheckQty);



                if(Constant.CheckQty){
                    Toast.makeText( getContext(), "Enter Quantity", Toast.LENGTH_LONG ).show();
                }

                else if (Constant.CheckPack == true || Constant.CheckPack1 == true || Constant.CheckPack2 == true || Constant.CheckPack3 == true) {

                    Toast.makeText( getContext(), "Enter Item", Toast.LENGTH_LONG ).show();
                    pack.setText( "" );
                    Constant.item = ("");


                } else {

                    Constant.isCheckPass = false;

                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.addToBackStack( null );
                    fr.replace( R.id.fragment_container, new Request_Detail_Fragment() );
                    fr.commit();

                }
            }
        } );
        return rootView;
    }
}


