//package com.example.Erranda;
//
//import android.animation.Animator;
//import android.animation.AnimatorListenerAdapter;
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.net.Uri;
//import android.text.InputFilter;
//import android.text.Spanned;
//import android.text.TextUtils;
//import android.text.format.DateFormat;
//import android.util.Base64;
//import android.util.Log;
//import android.view.View;
//import android.view.inputmethod.InputMethodManager;
//
//import com.example.myapp.R;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URLEncoder;
//import java.security.MessageDigest;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Locale;
//import java.util.TimeZone;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//
//import androidx.fragment.app.FragmentActivity;
//
///**
// * Created by Samir on 3/24/2015.
// */
//public class Utils {
//
//    public static final String DATEWITHTIME = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
//    public static final String DATEFORMATDDMMYYYY = "dd/MM/yyyy";
//    public static final String DATEFORMATYYYYMMDD = "yyyy-MM-dd";
//    public static final String DATEFORMATWITHDAY = "EEE, dd/MM/yyyy";
//    public static final String DATEFORMATWITHMONTH = "dd MMM yyyy";
//    public static final String TIME = "hh:mm a";
//    public static final String TIME2 = "hh:mm:ss";
//    private static boolean confirm = false;
//
//    public static boolean isValidEmail(CharSequence target) {
//        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
//    }
//
//    public static boolean isValidPhone(String strPhone) {
//        if (strPhone == null || strPhone.trim().length() == 0) {
//            return false;
//        }else {
//            return true;
//        }
//
//        //  boolean isValid = strPhone.trim().length() >= 9 && strPhone.trim().length() <= 12 ? true : false;
//        //  return isValid;
//    }
//
//    public static String toCamelCase(final String init) {
//        if (init == null)
//            return null;
//
//        final StringBuilder ret = new StringBuilder(init.length());
//
//        for (final String word : init.split(" ")) {
//            if (!word.isEmpty()) {
//                ret.append(word.substring(0, 1).toUpperCase());
//                ret.append(word.substring(1).toLowerCase());
//            }
//            if (!(ret.length() == init.length()))
//                ret.append(" ");
//        }
//
//        return ret.toString();
//    }
//
//  /*  public static boolean isValidDate(CharSequence target) {
//        // \+[0-9]+
//        Pattern mPattern = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
//        Matcher matcher = mPattern.matcher(target);
//        return matcher.matches();
//    }*/
//
//    public static class DecimalDigitsInputFilter implements InputFilter {
//
//        Pattern mPattern;
//
//        public DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero) {
//            mPattern = Pattern.compile("[0-9]{0," + (digitsBeforeZero - 1) + "}+((\\.[0-9]{0," + (digitsAfterZero - 1) + "})?)||(\\.)?");
//        }
//
//        @Override
//        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
//
//            Matcher matcher = mPattern.matcher(dest);
//            if (!matcher.matches())
//                return "";
//            return null;
//        }
//
//    }
//
//    public static String sendDateToApi(String str) {
//        if (str != null && !str.equalsIgnoreCase("null") && str.trim().length() != 0) {
//
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//            SimpleDateFormat sdf2 = new SimpleDateFormat(DATEFORMATYYYYMMDD);
//
//            try {
//
//                Date date = sdf1.parse(str);
//                return sdf2.format(date);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "";
//            }
//        } else {
//            return "";
//        }
//    }
//
//   /* public static String sendDateToApi2(String str) {
//        if (str != null && !str.equalsIgnoreCase("null") && str.trim().length() != 0) {
//
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//            SimpleDateFormat sdf2 = new SimpleDateFormat(DATEWITHTIME);
//
//            try {
//
//                Date date = sdf1.parse(str);
//                return sdf2.format(date);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "";
//            }
//        } else {
//            return "";
//        }
//    }*/
//
//    public static String getDateTimeForAPI(String dateFormatted) {
//        Calendar apiDate = Calendar.getInstance();
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//            apiDate.setTime(dateFormat.parse(dateFormatted));
//            Calendar corrTime = Calendar.getInstance();
//            apiDate.set(Calendar.HOUR_OF_DAY, corrTime.get(Calendar.HOUR_OF_DAY));
//            apiDate.set(Calendar.MINUTE, corrTime.get(Calendar.MINUTE));
//            apiDate.set(Calendar.SECOND, corrTime.get(Calendar.SECOND));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        //2014-03-15T21:04:43.162Z
//        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEWITHTIME);
//        return dateFormat.format(apiDate.getTime());
//    }
//
//    public static String getDateForAPP(String strDate) {
//        if (strDate != null && !strDate.equalsIgnoreCase("null") && strDate.trim().length() != 0 && !strDate.equalsIgnoreCase("0000-00-00")) {
//
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEWITHTIME);
//            SimpleDateFormat sdf2 = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//
//            try {
//
//                Date date = sdf1.parse(strDate);
//                return sdf2.format(date);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return strDate;
//            }
//
//
//        } else {
//            if(strDate != null && strDate.equalsIgnoreCase("0000-00-00")){
//                return "00/00/0000";
//            }else {
//                return "";
//            }
//        }
//    }
//
//    public static String getMonthDateForAPP(String strDate) {
//        if (strDate != null && !strDate.equalsIgnoreCase("null") && strDate.trim().length() != 0 && !strDate.equalsIgnoreCase("0000-00-00")) {
//
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEWITHTIME);
//            SimpleDateFormat sdf2 = new SimpleDateFormat(DATEFORMATWITHMONTH);
//
//            try {
//
//                Date date = sdf1.parse(strDate);
//                return sdf2.format(date);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//
//
//        } else {
//            if(strDate != null && strDate.equalsIgnoreCase("0000-00-00")){
//                return "00/00/0000";
//            }else {
//                return "";
//            }
//        }
//    }
//
//    public static String getDateForAPI(String strDate) {
//        if (strDate != null && !strDate.equalsIgnoreCase("null") && strDate.trim().length() != 0) {
//
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEWITHTIME);
//            SimpleDateFormat sdf2 = new SimpleDateFormat(DATEFORMATYYYYMMDD);
//
//            try {
//
//                Date date = sdf1.parse(strDate);
//                return sdf2.format(date);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//
//
//        } else {
//            return "";
//        }
//    }
//
//
//    public static boolean isNetworkAvailable(Context context) {
//        ConnectivityManager cm =
//                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        boolean isConnected = activeNetwork != null &&
//                activeNetwork.isConnectedOrConnecting();
//        return isConnected;
//    }
//
//    public static boolean chkDatePassed(String str1) {
//        try {
//            String strToday = getCurrentDate();
//
//            SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEFORMATYYYYMMDD);
//
//            Date date1 = sdf.parse(str1);
//            Date date2 = sdf1.parse(strToday);
//
//            System.out.println(sdf.format(date1));
//            System.out.println(sdf.format(date2));
//
//            if (date1.before(date2)) {
//                return true;
//            }
//
//
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//    public static boolean chkDateInFuture(String str1) {
//        try {
//            String strToday = getCurrentDate();
//
//            SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEFORMATYYYYMMDD);
//
//            Date date1 = sdf.parse(str1);
//            Date date2 = sdf1.parse(strToday);
//
//            System.out.println(sdf.format(date1));
//            System.out.println(sdf.format(date2));
//
//            if (date1.after(date2)) {
//                return true;
//            }
//
//
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//    public static String getFormatDateAPI(String str) {
//        if (str != null && !str.equalsIgnoreCase("null") && str.trim().length() != 0) {
//
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//            SimpleDateFormat sdf2 = new SimpleDateFormat(DATEFORMATYYYYMMDD);
//
//            try {
//
//                Date date = sdf1.parse(str);
//                return sdf2.format(date);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//
//
//        } else {
//            return "";
//        }
//    }
//
//    public static String getFormatDateAPP(String str) {
//        if (str != null && !str.equalsIgnoreCase("null") && str.trim().length() != 0 && !str.equalsIgnoreCase("0000-00-00")) {
//
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEFORMATYYYYMMDD);
//            SimpleDateFormat sdf2 = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//
//            try {
//
//                Date date = sdf1.parse(str);
//                return sdf2.format(date);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "";
//            }
//
//
//        } else {
//            if(str != null && str.equalsIgnoreCase("0000-00-00")){
//                return "00/00/0000";
//            }else {
//                return "";
//            }
//        }
//    }
//
//    public static String getTimeFromDate(String str){
//        if(str != null && !str.equalsIgnoreCase("null") && str.trim().length()!=0){
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEWITHTIME, Locale.US);
//            SimpleDateFormat sdf2 = new SimpleDateFormat(TIME, Locale.US);
//
//            try {
//                Date date = sdf1.parse(str);
//                return sdf2.format(date);
//            }catch (Exception e){
//                e.printStackTrace();
//                return "";
//            }
//        }else {
//            return " ";
//        }
//    }
//    public static String getDateTimeInDeviceLocale(String date)  {
//        if(date.trim().length()==0 || date.equalsIgnoreCase("null")){
//            return "";
//        }else {
//            Date desiredDate = new Date();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("EST"));
//            try
//            {
//
//                desiredDate = simpleDateFormat.parse(date);
//                TimeZone tz = TimeZone.getDefault();
//                SimpleDateFormat desiredFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                desiredFormat.setTimeZone(tz);
//                desiredFormat.format(desiredDate);
//            }
//            catch (ParseException e)
//            {
//                e.printStackTrace();
//            }
//            return desiredDate.toString();
//        }
//
//    }
//    /*   public static boolean chkDateisBefore(String str1, String str2) {
//           try {
//               SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//               Date date1 = sdf.parse(str1);
//               Date date2 = sdf.parse(str2);
//
//               System.out.println(sdf.format(date1));
//               System.out.println(sdf.format(date2));
//
//               if (date1.before(date2)) {
//                   return true;
//               }
//
//
//           } catch (ParseException ex) {
//               ex.printStackTrace();
//           }
//           return false;
//       }
//   */
//    public static String getCurrentDate() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMATYYYYMMDD, Locale.getDefault());
//        Date date = new Date();
//        return dateFormat.format(date);
//    }
//
//    public static String getCurrentTime() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME, Locale.getDefault());
//        Date date = new Date();
//        return dateFormat.format(date);
//    }
//
//    public static String getCurrentDateUI() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMATDDMMYYYY, Locale.getDefault());
//        Date date = new Date();
//        return dateFormat.format(date);
//    }
//
//
//    public static int getWeek(String strDate) {
//        try {
//            Calendar now = Calendar.getInstance();
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMATDDMMYYYY, Locale.getDefault());
//            Date date = dateFormat.parse(strDate);
//            now.setTime(date);
//            return now.get(Calendar.WEEK_OF_MONTH);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//
//    public static String getCurrentTimeAndDate() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
//        Date date = new Date();
//        return dateFormat.format(date);
//    }
//    public static String getCurrentTimeAndDate2() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//        Date date = new Date();
//        return dateFormat.format(date);
//    }
//
//    public static String getCurrentTimeAndDate3() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
//        Date date = new Date();
//        return dateFormat.format(date);
//    }
//
//    public static void showToast(Context context, String strMsg) {
//        if (context == null) {
//            return;
//        }
//       /* Toast toast = Toast.makeText(context, strMsg, Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.show();*/
//        if(strMsg.toLowerCase().contains("select")){
//            AlertDialog.Builder adb = new AlertDialog.Builder(context);
//            adb.setTitle("User Action Required");
//            adb.setMessage("You need to"+" "+strMsg);
//            adb.setCancelable(false);
//            adb.setNegativeButton("Ok", null);
//            adb.create().show();
//        }else {
//            showAlert(context, "Note", strMsg);
//        }
//    }
//
//    public static void showAlert(FragmentActivity context, String title, String msg) {
//        AlertDialog.Builder adb = new AlertDialog.Builder(context);
//        adb.setTitle(title);
//        adb.setMessage(msg);
//        adb.setCancelable(false);
//        adb.setNegativeButton("Ok", null);
//        adb.create().show();
//    }
//
//    public static String subtract30Years(String strDate) {
//        String strDate30 = "";
//        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//        try {
//            Date date = sdf.parse(strDate);
//            System.out.println(date);
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(date);
//            cal.add(Calendar.YEAR, -30);
//            strDate30 = (String.format("%02d", cal.get(Calendar.DATE)) + "/" + String.format("%02d", cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return strDate30;
//    }
//
//    public static String getLastDateofMonth() {
//
//        try {
//            Calendar cal = Calendar.getInstance();
//            cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
//
//            Date lastDayOfMonth = cal.getTime();
//            SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//            return sdf.format(lastDayOfMonth);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    public static String getFirstDateofMonth() {
//        try {
//
//            Calendar calendar = Calendar.getInstance();
//            calendar.set(Calendar.DAY_OF_MONTH, 1);
//            Date firstDayOfMonth = calendar.getTime();
//
//
//            SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//            return sdf.format(firstDayOfMonth);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    public static boolean chkUIDateIsValid(String strDate) {
//        if (strDate == null || strDate.equalsIgnoreCase("null") || strDate.trim().length() == 0 || strDate.trim().length() > 10) {
//            return false;
//        }
//
//        Date date = null;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//            date = sdf.parse(strDate);
//            if (!strDate.equals(sdf.format(date))) {
//                date = null;
//            }
//        } catch (Exception ex) {
//            // ex.printStackTrace();
//        }
//
//        if (date == null) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    public static boolean validateTime(String strTime) {
//        if (strTime == null || strTime.equalsIgnoreCase("null") || strTime.trim().length() == 0) {
//            return false;
//        }
//
//        Log.w("String time", strTime );
//        Date date = null;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
//            date = sdf.parse(strTime);
//            Log.w("Date time", sdf.format(date));
//            if (!strTime.equals(sdf.format(date))) {
//                date = null;
//            }
//        } catch (Exception ex) {
//            //  ex.printStackTrace();
//        }
//
//        if (date == null) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    public static boolean validateTime2(String strTime) {
//        if (strTime == null || strTime.equalsIgnoreCase("null") || strTime.trim().length() == 0) {
//            return false;
//        }
//
//        Log.w("String time", strTime );
//        Date date = null;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(TIME2);
//            date = sdf.parse(strTime);
//            Log.w("Date time", sdf.format(date));
//            if (!strTime.equals(sdf.format(date))) {
//                date = null;
//            }
//        } catch (Exception ex) {
//            //  ex.printStackTrace();
//        }
//
//        return date != null;
//    }
//
//    public static boolean checkDateinBetween(String strStartDate, String strEndDate, String strDate) {
//        if (strStartDate == null || strStartDate.equalsIgnoreCase("null") || strStartDate.trim().length() == 0 ||
//                strEndDate == null || strEndDate.equalsIgnoreCase("null") || strEndDate.trim().length() == 0 ||
//                strDate == null || strDate.equalsIgnoreCase("null") || strDate.trim().length() == 0) {
//            return false;
//        }
//
//        SimpleDateFormat sdf1 = new SimpleDateFormat(DATEWITHTIME);
//        SimpleDateFormat sdf2 = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//
//        try {
//
//            Date startDate = sdf1.parse(strStartDate);
//            Date endDate = sdf1.parse(strEndDate);
//            Date date = sdf2.parse(strDate);
//
//            return ( date.after(startDate) || date.equals(startDate) )&& date.before(endDate);
//        } catch (Exception ex) {
//            //  ex.printStackTrace();
//        }
//
//        return false;
//    }
//
//    public static HashMap<String, String> getFirstLastDateofYear() {
//        Date now = new Date();
//
//
//        Calendar calendarStart = Calendar.getInstance();
//
//        int year = calendarStart.get(Calendar.YEAR);
//        calendarStart.set(Calendar.YEAR, year);
//        calendarStart.set(Calendar.MONTH, 0);
//        calendarStart.set(Calendar.DAY_OF_MONTH, 1);
//        // returning the first date
//        Date startDate = calendarStart.getTime();
//
//        Calendar calendarEnd = Calendar.getInstance();
//        calendarEnd.set(Calendar.YEAR, year);
//        calendarEnd.set(Calendar.MONTH, 11);
//        calendarEnd.set(Calendar.DAY_OF_MONTH, 31);
//
//        // returning the last date
//        Date endDate = calendarEnd.getTime();
//
//        SimpleDateFormat format1 = new SimpleDateFormat(DATEFORMATYYYYMMDD);
//
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("startdate", format1.format(startDate));
//        hashMap.put("enddate", format1.format(endDate));
//
//        return hashMap;
//    }
//
//    public static HashMap<String, String> getDateofYear() {
//        Date now = new Date();
//        Calendar calendarStart = Calendar.getInstance();
//
//        int year = calendarStart.get(Calendar.YEAR);
//        int lasYear = year - 4;
//
//        calendarStart.set(Calendar.YEAR, lasYear);
//        calendarStart.set(Calendar.MONTH, 0);
//        calendarStart.set(Calendar.DAY_OF_MONTH, 1);
//        // returning the first date
//        Date startDate = calendarStart.getTime();
//
//        Calendar calendarEnd = Calendar.getInstance();
//        calendarEnd.set(Calendar.YEAR, year);
//        calendarEnd.set(Calendar.MONTH, 11);
//        calendarEnd.set(Calendar.DAY_OF_MONTH, 31);
//
//        // returning the last date
//        Date endDate = calendarEnd.getTime();
//
//        SimpleDateFormat format1 = new SimpleDateFormat(DATEFORMATYYYYMMDD);
//
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("startdate", format1.format(startDate));
//        hashMap.put("enddate", format1.format(endDate));
//
//        return hashMap;
//    }
//
//    public static boolean isWeekendDate(String input) {
//
//        String input2 = "";
//        try {
//            SimpleDateFormat inFormat = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//            Date date = inFormat.parse(input);
//            SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
//            input2 = outFormat.format(date);
//            if(input2.equalsIgnoreCase("Sunday") || input2.equalsIgnoreCase("Saturday")){
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//        return false;
//    }
//
//    public static int getDaysBetweenDates(String strDate1, String strDate2){
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMATDDMMYYYY, Locale.getDefault());
//            Date startDate =sdf.parse(strDate1);
//            Date endDate = sdf.parse(strDate2);
//
//            int syear =0 , eyear =0, smonth=0, emonth=0, sday=0, eday=0;
//
//            Calendar sCal = Calendar.getInstance();
//            sCal.setTime(startDate);
//            syear = sCal.get(Calendar.YEAR);
//            smonth = sCal.get(Calendar.MONTH);
//            sday = sCal.get(Calendar.DAY_OF_MONTH);
//
//
//            Calendar eCal = Calendar.getInstance();
//            eCal.setTime(endDate);
//            eyear = eCal.get(Calendar.YEAR);
//            emonth = eCal.get(Calendar.MONTH);
//            eday = eCal.get(Calendar.DAY_OF_MONTH);
//
//            Calendar date1 = Calendar.getInstance();
//            Calendar date2 = Calendar.getInstance();
//
//            date1.clear();
//            date1.set(syear, smonth, sday);
//            date2.clear();
//            date2.set(eyear, emonth, eday);
//
//            long diff = date2.getTimeInMillis() - date1.getTimeInMillis();
//
//            float dayCount = (float) diff / (24 * 60 * 60 * 1000);
//
//            return (int) dayCount;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//        return 0;
//    }
//
//    public static int getWeekDaysBetweenDates(String strDate1, String strDate2){
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMATDDMMYYYY, Locale.getDefault());
//            Date startDate =sdf.parse(strDate1);
//            Date endDate = sdf.parse(strDate2);
//
//
//
//            Calendar sCal = Calendar.getInstance();
//            sCal.setTime(startDate);
//
//            Calendar eCal = Calendar.getInstance();
//            eCal.setTime(endDate);
//
//
//
//            if(sCal.getTimeInMillis() >= eCal.getTimeInMillis()){
//                return 0;
//            }else {
//                int workDays =0;
//
//                do {
//                    if (sCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && sCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
//                        workDays++;
//                        //  Log.w("getWeek: ", String.valueOf(workDays));
//                    }
//                    sCal.add(Calendar.DAY_OF_MONTH, 1);
//                }while (sCal.getTimeInMillis() <= eCal.getTimeInMillis());
//
//                return workDays;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//        return 0;
//    }
//
//    public static int getMonthsBetweenDates(Date startDate, Date endDate) {
//        Calendar cal = Calendar.getInstance();
//        if (startDate.before(endDate)) {
//            cal.setTime(startDate);
//        } else {
//            cal.setTime(endDate);
//            endDate = startDate;
//        }
//        int c = 0;
//        while (cal.getTime().before(endDate)) {
//            cal.add(Calendar.MONTH, 1);
//            c++;
//        }
//        return c - 1;
//    }
//
//    public static String getDateAfterNumberOfDays(String strDate, int num){
//        if (strDate == null || strDate.equalsIgnoreCase("null") || strDate.trim().length() == 0) {
//            return "";
//        }
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMATYYYYMMDD);
//
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(sdf.parse(strDate));
//
//            calendar.add(Calendar.DATE, num);
//
//            Date resultdate = new Date(calendar.getTimeInMillis());
//            return sdf.format(resultdate);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//        return "";
//    }
//
//    public static String getMonthNameFromDate(String strDate){
//        if (strDate == null || strDate.equalsIgnoreCase("null") || strDate.trim().length() == 0) {
//            return "";
//        }
//        try {
//
//            Date date;
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEWITHTIME);
//            date = sdf1.parse(strDate);
//
//            return (String) DateFormat.format("MMM",  date);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    public static String getYearFromDate(String strDate){
//        if (strDate == null || strDate.equalsIgnoreCase("null") || strDate.trim().length() == 0) {
//            return "";
//        }
//        try {
//
//            Date date;
//            SimpleDateFormat sdf1 = new SimpleDateFormat(DATEWITHTIME);
//            date = sdf1.parse(strDate);
//
//            return (String) DateFormat.format("yyyy",  date);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//
//
//    public static String convertStreamtoString(HttpEntity is){
//        String line="";
//        String data="";
//        try{
//            BufferedReader br=new BufferedReader(new InputStreamReader(is.getContent()));
//            while((line=br.readLine())!=null){
//
//                data+=line;
//            }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        return  data;
//    }
//    public static int sortString(String string1, String string2, boolean asc_desc){
//        if(asc_desc){ // ascending order
//            if ((string1==null || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) && (string2==null || string2.trim().length() == 0 || string2.equalsIgnoreCase("null"))) {
//                return 0;
//            } else if (string1==null || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) {
//                return -1;
//            } else if (string2==null || string2.trim().length() == 0 || string2.equalsIgnoreCase("null")) {
//                return 1;
//            }else {
//                return string1.toLowerCase().compareTo(string2.toLowerCase());
//            }
//        }else { //descending order
//            if ((string1 == null || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) && (string2 == null || string2.trim().length() == 0 || string2.equalsIgnoreCase("null"))) {
//                return 0;
//            } else if (string1 == null || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) {
//                return 1;
//            } else if (string2 == null || string2.trim().length() == 0 || string2.equalsIgnoreCase("null")) {
//                return -1;
//            }else {
//                return string2.toLowerCase().compareTo(string1.toLowerCase());
//            }
//        }
//    }
//
//    public static int sortDate(String string1, String string2, boolean asc_desc){
//        try {
//            if(asc_desc){ // ascending order
//                if ((string1==null || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) && (string2==null || string2.trim().length() == 0 || string2.equalsIgnoreCase("null"))) {
//                    return 0;
//                } else if (string1==null || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) {
//                    return -1;
//                } else if (string2==null || string2.trim().length() == 0 || string2.equalsIgnoreCase("null")) {
//                    return 1;
//                }else {
//                    SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//                    Date date1 = dateFormat.parse(string1);
//                    Date date2 = dateFormat.parse(string2);
//
//                    return date1.compareTo(date2);
//
//                }
//            }else { //descending order
//                if ((string1==null || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) && (string2==null || string2.trim().length() == 0 || string2.equalsIgnoreCase("null"))) {
//                    return 0;
//                } else if (string1==null || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) {
//                    return 1;
//                } else if (string2==null || string2.trim().length() == 0 || string2.equalsIgnoreCase("null")) {
//                    return -1;
//                }else {
//                    SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMATDDMMYYYY);
//                    Date date1 = dateFormat.parse(string1);
//                    Date date2 = dateFormat.parse(string2);
//
//                    return date2.compareTo(date1);
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public static int sortDouble(Double string1, Double string2, boolean asc_desc){
//        if(asc_desc){ // ascending order
//            if(string1 > string2){
//                return 1;
//            }else if(string1 < string2){
//                return -1;
//            }else {
//                return 0;
//            }
//        }else { //descending order
//            if(string1 > string2){
//                return -1;
//            }else if(string1 < string2){
//                return 1;
//            }else {
//                return 0;
//            }
//        }
//    }
//    public static int sortTime(String string1, String string2, boolean asc_desc){
//        try {
//            if(asc_desc){ // ascending order
//                if ((string1.equals(null) || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) && (string2.equals(null) || string2.trim().length() == 0 || string2.equalsIgnoreCase("null"))) {
//                    return 0;
//                } else if (string1.equals(null) || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) {
//                    return -1;
//                } else if (string2.equals(null) || string2.trim().length() == 0 || string2.equalsIgnoreCase("null")) {
//                    return 1;
//                }else {
//                    SimpleDateFormat dateFormat = new SimpleDateFormat(TIME);
//                    Date date1 = dateFormat.parse(string1);
//                    Date date2 = dateFormat.parse(string2);
//
//                    return date1.compareTo(date2);
//
//                }
//            }else { //descending order
//                if ((string1.equals(null) || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) && (string2.equals(null) || string2.trim().length() == 0 || string2.equalsIgnoreCase("null"))) {
//                    return 0;
//                } else if (string1.equals(null) || string1.trim().length() == 0 || string1.equalsIgnoreCase("null")) {
//                    return 1;
//                } else if (string2.equals(null) || string2.trim().length() == 0 || string2.equalsIgnoreCase("null")) {
//                    return -1;
//                }else {
//                    SimpleDateFormat dateFormat = new SimpleDateFormat(TIME);
//                    Date date1 = dateFormat.parse(string1);
//                    Date date2 = dateFormat.parse(string2);
//
//                    return date2.compareTo(date1);
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public static boolean confirmAction(Context context,String strTitle, String strBody){
//        confirm = false;
//        final AlertDialog.Builder adb = new AlertDialog.Builder(context);
//        adb.setTitle(strTitle);
//        adb.setMessage(strBody);
//
//        adb.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                confirm = true;
//            }
//        });
//
//        adb.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                confirm = false;
//            }
//        });
//
//        adb.create().show();
//
//        return confirm;
//    }
//
//    public static String encryptText(String plainText, String Constants){
//        String encryptedString = "";
//
//        try {
//            plainText = URLEncoder.encode(plainText, "UTF-8");
//            // Log.e("Encoder", plainText);
//
//            plainText = plainText.replaceAll("\\+"," ");
//            plainText = plainText.replaceAll("%3A", ":");
//            // Log.e("Replaced Encoder", plainText);
//
//            byte[] plaintext = plainText.getBytes();//input
//
//
//
//            // Create hashMD5 of key
//            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
//            digest.update(URLEncoder.encode(Constants, "utf-8").getBytes());
//            byte[] tdesKeyData = digest.digest();// your encryption key
//
//
//            // 3DES Encrypt
//            Cipher c3des = Cipher.getInstance("DESede/ECB/PKCS5Padding");
//            SecretKeySpec myKey = new SecretKeySpec(tdesKeyData, "DESede");
//
//            c3des.init(Cipher.ENCRYPT_MODE, myKey);
//            byte[] cipherText = c3des.doFinal(plaintext);
//
//
//            // Log.e(plainText, new String(cipherText));
//
//            encryptedString = Base64.encodeToString(cipherText, 0, cipherText.length,  Base64.NO_WRAP);
//            encryptedString = encryptedString.replaceAll("'\'", "");
//            // Log.e("encrypted", encryptedString);
//            return encryptedString;
//            // return Base64Coder.encodeString(new String(cipherText));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//        return encryptedString;
//    }
//
////    public static void previewPdf(final Activity act, String url){
////        Dialog dialog = new Dialog(act);
////        dialog.setContentView(R.layout.preview_pdf);
////
////
////        final WebView pdfView = dialog.findViewById(R.id.webview);
////        final ProgressBar pgBar = dialog.findViewById(R.id.pbar);
////
////        WebSettings settings = pdfView.getSettings();
////        settings.setJavaScriptEnabled(true);
////        settings.setBuiltInZoomControls(true);
////        settings.setDisplayZoomControls(false);
////
////        pdfView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
////        final String webUrl = "https://docs.google.com/viewer?url="+url;
////        pdfView.loadUrl(webUrl);
////
////        // Log.w("Link", url);
////        pdfView.setWebViewClient(new WebViewClient(){
////            @Override
////            public boolean shouldOverrideUrlLoading(WebView view, String url){
////                // do your handling codes here, which url is the requested url
////                // probably you need to open that url rather than redirect:
////                Log.w("Link", url);
////                if(url.contains("viewer.googleusercontent.com")){
////                    showAlert(act, "Note","Not Supported");
////                    view.loadUrl(webUrl);
////                    return true;
////                }else {
////                    return false;
////                }
////                // then it is not handled by default action
////            }
////            @Override
////            public void onPageStarted(WebView view, String url, Bitmap favicon)
////            {
////                pdfView.setVisibility(View.GONE);
////                pgBar.setVisibility(View.VISIBLE);
////
////            }
////
////            @Override
////            public void onPageFinished(WebView view, String url)
////            {
////                pgBar.setVisibility(View.GONE);
////                pdfView.setVisibility(View.VISIBLE);
////            }
////        });
////        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
////        dialog.show();
////    }
//
//    public static String getUrlForPrinting(String url){
//        return "https://docs.google.com/viewer?url="+url;
//    }
//
//    public static void copyString(String str, Activity act){
//        int sdk = android.os.Build.VERSION.SDK_INT;
//        if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
//            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) act.getSystemService(Context.CLIPBOARD_SERVICE);
//            clipboard.setText(str);
//        } else {
//            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) act.getSystemService(Context.CLIPBOARD_SERVICE);
//            android.content.ClipData clip = android.content.ClipData.newPlainText("label",str);
//            clipboard.setPrimaryClip(clip);
//        }
//    }
//
//    public static void hideSoftKeyboard(Activity act, View v){
//        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//    }
//
////    public static void exportData(String strReceiverEmail, String strSchoolID, String strSchoolName, String strSchoolEmail,
////                                  final String reportName, String loading, JSONArray exportArray, final Activity act){
////        try {
////            JSONObject objMain = new JSONObject();
////            objMain.put("School_Identifier", strSchoolID);
////            objMain.put("School_Name", strSchoolName);
////            objMain.put("School_Email", strSchoolEmail);
////            if(strReceiverEmail.trim().length()>0){
////                objMain.put("Recepient_Email", strReceiverEmail);
////            }else {
////                objMain.put("Recepient_Email", strSchoolEmail);
////            }
////            objMain.put("Report_Name", reportName);
////
////
////            objMain.put("Items", exportArray);
////            HashMap<String, String> map = new HashMap<>();
////            map.put("url", Constant.URL+"utility/export_data");
////            map.put("body", objMain.toString());
////
////            new ParseController(act, ParseController.HttpMethod.POST, map, true, loading,  new ParseController.AsyncTaskCompleteListener() {
////                @Override
////                public void onSuccess(String response) {
////                    try{
////                        JSONObject obj = new JSONObject(response);
////                        if(obj.has("message")){
////                            Utils.showToast(act,obj.getString("message"));
////                        }else {
////                            Utils.showToast(act, response);
////                        }
////                    }catch (Exception e){e.printStackTrace();}
////                }
////
////                @Override
////                public void onFailed(String msg) {
////                    Utils.showToast(act, msg);
////                }
////            });
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////    }
//
//    public static void animateViewUp(final View view){
//        view.animate()
//                .translationY(-view.getHeight())
//                .setDuration(500)
//                .setListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//                        view.setVisibility(View.GONE);
//
//                        //  llmode.animate().translationX(0);
//                        view.clearAnimation();
//                    }
//                });
//    }
//
//    public static void animateViewDown(final View view){
//        if(view.getVisibility() == View.GONE){
//            view.animate()
//                    .translationY(0)
//                    .setDuration(500)
//                    .setListener(new AnimatorListenerAdapter() {
//                        @Override
//                        public void onAnimationEnd(Animator animation) {
//                            super.onAnimationEnd(animation);
//                            view.clearAnimation();
//                            //  llmode.setVisibility(View.VISIBLE);
//                        }
//                    });
//            view.setVisibility(View.VISIBLE);
//        }
//    }
//
//    public static void dialPhone(Activity act, String number){
//        //String phone = "*110#";
//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
//        act.startActivity(intent);
//    }
//
//    public static String loadLessonNoteJSON(Activity act){
//        String json = null;
//        try {
//            InputStream is = act.getAssets().open("strandJSON.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            json = new String(buffer, "UTF-8");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//
//        return json;
//    }
//
//    public static boolean isFound(String search, ArrayList<HashMap<String, String>> list, String key){
//        boolean isfound = false;
//        for(HashMap<String, String> map : list){
//            if(map.get(key).equalsIgnoreCase(search)){
//                isfound = true;
//                break;
//            }
//        }
//
//        return isfound;
//    }
//
//
//
//}
