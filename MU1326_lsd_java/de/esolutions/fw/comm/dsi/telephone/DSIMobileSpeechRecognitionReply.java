/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMobileSpeechRecognitionReply {
    public static final String IPL_COMM_UUID = "f14d948b-082d-5317-8e8d-ff2c2d47774f";
    public static final String IPL_COMM_INTERFACE_KEY = "5f606b95-6f71-5c15-a794-a18890d22182";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.27";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.27";

    public void updateSpeechRecognitionAvailable(int var1, int var2) throws MethodException;

    public void updateSpeechRecognitionActive(int var1, int var2) throws MethodException;

    public void updateSpeechRecognitionType(int var1, int var2) throws MethodException;

    public void responseStartSpeechRecognition(int var1) throws MethodException;

    public void responseStopSpeechRecognition(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

