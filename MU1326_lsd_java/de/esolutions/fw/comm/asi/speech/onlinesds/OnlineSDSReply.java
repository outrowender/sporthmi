/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

import de.esolutions.fw.comm.asi.speech.onlinesds.AudioData;
import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface OnlineSDSReply {
    public static final String IPL_COMM_UUID = "8a66769b-5812-4288-95b1-6ebd66230a2d";
    public static final String IPL_COMM_INTERFACE_KEY = "05e2991f-3978-5b4f-8580-84236c6e9c67";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.4.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.4.0";

    public void setLanguage(LanguageInfo var1) throws MethodException;

    public void speechDataUpdate(int var1, int var2, AudioData var3) throws MethodException;

    public void cancel(int var1) throws MethodException;
}

