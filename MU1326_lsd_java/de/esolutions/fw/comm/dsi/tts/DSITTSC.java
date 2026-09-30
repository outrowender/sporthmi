/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tts;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.tts.TTSPrompt;

public interface DSITTSC {
    public void speakPrompt(short var1, TTSPrompt var2) throws MethodException;

    public void setLanguage(short var1, String var2, int var3, int var4, int var5) throws MethodException;

    public void init(short var1) throws MethodException;

    public void requestAudioTrigger(short var1, int var2) throws MethodException;

    public void requestPlayTone(short var1, int var2) throws MethodException;

    public void requestSkipSpeaking(short var1, int var2, int var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

