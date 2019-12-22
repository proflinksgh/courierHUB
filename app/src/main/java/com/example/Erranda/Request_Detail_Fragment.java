
//Class for Customer Pick and Dispatch Residental Details

package com.example.Erranda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Request_Detail_Fragment extends Fragment {


    String check = "Error.......Check Internet Connection";
    String check2 = "Successful";
    String errCheck = "Error...... Try Again";
    String TAG = "";


    EditText city1, residence1, contact1, digital1;
    EditText city, residence, contact, gps;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_request_detail, container, false );



        TextView tvmycurrentlocation = ( TextView ) rootView.findViewById( R.id.tvcurrentlocation );
        city = ( EditText ) rootView.findViewById( R.id.etCity );
        residence = ( EditText ) rootView.findViewById( R.id.etResidence );
        contact = ( EditText ) rootView.findViewById( R.id.etContact );
        gps = ( EditText ) rootView.findViewById( R.id.etDigital );


        city1 = ( EditText ) rootView.findViewById( R.id.etDcity );
        residence1 = ( EditText ) rootView.findViewById( R.id.etDresidence );
        contact1 = ( EditText ) rootView.findViewById( R.id.etContact1 );
        digital1 = ( EditText ) rootView.findViewById( R.id.etDigital1 );


        Button GetDetails = rootView.findViewById( R.id.btnGetDetatils );
        Button PickMap = rootView.findViewById( R.id.btnMap );
        Button DispMap = rootView.findViewById( R.id.btnMapp );

   //     residence.setText(Constant.latitude + "," + Constant.longitude);
     //   residence1.setText(Constant.latitude + "," + Constant.longitude);

        RequestQueue queue = Volley.newRequestQueue( getActivity());
        queue.start();


        if(Constant.mylocation.length() !=2 ){

            Constant.mylocation = Constant.mylocation.substring( 26 );
            tvmycurrentlocation.setText("My current location: "+Constant.mylocation);

        }


        else{
            tvmycurrentlocation.setText("My current location: "+Constant.latitude + ", "+Constant.longitude);
        }




      //  city.setText(Constant.mylocation);

        PickMap.setOnClickListener( new View.OnClickListener() {

                                        @Override
                                        public void onClick(View v) {

                                            
                                            Intent i = new Intent( getActivity(), MapActivity.class );
                                                        startActivity( i );
                                                    }
                                    });

        DispMap.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                            Intent i = new Intent( getActivity(), MapActivity.class );
                            startActivity( i );

            }
        });



        GetDetails.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {

                                               Constant.PickT = city.getText().toString();
                                               Constant.PickRes = residence.getText().toString();
                                               Constant.PickCont = contact.getText().toString();
                                               Constant.PickGPS = gps.getText().toString();


                                               //INPUT CONDITIONS FOR PICK LOCATION

                                               Constant.CheckPack = (!Constant.PickT.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" ));
                                               Constant.CheckPack1 = Constant.PickT == null || "".equals( Constant.PickT );
                                               Constant.CheckPack2 = (Constant.PickT.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" )) && (Constant.StrCnt1 < 2);
                                               Constant.CheckPack3 = Constant.PickT.matches( "[0-9]+" );
                                               Constant.CheckPack4 = (Constant.PickT.matches( "[a-zA-Z]+" )) && (Constant.StrCnt1 < 2);

                                               // CHECKS FOR PICK RESIDENCE
                                               Constant.CheckPack = (!Constant.PickRes.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" ));
                                               Constant.CheckPack1 = Constant.PickRes == null || "".equals( Constant.PickRes );
                                               Constant.CheckPack2 = (Constant.PickRes.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" )) && (Constant.StrCnt1 < 2);
                                               Constant.CheckPack3 = Constant.PickRes.matches( "[0-9]+" );
                                               Constant.CheckPack4 = (Constant.PickRes.matches( "[a-zA-Z]+" )) && (Constant.StrCnt1 < 2);

                                               //CHECKS FOR CONTACT
                                               Constant.StrCnt1 = Constant.PickCont.length();
                                               Constant.PContCheck = (Constant.StrCnt1 != 10);

                                               if (Constant.CheckPack == true || Constant.CheckPack1 == true || Constant.CheckPack2 == true || Constant.CheckPack3 == true) {

                                                   Toast.makeText( getContext(), "Invalid City", Toast.LENGTH_LONG ).show();
                                                   city.setText( " " );
                                                   Constant.PickT = ("");
                                               }
                                               Constant.CityCheck = (Constant.CheckPack == true || Constant.CheckPack1 == true || Constant.CheckPack2 == true || Constant.CheckPack3 == true);


                                               if (Constant.CheckPack == true || Constant.CheckPack1 == true || Constant.CheckPack2 == true || Constant.CheckPack3 == true) {

                                                   Toast.makeText( getContext(), "Invalid Residence", Toast.LENGTH_LONG ).show();
                                                   residence.setText( " " );
                                                   Constant.PickRes = ("");
                                               }
                                               Constant.ResCheck = (Constant.CheckPack == true || Constant.CheckPack1 == true || Constant.CheckPack2 == true || Constant.CheckPack3 == true);


                                               //CHECKS FOR PICK CONTACT

                                               if (Constant.StrCnt1 != 10) {
                                                   Toast.makeText( getContext(), "Invalid Contact Number", Toast.LENGTH_LONG ).show();
                                                   contact.setText( "" );
                                                   Constant.PickCont = ("");
                                               }
                                               //   Constant.DContCheck = (Constant.StrCnt1 != 10);
                                               Constant.PContCheck = (Constant.StrCnt1 != 10);


                                               Constant.DispT = city1.getText().toString();
                                               Constant.DispRes = residence1.getText().toString();
                                               Constant.DispCont = contact1.getText().toString();
                                               Constant.DispGPS = digital1.getText().toString();


                                               //INPUT CONDITIONS


                                               Constant.CheckPack = (!Constant.DispT.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" ));
                                               Constant.CheckPack1 = Constant.DispT == null || "".equals( Constant.DispT );
                                               Constant.CheckPack2 = (Constant.DispT.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" )) && (Constant.StrCnt1 < 2);
                                               Constant.CheckPack3 = Constant.DispT.matches( "[0-9]+" );
                                               Constant.CheckPack4 = (Constant.DispT.matches( "[a-zA-Z]+" )) && (Constant.StrCnt1 < 2);

                                               // CHECKS FOR PICK RESIDENCE
                                               Constant.CheckPack = (!Constant.DispRes.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" ));
                                               Constant.CheckPack1 = Constant.DispRes == null || "".equals( Constant.DispRes );
                                               Constant.CheckPack2 = (Constant.DispRes.matches( "(?=.*\\S)[a-zA-Z0-9\\s]*" )) && (Constant.StrCnt1 < 2);
                                               Constant.CheckPack3 = Constant.DispRes.matches( "[0-9]+" );
                                               Constant.CheckPack4 = (Constant.DispRes.matches( "[a-zA-Z]+" )) && (Constant.StrCnt1 < 2);

                                               //CHECKS FOR CONTACT
                                               Constant.StrCnt2 = Constant.DispCont.length();
                                               Constant.DContCheck = (Constant.StrCnt2 != 10);


                                               if (Constant.CheckPack == true || Constant.CheckPack1 == true || Constant.CheckPack2 == true || Constant.CheckPack3 == true) {

                                                   Toast.makeText( getContext(), "Invalid City", Toast.LENGTH_LONG ).show();
                                                   city1.setText( " " );
                                                   Constant.DispT = ("");
                                               }
                                               Constant.CityCheck = (Constant.CheckPack == true || Constant.CheckPack1 == true || Constant.CheckPack2 == true || Constant.CheckPack3 == true);


                                               if (Constant.CheckPack == true || Constant.CheckPack1 == true || Constant.CheckPack2 == true || Constant.CheckPack3 == true) {

                                                   Toast.makeText( getContext(), "Invalid Residence", Toast.LENGTH_LONG ).show();
                                                   residence1.setText( " " );
                                                   Constant.DispRes = ("");
                                               }
                                               Constant.ResCheck = (Constant.CheckPack == true || Constant.CheckPack1 == true || Constant.CheckPack2 == true || Constant.CheckPack3 == true);


                                               //CHECKS FOR PICK CONTACT

                                               if (Constant.StrCnt1 != 10) {
                                                   Toast.makeText( getContext(), "Invalid Contact Number", Toast.LENGTH_LONG ).show();
                                                   contact1.setText( "" );
                                                   Constant.DispCont = ("");
                                               }
                                               Constant.DContCheck = (Constant.StrCnt1 != 10);
                                               //Constant.PickCont = (Constant.StrCnt1 != 10);


                                               // if ((Constant.CityCheck==true) && (Constant.ResCheck == true) && (Constant.DContCheck == true)){

                                               //   Toast.makeText( getApplicationContext(), "Something went wrong. Check Input", Toast.LENGTH_LONG ).show();
                                               // }

                                               //else if((Constant.CityCheck==false) && (Constant.ResCheck == false) && (Constant.DContCheck == false)) {


                                               if ((Constant.CityCheck == true) && (Constant.ResCheck == true) && (Constant.DContCheck == true) && (Constant.CheckPack == true || Constant.CheckPack1 == true || Constant.CheckPack2 == true || Constant.CheckPack3 == true || Constant.PContCheck == true || Constant.PContCheck == true || Constant.DContCheck == true)) {

                                                   Toast.makeText( getContext(), "Something went wrong. Check Input", Toast.LENGTH_LONG ).show();
                                               } else if ((Constant.CityCheck == false) && (Constant.ResCheck == false) && (Constant.DContCheck == false) && (Constant.CheckPack == false || Constant.CheckPack1 == false || Constant.CheckPack2 == false || Constant.CheckPack3 == false || Constant.PContCheck == false)) {



                                                  String url = Constant.url + "cust_request_submit";



                                                   progressBar progressBar = new progressBar( getActivity() );
                                                   progressBar.show();


                                                   StringRequest sr = new StringRequest( Request.Method.POST, url, new Response.Listener <String>() {
                                                       @Override
                                                       public void onResponse(String response) {

                                                           Log.d("Output", "API Response "+ response);

                                                           if(response.equalsIgnoreCase( null )|| response.equalsIgnoreCase( "null" )){

                                                                progressBar.hide();
                                                               customDialog( "Error", "Check Internet Connection", "", "okMethod" );
                                                           }


                                                           else if (response.equalsIgnoreCase( "Successful"  )) {

                                                               progressBar.hide();

                                                               FragmentTransaction fr = getFragmentManager().beginTransaction();
                                                               fr.addToBackStack( null );
                                                               fr.replace( R.id.fragment_container, new Partner_view());
                                                               fr.commit();


                                                           } else if (response.equalsIgnoreCase( "Unsuccessful" )) {
                                                               progressBar.hide();
                                                               customDialog( "Error", "Something went wrong", "", "okMethod" );
                                                           }

                                                           else{
                                                               progressBar.hide();
                                                               customDialog( "Error", "Something went wrong.... Try Again", "", "okMethod" );
                                                           }
                                                       }
                                                   }, new Response.ErrorListener() {


                                                       @Override
                                                       public void onErrorResponse(VolleyError error) {
                                                           Log.d("Output", "Error"+ error);




                                                           if(error.toString().contains( "failed to connect to /192.168.1.2 (port 3000)" )){
                                                               progressBar.hide();
                                                               customDialog( "Error", "Connection error...", "", "okMethod" );

                                                           }
                                                       }
                                                   } ) {


                                                       @Override
                                                       public byte[] getBody() throws AuthFailureError {
                                                           HashMap<String, String> params = new HashMap <String, String>();
                                                           params.put( "USERNAME", Constant.username );
                                                           params.put( "ITEM", Constant.item );
                                                           params.put( "QUANTITY", Constant.quantity );

                                                           params.put( "COST", Constant.Cost );
                                                           params.put( "REMARKS", Constant.Remarks );
                                                           params.put( "TOWN", Constant.PickT );

                                                           params.put( "RESIDENCE", Constant.PickRes );
                                                           params.put( "CONTACT", Constant.PickCont );
                                                           params.put( "DIGITAL_ADDRESS", Constant.PickGPS );

                                                           params.put( "TOWN_d", Constant.DispT );
                                                           params.put( "RESIDENCE_d", Constant.DispRes );
                                                           params.put( "CONTACT_d", Constant.DispCont );
                                                           params.put( "DIGITAL_ADDRESS_d", Constant.DispGPS );


                                                           return new JSONObject( params ).toString().getBytes();
                                                       }


                                                       @Override
                                                       public String getBodyContentType() {
                                                           return "application/json";
                                                       }
                                                   };
                                                   queue.add( sr );
                                               }
                                           }

        } );return rootView;

    }



    private void okMethod(){
        Log.d(TAG, "okMethod: Called");
    }

    public void customDialog(String title, String message, final String cancelMethod, final String okMethod ){
        final androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder(getContext());

        builderSingle.setTitle( title );
        builderSingle.setMessage(message);


        builderSingle.setPositiveButton(

                "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        Log.d(TAG, "onClick: Enter Code Called.");
                        if(okMethod.equals("okMethod")){
                            okMethod();
                        }
                    }
                } );
        builderSingle.show();
    }


}



