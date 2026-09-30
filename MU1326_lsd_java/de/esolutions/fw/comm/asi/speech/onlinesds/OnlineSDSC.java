/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface OnlineSDSC {
    public void onlineCapabilities(LanguageInfo[] var1) throws MethodException;

    public void responseSetLanguage(int var1) throws MethodException;

    public void sendOnlineResult(int var1, int var2, String var3) throws MethodException;

    public void responseCancel(int var1, int var2) throws MethodException;
}

