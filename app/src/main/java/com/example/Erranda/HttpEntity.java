

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.Erranda;

import android.preference.PreferenceActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** @deprecated */
@Deprecated
public interface HttpEntity {
    boolean isRepeatable();

    boolean isChunked();

    long getContentLength();

    PreferenceActivity.Header getContentType();

    PreferenceActivity.Header getContentEncoding();

    InputStream getContent() throws IOException, IllegalStateException;

    void writeTo(OutputStream var1) throws IOException;

    boolean isStreaming();

    void consumeContent() throws IOException;
}
