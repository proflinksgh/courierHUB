package com.example.Erranda;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvprofileimage;
    Button btnprofilephoto;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


        setContentView( R.layout.activity_main );

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
         //  fragmentTransaction.addToBackStack( null );
        fragmentTransaction.add( R.id.fragment_container, new TaskList_Fragment() );
        fragmentTransaction.commit();


        tvprofileimage = (TextView ) findViewById( R.id.tvprofilename );
        btnprofilephoto = (Button ) findViewById( R.id.btnprofilephoto );


        String usern = Constant.userName.split("\\@")[0];
       // String usern = Constant.userName.substring(0, Constant.token.length() - 1);
        tvprofileimage.setText(usern);


        btnprofilephoto.setOnClickListener( (View.OnClickListener)this );

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnprofilephoto:
                //Load profile image

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if (getFragmentManager().getBackStackEntryCount() != 0) {
                getFragmentManager().popBackStack();
            }
            return true;
        }

        return super.onOptionsItemSelected( item );
    }


//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate( R.menu.menu, menu );
//        return true;
//    }
}




//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//
//
//                switch (item.getItemId()) {
//                    case R.id.logout:
//
//
//                        final AlertDialog alertDialog = new SpotsDialog.Builder().setContext( MainActivity.this ).build();
//                        alertDialog.setTitle( "" );
//                        alertDialog.setMessage( "Signing Out....." );
//                        alertDialog.show();
//
//                        Runnable progressRunnable = new Runnable() {
//
//                            @Override
//                            public void run() {
//                                alertDialog.cancel();
//
//                                Intent i = new Intent( MainActivity.this, Sign.class );        // Specify any activity here e.g. home or fragment_splash or login etc
//                                i.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
//                                i.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK );
//                                i.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
//                                i.putExtra( "EXIT", true );
//                                startActivity( i );
//                                finish();
//                            }
//                        };
//
//                        Handler pdCanceller = new Handler();
//                        pdCanceller.postDelayed( progressRunnable, 3000 );
//
//                        break;
//
//
//                    case R.id.getsupport:
//
//                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                        ft.addToBackStack( null );
//                        ft.replace( R.id.fragment_container, new fragement_getSupport() );
//                        ft.commit();
//
//                        break;
//
//                    case R.id.request:
//
//                        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
//                        fr.addToBackStack( null );
//                        fr.replace( R.id.fragment_container, new Package_Detail_Fragment() );
//                        fr.commit();
//
//                        break;
//
//
//                    case R.id.gallary:
//
//                        FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
//                        fragment.addToBackStack( null );
//                        fragment.replace( R.id.fragment_container, new Gallary_main() );
//                        fragment.commit();
//
//                        break;
//
//
//                    case R.id.status:
//
//                        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
//                        fm.addToBackStack( null );
//                        fm.replace( R.id.fragment_container, new Status_View_Fragment() );
//                        fm.commit();
//
//                        break;
//
//
//                    case R.id.partner:
//
//                        FragmentTransaction partner = getSupportFragmentManager().beginTransaction();
//                        partner.addToBackStack( null );
//                        partner.replace( R.id.fragment_container, new Partner_view() );
//                        partner.commit();
//
//                        Constant.isCheckPass = true;
//                        break;
//
//
//                    case R.id.terms:
//
//                        Intent intent = new Intent( this, Webview.class );
//                        startActivity( intent );
//
//                        break;
//            }
//             getFragmentManager().popBackStackImmediate();
//
//            return super.onOptionsItemSelected( item );
//        }
//    }









    //ProgressBar progressBar =  findViewById(R.id.loadingPanel);
