package com.example.Erranda;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.iid.FirebaseInstanceId;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class UserPreference {

    private final String PREF_NAME = "user_preference";
    private final String PREF_SCHOOL_ID = "schoolId";
    private final String PREF_SCHOOL_NAME = "schoolName";
    private final String PREF_TOKEN = "token";
    private final String PREF_UserId = "userid";
    private final String PREF_BASE_64 = "base64string";
    private final String PREF_FULLNAME = "fullname";
    private final String PREF_SCHOOL_EMAIL= "schoolEmail";
    private final String URL = "pdfurl";

    private final String PUSHTITLE = "pushTitle";
    private final String PUSHDATA = "pushData";

    private final String TERMCACHE = "termCache";
    private final String CLASSROOMCACHE ="classroomCache";
    private final String COURSECACHE = "courseCache";
    private final String BILLABLE_ITEMS_CACHE = "billableitesmcache";
    private final String GROUPSCACHE = "groupscache";
    private final String TEACHERCACHE = "teachercache";
    private final String EMPLOYEECACHE = "employeeteacher";
    private final String CURRENCYCACHE = "currencycache";
    private final String BRANCHCACHE ="branchcache";
    private final String ACCOUNTYPECACHE ="accounttypecache";
    private final String DEVCATEGORYCACHE ="devcategorycache";
    private final String SIGNATURECACHE =   "signaturecache";
    private final String SCHOOLNETWORKCACHE = "schoolnetworkcache";




    private final String PREF_LAT = "lat";
    private final String PREF_LNG = "lng";

    private final String PREF_USER_NAME = "user_name";
    private final String PREF_USER_PASSWORD = "user_password";
    private SharedPreferences sharedPreferences;

    private final String PREF_ROLE = "userrole";

    private final String PREF_USER_ROLE = "userroleapp";
    private ArrayList<HashMap<String, String>> SCHOOL_ARRAY = new ArrayList<>();
    private final String schoolIdentifier="School_Identifier";
    private final String schoolName = "School_Name";
    private final String schoolEmail = "School_Email";
    private final String branchIndicator = "Branch_Indicator";
    private final String schoolArraySize ="sizeofschoolarray";
    private final String teacherStaffIdentifier = "teacherStaffIdentifier";
    private final String teacherStaff = "teacherStaff";

    // Classroom list
    private ArrayList<HashMap<String, String>> listOfClassroom = new ArrayList<>();
    private final String classArraySize = "classArraySize";

    private final String Classroom_Identifier ="Classroom_Identifier";
    private final String Classroom_Name = "Classroom_Name";
    private final String Classroom_Description ="Classroom_Description";
    private final String Grade_Level = "Classroom_Grade_Level";
    private final String Total_Students = "Total_Students";
    private final String Classroom_Location ="Classroom_Location";
    private final String Status ="Classroom_Status";
    private final String Created_By = "Classroom_Created_By";
    private final String Updated_By ="Classroom_Updated_By";
    private final String Grading_Scale_Type = "Classroom_Grading_Scale_Type";
    private final String Curriculum_Type ="Classroom_Curriculum_Type";
    private final String Classroom_Code ="Classroom_Code";
    private final String Best_Subjects_Core_Count_Total ="Classroom_Best_Subjects_Core_Count_Total";
    private final String Best_Subjects_Elective_Count_Total ="Classroom_Best_Subjects_Elective_Count_Total";
    private final String Level_Name ="Classroom_Level_Name";
    private final String Created_Datetime = "Classroom_Created_Datetime";
    private final String Updated_Datetime = "Classroom_Updated_Datetime";
    private final String School_Identifier = "Classroom_School_Identifier";
    private final String Branch_Identifier = "Classroom_Branch_Identifier";

    //Permission
    private final String PERMISSION_SETTINGS = "permissionsettings";
    private final String PERMISSION_ADMINISTRATION = "permissionadministration";
    private final String PERMISSION_NOTIFICATION = "permissionnotification";
    private final String PERMISSION_COURSEMANAGEMENT = "permissioncoursemanagement";
    private final String PERMISSION_STUDENTMANAGEMENT = "permissionstudentmanagement";
    private final String PERMISSION_STAFFTEACHERMANAGEMENT = "permissionstaffteachermanagement";
    private final String PERMISSION_FINANCIALMANAGEMENT = "permissionfinancialmanagement";
    private final String PERMISSION_CLASSROOMMANAGEMENT = "permissionclassroommanagement";
    private final String PERMISSION_PAYROLLMANAGEMENT ="permissionpayrollmanagement";
    private final String PERMISSION_INVENTORYMANAGEMENT = "PERMISSION_INVENTORYMANAGEMENT";
    private final String PERMISSION_REPORTMANAGEMENT ="permissionreportmanagement";
    private final String PERMISSION_PARENTMESSAGEBOARD = "permissionparentmessageboard";

    // Settings
    private final String PERMISSION_MYPROFILE = "permissionmyprofile";
    private final String PERMISSION_SYNCTOSERVER = "permissionsynctoserver";
    private final String PERMISSION_MYACTIVITY = "permissionmyactivity";
    private final String PERMISSION_LOCALDATACACHE = "permissionlocaldatacache";
    private final String PERMISSION_AUTOSYNCTOSERVER = "permissionautosynctoserver";
    private final String PREF_CACHEDATAALLOW = "usercachedataallow";
    private final String PREF_AUTOSYNCTOSERVER = "autosynctoserver";
    private final String PREF_WEEKUSAGEREPORT = "userweekusagereport";
    private final String PREF_MONTHUSAGEREPORT = "usermonthusagereport";
    private final String PREF_YEARUSAGEREPORT = "useryearusagereport";
    private final String PERMISSION_MYMESSAGES = "permissionmymessages";
    private final String PERMISSION_MYLOGINAUDIT ="permissionmyloginaudit";
    private final String PERMISSION_MYACTIVITYREPORT="permissionmyactivity";

    //Administration && Report
    private final String PERMISSION_GBOOKACCOUNT = "permissiongbookaccount";
    private final String PERMISSION_UPDATESCHOOLPROFILE = "permissionupdateschoolprofile";
    private final String PERMISSION_UPDATEOTHERUSERPROFILE = "permissionupdateotheruserprofile";
    private final String PERMISSION_CREATESTAFFTEACHERLOGIN = "permisssioncreatestaffteacherlogin";
    private final String PERMISSION_SETUPNEWINVOICE = "permissionsetupnewinvoice";
    private final String PERMISSION_SETUPNEWVENDOR = "permissionsetupnewvendor";
    private final String PERMISSION_SETUPNEWEXPENSEACCOUNT = "permissionsetupnewexpenseaccount";
    private final String PERMISSION_GENERATEFINALREPORT = "permissiongeneratefinalreport";
    private final String PERMISSION_GENERATEMANUALFINALREPORT = "permissiongeneratemanualfinalreport";
    private final String PERMISSION_VIEWFINALREPORT = "permissionviewfinalreport";
    private final String PERMISSION_SENDFINALREPORT = "permissionsendfinalreport";
    private final String PERMISSION_SCHOOLNOTIFICATIONHISTORY = "permissionschoolnotificationhistory";
    private final String PERMISSION_ADDNEWSCHOOLTERM = "permissionaddnewschoolterm";
    private final String PERMISSION_SCHOOLTERMREVIEW ="permissionschooltermreview";
    private final String PERMISSION_UPDATESCHOOLTERM = "permissionupdateschoolterm";
    private final String PERMISSION_CREATESCHOOLCALENDAR = "permissioncreateschoolcalendar";
    private final String PERMISSION_MOVESTUDENTS = "permissionmovestudents";
    private final String PERMISSION_NOTIFICATIONSETTINGS = "permissionnotificationsettings";
    private final String PERMISSION_MANAGEMENTDAILYREPORT = "permissionmanagementdailyreport";
    private final String PERMISSION_UPDATEVENDOR = "permissionupdatevendor";
    private final String PERMISSION_SCHOOLCANTEEN = "permissionschoolcanteen";
    private final String PERMISSION_SCHOOLCANTEENREVIEW = "permissionschoolcanteenreview";
    private final String PERMISSION_SCHOOLNOTIFICATIONREPORT = "permissionschoolnotificationreport";
    private final String PERMISSION_APPROVERSIGNATURE ="permissionapproversignature";
    private final String PERMISSION_SCHOOLNOTIFICATIONSUMMARY ="permissionschoolnotificationsummary";
    private final String PERMISSION_SWITCHSCHOOLACCOUNT = "permissionswitchschoolaccount";
    private final String PERMISSION_FINALREPORTSTATUS ="permissionfinalreportstatus";
    private final String PERMISSION_GBOOKSTATUSREVIEW ="permissiongbookstatusreview";
    private final String PERMISSION_RESENDLGLOGIN = "permissionresendlogin";
    private final String PERMISSION_CREATESCHOOLGROUP = "permissioncreateschoolgroup";
    private final String PERMISSION_REVIEWSCHOOLGROUP = "permissionreviewschoolgroup";
    private final String PERMISSION_UPDATESCHOOLGROUP = "permissionupdateschoolgroup";
    private final String PERMISSION_VIEWASSESSMENTREPORT = "permissionviewassessmentreport";
    private final String PERMISSION_SENDPROGRESSREPORT = "permissionsendprogressreport";
    private final String PERMISSION_DAILYATTENDANCESUMMARY = "permissiondailyattendancesummary";
    private final String PERMISSION_BULKPDFSTATUS = "permissionbulkpdfstatus";
    private final String PERMISSION_USERACCOUNTS = "permissionuseraccounts";
    private final String PERMISSION_REVIEWSTUDENTTRANSCRIPT ="permissionreviewstudenttranscript";
    private final String PERMISSION_SCHOOLMESSAGETEMPLATE ="permissionschoolnotificationtemplate";
    private final String PERMISSION_SCHOOLFINANCIALACCOUNT ="permissionschoolfinancialaccount";
    private final String PERMISSION_CREATEPICKUPPERSON ="permissioncreatepickupperson";
    private final String PERMISSION_FINALREPORTGPA ="permissionfinalreportgpa";
    private final String PERMISSION_PROGRESSREPORTGPA ="permissionprogressreportgpa";
    private final String PERMISSION_FINALREPORTQUALITYCHECK ="permissionfinalreportqualitycheck";
    private final String PERMISSION_PUSHNOTIFICATIONSETTINGS ="permissionpushnotificationsettings";
    private final String PERMISSION_REVIEWORGANIZATION = "permissionrevieworganization";
    private final String PERMISSION_CREATEORGANIZATION = "permissioncreateorganization";
    private final String PERMISSION_SCHOOLNETWORK = "permissionschoolnetwork";
    private final String PERMISSION_SETUPSTUDENTINVOICEITEMS ="permissionsetupstudentinvoiceitems";
    private final String PERMISSION_SETUPCLASSROOMINVOICEITEMS ="permissionsetupclassroominvoiceitems";
    private final String PERMISSION_REVIEWSCHOOLINVOICEITEMS ="permissionreviewschoolinvoiceitems";
    private final String PERMISSION_BACKENDSERVICESETTINGS = "permissionbackendservicesettings";
    private final String PERMISSION_CREATESCHOOLGRADINGSCALE ="permissioncreateschoolgradingscale";
    private final String PERMISSION_BECEFORCASTER = "permissionbeceforcaster";
    private final String PERMISSION_FINALREPORTANALYSIS ="permissionfinalreportanalysis";

    // Course
    private final String PERMISSION_NEWCOURSESETUP = "permissionnewcoursesetup";
    private final String PERMISSION_SHOWAVAILABLECOURSE = "permissionshowavailablecourse";
    private final String PERMISSION_COURSETEACHERLINK ="permissioncourseteacherlink";
    private final String PERMISSION_UPDATECOURSE = "permissionupdatecourse";

    //Student
    private final String PERMISSION_ENROLLMENT = "permissionenrollment";
    private final String PERMISSION_STUDENTSEARCH = "permissionstudentsearch";
    private final String PERMISSION_STUDENTPOPULATIONS = "permissionstudentpopulations";
    private final String PERMISSION_SEARCHINACTIVESTUDENTS = "permissionsearchinactivestudents";
    private final String PERMISSION_STUDENTSBYGROUP ="permissionstudentsbygroup";
    private final String PERMISSION_STUDENTADMISSIONREPORT ="permissionstudentadmissionreport";
    private final String PERMISSION_ASSIGNSTUDENTGROUP ="permissionassignstudentgroup";
    private final String PERMISSION_MOVESTUDENTGROUP = "permissionmovestudentgroup";
    private final String PERMISSION_REMOVESTUDENTFROMGROUP = "permissionremovestudentfromgroup";
    private final String PERMISSION_ASSIGNSTUDENTCOURSE = "permissionassignstudentcourse";
    private final String PERMISSION_STUDENTBYCOURSE = "permissionstudentbycourse";
    private final String PERMISSION_MOVESTUDENTCOURSE = "permissionmovestudentcourse";
    private final String PERMISSION_REMOVESTUDENTCOURSE = "permissionremovestudentcourse";
    private final String PERMISSION_STUDENTAWARD ="permissionstudentaward";
    private final String PERMISSION_REVIEWSTUDENTAWARD ="permissionreviewstudentaward";
    private final String PERMISSION_UPDATESTUDENTAWARD ="permissionupdatestudentaward";
    private final String PERMISSION_CREATESTUDENTTRANSCRIPT ="permissioncreatestudenttranscript";
    private final String PERMISSION_STUDENTTRANSCRIPTSTATUS ="permissionstudenttranscriptstatus";
    private final String PERMISSION_UPDATESTUDENTTRANSCRIPT ="permissionupdatestudenttranscript";
    private final String PERMISSION_STUDENTTRANSCRIPTEXPORT ="permissionstudenttranscriptexport";
    private final String PERMISSION_CREATEIGCSETRANSCRIPT ="permissioncreateigcsetranscript";
    private final String PERMISSION_PICKUPANDROPOFF ="permissionpickupandropoff";
    private final String PERMISSION_STUDENTDAILYACTIVITY ="permissionstudentdailyactivity";
    private final String PERMISSION_REVIEWSTUDENTDAILYACTIVITY ="permissionreviewstudentdailyactivity";
    private final String PERMISSION_ADDSTUDENTMEDICALCONDITION = "permissionaddstudentmedicalcondition";
    private final String PERMISSION_UPDATESTUDENTMEDICALCONDITION ="permissionupdatestudentmedicalcondition";
    private final String PERMISSION_STUDENTMEDICALHISTORY = "permissionstudentmedicalhistory";
    private final String PERMISSION_STUDENTPICKUPDROPOFFLOG = "permissionpickupdropofflog";
    private final String PERMISSION_SENDSTUDENTTRANSCRIPTNOTIFICATION = "permissionsendstudenttranscriptnotification";

    //Teacher & Staff
    private final String PERMISSION_NEWTEACHERSETUP = "permissionnewteachersetup";
    private final String PERMISSION_NEWSTAFFSETUP = "permissionstaffsetup";
    private final String PERMISSION_STAFFNOTICE = "permissionstaffnotice";
    private final String PERMISSION_TEACHERPERFORMANCE = "permissionteacherperformance";
    private final String PERMISSION_TEACHERATTENDANCE = "permissionteacherattendance";
    private final String PERMISSION_RECORDSTAFFTEACHERATTENDANCE = "permissionrecordstaffteacherattendance";
    private final String PERMISSION_REVIEWSTAFFTEACHERATTENDANCE = "permissionreviewstaffteacherattendance";
    private final String PERMISSION_STAFFTEACHERBYGROUP = "permissionstaffteaherbygroup";
    private final String PERMISSION_MOVESTAFFTEACHERGROUP = "permissionmovestaffteachergroup";
    private final String PERMISSION_ASSIGNSTAFFTEACHERGROUP = "permissionassignstaffteachergroup";
    private final String PERMISSION_REMOVESTAFFTEACHERGROUP = "permissionremovestaffteachergroup";
    private final String PERMISSION_SEARCHINACTIVEEMPLOYEES = "permissionsearchinactiveemployees";
    private final String PERMISSION_LESSONNOTES = "permissionlessonnotes";
    private final String PERMISSION_LESSONNOTESHEADTEACHER ="permissionlessonnotesheadteacher";
    private final String PERMISSION_EMPLOYEESETUP = "permissionemployeesetup";
    private final String PERMISSION_UPDATELESSONNOTES ="permissionupdatelessonnotes";
    private final String PERMISSION_REVIEWLESSONNOTES = "permissionreviewlessonnotes";
    private final String PERMISSION_EMPLOYEELOGINAUDIT ="permissionemployeeloginaduit";
    private final String PERMISSION_EMPLOYEEACTIVITYREPORT ="permissionemployeeactivityreport";
    private final String PERMISSION_EMPLOYEEGROUP ="permissionemployeegroup";
    private final String PERMISSION_EMPLOYEEACCOUNTSTATUS ="permissionemployeeaccountstatus";
    private final String PERMISSION_WEEKLYWORKPLAN = "permissionweeklyworkplan";
    private final String PERMISSION_WEEKLYWORKPLANREVIEW ="permissionweeklyworkplanreview";
    private final String PERMISSION_UPDATEWEEKLYWORKPLAN ="permissionupdateweeklyworkplan";


    // Financial
    private final String PERMISSION_CREATEINVOICEBILL = "permissioncreateinvoicebill";
    private final String PERMISSION_CREATESELECTIVEINVOICEBILL = "permissioncreateselectiveinvoicebill";
    private final String PERMISSION_PAYINVOICEBILL = "permissionpayinvoicebill";
    private final String PERMISSION_ONDEMANDPAYMENT = "permissionondemandpayment";
    private final String PERMISSION_RECORDEXPENSE = "permissionrecordexpense";
    private final String PERMISSION_INVOICEBILLREPORT = "permissioninvoicebillreport";
    private final String PERMISSION_SCHOOLREVENUEREPORT = "permissionschoolrevenuereport";
    private final String PERMISSION_SCHOOLREVENUEDETAILSPOPUP = "permissionschoolrevenuedetailspopup";
    private final String PERMISSION_SCHOOLEXPENSEREPORT = "permissionschoolexpensereport";
    private final String PERMISSION_PAYINVOICEBILLITEM = "permissionpayinvoicebillitem";

    private final String PERMISSION_REVENUEEXPENSEREPORT = "permissionrevenueexpensereport";
    private final String PERMISSION_PAYROLLREPORT = "permissionpayrollreport";
    private final String PERMISSION_CASHFLOWSSTATEMENT = "permissioncashflowstatement";
    private final String PERMISSION_BALANCESHEET = "permissionbalancesheet";
    private final String PERMISSION_PROFITLESSSTATEMENT = "permissionprofitlessstatement";
    private final String PERMISSION_UPDATEPAYMENTDETAILS = "permissionupdatepaymentdetails";
    private final String PERMISSION_UPDATEBILLDETAILS = "permissionupdatebilldetails";
    private final String PERMISSION_UNBILLEDSTUDENTS = "permissionunbilledstudents";
    private final String PERMISSION_BILLITEMPAYMENTHISTORY = "permissionbillitempaymenthistory";
    private final String PERMISSION_BILLITEMINVOICEBILLREPORT = "permissionbilliteminvoicebillreport";
    private final String PERMISSION_BADDEBTSREPORT = "permissionbaddebtsreport";
    private final String PERMISSION_BANKACTIVITYREPORT ="permissionbankactivityreport";
    private final String PERMISSION_SENDEDITBILLNOTIFICATION ="permissionsendeditbillnotification";
    private final String PERMISSION_RESENDBILLNOTIFICATION = "permissionresendbillnotification";
    private final String PERMISSION_RESENDPAYMENTNOTIFICATION ="permissionresendpaymentnotification";
    private final String PERMISSION_EXPORTDATA = "permissionexportdata";
    private final String PERMISSION_DELETEUNPAIDBILLS = "permissiondeleteunpaidbills";
    private final String PERMISSION_ADVANCEPAYMENTREPORT ="permissionadvancepaymentreport";
    private final String PERMISSION_COPYBILL = "permissioncopybill";
    private final String PERMISSION_SENDBILLNOTIFICATION ="permissionsendbillnotification";
    private final String PERMISSION_SELECTIVEONDEMANDPAYMENT = "permissionselectiveondemandpayment";
    private final String PERMISSION_VIEWPATMENTRECEIPT ="permissonviewpaymentreceipt";
    private final String PERMISSION_PAYMENTS = "permissionpayments";
    private final String PERMISSION_LINEITEMONDEMANDPAYMENT ="lineitemondemandpayment";
    private final String PERMISSION_UPDATEMULTIPLELINEITEMS ="permissionupdatemultiplelineitems";
    private final String PERMISSION_PROFITANDLOSSEXPORT ="permissionprofitandlossexport";
    private final String PERMISSION_FINANCIALREPORTS ="permissionfinancialreports";
    private final String PERMISSION_FINANCIALSTATEMENTS ="permissionfinancialstatements";
    private final String PERMISSION_DAILYFEERECON ="permissiondailyfeerecon";
    private final String PERMISSION_PAYEXPENSE = "permissionpayexpense";
    private final String PERMISSION_DELETEUNPAIDEXPENSE = "permissiondeleteunpaidexpense";
    private final String PERMISSION_PAYMENTHISTORY = "permissionpaymenthistory";
    private final String PERMISSION_FUNDSTRANSFER = "permissionfundstransfer";
    private final String PERMISSION_FINANCIALACCOUNTHISTORY ="permissionfinancialaccounthistory";
    private final String PERMISSION_FUNDSTRANSFERREPORT = "permissionfundstransferreport";
    private final String PERMISSION_RECORDREVENUE = "permissionrecordrevenue";
    private final String PERMISSION_STUDENTFINANCIALSTATEMENT = "permissionstudentfinancialstatement";
    private final String PERMISSION_RECEIVEREVENUE = "permissionreceiverevenue";
    private final String PERMISSION_VOUCHERREPORT = "permissionvoucherreport";
    private final String PERMISSION_VOUCHERREPORTBUTTON = "permissionvoucherreportbutton";
    private final String PERMISSION_DAILYTRANSACTIONREPORT = "permissionfundstransfer";
    private final String PERMISSION_DELETEEXPENSE = "permissiondeleteexpense";
    private final String PERMISSION_SCHOOLREVENUESUMMARYREPORT ="permissionschoolrevenuesummaryreport";
    private final String PERMISSION_STUDENTBALANCES ="permissionstudentbalances";
    private final String PERMISSION_CHARTOFACCOUNTS ="permissionchartofaccounts";
    private final String PERMISSION_DAILYFINANCIALSUMMARY ="permissiondailyfinancicalsummary";
    private final String PERMISSION_BULKSTUDENTBILLING ="permissonbulkstudentbilling";
    private final String PERMISSION_FIXEDASSET = "permissionfixedasset";
    private final String PERMISSION_FIXEDASSETREPORT ="permissionfixedassetreport";
    private final String PERMISSION_DEPRECIATIONSCHEDULE ="permissiondepreciationschedule";
    private final String PERMISSION_UPDATEDEPRECIATIONSCHEDULE ="permissionupdatedepreciationschedule";
    private final String PERMISSION_FINANCIALACCOUNTBALANCE ="permissionfinancialaccountbalance";

    // Payroll
    private final String PERMISSION_CREATEEMPLOYEEPAYROLL ="createemployeepayroll";
    private final String PERMISSION_CREATEEMPLOYEEPAYROLLDETAILS = "createdemployeepayrolldetails";
    private final String PERMISSION_REVIEWEMPLOYEEPAYROLLDETAILS ="reviewemployeepayrolldetails";
    private final String PERMISSION_UPDATEEMPLOYEEPAYROLLDETAILS = "reviewemployeepayrolldetails";
    private final String PERMISSION_CREATEPAYROLLDEDUCTADD = "createpayrolldeductadd";
    private final String PERMISSION_REVIEWPAYROLLDEDUCTADD = "reviewpayrolldeductadd";
    private final String PERMISSION_UPDATEPAYROLLDEDUCTADD = "updatepayrolldeductadd";
    private final String PERMISSION_REVIEWEMPLOYEEPAYROLL = "reviewemployeepayroll";
    private final String PERMISSION_GENERATEPAYSLIPPDF = "permissiongeneratepayslipdf";
    private final String PERMISSION_SENDPAYROLLNOTIFICATION ="permissionsendpayrollnotification";
    private final String PERMISSION_PAYROLLSUMMARRYREPORT ="permissionpayrollsumarryreport";
    private final String PERMISSION_PAYROLLSUMMARRYREPORT_NNS = "permissionpayrollsummaryreportnns";
    private final String PERMISSION_BULKPAYROLLPROCESSING = "permissionbulkpayrollprocessing";
    private final String PERMISSION_EMPLOYEEADDITIONDEDUCTION ="permissionemployeeadditiondeduction";
    private final String PERMISSION_RECORDLOAN = "permissionrecordloan";
    private final String PERMISSION_SETUPEMPLOYEELOANTERMS ="permissionsetupemployeeloanterms";
    private final String PERMISSION_PAYROLLPAYMENT ="permissionpayrollpayment";
    private final String PERMISSION_PAYROLLREPORTSEXPORT = "permissionpayrollreportsexport";

    //classroom
    private final String PERMISSION_NEWCLASSROOMSETUP = "permissionnewclassroomsetup";
    private final String PERMISSION_ATTENDANCE = "permissionattendance";
    private final String PERMISSION_GRADES = "permissiongrades";
    private final String PERMISSION_CLASSROOMNOTIFICATION = "permissionclassroomnotification";
    private final String PERMISSION_STUDENTSBYCLASSROOM = "permissionstudentsbyclassroom";
    private final String PERMISSION_RAWGRADERECORDING = "permissionrawgraderecording";
    private final String PERMISSION_GRADESREVIEW = "permissiongradereview";
    private final String PERMISSION_CLASSNOTIFICATIONHISTORY = "permissionclassnotificationhistory";
    private final String PERMISSION_SENDGRADENOTIFICATION = "permissionsendgradenotification";
    private final String PERMISSION_SENDRAWGRADENOTIFICATION = "permissionsendrawgradenotification";
    private final String PERMISSION_MANUALFINALMARKENTRY = "permissionmanualfinalmarkentry";
    private final String PERMISSION_MANUALFINALMARKREVIEW = "permissionmanualfinalmarkreview";
    private final String PERMISSION_EDITGRADE = "permissioneditgrade";
    private final String PERMISSION_ATTENDANCESUMMARYREPORT = "permissionattendancesummaryreport";
    private final String PERMISSION_SENDATTENDANCENOTIFICATION = "permissionsendattendancenotification";
    private final String PERMISSION_SENDBEHAVIORNOTIFICATION ="permissionsendbehaviornotification";
    private final String PERMISSION_ADDADDITIONALDETAILS = "permissionaddadditionaldetails";
    private final String PERMISSION_STUDENTMINIPROFILE = "PERMISSION_STUDENTMINIPROFILE";
    private final String PERMISSION_CREATECLASSROOMSCHEDULE = "PERMISSION_CREATECLASSROOMSCHEDULE";
    private final String PERMISSION_UPDATECLASSROOMSCHEDULE = "PERMISSION_UPDATECLASSROOMSCHEDULE";
    private final String PERMISSION_CLASSROOMSCHEDULEREVIEW = "PERMISSION_CLASSROOMSCHEDULEREVIEW";
    private final String PERMISSION_CLASSROOMREVIEW = "permissionclassroomreivew";
    private final String PERMISSION_UPDATECLASSROOM = "permissionupdateclassroom";
    private final String PERMISSION_CLASSPERFORMANCEREPORT = "permissionclassperformancereport";
    private final String PERMISSION_ASSIGNGRADE = "permissionassigngrade";
    private final String PERMISSION_RESENDGRADENOTIFICATION = "permissionresendgradenotification";
    private final String PERMISSION_ATTENDANCEREVIEW = "PERMISSION_ATTENDANCEREVIEW";
    private final String PERMISSION_ATTENDANCEUPDATE ="permissionattendanceupdate";
    private final String PERMISSION_ATTENDANCEBYSUBJECTREVIEW ="permissionattendancebysubjectreview";
    private final String PERMISSION_ATTENDANCEBYSUBJECTUPDATE ="permissionattendancebysubjectupdate";
    private final String PERMISSION_DELETEGRADES = "permissiondeletegrades";
    private final String PERMISSION_DELETEATTENDANCE ="permissiondeleteattendance";
    private final String PERMISSION_STUDENTFINALMARKREVIEW ="permissionstudentfinalmarkreview";
    private final String PERMISSION_GENERATEPROGRESSREPORT = "permissiongenerateprogressreport";
    private final String PERMISSION_REVIEWPROGRESSREPORT = "permissionreviewprogressreport";
    private final String PERMISSION_EDITPROGRESSREPORT = "permissioneditprogressreport";
    private final String PERMISSION_COPYCLASSROOMSCHEDULE ="permissioncopyclassroomschedule";
    private final String PERMISSION_COPYSCHOOLCANTEEN ="permissioncopyschoolcanteen";



    private final String PERMISSION_RECORDSTUDENTFINALGRADE = "permissionrecordstudentfinalgrade";
    private final String PERMISSION_RECORDSTUDENTBEHAVIOR = "permissionrecordstudentbehavior";
    private final String PERMISSION_RECORDSTUDENTPROFILE = "permissionrecordstudentprofile";
    private final String PERMISSION_REVIEWSTUDENTFINALGRADE = "permissionreviewstudentfinalgrade";
    private final String PERMISSION_REVIEWSTUDENTBEHAVIOR = "permissionreviewstudentbehavior";
    private final String PERMISSION_REVIEWSTUDENTATTENDANCE = "permissionreviewstudentattendance";
    private final String PERMISSION_REVIEWSTUDENTGRADES = "permissionreviewstudentgrades";
    private final String PERMISSION_DELETEBEHAVIOR = "permissiondeletebehavior";


    private final String PERMISSION_CRECHENURSERYMANAGEMENT = "premissioncreachenurserymanagemnt";
    private final String PERMISSION_CHILDDEVELOPMENTASSESSMENT = "permissionchilddevelopmentassessment";
    private final String PERMISSION_NURSERYCRECHEGRADERECORDING = "premissionnurserycrechegraderecording";
    private final String PERMISSION_NURSERYCRECHEGRADERECORDINGREVIEW = "permissionnurserycrechegraderecordingreview";
    private final String PERMISSION_NURSERYCRECHEGRADERECORDINGEDIT = "permissionnurserycrechegraderecordingedit";
    private final String PERMISSION_CRECHEASSESSMENTREVIEW = "PERMISSION_CRECHEASSESSMENTREVIEW";
    private final String PERMISSION_CRECHEASSESSMENTEDIT = "permissioncrecheassessmenteedit";
    private final String PERMISSION_CHILDASSESSMENTREVIEW = "PERMISSION_CHILDASSESSMENTREVIEW";
    private final String PERMISSION_DELETECHILDASSESSMENT = "permissiondeletechildassessment";
    private final String PERMISSION_ADDCHILDASSESSMENTCATEGORY ="permissoinaddchildassessmentcategory";
    private final String PERMISSION_DEVELOPMENTCATEGORYREVIEW ="permissiondevelopmentcategoryreview";
    private final String PERMISSION_ASSIGNCLASSCATEGORY ="permissionassignclasscategory";
    private final String PERMISSION_UPDATECHILDDEVELOPMENTCATEGORY ="permissionupdatechilddevelopmentcategory";
    private final String PERMISSION_CHILDASSESSMENTREPORT = "permissionchildassessmentreport";
    private final String PERMISSION_CHILDASSESSMENTNOTIFICATION ="permissionchildassessmentnotification";


    private final String PERMISSION_STUDENTPROFILE = "permissionstudentprofile";
    private final String PERMISSION_UPDATESTUDENTPROFILE = "permissionupdatestudentprofile";

    // Inventory
    private final String PERMISSION_RECORDINVENTORY = "PERMISSION_RECORDINVENTORY";
    private final String PERMISSION_INVENTORYITEMS = "permissioninventoryitems";
    private final String PERMISSION_INVENTORYCATEGORIES = "permissioninventorycategories";
    private final String PERMISSION_CREATEINVENTORYCATEGORY = "permissioncreateinventorycategory";
    private final String PERMISSION_UPDATEINVENTORYITEM = "permissionupdateinventoryitem";
    private final String PERMISSION_UPDATEINVENTORYCATEGORY = "permissionupdateinventorycategory";

    // Export Buttons
    private final String PERMISSION_PAYMENTHISTORYEXPORT ="permissionpaymenthistoryexport";
    private final String PERMISSION_INVOICEBILLLEXPORT ="permissioninvoicebillexport";
    private final String PERMISSION_BILLITEMINVOICEEXPORT ="permissionbillitemnvoiceexport";
    private final String PERMISSION_BILLITEMPAYMENTEXPORT = "permissionbillitempayment";
    private final String PERMISSION_SCHOOLREVENUEEXPORT = "permissionschoolrevenueexport";
    private final String PERMISSION_SCHOOLEXPENSEEXPORT = "permissionschoolexpenseexport";
    private final String PERMISSION_CASHFLOWEXPORT = "permissioncashflowexport";
    private final String PERMISSION_ADVANCEPAYMENTEXPORT ="permissionadvancepaymentexport";
    private final String PERMISSION_UNBILLEDSTUDENTSEXPORT ="permissionunbilledstudentexport";
    private final String PERMISSION_BADDEPTSEXPORT = "permissionbaddepts";
    private final String PERMISSION_BANKACTIVITIESEXPORT ="permissionbankactivitiesexport";
    private final String PERMISSION_FINALREPORTEXPORT ="permissionreportexport";
    private final String PERMISSION_PROGRESSREPORTEXPORT ="permissionprogressreportexport";
    private final String PERMISSION_GENERATEPAYSLIPEXPORT ="permissiongeneratepayslipexport";
    private final String PERMISSION_PAYROLLSUMMARYEXPORT ="permissionpayrollsummaryexport";
    private final String PERMISSION_ATTENDANCEEXPORT ="permissionattendanceexport";
    private final String PERMISSION_GRADEEXPORT ="permissiongradeexport";
    private final String PERMISSION_STUDENTBYCLASSEXPORT ="permissionstudentbyclassexport";
    private final String PERMISSION_CLASSROOMREVIEWEXPORT = "permissionclassroomreviewexport";


    private final String PERMISSION_PROGRESSREPORTSTATUS ="permissionprogressreportstatus";
    private final String PERMISSION_VIEWPROGRESSREPORT ="permissionviewprogressreport";
    private final String PERMISSION_STUDENTPROMOTION ="permissionstudentpromotion";

    private final String PERMISSION_BUYSMSREQUESTSUPPORT = "permissionbuysmsrequestsupport";
    private final String PERMISSION_BUYSMSEMAIL = "permissionbuysmsemail";
    private final String PERMISSION_REQUESTSUPPORT ="permissionrequestemail";


    private final String SCHOOL_NOTIFICATION_MESSAGE_COPY = "schoolnotificationmessagecopy";


    private final String PREF_USERPROFILE = "userprofile";






    public UserPreference(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME,
                Context.MODE_PRIVATE);
    }

    public Editor getEditor() {
        Editor editor = sharedPreferences.edit();
        return editor;
    }

    public SharedPreferences getPref() {
        return sharedPreferences;
    }

    public boolean getPERMISSION_STUDENTPROFILE() {
        return sharedPreferences.getBoolean(PERMISSION_STUDENTPROFILE, false);
    }


    public ArrayList<HashMap<String, String>> getSCHOOL_ARRAY() {
        SCHOOL_ARRAY.clear();
        int size = sharedPreferences.getInt(schoolArraySize,0);
        for(int i=0;i<size;i++){
            HashMap<String, String> map = new HashMap<>();
            map.put("School_Identifier",sharedPreferences.getString(schoolIdentifier+"_"+i,null));
            map.put("School_Name", sharedPreferences.getString(schoolName+"_"+i, null));
            map.put("School_Email", sharedPreferences.getString(schoolEmail+"_"+i, null));
            map.put("Branch_Indicator", sharedPreferences.getString(branchIndicator+"_"+i, null));
            map.put("ischecked","false");
            SCHOOL_ARRAY.add(map);
        }
        return SCHOOL_ARRAY;
    }
    public void setSCHOOL_ARRAY(ArrayList<HashMap<String, String>> map, int size){
        Editor editor = getEditor();
        editor.putInt(schoolArraySize, size);
        for(int i=0;i<size;i++){
            HashMap<String, String> map2 = map.get(i);
            editor.putString(schoolIdentifier+"_"+i, map2.get("School_Identifier"));
            editor.putString(schoolName+"_"+i, map2.get("School_Name"));
            editor.putString(schoolEmail+"_"+i, map2.get("School_Email"));
            editor.putString(branchIndicator+"_"+i, map2.get("Branch_Indicator"));
        }
        editor.commit();
        // SCHOOL_ARRAY.add(map);
    }

    // set Teacher and Staff Id
    public String getTeacherStaffIdentifier(){return sharedPreferences.getString(teacherStaffIdentifier, "");}

    public void setTeacherStaffIdentifier(String teacherStaffIdentifier){
        Editor editor= getEditor();
        editor.putString(this.teacherStaffIdentifier, teacherStaffIdentifier);
        editor.commit();
    }

    public String getTeacherStaff(){return sharedPreferences.getString(teacherStaff, "");}

    public void setTeacherStaff(String teacherStaff){
        Editor editor= getEditor();
        editor.putString(this.teacherStaff, teacherStaff);
        editor.commit();
    }

    // Term Cache
    public String getTermCache(){
        return sharedPreferences.getString(TERMCACHE,"");
    }

    public void setTermCache(String termCache){
        Editor editor = getEditor();
        editor.putString(TERMCACHE,termCache);
        editor.commit();
    }

    // Billable Items Cache
    public String getbillabeItemsCache(){
        return sharedPreferences.getString(BILLABLE_ITEMS_CACHE,"");
    }

    public void setBillableItemsCache(String billableItemsCache){
        Editor editor = getEditor();
        editor.putString(BILLABLE_ITEMS_CACHE,billableItemsCache);
        editor.commit();
    }

    // School Groups Cache
    public String getGroupCache(){
        return sharedPreferences.getString(GROUPSCACHE,"");
    }

    public void setGroupCache(String groupCache){
        Editor editor = getEditor();
        editor.putString(GROUPSCACHE,groupCache);
        editor.commit();
    }


    // Classroom Cache
    public String getClassroomCache(){
        return sharedPreferences.getString(CLASSROOMCACHE,"");
    }

    public void setClassroomCache(String classroomCache){
        Editor editor = getEditor();
        editor.putString(CLASSROOMCACHE,classroomCache);
        editor.commit();

    }// Teachers Cache
    public String getTeacherCache(){
        return sharedPreferences.getString(TEACHERCACHE,"");
    }

    public void setTeacherCache(String teacherCache){
        Editor editor = getEditor();
        editor.putString(TEACHERCACHE,teacherCache);
        editor.commit();
    }

    // Employee code

    public String getEmployeeCache(){
        return sharedPreferences.getString(EMPLOYEECACHE,"");
    }

    public void setEmployeeCache(String employeeCache){
        Editor editor = getEditor();
        editor.putString(EMPLOYEECACHE,employeeCache);
        editor.commit();
    }
    // course Cache
    public void setCOURSECACHE(String coursecache){
        Editor editor= getEditor();
        editor.putString(COURSECACHE, coursecache);
        editor.commit();
    }

    public String getCOURSECACHE(){
        return sharedPreferences.getString(COURSECACHE, "");
    }

    public void setCurrencyCache(String currencyCache){
        Editor editor = getEditor();
        editor.putString(CURRENCYCACHE, currencyCache);
        editor.commit();
    }

    public String getCurrencyCache(){
        return  sharedPreferences.getString(CURRENCYCACHE, "");
    }

    // branch cache
    public void setBranchCache(String branchCache){
        Editor editor = getEditor();
        editor.putString(BRANCHCACHE, branchCache);
        editor.commit();
    }

    public String getBranchCache(){
        return  sharedPreferences.getString(BRANCHCACHE, "");
    }

    // Account Type Cache

    public void setAccountTypeCache(String accountTypeCache){
        Editor editor = getEditor();
        editor.putString(ACCOUNTYPECACHE, accountTypeCache);
        editor.commit();
    }

    public String getAccountTypeCache(){
        return  sharedPreferences.getString(ACCOUNTYPECACHE, "");
    }

    // Child Dev Category
    public void setDevCategoryCache(String devCategoryCache){
        Editor editor = getEditor();
        editor.putString(DEVCATEGORYCACHE, devCategoryCache);
        editor.commit();
    }

    public String getDevCategoryCache(){
        return  sharedPreferences.getString(DEVCATEGORYCACHE, "");
    }

    // Signature Cache
    public void setSignatureCache(String signatureCache){
        Editor editor = getEditor();
        editor.putString(SIGNATURECACHE, signatureCache);
        editor.commit();
    }

    public String getSignatureCache(){
        return  sharedPreferences.getString(SIGNATURECACHE, "");
    }

    // School Network Cache
    public void setSchoolNetworkCache(String signatureCache){
        Editor editor = getEditor();
        editor.putString(SCHOOLNETWORKCACHE, signatureCache);
        editor.commit();
    }

    public String getSchoolNetworkCache(){
        return  sharedPreferences.getString(SCHOOLNETWORKCACHE, "");
    }

    // classroom list
    public ArrayList<HashMap<String, String>> getListOfClassroom() {
        listOfClassroom.clear();
        int size = sharedPreferences.getInt(classArraySize,0);
        for(int i=0;i<size;i++){
            HashMap<String, String> map = new HashMap<>();
            map.put("Classroom_Identifier",sharedPreferences.getString(Classroom_Identifier+"_"+i,"0"));
            map.put("Classroom_Name", sharedPreferences.getString(Classroom_Name+"_"+i, ""));
            map.put("Classroom_Description",sharedPreferences.getString(Classroom_Description+"_"+i,""));
            map.put("Grade_Level", sharedPreferences.getString(Grade_Level+"_"+i, ""));
            map.put("Total_Students",sharedPreferences.getString(Total_Students+"_"+i,"0"));
            map.put("Classroom_Location", sharedPreferences.getString(Classroom_Location+"_"+i, ""));
            map.put("Status",sharedPreferences.getString(Status+"_"+i,""));
            map.put("Created_By", sharedPreferences.getString(Created_By+"_"+i, ""));
            map.put("Updated_By",sharedPreferences.getString(Updated_By+"_"+i,""));
            map.put("Grading_Scale_Type", sharedPreferences.getString(Grading_Scale_Type+"_"+i, ""));
            map.put("Curriculum_Type",sharedPreferences.getString(Curriculum_Type+"_"+i,""));
            map.put("Classroom_Code", sharedPreferences.getString(Classroom_Code+"_"+i, ""));
            map.put("Best_Subjects_Core_Count_Total",sharedPreferences.getString(Best_Subjects_Core_Count_Total+"_"+i,""));
            map.put("Best_Subjects_Elective_Count_Total", sharedPreferences.getString(Best_Subjects_Elective_Count_Total+"_"+i, ""));
            map.put("Level_Name",sharedPreferences.getString(Level_Name+"_"+i,""));
            map.put("Created_Datetime", sharedPreferences.getString(Created_Datetime+"_"+i, ""));
            map.put("Updated_Datetime", sharedPreferences.getString(Updated_Datetime+"_"+i, ""));
            map.put("School_Identifier",sharedPreferences.getString(School_Identifier+"_"+i,""));
            map.put("Branch_Identifier", sharedPreferences.getString(Branch_Identifier+"_"+i, ""));


            listOfClassroom.add(map);
        }
        return listOfClassroom;
    }
    public void setListOfClassroom(ArrayList<HashMap<String, String>> map, int size){
        Editor editor = getEditor();
        editor.putInt(classArraySize, size);
        for(int i=0;i<size;i++){
            HashMap<String, String> map2 = map.get(i);
            editor.putString(Classroom_Identifier+"_"+i, map2.get("Classroom_Identifier"));
            editor.putString(Classroom_Name+"_"+i, map2.get("Classroom_Name"));
            editor.putString(Classroom_Description+"_"+i, map2.get("Classroom_Description"));
            editor.putString(Grade_Level+"_"+i, map2.get("Grade_Level"));
            editor.putString(Total_Students+"_"+i, map2.get("Total_Students"));
            editor.putString(Classroom_Location+"_"+i, map2.get("Classroom_Location"));
            editor.putString(Status+"_"+i, map2.get("Status"));
            editor.putString(Created_By+"_"+i, map2.get("Created_By"));
            editor.putString(Updated_By+"_"+i, map2.get("Updated_By"));
            editor.putString(Grading_Scale_Type+"_"+i, map2.get("Grading_Scale_Type"));
            editor.putString(Curriculum_Type+"_"+i, map2.get("Curriculum_Type"));
            editor.putString(Classroom_Code+"_"+i, map2.get("Classroom_Code"));
            editor.putString(Best_Subjects_Core_Count_Total+"_"+i, map2.get("Best_Subjects_Core_Count_Total"));
            editor.putString(Best_Subjects_Elective_Count_Total+"_"+i, map2.get("Best_Subjects_Elective_Count_Total"));
            editor.putString(Level_Name+"_"+i, map2.get("Level_Name"));
            editor.putString(Created_Datetime+"_"+i, map2.get("Created_Datetime"));
            editor.putString(Updated_Datetime+"_"+i, map2.get("Updated_Datetime"));
            editor.putString(School_Identifier+"_"+i, map2.get("School_Identifier"));
            editor.putString(Branch_Identifier+"_"+i, map2.get("Branch_Identifier"));

        }
        editor.commit();
        // SCHOOL_ARRAY.add(map);
    }
    public void setPERMISSION_STUDENTPROFILE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTPROFILE, isAllow);
        editor.commit();
    }


    public String getSchoolId() {
        return sharedPreferences.getString(PREF_SCHOOL_ID, "");
    }


    public void setSchoolName(String schoolname) {
        Editor editor = getEditor();
        editor.putString(PREF_SCHOOL_NAME, schoolname);
        editor.commit();
    }

    public void setSchoolId(String schoolId) {
        Editor editor = getEditor();
        editor.putString(PREF_SCHOOL_ID, schoolId);
        editor.commit();
    }

    public String getSchoolName() {
        return sharedPreferences.getString(PREF_SCHOOL_NAME, "");
    }

    public String getSchoolEmail(){
        return sharedPreferences.getString(PREF_SCHOOL_EMAIL,"");
    }
    public void setSchoolEmail(String schoolEmail){
        Editor editor = getEditor();
        editor.putString(PREF_SCHOOL_EMAIL, schoolEmail);
        editor.commit();
    }


    public void setLocation(LatLng location) {
        Editor editor = getEditor();
        editor.putString(PREF_LAT, String.valueOf(location.latitude));
        editor.putString(PREF_LNG, String.valueOf(location.longitude));
        editor.commit();
    }

    public LatLng getLocation() {
        String strLat = sharedPreferences.getString(PREF_LAT, "0.0");
        String strLng = sharedPreferences.getString(PREF_LNG, "0.0");
        LatLng location = new LatLng(Double.parseDouble(strLat), Double.parseDouble(strLng));
        return location;
    }

    public String strGetLocation() {
        String strLocation = sharedPreferences.getString("userlat", "0.0") + ","
                + sharedPreferences.getString("userlng", "0.0") + ",12z";
        return strLocation;
    }

    public int getUserId() {
        return sharedPreferences.getInt(PREF_UserId, 0);
    }


    public void setUserId(int userId) {
        Editor editor = getEditor();
        editor.putInt(PREF_UserId, userId);
        editor.commit();
    }

    public String getToken() {
        return sharedPreferences.getString(PREF_TOKEN, "");
    }

    public void setToken(String token) {
        Editor editor = getEditor();
        editor.putString(PREF_TOKEN, token);
        editor.commit();
    }

    public void setBase64(String token) {
        Editor editor = getEditor();
        editor.putString(PREF_BASE_64, token);
        editor.commit();
    }

    public String getBase64string() {
        return sharedPreferences.getString(PREF_BASE_64, "");
    }

    public String getUserName() {
        return sharedPreferences.getString(PREF_USER_NAME, "");
    }

    public String getName() {
        return sharedPreferences.getString(PREF_USER_NAME, "").split("@")[0];
    }

    public void setUserName(String userName) {
        Editor editor = getEditor();
        editor.putString(PREF_USER_NAME, userName);
        editor.commit();
    }

    public String getUserPassword() {
        return sharedPreferences.getString(PREF_USER_PASSWORD, "");
    }

    public void setUserPassword(String password) {
        Editor editor = getEditor();
        editor.putString(PREF_USER_PASSWORD, password);
        editor.commit();
    }

    public String getPREF_FULLNAME() {
        return sharedPreferences.getString(PREF_FULLNAME, "");
    }

    public void setPREF_FULLNAME(String fullname) {
        Editor editor = getEditor();
        editor.putString(PREF_FULLNAME, fullname);
        editor.commit();
    }

    public void setPUSHTITLE(String pushTitle){
        Editor editor = getEditor();
        editor.putString(PUSHTITLE, pushTitle);
        editor.commit();
    }
    public String getPUSHTITLE(){
        return sharedPreferences.getString(PUSHTITLE,"");
    }

    public void setPUSHDATA(String pushData){
        Editor editor = getEditor();
        editor.putString(PUSHDATA, pushData);
        editor.commit();
    }
    public String getPUSHDATA(){
        return  sharedPreferences.getString(PUSHDATA,"");
    }

    public void setURL(String pushData){
        Editor editor = getEditor();
        editor.putString(URL, pushData);
        editor.commit();
    }
    public String getURL(){
        return  sharedPreferences.getString(URL,"");
    }


    /*ALL PERMISSIONS GOES HERE*/
    public boolean getPERMISSION_SETTINGS() {
        return sharedPreferences.getBoolean(PERMISSION_SETTINGS, false);
    }

    public void setPERMISSION_SETTINGS(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SETTINGS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ADMINISTRATION() {
        return sharedPreferences.getBoolean(PERMISSION_ADMINISTRATION, false);
    }

    public void setPERMISSION_ADMINISTRATION(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ADMINISTRATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_NOTIFICATION() {
        return sharedPreferences.getBoolean(PERMISSION_NOTIFICATION, false);
    }

    public void setPERMISSION_NOTIFICATION(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_NOTIFICATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_COURSEMANAGEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_COURSEMANAGEMENT, false);
    }

    public void setPERMISSION_COURSEMANAGEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_COURSEMANAGEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTMANAGEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_STUDENTMANAGEMENT, false);
    }

    public void setPERMISSION_STUDENTMANAGEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTMANAGEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STAFFTEACHERMANAGEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_STAFFTEACHERMANAGEMENT, false);
    }

    public void setPERMISSION_STAFFTEACHERMANAGEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STAFFTEACHERMANAGEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FINANCIALMANAGEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_FINANCIALMANAGEMENT, false);
    }

    public void setPERMISSION_FINANCIALMANAGEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FINANCIALMANAGEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CLASSROOMMANAGEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_CLASSROOMMANAGEMENT, false);
    }

    public void setPERMISSION_CLASSROOMMANAGEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CLASSROOMMANAGEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYROLLMANAGEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_PAYROLLMANAGEMENT, false);
    }

    public void setPERMISSION_PAYROLLMANAGEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYROLLMANAGEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REPORTMANAGEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_REPORTMANAGEMENT, false);
    }

    public void setPERMISSION_REPORTMANAGEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REPORTMANAGEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PARENTMESSAGEBOARD() {
        return sharedPreferences.getBoolean(PERMISSION_PARENTMESSAGEBOARD, false);
    }

    public void setPERMISSION_PARENTMESSAGEBOARD(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PARENTMESSAGEBOARD, isAllow);
        editor.commit();
    }

    /**
     * Settings...
     **/
    public boolean getPERMISSION_MYPROFILE() {
        return sharedPreferences.getBoolean(PERMISSION_MYPROFILE, false);
    }

    public void setPERMISSION_MYPROFILE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MYPROFILE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SYNCTOSERVER() {
        return sharedPreferences.getBoolean(PERMISSION_SYNCTOSERVER, false);
    }

    public void setPERMISSION_SYNCTOSERVER(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SYNCTOSERVER, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_MYACTIVITY() {
        return sharedPreferences.getBoolean(PERMISSION_MYACTIVITY, false);
    }

    public void setPERMISSION_MYACTIVITY(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MYACTIVITY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_LOCALDATACACHE() {
        return sharedPreferences.getBoolean(PERMISSION_LOCALDATACACHE, false);
    }

    public void setPERMISSION_LOCALDATACACHE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_LOCALDATACACHE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_AUTOSYNCTOSERVER() {
        return sharedPreferences.getBoolean(PERMISSION_AUTOSYNCTOSERVER, false);
    }

    public void setPERMISSION_AUTOSYNCTOSERVER(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_AUTOSYNCTOSERVER, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_MYLOGINAUDIT() {
        return sharedPreferences.getBoolean(PERMISSION_MYLOGINAUDIT, false);
    }

    public void setPERMISSION_MYLOGINAUDIT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MYLOGINAUDIT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_MYACTIVITYREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_MYACTIVITYREPORT, false);
    }

    public void setPERMISSION_MYACTIVITYREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MYACTIVITYREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_MYMESSAGES() {
        return sharedPreferences.getBoolean(PERMISSION_MYMESSAGES, false);
    }

    public void setPERMISSION_MYMESSAGES(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MYMESSAGES, isAllow);
        editor.commit();
    }


    /** ADMINISTRATION...*/

    public boolean getPERMISSION_GBOOKACCOUNT() {
        return sharedPreferences.getBoolean(PERMISSION_GBOOKACCOUNT, false);
    }

    public void setPERMISSION_GBOOKACCOUNT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_GBOOKACCOUNT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATESCHOOLPROFILE() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATESCHOOLPROFILE, false);
    }

    public void setPERMISSION_UPDATESCHOOLPROFILE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATESCHOOLPROFILE, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_UPDATEOTHERUSERPROFILE() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATEOTHERUSERPROFILE, false);
    }

    public void setPERMISSION_UPDATEOTHERUSERPROFILE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEOTHERUSERPROFILE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SETUPNEWINVOICE() {
        return sharedPreferences.getBoolean(PERMISSION_SETUPNEWINVOICE, false);
    }

    public void setPERMISSION_SETUPNEWINVOICE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SETUPNEWINVOICE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SETUPNEWVENDOR() {
        return sharedPreferences.getBoolean(PERMISSION_SETUPNEWVENDOR, false);
    }

    public void setPERMISSION_SETUPNEWVENDOR(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SETUPNEWVENDOR, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SETUPNEWEXPENSEACCOUNT() {
        return sharedPreferences.getBoolean(PERMISSION_SETUPNEWEXPENSEACCOUNT, false);
    }

    public void setPERMISSION_SETUPNEWEXPENSEACCOUNT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SETUPNEWEXPENSEACCOUNT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_GENERATEFINALREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_GENERATEFINALREPORT, false);
    }

    public void setPERMISSION_GENERATEFINALREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_GENERATEFINALREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_VIEWFINALREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_VIEWFINALREPORT, false);
    }

    public void setPERMISSION_VIEWFINALREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_VIEWFINALREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SENDFINALREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_SENDFINALREPORT, false);
    }

    public void setPERMISSION_SENDFINALREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SENDFINALREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLNOTIFICATIONHISTORY() {
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLNOTIFICATIONHISTORY, false);
    }

    public void setPERMISSION_SCHOOLNOTIFICATIONHISTORY(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLNOTIFICATIONHISTORY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ADDNEWSCHOOLTERM() {
        return sharedPreferences.getBoolean(PERMISSION_ADDNEWSCHOOLTERM, false);
    }

    public void setPERMISSION_ADDNEWSCHOOLTERM(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ADDNEWSCHOOLTERM, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATESCHOOLCALENDAR() {
        return sharedPreferences.getBoolean(PERMISSION_CREATESCHOOLCALENDAR, false);
    }

    public void setPERMISSION_CREATESCHOOLCALENDAR(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATESCHOOLCALENDAR, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_GENERATEMANUALFINALREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_GENERATEMANUALFINALREPORT, false);
    }

    public void setPERMISSION_GENERATEMANUALFINALREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_GENERATEMANUALFINALREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_NOTIFICATIONSETTINGS() {
        return sharedPreferences.getBoolean(PERMISSION_NOTIFICATIONSETTINGS, false);
    }

    public void setPERMISSION_NOTIFICATIONSETTINGS(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_NOTIFICATIONSETTINGS, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_MANAGEMENTDAILYREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_MANAGEMENTDAILYREPORT, false);
    }

    public void setPERMISSION_MANAGEMENTDAILYREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MANAGEMENTDAILYREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_MOVESTUDENTS() {
        return sharedPreferences.getBoolean(PERMISSION_MOVESTUDENTS, false);
    }

    public void setPERMISSION_MOVESTUDENTS(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MOVESTUDENTS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATEVENDOR() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATEVENDOR, false);
    }

    public void setPERMISSION_UPDATEVENDOR(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEVENDOR, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLCANTEEN(){
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLCANTEEN, false);
    }
    public void setPERMISSION_SCHOOLCANTEEN(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLCANTEEN, isAllow);
        editor.commit();
    }
    public boolean getPERMISSION_SCHOOLCANTEENREIVEW(){
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLCANTEENREVIEW, false);
    }
    public void setPERMISSION_SCHOOLCANTEENREVIEW(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLCANTEENREVIEW, isAllow);
        editor.commit();
    }
    public boolean getPERMISSION_SCHOOLNOTIFICATIONREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLNOTIFICATIONREPORT, false);
    }
    public void setPERMISSION_SCHOOLNOTIFICATIONREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLNOTIFICATIONREPORT, isAllow);
        editor.commit();
    }
    public boolean getPERMISSION_SCHOOLNOTIFICATIONSUMMARY(){
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLNOTIFICATIONSUMMARY, false);
    }
    public void setPERMISSION_SCHOOLNOTIFICATIONSUMMARY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLNOTIFICATIONSUMMARY, isAllow);
        editor.commit();
    }
    public boolean getPERMISSION_APPROVERSIGNATURE(){
        return  sharedPreferences.getBoolean(PERMISSION_APPROVERSIGNATURE, false);
    }
    public void setPERMISSION_APPROVERSIGNATURE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_APPROVERSIGNATURE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATECLASSROOMSCHEDULE() {
        return sharedPreferences.getBoolean(PERMISSION_CREATECLASSROOMSCHEDULE, false);
    }

    public void setPERMISSION_CREATECLASSROOMSCHEDULE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATECLASSROOMSCHEDULE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATECLASSROOMSCHEDULE() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATECLASSROOMSCHEDULE, false);
    }

    public void setPERMISSION_UPDATECLASSROOMSCHEDULE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATECLASSROOMSCHEDULE, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_SCHOOLTTERMREVIEW(){
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLTERMREVIEW, false);
    }
    public void setPERMISSION_SCHOOLTERMREVIEW(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLTERMREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATESCHOOLTERM(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATESCHOOLTERM, false);
    }
    public void setPERMISSION_UPDATESCHOOLTERM(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATESCHOOLTERM, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SWITCHSCHOOLACCOUNT(){
        return sharedPreferences.getBoolean(PERMISSION_SWITCHSCHOOLACCOUNT, false);
    }
    public void setPERMISSION_SWITCHSCHOOLACCOUNT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SWITCHSCHOOLACCOUNT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATESTAFFTEACHERLOGIN(){
        return sharedPreferences.getBoolean(PERMISSION_CREATESTAFFTEACHERLOGIN, false);
    }
    public void setPERMISSION_CREATESTAFFTEACHERLOGIN(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATESTAFFTEACHERLOGIN, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FINALREPORTSTATUS(){
        return sharedPreferences.getBoolean(PERMISSION_FINALREPORTSTATUS, false);
    }
    public void setPERMISSION_FINALREPORTSTATUS(boolean isAllow){
        Editor editor= getEditor();
        editor.putBoolean(PERMISSION_FINALREPORTSTATUS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_GBOOKSTATUSREVIEW(){
        return sharedPreferences.getBoolean(PERMISSION_GBOOKSTATUSREVIEW, false);
    }
    public void setPERMISSION_GBOOKSTATUSREVIEW(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_GBOOKSTATUSREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RESENDLGLOGIN(){
        return sharedPreferences.getBoolean(PERMISSION_RESENDLGLOGIN, false);
    }
    public void setPERMISSION_RESENDLGLOGIN(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RESENDLGLOGIN, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATESCHOOLGROUP() {
        return sharedPreferences.getBoolean(PERMISSION_CREATESCHOOLGROUP, false);
    }
    public void setPERMISSION_CREATESCHOOLGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATESCHOOLGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWSCHOOLGROUP(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWSCHOOLGROUP, false);
    }
    public void setPERMISSION_REVIEWSCHOOLGROUP(boolean isAllow){
        Editor editor =getEditor();
        editor.putBoolean(PERMISSION_REVIEWSCHOOLGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATESCHOOLGROUP(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATESCHOOLGROUP, false);
    }
    public void setPERMISSION_UPDATESCHOOLGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATESCHOOLGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_VIEWASSESSMENTREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_VIEWASSESSMENTREPORT, false);
    }
    public void setPERMISSION_VIEWASSESSMENTREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_VIEWASSESSMENTREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SENDPROGRESSREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_SENDPROGRESSREPORT, false);
    }
    public void setPERMISSION_SENDPROGRESSREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SENDPROGRESSREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DAILYATTENDANCESUMMARY(){
        return sharedPreferences.getBoolean(PERMISSION_DAILYATTENDANCESUMMARY, false);
    }
    public void setPERMISSION_DAILYATTENDANCESUMMARY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DAILYATTENDANCESUMMARY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_USERACCOUNTS(){
        return sharedPreferences.getBoolean(PERMISSION_USERACCOUNTS, false);
    }
    public void setPERMISSION_USERACCOUNTS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_USERACCOUNTS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BULKPDFSTATUS(){
        return sharedPreferences.getBoolean(PERMISSION_BULKPDFSTATUS, false);
    }
    public void setPERMISSION_BULKPDFSTATUS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BULKPDFSTATUS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_COPYSCHOOLCANTEEN(){
        return sharedPreferences.getBoolean(PERMISSION_COPYSCHOOLCANTEEN, false);
    }
    public void setPERMISSION_COPYSCHOOLCANTEEN(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_COPYSCHOOLCANTEEN, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLMESSAGETEMPLATE(){
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLMESSAGETEMPLATE, false);
    }
    public void setPERMISSION_SCHOOLMESSAGETEMPLATE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLMESSAGETEMPLATE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLFINANCIALACCOUNT(){
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLFINANCIALACCOUNT, false);
    }
    public void setPERMISSION_SCHOOLFINANCIALACCOUNT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLFINANCIALACCOUNT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FINALREPORTGPA(){
        return sharedPreferences.getBoolean(PERMISSION_FINALREPORTGPA, false);
    }
    public void setPERMISSION_FINALREPORTGPA(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FINALREPORTGPA, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PROGRESSREPORTGPA(){
        return sharedPreferences.getBoolean(PERMISSION_PROGRESSREPORTGPA, false);
    }
    public void setPERMISSION_PROGRESSREPORTGPA(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PROGRESSREPORTGPA, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FINALREPORTQUALITYCHECK(){
        return sharedPreferences.getBoolean(PERMISSION_FINALREPORTQUALITYCHECK, false);
    }
    public void setPERMISSION_FINALREPORTQUALITYCHECK(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FINALREPORTQUALITYCHECK, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATEPICKUPPERSON(){
        return sharedPreferences.getBoolean(PERMISSION_CREATEPICKUPPERSON, false);
    }
    public void setPERMISSION_CREATEPICKUPPERSON(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATEPICKUPPERSON, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PUSHNOTIFICATIONSETTINGS(){
        return sharedPreferences.getBoolean(PERMISSION_PUSHNOTIFICATIONSETTINGS, false);
    }
    public void setPERMISSION_PUSHNOTIFICATIONSETTINGS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PUSHNOTIFICATIONSETTINGS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWORGANIZATION(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWORGANIZATION, false);
    }
    public void setPERMISSION_REVIEWORGANIZATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWORGANIZATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATEORGANIZATION(){
        return sharedPreferences.getBoolean(PERMISSION_CREATEORGANIZATION, false);
    }
    public void setPERMISSION_CREATEORGANIZATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATEORGANIZATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLNETWORK(){
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLNETWORK, false);
    }
    public void setPERMISSION_SCHOOLNETWORK(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLNETWORK, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SETUPSTUDENTINVOICEITEMS(){
        return sharedPreferences.getBoolean(PERMISSION_SETUPSTUDENTINVOICEITEMS, false);
    }
    public void setPERMISSION_SETUPSTUDENTINVOICEITEMS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SETUPSTUDENTINVOICEITEMS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SETUPCLASSROOMINVOICEITEMS(){
        return sharedPreferences.getBoolean(PERMISSION_SETUPCLASSROOMINVOICEITEMS, false);
    }
    public void setPERMISSION_SETUPCLASSROOMINVOICEITEMS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SETUPCLASSROOMINVOICEITEMS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWSCHOOLINVOICEITEMS(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWSCHOOLINVOICEITEMS, false);
    }
    public void setPERMISSION_REVIEWSCHOOLINVOICEITEMS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWSCHOOLINVOICEITEMS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATESCHOOLGRADINGSCALE(){
        return sharedPreferences.getBoolean(PERMISSION_CREATESCHOOLGRADINGSCALE, false);
    }
    public void setPERMISSION_CREATESCHOOLGRADINGSCALE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATESCHOOLGRADINGSCALE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BECEFORCASTER(){
        return sharedPreferences.getBoolean(PERMISSION_BECEFORCASTER, false);
    }
    public void setPERMISSION_BECEFORCASTER(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BECEFORCASTER, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FINALREPORTANALYSIS(){
        return sharedPreferences.getBoolean(PERMISSION_FINALREPORTANALYSIS, false);
    }
    public void setPERMISSION_FINALREPORTANALYSIS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FINALREPORTANALYSIS, isAllow);
        editor.commit();
    }

    /** Course Management */
    public boolean getPERMISSION_NEWCOURSESETUP() {
        return sharedPreferences.getBoolean(PERMISSION_NEWCOURSESETUP, false);
    }

    public void setPERMISSION_NEWCOURSESETUP(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_NEWCOURSESETUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SHOWAVAILABLECOURSE() {
        return sharedPreferences.getBoolean(PERMISSION_STUDENTSEARCH, false);
    }

    public void setPERMISSION_SHOWAVAILABLECOURSE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTSEARCH, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_COURSETEACHERLINK() {
        return sharedPreferences.getBoolean(PERMISSION_COURSETEACHERLINK, false);
    }

    public void setPERMISSION_COURSETEACHERLINK(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_COURSETEACHERLINK, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATECOURSE() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATECOURSE, false);
    }

    public void setPERMISSION_UPDATECOURSE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATECOURSE, isAllow);
        editor.commit();
    }

    /** Student Management*/
    public boolean getPERMISSION_ENROLLMENT() {
        return sharedPreferences.getBoolean(PERMISSION_ENROLLMENT, false);
    }

    public void setPERMISSION_ENROLLMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ENROLLMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTSEARCH() {
        return sharedPreferences.getBoolean(PERMISSION_STUDENTSEARCH, false);
    }

    public void setPERMISSION_STUDENTSEARCH(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTSEARCH, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTPOPULATIONS() {
        return sharedPreferences.getBoolean(PERMISSION_STUDENTPOPULATIONS, false);
    }

    public void setPERMISSION_STUDENTPOPULATIONS(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTPOPULATIONS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SEARCHINACTIVESTUDENTS() {
        return sharedPreferences.getBoolean(PERMISSION_SEARCHINACTIVESTUDENTS, false);
    }

    public void setPERMISSION_SEARCHINACTIVESTUDENTS(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SEARCHINACTIVESTUDENTS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTSBYGROUP(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTSBYGROUP, false);
    }
    public void setPERMISSION_STUDENTSBYGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTSBYGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTADMISSIONREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTADMISSIONREPORT, false);
    }
    public void setPERMISSION_STUDENTADMISSIONREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTADMISSIONREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ASSIGNSTUDENTGROUP(){
        return sharedPreferences.getBoolean(PERMISSION_ASSIGNSTUDENTGROUP, false);
    }
    public void setPERMISSION_ASSIGNSTUDENTGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ASSIGNSTUDENTGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_MOVESTUDENTGROUP(){
        return  sharedPreferences.getBoolean(PERMISSION_MOVESTUDENTGROUP, false);
    }
    public void setPERMISSION_MOVESTUDENTGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MOVESTUDENTGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REMOVESTUDENTFROMGROUP(){
        return sharedPreferences.getBoolean(PERMISSION_REMOVESTUDENTFROMGROUP, false);
    }
    public void setPERMISSION_REMOVESTUDENTFROMGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REMOVESTUDENTFROMGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ASSIGNSTUDENTCOURSE(){
        return sharedPreferences.getBoolean(PERMISSION_ASSIGNSTUDENTCOURSE, false);
    }
    public void setPERMISSION_ASSIGNSTUDENTCOURSE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ASSIGNSTUDENTCOURSE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTBYCOURSE(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTBYCOURSE, false);
    }
    public void setPERMISSION_STUDENTBYCOURSE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTBYCOURSE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_MOVESTUDENTCOURSE(){
        return sharedPreferences.getBoolean(PERMISSION_MOVESTUDENTCOURSE, false);
    }
    public void setPERMISSION_MOVESTUDENTCOURSE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MOVESTUDENTCOURSE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REMOVESTUDENTCOURSE(){
        return sharedPreferences.getBoolean(PERMISSION_REMOVESTUDENTCOURSE, false);
    }
    public void setPERMISSION_REMOVESTUDENTCOURSE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REMOVESTUDENTCOURSE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTAWARD(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTAWARD, false);
    }
    public void setPERMISSION_STUDENTAWARD(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTAWARD, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATESTUDENTAWARD(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATESTUDENTAWARD, false);
    }
    public void setPERMISSION_UPDATESTUDENTAWARD(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATESTUDENTAWARD, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWSTUDENTAWARD(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWSTUDENTAWARD, false);
    }
    public void setPERMISSION_REVIEWSTUDENTAWARD(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWSTUDENTAWARD, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATESTUDENTTRANSCRIPT(){
        return sharedPreferences.getBoolean(PERMISSION_CREATESTUDENTTRANSCRIPT, false);
    }
    public void setPERMISSION_CREATESTUDENTTRANSCRIPT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATESTUDENTTRANSCRIPT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATESTUDENTTRANSCRIPT(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATESTUDENTTRANSCRIPT, false);
    }
    public void setPERMISSION_UPDATESTUDENTTRANSCRIPT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATESTUDENTTRANSCRIPT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWSTUDENTTRANSCRIPT(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWSTUDENTTRANSCRIPT, false);
    }
    public void setPERMISSION_REVIEWSTUDENTTRANSCRIPT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWSTUDENTTRANSCRIPT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTTRANSCRIPTSTATUS(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTTRANSCRIPTSTATUS, false);
    }
    public void setPERMISSION_STUDENTTRANSCRIPTSTATUS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTTRANSCRIPTSTATUS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATEIGCSETRANSCRIPT(){
        return sharedPreferences.getBoolean(PERMISSION_CREATEIGCSETRANSCRIPT, false);
    }
    public void setPERMISSION_CREATEIGCSETRANSCRIPT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATEIGCSETRANSCRIPT, isAllow);
        editor.commit();
    }
    public boolean getPERMISSION_PICKUPANDROPOFF(){
        return sharedPreferences.getBoolean(PERMISSION_PICKUPANDROPOFF, false);
    }
    public void setPERMISSION_PICKUPANDROPOFF(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PICKUPANDROPOFF, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTDAILYACTIVITY(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTDAILYACTIVITY, false);
    }
    public void setPERMISSION_STUDENTDAILYACTIVITY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTDAILYACTIVITY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWSTUDENTDAILYACTIVITY(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWSTUDENTDAILYACTIVITY, false);
    }
    public void setPERMISSION_REVIEWSTUDENTDAILYACTIVITY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWSTUDENTDAILYACTIVITY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BACKENDSERVICESETTINGS(){
        return sharedPreferences.getBoolean(PERMISSION_BACKENDSERVICESETTINGS, false);
    }
    public void setPERMISSION_BACKENDSERVICESETTINGS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BACKENDSERVICESETTINGS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ADDSTUDENTMEDICALCONDITION(){
        return sharedPreferences.getBoolean(PERMISSION_ADDSTUDENTMEDICALCONDITION, false);
    }
    public void setPERMISSION_ADDSTUDENTMEDICALCONDITION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ADDSTUDENTMEDICALCONDITION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATESTUDENTMEDICALCONDITION(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATESTUDENTMEDICALCONDITION, false);
    }
    public void setPERMISSION_UPDATESTUDENTMEDICALCONDITION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATESTUDENTMEDICALCONDITION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTMEDICALHISTORY(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTMEDICALHISTORY, false);
    }
    public void setPERMISSION_STUDENTMEDICALHISTORY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTMEDICALHISTORY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTPICKUPDROPOFFLOG(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTPICKUPDROPOFFLOG, false);
    }
    public void setPERMISSION_STUDENTPICKUPDROPOFFLOG(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTPICKUPDROPOFFLOG, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SENDSTUDENTTRANSCRIPTNOTIFICATION(){
        return sharedPreferences.getBoolean(PERMISSION_SENDSTUDENTTRANSCRIPTNOTIFICATION, false);
    }
    public void setPERMISSION_SENDSTUDENTTRANSCRIPTNOTIFICATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SENDSTUDENTTRANSCRIPTNOTIFICATION, isAllow);
        editor.commit();
    }




    /** STAFF/ TEACHER MANAGEMENT*/
    public boolean getPERMISSION_NEWTEACHERSETUP() {
        return sharedPreferences.getBoolean(PERMISSION_NEWTEACHERSETUP, false);
    }

    public void setPERMISSION_NEWTEACHERSETUP(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_NEWTEACHERSETUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_NEWSTAFFSETUP() {
        return sharedPreferences.getBoolean(PERMISSION_NEWSTAFFSETUP, false);
    }

    public void setPERMISSION_NEWSTAFFSETUP(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_NEWSTAFFSETUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STAFFNOTICE() {
        return sharedPreferences.getBoolean(PERMISSION_STAFFNOTICE, false);
    }

    public void setPERMISSION_STAFFNOTICE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STAFFNOTICE, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_TEACHERPERFORMANCE() {
        return sharedPreferences.getBoolean(PERMISSION_TEACHERPERFORMANCE, false);
    }

    public void setPERMISSION_TEACHERPERFORMANCE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_TEACHERPERFORMANCE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_TEACHERATTENDANCE() {
        return sharedPreferences.getBoolean(PERMISSION_TEACHERATTENDANCE, false);
    }

    public void setPERMISSION_TEACHERATTENDANCE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_TEACHERATTENDANCE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RECORDSTAFFTEACHERATTENDANCE() {
        return sharedPreferences.getBoolean(PERMISSION_RECORDSTAFFTEACHERATTENDANCE, false);
    }

    public void setPERMISSION_RECORDSTAFFTEACHERATTENDANCE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RECORDSTAFFTEACHERATTENDANCE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWSTAFFTEACHERATTENDANCE() {
        return sharedPreferences.getBoolean(PERMISSION_REVIEWSTAFFTEACHERATTENDANCE, false);
    }

    public void setPERMISSION_REVIEWSTAFFTEACHERATTENDANCE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWSTAFFTEACHERATTENDANCE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_MOVESTAFFTEACHERGROUP(){
        return sharedPreferences.getBoolean(PERMISSION_MOVESTAFFTEACHERGROUP, false);
    }
    public void setPERMISSION_MOVESTAFFTEACHERGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MOVESTAFFTEACHERGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REMOVESTAFFTEACHERGROUP(){
        return sharedPreferences.getBoolean(PERMISSION_REMOVESTAFFTEACHERGROUP, false);
    }
    public void setPERMISSION_REMOVESTAFFTEACHERGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REMOVESTAFFTEACHERGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STAFFTEACHERBYGROUP(){
        return sharedPreferences.getBoolean(PERMISSION_STAFFTEACHERBYGROUP, false);
    }
    public void setPERMISSION_STAFFTEACHERBYGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STAFFTEACHERBYGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ASSIGNSTAFFTEACHERGROUP(){
        return sharedPreferences.getBoolean(PERMISSION_ASSIGNSTAFFTEACHERGROUP, false);
    }
    public void setPERMISSION_ASSIGNSTAFFTEACHERGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ASSIGNSTAFFTEACHERGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SEARCHINACTIVEEMPLOYEES(){
        return sharedPreferences.getBoolean(PERMISSION_SEARCHINACTIVEEMPLOYEES, false);
    }
    public void setPERMISSION_SEARCHINACTIVEEMPLOYEES(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SEARCHINACTIVEEMPLOYEES, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_LESSONNOTES(){
        return sharedPreferences.getBoolean(PERMISSION_LESSONNOTES, false);
    }
    public void setPERMISSION_LESSONNOTES(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_LESSONNOTES, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_LESSONNOTESHEADTEACHER(){
        return sharedPreferences.getBoolean(PERMISSION_LESSONNOTESHEADTEACHER, false);
    }
    public void setPERMISSION_LESSONNOTESHEADTEACHER(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_LESSONNOTESHEADTEACHER, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATELESSONNOTES(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATELESSONNOTES, false);
    }
    public void setPERMISSION_UPDATELESSONNOTES(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATELESSONNOTES, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWLESSONNOTES(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWLESSONNOTES, false);
    }
    public void setPERMISSION_REVIEWLESSONNOTES(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWLESSONNOTES, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_EMPLOYEESETUP(){
        return sharedPreferences.getBoolean(PERMISSION_EMPLOYEESETUP, false);
    }
    public void setPERMISSION_EMPLOYEESETUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_EMPLOYEESETUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_EMPLOYEELOGINAUDIT(){
        return sharedPreferences.getBoolean(PERMISSION_EMPLOYEELOGINAUDIT, false);
    }
    public void setPERMISSION_EMPLOYEELOGINAUDIT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_EMPLOYEELOGINAUDIT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_EMPLOYEEACTIVITYREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_EMPLOYEEACTIVITYREPORT, false);
    }
    public void setPERMISSION_EMPLOYEEACTIVITYREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_EMPLOYEEACTIVITYREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_EMPLOYEEGROUP(){
        return sharedPreferences.getBoolean(PERMISSION_EMPLOYEEGROUP, false);
    }
    public void setPERMISSION_EMPLOYEEGROUP(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_EMPLOYEEGROUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_EMPLOYEEACCOUNTSTATUS(){
        return sharedPreferences.getBoolean(PERMISSION_EMPLOYEEACCOUNTSTATUS, false);
    }
    public void setPERMISSION_EMPLOYEEACCOUNTSTATUS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_EMPLOYEEACCOUNTSTATUS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_WEEKLYWORKPLAN(){
        return sharedPreferences.getBoolean(PERMISSION_WEEKLYWORKPLAN, false);
    }
    public void setPERMISSION_WEEKLYWORKPLAN(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_WEEKLYWORKPLAN, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_WEEKLYWORKPLANREVIEW(){
        return sharedPreferences.getBoolean(PERMISSION_WEEKLYWORKPLANREVIEW, false);
    }
    public void setPERMISSION_WEEKLYWORKPLANREVIEW(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_WEEKLYWORKPLANREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATEWEEKLYWORKPLAN(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATEWEEKLYWORKPLAN, false);
    }
    public void setPERMISSION_UPDATEWEEKLYWORKPLAN(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEWEEKLYWORKPLAN, isAllow);
        editor.commit();
    }


    /** Financial Management*/
    public boolean getPERMISSION_CREATEINVOICEBILL() {
        return sharedPreferences.getBoolean(PERMISSION_CREATEINVOICEBILL, false);
    }

    public void setPERMISSION_CREATEINVOICEBILL(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATEINVOICEBILL, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATESELECTIVEINVOICEBILL() {
        return sharedPreferences.getBoolean(PERMISSION_CREATESELECTIVEINVOICEBILL, false);
    }

    public void setPERMISSION_CREATESELECTIVEINVOICEBILL(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATESELECTIVEINVOICEBILL, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYINVOICEBILL() {
        return sharedPreferences.getBoolean(PERMISSION_PAYINVOICEBILL, false);
    }

    public void setPERMISSION_PAYINVOICEBILL(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYINVOICEBILL, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ONDEMANDPAYMENT() {
        return sharedPreferences.getBoolean(PERMISSION_ONDEMANDPAYMENT, false);
    }

    public void setPERMISSION_ONDEMANDPAYMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ONDEMANDPAYMENT, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_RECORDEXPENSE() {
        return sharedPreferences.getBoolean(PERMISSION_RECORDEXPENSE, false);
    }

    public void setPERMISSION_RECORDEXPENSE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RECORDEXPENSE, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_INVOICEBILLREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_INVOICEBILLREPORT, false);
    }

    public void setPERMISSION_INVOICEBILLREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_INVOICEBILLREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLREVENUEREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLREVENUEREPORT, false);
    }

    public void setPERMISSION_SCHOOLREVENUEREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLREVENUEREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLREVENUEDETAILSPOPUP() {
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLREVENUEDETAILSPOPUP, false);
    }

    public void setPERMISSION_SCHOOLREVENUEDETAILSPOPUP(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLREVENUEDETAILSPOPUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLEXPENSEREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLEXPENSEREPORT, false);
    }

    public void setPERMISSION_SCHOOLEXPENSEREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLEXPENSEREPORT, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_REVENUEEXPENSEREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_REVENUEEXPENSEREPORT, false);
    }

    public void setPERMISSION_REVENUEEXPENSEREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVENUEEXPENSEREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYROLLREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_PAYROLLREPORT, false);
    }

    public void setPERMISSION_PAYROLLREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYROLLREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CASHFLOWSSTATEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_CASHFLOWSSTATEMENT, false);
    }

    public void setPERMISSION_CASHFLOWSSTATEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CASHFLOWSSTATEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BALANCESHEET() {
        return sharedPreferences.getBoolean(PERMISSION_BALANCESHEET, false);
    }

    public void setPERMISSION_BALANCESHEET(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BALANCESHEET, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PROFITLESSSTATEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_PROFITLESSSTATEMENT, false);
    }

    public void setPERMISSION_PROFITLESSSTATEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PROFITLESSSTATEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATEPAYMENTDETAILS() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATEPAYMENTDETAILS, false);
    }

    public void setPERMISSION_UPDATEPAYMENTDETAILS(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEPAYMENTDETAILS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATEBILLDETAILS() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATEBILLDETAILS, false);
    }

    public void setPERMISSION_UPDATEBILLDETAILS(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEBILLDETAILS, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_UNBILLEDSTUDENTS() {
        return sharedPreferences.getBoolean(PERMISSION_UNBILLEDSTUDENTS, false);
    }

    public void setPERMISSION_UNBILLEDSTUDENTS(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UNBILLEDSTUDENTS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BILLITEMPAYMENTHISTORY() {
        return sharedPreferences.getBoolean(PERMISSION_BILLITEMPAYMENTHISTORY, false);
    }

    public void setPERMISSION_BILLITEMPAYMENTHISTORY(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BILLITEMPAYMENTHISTORY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BILLITEMINVOICEBILLREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_BILLITEMINVOICEBILLREPORT, false);
    }

    public void setPERMISSION_BILLITEMINVOICEBILLREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BILLITEMINVOICEBILLREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BADDEBTSREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_BADDEBTSREPORT, false);
    }

    public void setPERMISSION_BADDEBTSREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BADDEBTSREPORT, isAllow);
        editor.commit();
    }
    public boolean getPERMISSION_BANKACTIVITYREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_BANKACTIVITYREPORT, false);
    }
    public void setPERMISSION_BANKACTIVITYREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BANKACTIVITYREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SENDEDITBILLNOTIFICATION(){
        return sharedPreferences.getBoolean(PERMISSION_SENDEDITBILLNOTIFICATION, false);
    }
    public void setPERMISSION_SENDEDITBILLNOTIFICATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SENDEDITBILLNOTIFICATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RESENDBILLNOTIFICATION(){
        return sharedPreferences.getBoolean(PERMISSION_RESENDBILLNOTIFICATION, false);
    }
    public void setPERMISSION_RESENDBILLNOTIFICATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RESENDBILLNOTIFICATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RESENDPAYMENTNOTIFICATION(){
        return sharedPreferences.getBoolean(PERMISSION_RESENDPAYMENTNOTIFICATION, false);
    }
    public  void setPERMISSION_RESENDPAYMENTNOTIFICATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RESENDPAYMENTNOTIFICATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_EXPORTDATA(){
        return sharedPreferences.getBoolean(PERMISSION_EXPORTDATA, false);
    }
    public void setPERMISSION_EXPORTDATA(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_EXPORTDATA, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DELETEUNPAIDBILLS(){
        return sharedPreferences.getBoolean(PERMISSION_DELETEUNPAIDBILLS, false);
    }
    public void setPERMISSION_DELETEUNPAIDBILLS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DELETEUNPAIDBILLS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ADVANCEPAYMENTREPORT(){
        return  sharedPreferences.getBoolean(PERMISSION_ADVANCEPAYMENTREPORT, false);
    }
    public void setPERMISSION_ADVANCEPAYMENTREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ADVANCEPAYMENTREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_COPYBILL(){
        return sharedPreferences.getBoolean(PERMISSION_COPYBILL, false);
    }
    public void setPERMISSION_COPYBILL(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_COPYBILL, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SENDBILLNOTIFICATION(){
        return sharedPreferences.getBoolean(PERMISSION_SENDBILLNOTIFICATION, false);
    }
    public void setPERMISSION_SENDBILLNOTIFICATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SENDBILLNOTIFICATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SELECTIVEONDEMANDPAYMENT(){
        return sharedPreferences.getBoolean(PERMISSION_SELECTIVEONDEMANDPAYMENT, false);
    }
    public void setPERMISSION_SELECTIVEONDEMANDPAYMENT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SELECTIVEONDEMANDPAYMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYINVOICEBILLITEM(){
        return sharedPreferences.getBoolean(PERMISSION_PAYINVOICEBILLITEM, false);
    }
    public void setPERMISSION_PAYINVOICEBILLITEM(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYINVOICEBILLITEM, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_VIEWPATMENTRECEIPT(){
        return sharedPreferences.getBoolean(PERMISSION_VIEWPATMENTRECEIPT, false);
    }
    public void setPERMISSION_VIEWPATMENTRECEIPT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_VIEWPATMENTRECEIPT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_LINEITEMONDEMANDPAYMENT(){
        return sharedPreferences.getBoolean(PERMISSION_LINEITEMONDEMANDPAYMENT, false);
    }
    public void setPERMISSION_LINEITEMONDEMANDPAYMENT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_LINEITEMONDEMANDPAYMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYMENTS(){
        return sharedPreferences.getBoolean(PERMISSION_PAYMENTS, false);
    }
    public void setPERMISSION_PAYMENTS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYMENTS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PROFITANDLOSSEXPORT(){
        return sharedPreferences.getBoolean(PERMISSION_PROFITANDLOSSEXPORT, false);
    }
    public void setPERMISSION_PROFITANDLOSSEXPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PROFITANDLOSSEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATEMULTIPLELINEITEMS(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATEMULTIPLELINEITEMS, false);
    }
    public void setPERMISSION_UPDATEMULTIPLELINEITEMS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEMULTIPLELINEITEMS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FINANCIALREPORTS(){
        return sharedPreferences.getBoolean(PERMISSION_FINANCIALREPORTS, false);
    }
    public void setPERMISSION_FINANCIALREPORTS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FINANCIALREPORTS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FINANCIALSTATEMENTS(){
        return sharedPreferences.getBoolean(PERMISSION_FINANCIALSTATEMENTS, false);
    }
    public void setPERMISSION_FINANCIALSTATEMENTS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FINANCIALSTATEMENTS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DAILYFEERECON(){
        return sharedPreferences.getBoolean(PERMISSION_DAILYFEERECON, false);
    }
    public void setPERMISSION_DAILYFEERECON(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DAILYFEERECON, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYEXPENSE(){
        return sharedPreferences.getBoolean(PERMISSION_PAYEXPENSE, false);
    }
    public void setPERMISSION_PAYEXPENSE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYEXPENSE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DELETEUNPAIDEXPENSE(){
        return sharedPreferences.getBoolean(PERMISSION_DELETEUNPAIDEXPENSE, false);
    }
    public void setPERMISSION_DELETEUNPAIDEXPENSE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DELETEUNPAIDEXPENSE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYMENTHISTORY(){
        return sharedPreferences.getBoolean(PERMISSION_PAYMENTHISTORY, false);
    }
    public void setPERMISSION_PAYMENTHISTORY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYMENTHISTORY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FUNDSTRANSFER(){
        return sharedPreferences.getBoolean(PERMISSION_FUNDSTRANSFER, false);
    }
    public void setPERMISSION_FUNDSTRANSFER(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FUNDSTRANSFER, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FINANCIALACCOUNTHISTORY(){
        return sharedPreferences.getBoolean(PERMISSION_FINANCIALACCOUNTHISTORY, false);
    }
    public void setPERMISSION_FINANCIALACCOUNTHISTORY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FINANCIALACCOUNTHISTORY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_VOUCHERREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_VOUCHERREPORT, false);
    }
    public void setPERMISSION_VOUCHERREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_VOUCHERREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_VOUCHERREPORTBUTTON(){
        return sharedPreferences.getBoolean(PERMISSION_VOUCHERREPORTBUTTON, false);
    }
    public void setPERMISSION_VOUCHERREPORTBUTTON(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_VOUCHERREPORTBUTTON, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FUNDSTRANSFERREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_FUNDSTRANSFERREPORT, false);
    }
    public void setPERMISSION_FUNDSTRANSFERREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FUNDSTRANSFERREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RECORDREVENUE(){
        return sharedPreferences.getBoolean(PERMISSION_RECORDREVENUE, false);
    }
    public void setPERMISSION_RECORDREVENUE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RECORDREVENUE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RECEIVEREVENUE(){
        return sharedPreferences.getBoolean(PERMISSION_RECEIVEREVENUE, false);
    }
    public void setPERMISSION_RECEIVEREVENUE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RECEIVEREVENUE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTFINANCIALSTATEMENT(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTFINANCIALSTATEMENT, false);
    }
    public void setPERMISSION_STUDENTFINANCIALSTATEMENT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTFINANCIALSTATEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DAILYTRANSACTIONREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_DAILYTRANSACTIONREPORT, false);
    }
    public void setPERMISSION_DAILYTRANSACTIONREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DAILYTRANSACTIONREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DELETEEXPENSE(){
        return sharedPreferences.getBoolean(PERMISSION_DELETEEXPENSE, false);
    }
    public void setPERMISSION_DELETEEXPENSE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DELETEEXPENSE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLREVENUESUMMARYREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLREVENUESUMMARYREPORT, false);
    }
    public void setPERMISSION_SCHOOLREVENUESUMMARYREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLREVENUESUMMARYREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CHARTOFACCOUNTS(){
        return sharedPreferences.getBoolean(PERMISSION_CHARTOFACCOUNTS, false);
    }
    public void setPERMISSION_CHARTOFACCOUNTS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CHARTOFACCOUNTS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTBALANCES(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTBALANCES, false);
    }
    public void setPERMISSION_STUDENTBALANCES(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTBALANCES, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DAILYFINANCIALSUMMARY(){
        return sharedPreferences.getBoolean(PERMISSION_DAILYFINANCIALSUMMARY, false);
    }
    public void setPERMISSION_DAILYFINANCIALSUMMARY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DAILYFINANCIALSUMMARY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BULKSTUDENTBILLING(){
        return sharedPreferences.getBoolean(PERMISSION_BULKSTUDENTBILLING, false);
    }
    public void setPERMISSION_BULKSTUDENTBILLING(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BULKSTUDENTBILLING, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FINANCIALACCOUNTBALANCE(){
        return sharedPreferences.getBoolean(PERMISSION_FINANCIALACCOUNTBALANCE, false);
    }
    public void setPERMISSION_FINANCIALACCOUNTBALANCE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FINANCIALACCOUNTBALANCE, isAllow);
        editor.commit();
    }


    /** Payroll Management*/
    public boolean getPERMISSION_CREATEEMPLOYEEPAYROLL(){
        return sharedPreferences.getBoolean(PERMISSION_CREATEEMPLOYEEPAYROLL, false);
    }

    public void setPERMISSION_CREATEEMPLOYEEPAYROLL(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATEEMPLOYEEPAYROLL, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWEMPLOYEEPAYROLL(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWEMPLOYEEPAYROLL, false);
    }

    public void setPERMISSION_REVIEWEMPLOYEEPAYROLL(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWEMPLOYEEPAYROLL, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATEEMPLOYEEPAYROLLDETAILS(){
        return  sharedPreferences.getBoolean(PERMISSION_CREATEEMPLOYEEPAYROLLDETAILS, false);
    }

    public void setPERMISSION_CREATEEMPLOYEEPAYROLLDETAILS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATEEMPLOYEEPAYROLLDETAILS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWEMPLOYEEPAYROLLDETAILS(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWEMPLOYEEPAYROLLDETAILS, false);
    }

    public void setPERMISSION_REVIEWEMPLOYEEPAYROLLDETAILS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWEMPLOYEEPAYROLLDETAILS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATEEMPLOYEEPAYROLLDETAILS(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATEEMPLOYEEPAYROLLDETAILS, false);
    }

    public void setPERMISSION_UPDATEEMPLOYEEPAYROLLDETAILS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEEMPLOYEEPAYROLLDETAILS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATEPAYROLLDEDUCTADD(){
        return sharedPreferences.getBoolean(PERMISSION_CREATEPAYROLLDEDUCTADD, false);
    }

    public void setPERMISSION_CREATEPAYROLLDEDUCTADD(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATEPAYROLLDEDUCTADD, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWPAYROLLDEDUCTADD(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWPAYROLLDEDUCTADD, false);
    }

    public void setPERMISSION_REVIEWPAYROLLDEDUCTADD(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWPAYROLLDEDUCTADD, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATEPAYROLLDEDUCTADD(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATEPAYROLLDEDUCTADD, false);
    }

    public void setPERMISSION_UPDATEPAYROLLDEDUCTADD(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEPAYROLLDEDUCTADD, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_GENERATEPAYSLIPPDF(){
        return sharedPreferences.getBoolean(PERMISSION_GENERATEPAYSLIPPDF, false);
    }

    public void setPERMISSION_GENERATEPAYSLIPPDF(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_GENERATEPAYSLIPPDF, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SENDPAYROLLNOTIFICATION(){
        return sharedPreferences.getBoolean(PERMISSION_SENDPAYROLLNOTIFICATION, false);
    }

    public void setPERMISSION_SENDPAYROLLNOTIFICATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SENDPAYROLLNOTIFICATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYROLLSUMMARRYREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_PAYROLLSUMMARRYREPORT, false);
    }

    public void setPERMISSION_PAYROLLSUMMARRYREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYROLLSUMMARRYREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYROLLSUMMARRYREPORT_NNS(){
        return sharedPreferences.getBoolean(PERMISSION_PAYROLLSUMMARRYREPORT_NNS, false);
    }

    public void setPERMISSION_PAYROLLSUMMARRYREPORT_NNS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYROLLSUMMARRYREPORT_NNS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BULKPAYROLLPROCESSING(){
        return sharedPreferences.getBoolean(PERMISSION_BULKPAYROLLPROCESSING, false);
    }

    public void setPERMISSION_BULKPAYROLLPROCESSING(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BULKPAYROLLPROCESSING, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_EMPLOYEEADDITIONDEDUCTION(){
        return sharedPreferences.getBoolean(PERMISSION_EMPLOYEEADDITIONDEDUCTION, false);
    }

    public void setPERMISSION_EMPLOYEEADDITIONDEDUCTION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_EMPLOYEEADDITIONDEDUCTION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RECORDLOAN(){
        return sharedPreferences.getBoolean(PERMISSION_RECORDLOAN, false);
    }

    public void setPERMISSION_RECORDLOAN(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RECORDLOAN, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SETUPEMPLOYEELOANTERMS(){
        return sharedPreferences.getBoolean(PERMISSION_SETUPEMPLOYEELOANTERMS, false);
    }

    public void setPERMISSION_SETUPEMPLOYEELOANTERMS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SETUPEMPLOYEELOANTERMS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYROLLPAYMENT(){
        return sharedPreferences.getBoolean(PERMISSION_PAYROLLPAYMENT, false);
    }

    public void setPERMISSION_PAYROLLPAYMENT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYROLLPAYMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYROLLREPORTSEXPORT(){
        return sharedPreferences.getBoolean(PERMISSION_PAYROLLREPORTSEXPORT, false);
    }

    public void setPERMISSION_PAYROLLREPORTSEXPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYROLLREPORTSEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FIXEDASSET(){
        return sharedPreferences.getBoolean(PERMISSION_FIXEDASSET, false);
    }

    public void setPERMISSION_FIXEDASSET(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FIXEDASSET, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FIXEDASSETREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_FIXEDASSETREPORT, false);
    }

    public void setPERMISSION_FIXEDASSETREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FIXEDASSETREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DEPRECIATIONSCHEDULE(){
        return sharedPreferences.getBoolean(PERMISSION_DEPRECIATIONSCHEDULE, false);
    }

    public void setPERMISSION_DEPRECIATIONSCHEDULE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DEPRECIATIONSCHEDULE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATEDEPRECIATIONSCHEDULE(){
        return sharedPreferences.getBoolean(PERMISSION_UPDATEDEPRECIATIONSCHEDULE, false);
    }

    public void setPERMISSION_UPDATEDEPRECIATIONSCHEDULE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEDEPRECIATIONSCHEDULE, isAllow);
        editor.commit();
    }


    /** Classroom setup*/

    public boolean getPERMISSION_NEWCLASSROOMSETUP() {
        return sharedPreferences.getBoolean(PERMISSION_NEWCLASSROOMSETUP, false);
    }

    public void setPERMISSION_NEWCLASSROOMSETUP(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_NEWCLASSROOMSETUP, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ATTENDANCE() {
        return sharedPreferences.getBoolean(PERMISSION_ATTENDANCE, false);
    }

    public void setPERMISSION_ATTENDANCE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ATTENDANCE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_GRADES() {
        return sharedPreferences.getBoolean(PERMISSION_GRADES, false);
    }

    public void setPERMISSION_GRADES(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_GRADES, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CLASSROOMNOTIFICATION() {
        return sharedPreferences.getBoolean(PERMISSION_CLASSROOMNOTIFICATION, false);
    }

    public void setPERMISSION_CLASSROOMNOTIFICATION(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CLASSROOMNOTIFICATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTSBYCLASSROOM() {
        return sharedPreferences.getBoolean(PERMISSION_STUDENTSBYCLASSROOM, false);
    }

    public void setPERMISSION_STUDENTSBYCLASSROOM(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTSBYCLASSROOM, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RAWGRADERECORDING() {
        return sharedPreferences.getBoolean(PERMISSION_RAWGRADERECORDING, false);
    }

    public void setPERMISSION_RAWGRADERECORDING(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RAWGRADERECORDING, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_GRADESREVIEW() {
        return sharedPreferences.getBoolean(PERMISSION_GRADESREVIEW, false);
    }

    public void setPERMISSION_GRADESREVIEW(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_GRADESREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTMINIPROFILE() {
        return sharedPreferences.getBoolean(PERMISSION_STUDENTMINIPROFILE, false);
    }

    public void setPERMISSION_STUDENTMINIPROFILE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTMINIPROFILE, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_CLASSNOTIFICATIONHISTORY() {
        return sharedPreferences.getBoolean(PERMISSION_CLASSNOTIFICATIONHISTORY, false);
    }

    public void setPERMISSION_CLASSNOTIFICATIONHISTORY(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CLASSNOTIFICATIONHISTORY, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_SENDGRADENOTIFICATION() {
        return sharedPreferences.getBoolean(PERMISSION_SENDGRADENOTIFICATION, false);
    }

    public void setPERMISSION_SENDGRADENOTIFICATION(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SENDGRADENOTIFICATION, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_SENDRAWGRADENOTIFICATION() {
        return sharedPreferences.getBoolean(PERMISSION_SENDRAWGRADENOTIFICATION, false);
    }

    public void setPERMISSION_SENDRAWGRADENOTIFICATION(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SENDRAWGRADENOTIFICATION, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_MANUALFINALMARKENTRY() {
        return sharedPreferences.getBoolean(PERMISSION_MANUALFINALMARKENTRY, false);
    }

    public void setPERMISSION_MANUALFINALMARKENTRY(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MANUALFINALMARKENTRY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_EDITGRADE() {
        return sharedPreferences.getBoolean(PERMISSION_EDITGRADE, false);
    }

    public void setPERMISSION_EDITGRADE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_EDITGRADE, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_ATTENDANCESUMMARYREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_ATTENDANCESUMMARYREPORT, false);
    }

    public void setPERMISSION_ATTENDANCESUMMARYREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ATTENDANCESUMMARYREPORT, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_MANUALFINALMARKREVIEW() {
        return sharedPreferences.getBoolean(PERMISSION_MANUALFINALMARKREVIEW, false);
    }

    public void setPERMISSION_MANUALFINALMARKREVIEW(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_MANUALFINALMARKREVIEW, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_CLASSROOMREVIEW() {
        return sharedPreferences.getBoolean(PERMISSION_CLASSROOMREVIEW, false);
    }

    public void setPERMISSION_CLASSROOMREVIEW(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CLASSROOMREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATECLASSROOM() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATECLASSROOM, false);
    }

    public void setPERMISSION_UPDATECLASSROOM(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATECLASSROOM, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CLASSPERFORMANCEREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_CLASSPERFORMANCEREPORT, false);
    }
    public void setPERMISSION_CLASSPERFORMANCEREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CLASSPERFORMANCEREPORT, isAllow);
        editor.commit();
    }
    public boolean getPERMISSION_ASSIGNGRADE(){
        return sharedPreferences.getBoolean(PERMISSION_ASSIGNGRADE, false);
    }
    public void setPERMISSION_ASSIGNGRADE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ASSIGNGRADE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SENDATTENDANCENOTIFICATION(){
        return sharedPreferences.getBoolean(PERMISSION_SENDATTENDANCENOTIFICATION, false);
    }
    public void setPERMISSION_SENDATTENDANCENOTIFICATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SENDATTENDANCENOTIFICATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RESENDGRADENOTIFICATION() {
        return sharedPreferences.getBoolean(PERMISSION_RESENDGRADENOTIFICATION, false);
    }

    public void setPERMISSION_RESENDGRADENOTIFICATION(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RESENDGRADENOTIFICATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ATTENDANCEREVIEW() {
        return sharedPreferences.getBoolean(PERMISSION_ATTENDANCEREVIEW, false);
    }

    public void setPERMISSION_ATTENDANCEREVIEW(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ATTENDANCEREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CLASSROOMSCHEDULEREVIEW() {
        return sharedPreferences.getBoolean(PERMISSION_CLASSROOMSCHEDULEREVIEW, false);
    }

    public void setPERMISSION_CLASSROOMSCHEDULEREVIEW(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CLASSROOMSCHEDULEREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ADDADDITIONALDETAILS(){
        return sharedPreferences.getBoolean(PERMISSION_ADDADDITIONALDETAILS, false);
    }
    public void setPERMISSION_ADDADDITIONALDETAILS(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ADDADDITIONALDETAILS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ATTENDANCEBYSUBJECTREVIEW(){
        return sharedPreferences.getBoolean(PERMISSION_ATTENDANCEBYSUBJECTREVIEW, false);
    }
    public void setPERMISSION_ATTENDANCEBYSUBJECTREVIEW(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ATTENDANCEBYSUBJECTREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ATTENDANCEBYSUBJECTUPDATE(){
        return sharedPreferences.getBoolean(PERMISSION_ATTENDANCEBYSUBJECTUPDATE, false);
    }
    public void setPERMISSION_ATTENDANCEBYSUBJECTUPDATE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ATTENDANCEBYSUBJECTUPDATE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ATTENDANCEUPDATE(){
        return  sharedPreferences.getBoolean(PERMISSION_ATTENDANCEUPDATE, false);
    }
    public void setPERMISSION_ATTENDANCEUPDATE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ATTENDANCEUPDATE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DELETEATTENDANCE(){
        return sharedPreferences.getBoolean(PERMISSION_DELETEATTENDANCE, false);
    }
    public void setPERMISSION_DELETEATTENDANCE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DELETEATTENDANCE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DELETEGRADE(){
        return sharedPreferences.getBoolean(PERMISSION_DELETEGRADES, false);
    }
    public void setPERMISSION_DELETEGRADES(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DELETEGRADES, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTFINALMARKREVIEW(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTFINALMARKREVIEW, false);
    }
    public void setPERMISSION_STUDENTFINALMARKREVIEW(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTFINALMARKREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_GENERATEPROGRESSREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_GENERATEPROGRESSREPORT, false);
    }
    public void setPERMISSION_GENERATEPROGRESSREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_GENERATEPROGRESSREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWPROGRESSREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_REVIEWPROGRESSREPORT, false);
    }
    public void setPERMISSION_REVIEWPROGRESSREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWPROGRESSREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_EDITPROGRESSREPORT(){
        return sharedPreferences.getBoolean(PERMISSION_EDITPROGRESSREPORT, false);
    }
    public void setPERMISSION_EDITPROGRESSREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_EDITPROGRESSREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_COPYCLASSROOMSCHEDULE(){
        return sharedPreferences.getBoolean(PERMISSION_COPYCLASSROOMSCHEDULE, false);
    }
    public void setPERMISSION_COPYCLASSROOMSCHEDULE(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_COPYCLASSROOMSCHEDULE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTPROMOTION(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTPROMOTION, false);
    }
    public void setPERMISSION_STUDENTPROMOTION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTPROMOTION, isAllow);
        editor.commit();
    }


    /** student review/record */
    public boolean getPERMISSION_RECORDSTUDENTFINALGRADE() {
        return sharedPreferences.getBoolean(PERMISSION_RECORDSTUDENTFINALGRADE, false);
    }

    public void setPERMISSION_RECORDSTUDENTFINALGRADE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RECORDSTUDENTFINALGRADE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RECORDSTUDENTBEHAVIOR() {
        return sharedPreferences.getBoolean(PERMISSION_RECORDSTUDENTBEHAVIOR, false);
    }

    public void setPERMISSION_RECORDSTUDENTBEHAVIOR(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RECORDSTUDENTBEHAVIOR, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_RECORDSTUDENTPROFILE() {
        return sharedPreferences.getBoolean(PERMISSION_RECORDSTUDENTPROFILE, false);
    }

    public void setPERMISSION_RECORDSTUDENTPROFILE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RECORDSTUDENTPROFILE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWSTUDENTFINALGRADE() {
        return sharedPreferences.getBoolean(PERMISSION_REVIEWSTUDENTFINALGRADE, false);
    }

    public void setPERMISSION_REVIEWSTUDENTFINALGRADE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWSTUDENTFINALGRADE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWSTUDENTBEHAVIOR() {
        return sharedPreferences.getBoolean(PERMISSION_REVIEWSTUDENTBEHAVIOR, false);
    }

    public void setPERMISSION_REVIEWSTUDENTBEHAVIOR(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWSTUDENTBEHAVIOR, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWSTUDENTATTENDANCE() {
        return sharedPreferences.getBoolean(PERMISSION_REVIEWSTUDENTATTENDANCE, false);
    }

    public void setPERMISSION_REVIEWSTUDENTATTENDANCE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWSTUDENTATTENDANCE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REVIEWSTUDENTGRADES() {
        return sharedPreferences.getBoolean(PERMISSION_REVIEWSTUDENTGRADES, false);
    }

    public void setPERMISSION_REVIEWSTUDENTGRADES(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REVIEWSTUDENTGRADES, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATESTUDENTPROFILE() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATESTUDENTPROFILE, false);
    }

    public void setPERMISSION_UPDATESTUDENTPROFILE(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATESTUDENTPROFILE, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SENDBEHAVIORNOTIFICATION(){
        return sharedPreferences.getBoolean(PERMISSION_SENDBEHAVIORNOTIFICATION, false);
    }
    public void setPERMISSION_SENDBEHAVIORNOTIFICATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SENDBEHAVIORNOTIFICATION, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DELETEBEHAVIOR(){
        return sharedPreferences.getBoolean(PERMISSION_DELETEBEHAVIOR, false);
    }
    public void setPERMISSION_DELETEBEHAVIOR(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DELETEBEHAVIOR, isAllow);
        editor.commit();
    }

    /** CRECHE NURSERY MANAGEMENT */

    public boolean getPERMISSION_CRECHENURSERYMANAGEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_CRECHENURSERYMANAGEMENT, false);
    }

    public void setPERMISSION_CRECHENURSERYMANAGEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CRECHENURSERYMANAGEMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CHILDDEVELOPMENTASSESSMENT() {
        return sharedPreferences.getBoolean(PERMISSION_CHILDDEVELOPMENTASSESSMENT, false);
    }

    public void setPERMISSION_CHILDDEVELOPMENTASSESSMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CHILDDEVELOPMENTASSESSMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_NURSERYCRECHEGRADERECORDING() {
        return sharedPreferences.getBoolean(PERMISSION_NURSERYCRECHEGRADERECORDING, false);
    }

    public void setPERMISSION_NURSERYCRECHEGRADERECORDING(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_NURSERYCRECHEGRADERECORDING, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CRECHEASSESSMENTREVIEW() {
        return sharedPreferences.getBoolean(PERMISSION_CRECHEASSESSMENTREVIEW, false);
    }

    public void setPERMISSION_CRECHEASSESSMENTREVIEW(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CRECHEASSESSMENTREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CHILDASSESSMENTREVIEW() {
        return sharedPreferences.getBoolean(PERMISSION_CHILDASSESSMENTREVIEW, false);
    }

    public void setPERMISSION_CHILDASSESSMENTREVIEW(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CHILDASSESSMENTREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_NURSERYCRECHEGRADERECORDINGREVIEW(){
        return sharedPreferences.getBoolean(PERMISSION_NURSERYCRECHEGRADERECORDINGREVIEW, false);
    }
    public void setPERMISSION_NURSERYCRECHEGRADERECORDINGREVIEW(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_NURSERYCRECHEGRADERECORDINGREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_NURSERYCRECHEGRADERECORDINGEDIT(){
        return sharedPreferences.getBoolean(PERMISSION_NURSERYCRECHEGRADERECORDINGEDIT, false);
    }
    public void setPERMISSION_NURSERYCRECHEGRADERECORDINGEDIT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_NURSERYCRECHEGRADERECORDINGEDIT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CRECHEASSESSMENTEDIT(){
        return  sharedPreferences.getBoolean(PERMISSION_CRECHEASSESSMENTEDIT, false);
    }
    public void setPERMISSION_CRECHEASSESSMENTEDIT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CRECHEASSESSMENTEDIT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ADDCHILDASSESSMENTCATEGORY(){
        return  sharedPreferences.getBoolean(PERMISSION_ADDCHILDASSESSMENTCATEGORY, false);
    }
    public void setPERMISSION_ADDCHILDASSESSMENTCATEGORY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ADDCHILDASSESSMENTCATEGORY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DELETECHILDASSESSMENT(){
        return  sharedPreferences.getBoolean(PERMISSION_DELETECHILDASSESSMENT, false);
    }
    public void setPERMISSION_DELETECHILDASSESSMENT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DELETECHILDASSESSMENT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ASSIGNCLASSCATEGORY(){
        return  sharedPreferences.getBoolean(PERMISSION_ASSIGNCLASSCATEGORY, false);
    }
    public void setPERMISSION_ASSIGNCLASSCATEGORY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ASSIGNCLASSCATEGORY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_DEVELOPMENTCATEGORYREVIEW(){
        return  sharedPreferences.getBoolean(PERMISSION_DEVELOPMENTCATEGORYREVIEW, false);
    }
    public void setPERMISSION_DEVELOPMENTCATEGORYREVIEW(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_DEVELOPMENTCATEGORYREVIEW, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATECHILDDEVELOPMENTCATEGORY(){
        return  sharedPreferences.getBoolean(PERMISSION_UPDATECHILDDEVELOPMENTCATEGORY, false);
    }
    public void setPERMISSION_UPDATECHILDDEVELOPMENTCATEGORY(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATECHILDDEVELOPMENTCATEGORY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CHILDASSESSMENTREPORT(){
        return  sharedPreferences.getBoolean(PERMISSION_CHILDASSESSMENTREPORT, false);
    }
    public void setPERMISSION_CHILDASSESSMENTREPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CHILDASSESSMENTREPORT, isAllow);
        editor.commit();
    }
    public boolean getPERMISSION_CHILDASSESSMENTNOTIFICATION(){
        return  sharedPreferences.getBoolean(PERMISSION_CHILDASSESSMENTNOTIFICATION, false);
    }
    public void setPERMISSION_CHILDASSESSMENTNOTIFICATION(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CHILDASSESSMENTREPORT, isAllow);
        editor.commit();
    }


    /** Inventory */
    public boolean getPERMISSION_INVENTORYMANAGEMENT() {
        return sharedPreferences.getBoolean(PERMISSION_INVENTORYMANAGEMENT, false);
    }

    public void setPERMISSION_INVENTORYMANAGEMENT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_INVENTORYMANAGEMENT, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_RECORDINVENTORY() {
        return sharedPreferences.getBoolean(PERMISSION_RECORDINVENTORY, false);
    }

    public void setPERMISSION_RECORDINVENTORY(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_RECORDINVENTORY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATEINVENTORYITEM() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATEINVENTORYITEM, false);
    }

    public void setPERMISSION_UPDATEINVENTORYITEM(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEINVENTORYITEM, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CREATEINVENTORYCATEGORY() {
        return sharedPreferences.getBoolean(PERMISSION_CREATEINVENTORYCATEGORY, false);
    }

    public void setPERMISSION_CREATEINVENTORYCATEGORY(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CREATEINVENTORYCATEGORY, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_INVENTORYCATEGORIES() {
        return sharedPreferences.getBoolean(PERMISSION_INVENTORYCATEGORIES, false);
    }

    public void setPERMISSION_INVENTORYCATEGORIES(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_INVENTORYCATEGORIES, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_INVENTORYITEMS() {
        return sharedPreferences.getBoolean(PERMISSION_INVENTORYITEMS, false);
    }

    public void setPERMISSION_INVENTORYITEMS(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_INVENTORYITEMS, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UPDATEINVENTORYCATEGORY() {
        return sharedPreferences.getBoolean(PERMISSION_UPDATEINVENTORYCATEGORY, false);
    }

    public void setPERMISSION_UPDATEINVENTORYCATEGORY(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UPDATEINVENTORYCATEGORY, isAllow);
        editor.commit();
    }

    /**Report Management**/

    public boolean getPERMISSION_VIEWPROGRESSREPORT() {
        return sharedPreferences.getBoolean(PERMISSION_VIEWPROGRESSREPORT, false);
    }

    public void setPERMISSION_VIEWPROGRESSREPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_VIEWPROGRESSREPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PROGRESSREPORTSTATUS() {
        return sharedPreferences.getBoolean(PERMISSION_PROGRESSREPORTSTATUS, false);
    }

    public void setPERMISSION_PROGRESSREPORTSTATUS(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PROGRESSREPORTSTATUS, isAllow);
        editor.commit();
    }


    /**PAID SERVICES PERMISSIONS***/

    public boolean getPERMISSION_BUYSMSREQUESTSUPPORT() {
        return sharedPreferences.getBoolean(PERMISSION_BUYSMSREQUESTSUPPORT, false);
    }

    public void setPERMISSION_BUYSMSREQUESTSUPPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BUYSMSREQUESTSUPPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BUYSMSEMAIL() {
        return sharedPreferences.getBoolean(PERMISSION_BUYSMSEMAIL, false);
    }

    public void setPERMISSION_BUYSMSEMAIL(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BUYSMSEMAIL, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_REQUESTSUPPORT() {
        return sharedPreferences.getBoolean(PERMISSION_REQUESTSUPPORT, false);
    }

    public void setPERMISSION_REQUESTSUPPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_REQUESTSUPPORT, isAllow);
        editor.commit();
    }


    /***
     * Export Buttons Permissions
     * */


    public boolean getPERMISSION_INVOICEBILLLEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_INVOICEBILLLEXPORT, false);
    }

    public void setPERMISSION_INVOICEBILLLEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_INVOICEBILLLEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYMENTHISTORYEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_PAYMENTHISTORYEXPORT, false);
    }

    public void setPERMISSION_PAYMENTHISTORYEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYMENTHISTORYEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BILLITEMINVOICEEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_BILLITEMINVOICEEXPORT, false);
    }

    public void setPERMISSION_BILLITEMINVOICEEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BILLITEMINVOICEEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BILLITEMPAYMENTEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_BILLITEMPAYMENTEXPORT, false);
    }

    public void setPERMISSION_BILLITEMPAYMENTEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BILLITEMPAYMENTEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLREVENUEEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLREVENUEEXPORT, false);
    }

    public void setPERMISSION_SCHOOLREVENUEEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLREVENUEEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_SCHOOLEXPENSEEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_SCHOOLEXPENSEEXPORT, false);
    }

    public void setPERMISSION_SCHOOLEXPENSEEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_SCHOOLEXPENSEEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CASHFLOWEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_CASHFLOWEXPORT, false);
    }

    public void setPERMISSION_CASHFLOWEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CASHFLOWEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ADVANCEPAYMENTEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_ADVANCEPAYMENTEXPORT, false);
    }

    public void setPERMISSION_ADVANCEPAYMENTEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ADVANCEPAYMENTEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_UNBILLEDSTUDENTSEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_UNBILLEDSTUDENTSEXPORT, false);
    }

    public void setPERMISSION_UNBILLEDSTUDENTSEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_UNBILLEDSTUDENTSEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BADDEPTSEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_BADDEPTSEXPORT, false);
    }

    public void setPERMISSION_BADDEPTSEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BADDEPTSEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_BANKACTIVITIESEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_BANKACTIVITIESEXPORT, false);
    }

    public void setPERMISSION_BANKACTIVITIESEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_BANKACTIVITIESEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_FINALREPORTEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_FINALREPORTEXPORT, false);
    }

    public void setPERMISSION_FINALREPORTEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_FINALREPORTEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PROGRESSREPORTEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_PROGRESSREPORTEXPORT, false);
    }

    public void setPERMISSION_PROGRESSREPORTEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PROGRESSREPORTEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_GENERATEPAYSLIPEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_GENERATEPAYSLIPEXPORT, false);
    }

    public void setPERMISSION_GENERATEPAYSLIPEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_GENERATEPAYSLIPEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_PAYROLLSUMMARYEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_PAYROLLSUMMARYEXPORT, false);
    }

    public void setPERMISSION_PAYROLLSUMMARYEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_PAYROLLSUMMARYEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_ATTENDANCEEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_ATTENDANCEEXPORT, false);
    }

    public void setPERMISSION_ATTENDANCEEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_ATTENDANCEEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_GRADEEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_GRADEEXPORT, false);
    }

    public void setPERMISSION_GRADEEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_GRADEEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_STUDENTTRANSCRIPTEXPORT(){
        return sharedPreferences.getBoolean(PERMISSION_STUDENTTRANSCRIPTEXPORT, false);
    }
    public void setPERMISSION_STUDENTTRANSCRIPTEXPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTTRANSCRIPTEXPORT, isAllow);
        editor.commit();
    }


    public boolean getPERMISSION_STUDENTBYCLASSEXPORT() {
        return sharedPreferences.getBoolean(PERMISSION_STUDENTBYCLASSEXPORT, false);
    }

    public void setPERMISSION_STUDENTBYCLASSEXPORT(boolean isAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_STUDENTBYCLASSEXPORT, isAllow);
        editor.commit();
    }

    public boolean getPERMISSION_CLASSROOMREVIEWEXPORT(){
        return sharedPreferences.getBoolean(PERMISSION_CLASSROOMREVIEWEXPORT, false);
    }
    public void setPERMISSION_CLASSROOMREVIEWEXPORT(boolean isAllow){
        Editor editor = getEditor();
        editor.putBoolean(PERMISSION_CLASSROOMREVIEWEXPORT, isAllow);
        editor.commit();
    }



    //Role
    public String getRole() {
        return sharedPreferences.getString(PREF_ROLE, null);
    }

    public void setRole(String userRole) {
        Editor editor = getEditor();
        editor.putString(PREF_ROLE, userRole);
        editor.commit();
    }



    public int getRoleId() {
        int roleId = 1;
        String strRole = getRole();
        if (strRole.equalsIgnoreCase("Test_Role")) {
            roleId = 1;
        } else if (strRole.equalsIgnoreCase("Parent")) {
            roleId = 2;
        } else if (strRole.equalsIgnoreCase("Staff")) {
            roleId = 3;
        } else if (strRole.equalsIgnoreCase("Teacher")) {
            roleId = 4;
        } else if (strRole.equalsIgnoreCase("Head Principal")) {
            roleId = 5;
        } else if (strRole.equalsIgnoreCase("School Owner")) {
            roleId = 6;
        }
        return roleId;
    }

    //Cache Data
    public void setCacheDataAllow(boolean cacheDataAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PREF_CACHEDATAALLOW, cacheDataAllow);
        editor.commit();
    }

    public boolean getCacheDataAllow() {
        return sharedPreferences.getBoolean(PREF_CACHEDATAALLOW, true);
    }

    //Auto Sync
    public void setAutoSyncAllow(boolean cacheDataAllow) {
        Editor editor = getEditor();
        editor.putBoolean(PREF_AUTOSYNCTOSERVER, cacheDataAllow);
        editor.commit();
    }

    public boolean getAutoSyncAllow() {
        return sharedPreferences.getBoolean(PREF_AUTOSYNCTOSERVER, true);
    }

    //Usage Report
    public void setWeekUsageReport(String userRole) {
        Editor editor = getEditor();
        editor.putString(PREF_WEEKUSAGEREPORT, userRole);
        editor.commit();
    }

    public String getWeekUsageReport() {
        return sharedPreferences.getString(PREF_WEEKUSAGEREPORT, null);
    }

    public void setMonthUsageReport(String userRole) {
        Editor editor = getEditor();
        editor.putString(PREF_MONTHUSAGEREPORT, userRole);
        editor.commit();
    }

    public String getMonthUsageReport() {
        return sharedPreferences.getString(PREF_MONTHUSAGEREPORT, null);
    }

    public void setYearUsageReport(String userRole) {
        Editor editor = getEditor();
        editor.putString(PREF_YEARUSAGEREPORT, userRole);
        editor.commit();
    }

    public String getYearUsageReport() {
        return sharedPreferences.getString(PREF_YEARUSAGEREPORT, null);
    }

    public String getSchoolNotificationCopyMessage() {
        return sharedPreferences.getString(SCHOOL_NOTIFICATION_MESSAGE_COPY, "");
    }

    public void setSchoolNotificationCopyMessage(String msg) {
        Editor editor = getEditor();
        editor.putString(SCHOOL_NOTIFICATION_MESSAGE_COPY, msg);
        editor.commit();
    }

    public void removeSchoolNotificationCopyMessage() {
        Editor editor = getEditor();
        editor.remove(SCHOOL_NOTIFICATION_MESSAGE_COPY);
        editor.commit();
    }

    // Clear Data

    public void clearAllData() {
        setToken("");
        setBase64("");
        setRole("");
        setSchoolName("");
        setWeekUsageReport("");
        setMonthUsageReport("");
        setYearUsageReport("");
        setCOURSECACHE("");
        setClassroomCache("");
        setTermCache("");
        setDevCategoryCache("");
        setAccountTypeCache("");
        setBranchCache("");
        setSignatureCache("");
        SCHOOL_ARRAY.clear();
        listOfClassroom.clear();



    }
    public void clearSchoolArray(){
        SCHOOL_ARRAY.clear();
    }

    public void clearClassroomArray(){
        listOfClassroom.clear();
    }

    public void saveUserProfile(String str) {
        Editor editor = getEditor();
        editor.putString(PREF_USERPROFILE, str);
        editor.commit();
    }

    public String getUserProfile() {
        return sharedPreferences.getString(PREF_USERPROFILE, null);
    }


    public String getDeviceInfo() {
        String strFirebaseToken = FirebaseInstanceId.getInstance().getToken();
        StringBuilder sb = new StringBuilder("OS Name: ");

        Field[] fields = Build.VERSION_CODES.class.getFields();
        for (Field field : fields) {

            String fieldName = field.getName();
            int fieldValue = -1;

            try {
                fieldValue = field.getInt(new Object());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            if (fieldValue == Build.VERSION.SDK_INT) {
                sb.append(fieldName);
            }

        }
        sb.append(", ");
        sb.append("OS Version: ");
        sb.append(Build.VERSION.RELEASE);
        sb.append(", ");
        sb.append("Device: ");
        sb.append(getDeviceName());
        sb.append(", ");
        sb.append("Model: ");
        sb.append(Build.MODEL);
        sb.append(", ");
        sb.append("Manufacturer: ");
        sb.append(android.os.Build.MANUFACTURER);
        sb.append(", ");
        sb.append("Firebase_Key: ");
        sb.append(strFirebaseToken);
        // Log.w("Device Info",sb.toString());
        return sb.toString();
    }

    public static String getDeviceName() {
        final String manufacturer = Build.MANUFACTURER;
        final String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        if (manufacturer.equalsIgnoreCase("HTC")) {
            // make sure "HTC" is fully capitalized.
            return "HTC " + model;
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        final char[] arr = str.toCharArray();
        boolean capitalizeNext = true;
        String phrase = "";
        for (final char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase += Character.toUpperCase(c);
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase += c;
        }
        return phrase;
    }

}
