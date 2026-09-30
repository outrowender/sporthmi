/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tts;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public interface DSITTSReply {
    public static final String IPL_COMM_UUID = "8d1a024d-227e-5e50-ada7-839a66737794";
    public static final String IPL_COMM_INTERFACE_KEY = "80b3f4dc-2495-5caf-8fcf-ebd63773bdb5";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.13";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.13";

    public void updateLanguage(String var1, int var2, int var3, int var4) throws MethodException;

    public void updateAvailableLanguages(LanguageVoiceInfo[] var1, int var2) throws MethodException;

    public void updateMarkerPassed(int var1, int var2) throws MethodException;

    public void responseSetLanguage(short var1, int var2) throws MethodException;

    public void responseInit(short var1, int var2) throws MethodException;

    public void responseAudioTrigger(short var1, int var2) throws MethodException;

    public void updateAudioRequest(int var1, int var2) throws MethodException;

    public void responsePlayTone(short var1, int var2) throws MethodException;

    public void responseSpeakPrompt(short var1, int var2) throws MethodException;

    public void responseSkipSpeaking(short var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

