package com.example.Erranda;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constant {

    public static String packageName = "";
    public static Boolean isQueue = false, isIntransit = false, isDelivered = false, isOnhold = false;
    public static String partnerId = "";
    public static Boolean isCheckPass = false;
    public static String result = "null";
    public static String selectedPartner  = "";
    public static int StrCnt, StrCnt2;
    public static String password = "";
    public static String userName = "";
    public static String cost = "";
    static int StrCnt1;
    static int StrCnt6;
    static String PickT;
    static String PickRes;
    static String PickCont;
    static String PickGPS;
    static String DispRes;
    static String DispCont;
    static String DispGPS;
    static boolean CheckPack, CheckPack1, CheckPack2, CheckPack3, CheckPack4, CityCheck, ResCheck, DContCheck, PContCheck, CheckQty;
    static String Package;
    static String DispT;
    public static String defUsern, defUserp;
    public static String response = "";
    public static String userId = "";
    public static double latitude, longitude;

    //public static  String url = "http://192.168.1.2:3000/";

   // public static  String url = "http://192.168.1.2:3000/";


    public static String url = "http://67205ddc.ngrok.io/";



    //public static  String url = "http://192.168.1.2:3000/";

   // public static String url = "http://67205ddc.ngrok.io/"
    // public static  String url = "http://192.168.1.2:3000/";





    // public static String url = "https://gomes.localtunnel.me/";

    //public static String url = "http://67205ddc.ngrok.io/";



 //  public static  String url = "http://192.168.1.2:3000/";
//    public static String url = "http://67205ddc.ngrok.io/";
   // public static  String url = "http://192.168.1.2:3000/";

    //public static  String url = "http://192.168.1.2:3000/";



    //Partner Names and Id





    public static String First = "", ParsedData = "", trackagent, Surname = "", Firstname = "", Phone = "", MomoTransToken = "";

    //Momo API Attributes
    public static String randomUUIDString = "", token = "", key = "eaf602bce8e0439caec2ac363a0a0134", Test_contact = "46733123453", Cust_amount = "25", contact = "", output = "", getOutput = "", ContExtract = "";

    public static String Pickdate = "NULL", Dispdate = "NULL", Cost = "25.00", Remarks = "NOT PAID";

    public static String item, email, username = "", quantity, ReqID, SentCode, Contact,  paycode, reqstatus, data, custView="", mylocation = null;

    public static String message = "\n" + "\n1.Dial *170# on your phone\n2. " +
            "Select 3 for approval \n" + " \n3. Select Payment_Options_Fragment \n4.Enter your MOMO PIN to Confirm \n " + "\n(You will receive Payment_Options_Fragment Code after Confimation)\n" + "\n5. Finally Enter Code on Portal";


//    public static  String URL = "http://34.247.24.133/";
//    public static  String URL_BACKUP="http://34.247.24.133/";
//    public static final String CC_URL ="https://test.interpayafrica.com:8073/CardPaymentCC/";






    public static String encodeTobase64(Bitmap image) {
        Bitmap immagex = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }


    public static Bitmap decodeBase64(String input) {

        try {
            byte[] decodedByte = Base64.decode(input, 0);
            return BitmapFactory.decodeByteArray(decodedByte, 0,
                    decodedByte.length);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public static Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0,
                    encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }


    /**
     * Create a File for saving an image or video
     */
    @SuppressLint("SimpleDateFormat")
    public static File getOutputMediaFile(int type) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "prive");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        File mediaFile;
        if (type == 1) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }

        return mediaFile;
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, false);
        return resizedBitmap;

    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri
                .getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri
                .getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri
                .getAuthority());
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public static String getDataColumn(Context context, Uri uri,
                                       String selection, String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri, projection,
                    selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri
                .getAuthority());
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (activity.getCurrentFocus() != null)
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus()
                    .getWindowToken(), 0);
    }

    public static Bitmap getImageResize(Bitmap bitmapOrg) {
        int width = bitmapOrg.getWidth();
        int height = bitmapOrg.getHeight();
        int newWidth = 300;
        int newHeight = 300;

        // calculate the scale - in this case = 0.4f
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        // createa matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);

        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width,
                height, matrix, true);

        return resizedBitmap;
    }

    public static double roundLatLong(double value) {
        double factor = 1e5; // = 1 * 10^5 = 100000.
        return Math.round(value * factor) / factor;
    }

//    public static int getEducationselect(String higesteducation, Context context) {
//
//        String[] array = context.getResources().getStringArray(
//                R.array.higesteducationlevel);
//
//        for (int i = 0; i < array.length; i++) {
//            if (higesteducation.toLowerCase().equals(array[i].toLowerCase())) {
//                return i;
//            }
//        }
//        return 0;
//    }

//    public static int publicprivateSchool(String publicprivate, Context context) {
//
//        String[] array = context.getResources().getStringArray(
//                R.array.schooltype);
//
//        for (int i = 0; i < array.length; i++) {
//            if (publicprivate.toLowerCase().equals(array[i].toLowerCase())) {
//                return i;
//            }
//        }
//        return 0;
//    }

    public static void setupUI(View view, final Activity activity) {

        // Set ic_down touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {

            view.setOnTouchListener(new View.OnTouchListener() {

                @SuppressLint("ClickableViewAccessibility")
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(activity);
                    return false;
                }

            });
        }

        // If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {

            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

                View innerView = ((ViewGroup) view).getChildAt(i);

                setupUI(innerView, activity);
            }
        }
    }







}

