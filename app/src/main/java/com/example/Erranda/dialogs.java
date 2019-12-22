package com.example.Erranda;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.android.volley.VolleyLog.TAG;

public class dialogs extends Context {


    private void cancelMethod() {

    }

    public static void okMethod() {


    }


    public static void customDialog(String title, String message, final String cancelMethod, final String okMethod) {
         androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder( new dialogs() );

        //  builderSingle.setIcon( R.drawable.momo2 );
        builderSingle.setTitle( title );
        builderSingle.setMessage( message );

        builderSingle.setTitle( title );
        builderSingle.setMessage( message );

        builderSingle.setCancelable( false );

        builderSingle.setPositiveButton(

                "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Log.d( TAG, "onClick: Enter Code Called." );
                        if (okMethod.equals( "okMethod" )) {
                            okMethod();
                        }

                    }
                } );
        builderSingle.show();

    }

    private void toastMessage(String message) {
        Toast.makeText( new dialogs(), message, Toast.LENGTH_SHORT ).show();
    }


    /**
     * Returns an AssetManager instance for the application's package.
     * <p>
     * <strong>Note:</strong> Implementations of this method should return
     * an AssetManager instance that is consistent with the Resources instance
     * returned by {@link #getResources()}. For example, they should share the
     * same {@link Configuration} object.
     *
     * @return an AssetManager instance for the application's package
     * @see #getResources()
     */
    @Override
    public AssetManager getAssets() {
        return null;
    }

    /**
     * Returns a Resources instance for the application's package.
     * <p>
     * <strong>Note:</strong> Implementations of this method should return
     * a Resources instance that is consistent with the AssetManager instance
     * returned by {@link #getAssets()}. For example, they should share the
     * same {@link Configuration} object.
     *
     * @return a Resources instance for the application's package
     * @see #getAssets()
     */
    @Override
    public Resources getResources() {
        return null;
    }

    /**
     * Return PackageManager instance to find global package information.
     */
    @Override
    public PackageManager getPackageManager() {
        return null;
    }

    /**
     * Return a ContentResolver instance for your application's package.
     */
    @Override
    public ContentResolver getContentResolver() {
        return null;
    }

    /**
     * Return the Looper for the main thread of the current process.  This is
     * the thread used to dispatch calls to application components (activities,
     * services, etc).
     * <p>
     * By definition, this method returns the same result as would be obtained
     * by calling {@link Looper#getMainLooper() Looper.getMainLooper()}.
     * </p>
     *
     * @return The main looper.
     */
    @Override
    public Looper getMainLooper() {
        return null;
    }

    /**
     * Return the context of the single, global Application object of the
     * current process.  This generally should only be used if you need a
     * Context whose lifecycle is separate from the current context, that is
     * tied to the lifetime of the process rather than the current component.
     *
     * <p>Consider for example how this interacts with
     * {@link #registerReceiver(BroadcastReceiver, IntentFilter)}:
     * <ul>
     * <li> <p>If used from an Activity context, the receiver is being registered
     * within that activity.  This means that you are expected to unregister
     * before the activity is done being destroyed; in fact if you do not do
     * so, the framework will clean up your leaked registration as it removes
     * the activity and log an error.  Thus, if you use the Activity context
     * to register a receiver that is static (global to the process, not
     * associated with an Activity instance) then that registration will be
     * removed on you at whatever point the activity you used is destroyed.
     * <li> <p>If used from the Context returned here, the receiver is being
     * registered with the global state associated with your application.  Thus
     * it will never be unregistered for you.  This is necessary if the receiver
     * is associated with static data, not a particular component.  However
     * using the ApplicationContext elsewhere can easily lead to serious leaks
     * if you forget to unregister, unbind, etc.
     * </ul>
     */
    @Override
    public Context getApplicationContext() {
        return null;
    }

    /**
     * Set the base theme for this context.  Note that this should be called
     * before any views are instantiated in the Context (for example before
     * calling {@link Activity#setContentView} or
     * {@link LayoutInflater#inflate}).
     *
     * @param resid The style resource describing the theme.
     */
    @Override
    public void setTheme(int resid) {

    }

    /**
     * Return the Theme object associated with this Context.
     */
    @Override
    public Resources.Theme getTheme() {
        return null;
    }

    /**
     * Return a class loader you can use to retrieve classes in this package.
     */
    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    /**
     * Return the name of this application's package.
     */
    @Override
    public String getPackageName() {
        return null;
    }

    /**
     * Return the full application info for this context's package.
     */
    @Override
    public ApplicationInfo getApplicationInfo() {
        return null;
    }

    /**
     * Return the full path to this context's primary Android package.
     * The Android package is a ZIP file which contains the application's
     * primary resources.
     *
     * <p>Note: this is not generally useful for applications, since they should
     * not be directly accessing the file system.
     *
     * @return String Path to the resources.
     */
    @Override
    public String getPackageResourcePath() {
        return null;
    }

    /**
     * Return the full path to this context's primary Android package.
     * The Android package is a ZIP file which contains application's
     * primary code and assets.
     *
     * <p>Note: this is not generally useful for applications, since they should
     * not be directly accessing the file system.
     *
     * @return String Path to the code and assets.
     */
    @Override
    public String getPackageCodePath() {
        return null;
    }

    /**
     * Retrieve and hold the contents of the preferences file 'name', returning
     * a SharedPreferences through which you can retrieve and modify its
     * values.  Only one instance of the SharedPreferences object is returned
     * to any callers for the same name, meaning they will see each other's
     * edits as soon as they are made.
     * <p>
     * This method is thead-safe.
     *
     * @param name Desired preferences file. If a preferences file by this name
     *             does not exist, it will be created when you retrieve an
     *             editor (SharedPreferences.edit()) and then commit changes (Editor.commit()).
     * @param mode Operating mode.
     * @return The single {@link SharedPreferences} instance that can be used
     * to retrieve and modify the preference values.
     * @see #MODE_PRIVATE
     */
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return null;
    }

    /**
     * Move an existing shared preferences file from the given source storage
     * context to this context. This is typically used to migrate data between
     * storage locations after an upgrade, such as moving to device protected
     * storage.
     *
     * @param sourceContext The source context which contains the existing
     *                      shared preferences to move.
     * @param name          The name of the shared preferences file.
     * @return {@code true} if the move was successful or if the shared
     * preferences didn't exist in the source context, otherwise
     * {@code false}.
     * @see #createDeviceProtectedStorageContext()
     */
    @Override
    public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
        return false;
    }

    /**
     * Delete an existing shared preferences file.
     *
     * @param name The name (unique in the application package) of the shared
     *             preferences file.
     * @return {@code true} if the shared preferences file was successfully
     * deleted; else {@code false}.
     * @see #getSharedPreferences(String, int)
     */
    @Override
    public boolean deleteSharedPreferences(String name) {
        return false;
    }

    /**
     * Open a private file associated with this Context's application package
     * for reading.
     *
     * @param name The name of the file to open; can not contain path
     *             separators.
     * @return The resulting {@link FileInputStream}.
     * @see #openFileOutput
     * @see #fileList
     * @see #deleteFile
     * @see FileInputStream#FileInputStream(String)
     */
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        return null;
    }

    /**
     * Open a private file associated with this Context's application package
     * for writing. Creates the file if it doesn't already exist.
     * <p>
     * No additional permissions are required for the calling app to read or
     * write the returned file.
     *
     * @param name The name of the file to open; can not contain path
     *             separators.
     * @param mode Operating mode.
     * @return The resulting {@link FileOutputStream}.
     * @see #MODE_APPEND
     * @see #MODE_PRIVATE
     * @see #openFileInput
     * @see #fileList
     * @see #deleteFile
     * @see FileOutputStream#FileOutputStream(String)
     */
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return null;
    }

    /**
     * Delete the given private file associated with this Context's
     * application package.
     *
     * @param name The name of the file to delete; can not contain path
     *             separators.
     * @return {@code true} if the file was successfully deleted; else
     * {@code false}.
     * @see #openFileInput
     * @see #openFileOutput
     * @see #fileList
     * @see File#delete()
     */
    @Override
    public boolean deleteFile(String name) {
        return false;
    }

    /**
     * Returns the absolute path on the filesystem where a file created with
     * {@link #openFileOutput} is stored.
     * <p>
     * The returned path may change over time if the calling app is moved to an
     * adopted storage device, so only relative paths should be persisted.
     *
     * @param name The name of the file for which you would like to get
     *             its path.
     * @return An absolute path to the given file.
     * @see #openFileOutput
     * @see #getFilesDir
     * @see #getDir
     */
    @Override
    public File getFileStreamPath(String name) {
        return null;
    }

    /**
     * Returns the absolute path to the directory on the filesystem where all
     * private files belonging to this app are stored. Apps should not use this
     * path directly; they should instead use {@link #getFilesDir()},
     * {@link #getCacheDir()}, {@link #getDir(String, int)}, or other storage
     * APIs on this class.
     * <p>
     * The returned path may change over time if the calling app is moved to an
     * adopted storage device, so only relative paths should be persisted.
     * <p>
     * No additional permissions are required for the calling app to read or
     * write files under the returned path.
     *
     * @see ApplicationInfo#dataDir
     */
    @Override
    public File getDataDir() {
        return null;
    }

    /**
     * Returns the absolute path to the directory on the filesystem where files
     * created with {@link #openFileOutput} are stored.
     * <p>
     * The returned path may change over time if the calling app is moved to an
     * adopted storage device, so only relative paths should be persisted.
     * <p>
     * No additional permissions are required for the calling app to read or
     * write files under the returned path.
     *
     * @return The path of the directory holding application files.
     * @see #openFileOutput
     * @see #getFileStreamPath
     * @see #getDir
     */
    @Override
    public File getFilesDir() {
        return null;
    }


    @Override
    public File getNoBackupFilesDir() {
        return null;
    }


    @Nullable
    @Override
    public File getExternalFilesDir(@Nullable String type) {
        return null;
    }

    @Override
    public File[] getExternalFilesDirs(String type) {
        return new File[0];
    }


    @Override
    public File getObbDir() {
        return null;
    }

    @Override
    public File[] getObbDirs() {
        return new File[0];
    }

    @Override
    public File getCacheDir() {
        return null;
    }


    @Override
    public File getCodeCacheDir() {
        return null;
    }


    @Nullable
    @Override
    public File getExternalCacheDir() {
        return null;
    }

    @Override
    public File[] getExternalCacheDirs() {
        return new File[0];
    }


    @Override
    public File[] getExternalMediaDirs() {
        return new File[0];
    }

    @Override
    public String[] fileList() {
        return new String[0];
    }


    @Override
    public File getDir(String name, int mode) {
        return null;
    }


    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return null;
    }


    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, @Nullable DatabaseErrorHandler errorHandler) {
        return null;
    }

    /**
     * Move an existing database file from the given source storage context to
     * this context. This is typically used to migrate data between storage
     * locations after an upgrade, such as migrating to device protected
     * storage.
     * <p>
     * The database must be closed before being moved.
     *
     * @param sourceContext The source context which contains the existing
     *                      database to move.
     * @param name          The name of the database file.
     * @return {@code true} if the move was successful or if the database didn't
     * exist in the source context, otherwise {@code false}.
     * @see #createDeviceProtectedStorageContext()
     */
    @Override
    public boolean moveDatabaseFrom(Context sourceContext, String name) {
        return false;
    }

    /**
     * Delete an existing private SQLiteDatabase associated with this Context's
     * application package.
     *
     * @param name The name (unique in the application package) of the
     *             database.
     * @return {@code true} if the database was successfully deleted; else {@code false}.
     * @see #openOrCreateDatabase
     */
    @Override
    public boolean deleteDatabase(String name) {
        return false;
    }

    /**
     * Returns the absolute path on the filesystem where a database created with
     * {@link #openOrCreateDatabase} is stored.
     * <p>
     * The returned path may change over time if the calling app is moved to an
     * adopted storage device, so only relative paths should be persisted.
     *
     * @param name The name of the database for which you would like to get
     *             its path.
     * @return An absolute path to the given database.
     * @see #openOrCreateDatabase
     */
    @Override
    public File getDatabasePath(String name) {
        return null;
    }

    /**
     * Returns an array of strings naming the private databases associated with
     * this Context's application package.
     *
     * @return Array of strings naming the private databases.
     * @see #openOrCreateDatabase
     * @see #deleteDatabase
     */
    @Override
    public String[] databaseList() {
        return new String[0];
    }

    /**
     * @deprecated Use {@link WallpaperManager#getDrawable
     * WallpaperManager.get()} instead.
     */
    @Override
    public Drawable getWallpaper() {
        return null;
    }

    /**
     * @deprecated Use {@link WallpaperManager#peekDrawable
     * WallpaperManager.peek()} instead.
     */
    @Override
    public Drawable peekWallpaper() {
        return null;
    }

    /**
     * @deprecated Use {@link WallpaperManager#getDesiredMinimumWidth()
     * WallpaperManager.getDesiredMinimumWidth()} instead.
     */
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        return 0;
    }

    /**
     * @deprecated Use {@link WallpaperManager#getDesiredMinimumHeight()
     * WallpaperManager.getDesiredMinimumHeight()} instead.
     */
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        return 0;
    }

    /**
     * @param bitmap
     * @deprecated Use {@link WallpaperManager#setBitmap(Bitmap)
     * WallpaperManager.set()} instead.
     * <p>This method requires the caller to hold the permission
     * {@link Manifest.permission#SET_WALLPAPER}.
     */
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {

    }

    /**
     * @param data
     * @deprecated Use {@link WallpaperManager#setStream(InputStream)
     * WallpaperManager.set()} instead.
     * <p>This method requires the caller to hold the permission
     * {@link Manifest.permission#SET_WALLPAPER}.
     */
    @Override
    public void setWallpaper(InputStream data) throws IOException {

    }

    /**
     * @deprecated Use {@link WallpaperManager#clear
     * WallpaperManager.clear()} instead.
     * <p>This method requires the caller to hold the permission
     * {@link Manifest.permission#SET_WALLPAPER}.
     */
    @Override
    public void clearWallpaper() throws IOException {

    }


    @Override
    public void startActivity(Intent intent) {

    }


    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {

    }


    @Override
    public void startActivities(Intent[] intents) {

    }


    @Override
    public void startActivities(Intent[] intents, Bundle options) {

    }


    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }


    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {

    }

    @Override
    public void sendBroadcast(Intent intent) {

    }


    @Override
    public void sendBroadcast(Intent intent, @Nullable String receiverPermission) {

    }


    @Override
    public void sendOrderedBroadcast(Intent intent, @Nullable String receiverPermission) {

    }


    @Override
    public void sendOrderedBroadcast(@NonNull Intent intent, @Nullable String receiverPermission, @Nullable BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {

    }


    @Override
    public void sendBroadcastAsUser(Intent intent, UserHandle user) {

    }

    @Override
    public void sendBroadcastAsUser(Intent intent, UserHandle user, @Nullable String receiverPermission) {

    }


    @Override
    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle user, @Nullable String receiverPermission, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {

    }


    @Override
    public void sendStickyBroadcast(Intent intent) {

    }

    @Override
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {

    }


    @Override
    public void removeStickyBroadcast(Intent intent) {

    }


    @Override
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {

    }


    @Override
    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {

    }


    @Override
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {

    }


    @Nullable
    @Override
    public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter) {
        return null;
    }


    @Nullable
    @Override
    public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter, int flags) {
        return null;
    }


    @Nullable
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler) {
        return null;
    }


    @Nullable
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler, int flags) {
        return null;
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {

    }


    @Nullable
    @Override
    public ComponentName startService(Intent service) {
        return null;
    }


    @Nullable
    @Override
    public ComponentName startForegroundService(Intent service) {
        return null;
    }


    @Override
    public boolean stopService(Intent service) {
        return false;
    }


    @Override
    public boolean bindService(Intent service, @NonNull ServiceConnection conn, int flags) {
        return false;
    }


    @Override
    public void unbindService(@NonNull ServiceConnection conn) {

    }


    @Override
    public boolean startInstrumentation(@NonNull ComponentName className, @Nullable String profileFile, @Nullable Bundle arguments) {
        return false;
    }


    @Override
    public Object getSystemService(@NonNull String name) {
        return null;
    }

    @Nullable
    @Override
    public String getSystemServiceName(@NonNull Class <?> serviceClass) {
        return null;
    }


    @SuppressLint("WrongConstant")
    @Override
    public int checkPermission(@NonNull String permission, int pid, int uid) {
        return 0;
    }


    @SuppressLint("WrongConstant")
    @Override
    public int checkCallingPermission(@NonNull String permission) {
        return 0;
    }


    @SuppressLint("WrongConstant")
    @Override
    public int checkCallingOrSelfPermission(@NonNull String permission) {
        return 0;
    }


    @SuppressLint("WrongConstant")
    @Override
    public int checkSelfPermission(@NonNull String permission) {
        return 0;
    }

    @Override
    public void enforcePermission(@NonNull String permission, int pid, int uid, @Nullable String message) {

    }


    @Override
    public void enforceCallingPermission(@NonNull String permission, @Nullable String message) {

    }

    @Override
    public void enforceCallingOrSelfPermission(@NonNull String permission, @Nullable String message) {

    }


    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {

    }


    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {

    }


    @Override
    public void revokeUriPermission(String toPackage, Uri uri, int modeFlags) {

    }


    @SuppressLint("WrongConstant")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return 0;
    }

    @SuppressLint("WrongConstant")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        return 0;
    }


    @SuppressLint("WrongConstant")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return 0;
    }


    @SuppressLint("WrongConstant")
    @Override
    public int checkUriPermission(@Nullable Uri uri, @Nullable String readPermission, @Nullable String writePermission, int pid, int uid, int modeFlags) {
        return 0;
    }


    @Override
    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {

    }

    @Override
    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {

    }


    @Override
    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {

    }
    @Override
    public void enforceUriPermission(@Nullable Uri uri, @Nullable String readPermission, @Nullable String writePermission, int pid, int uid, int modeFlags, @Nullable String message) {

    }


    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override
    public Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
        return null;
    }


    @Override
    public Context createConfigurationContext(@NonNull Configuration overrideConfiguration) {
        return null;
    }


    @Override
    public Context createDisplayContext(@NonNull Display display) {
        return null;
    }


    @Override
    public Context createDeviceProtectedStorageContext() {
        return null;
    }

    @Override
    public boolean isDeviceProtectedStorage() {
        return false;
    }
}
